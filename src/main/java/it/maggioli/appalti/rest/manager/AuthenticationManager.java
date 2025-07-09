package it.maggioli.appalti.rest.manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import it.eldasoft.utils.sicurezza.CriptazioneException;
import it.eldasoft.utils.sicurezza.FactoryCriptazioneByte;
import it.eldasoft.utils.sicurezza.ICriptazioneByte;
import it.maggioli.appalti.rest.dto.UserSysDto;
import it.maggioli.appalti.rest.entities.UserSys;
import it.maggioli.appalti.rest.entities.Usrein;
import it.maggioli.appalti.rest.entities.WApplicationKeys;
import it.maggioli.appalti.rest.entities.WConfig;
import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.entities.identities.UsreinIdentity;
import it.maggioli.appalti.rest.entities.identities.WConfigIdentity;
import it.maggioli.appalti.rest.exceptions.InvalidTokenException;
import it.maggioli.appalti.rest.exceptions.InvalidUserException;
import it.maggioli.appalti.rest.repositories.UffintRepository;
import it.maggioli.appalti.rest.repositories.UserSysRepository;
import it.maggioli.appalti.rest.repositories.WApplicationKeysRepository;
import it.maggioli.appalti.rest.repositories.WConfigRepository;

/**
 * Servizio per la gestione dell'autenticazione
 * @author gabriele.nencini
 *
 */
@Service
@SuppressWarnings("java:S3749")
public class AuthenticationManager {
  private static final Logger logger = LoggerFactory.getLogger(AuthenticationManager.class);
  
  public static final String TIPOLOGIA_CIFRATURA_DATI="LEG";
  
  @Value("${sso.token.expireTime:7200000}")
  private long tokenExpTime;
  @Value("${sso.refreshToken.expireTime:21600000}")
  private long refreshTokenExpTime;
  @Value("${sso.token.secret:$3cR3t}")
  private String secret;
  @Value("${sso.token.issuer:UnknownHost}")
  private String issuer;
  
  @Autowired
  private UserSysRepository usRepository;
  @Autowired
  private WConfigRepository wcRepository;
  @Autowired
  private WlogEventiManager wleManager;
  @Autowired
  private WApplicationKeysRepository wakRepository;
  @Autowired
  private UffintRepository uffintRepository;
  
  private MessageDigest md;
  
  @PostConstruct
  public void postConstruct() throws NoSuchAlgorithmException {
    WConfigIdentity id = new WConfigIdentity("PG","it.maggioli.eldasoft.wslogin.jwtKey");
    Optional<WConfig> op = wcRepository.findById(id);
    if(op.isPresent()) {
      WConfig wc = op.get();
      this.secret = "1".equalsIgnoreCase(wc.getCriptato())?decode(wc.getValore()):wc.getValore();
    }
    this.issuer = getIssuer();
    this.md = MessageDigest.getInstance("SHA-256");
  }
  
  private static String decode(String value) {
    try {
      ICriptazioneByte decriptatorePsw = FactoryCriptazioneByte.getInstance(TIPOLOGIA_CIFRATURA_DATI, 
          value.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
      return new String(decriptatorePsw.getDatoNonCifrato());
    } catch (CriptazioneException e) {
      logger.error("Errore nella decifratura della chiave.",e);
    }
    return value;
  }
  private String encode(String value) {
    try {
      ICriptazioneByte decriptatorePsw = FactoryCriptazioneByte.getInstance(TIPOLOGIA_CIFRATURA_DATI, 
          value.getBytes(), ICriptazioneByte.FORMATO_DATO_NON_CIFRATO);
      String enc = new String(decriptatorePsw.getDatoCifrato());
      return enc;
    } catch (CriptazioneException e) {
      logger.error("Errore nella decifratura della chiave.",e);
    }
    return value;
  }
  
  @Transactional(propagation = Propagation.MANDATORY)
  public UserSys findUser(String username, String password) throws InvalidUserException{
    Optional<UserSys> op = usRepository.findBySysloginIgnoreCaseAndSyspwd(username, this.encode(password));
    return op.orElseThrow(InvalidUserException::new);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public String authenticate(String username, String password) throws InvalidUserException {
      logger.info("Request auth for user with username: {}",username);
      UserSys usr = this.findUser(username, password);
      usr.setSysultacc(new Date());
      usRepository.updateLastAccessDate(usr.getSysultacc(),usr.getSyscon());
      logger.debug("{}",usr);
      return generateToken(usr);
  }
  
  private String generateToken(UserSys usr) {
    long nowmillis = System.currentTimeMillis();
    Date now = new Date(nowmillis);
    Date expiresAt = new Date(nowmillis + tokenExpTime);
    logger.debug("expiresAt {}",expiresAt);
    String cf = usr.getSyscf()==null ? usr.getSyslogin() : usr.getSyscf();
    logger.debug("codein[{}]",usr.getListUffint().size());
    List<String> codein = usr.getListUffint().parallelStream().map(e->e.getId().getCodein()).collect(Collectors.toList());
    logger.trace("codein[{}]",codein);
    String token = JWT.create()
                      .withIssuedAt(now)
                      .withSubject(cf)
                      .withAudience(cf)
                      .withClaim("USER_CF", cf)
                      .withClaim("USER_NAME", usr.getSyslogin())
                      .withClaim("USER_SURNAME", usr.getSysute())
                      .withClaim("syscon", usr.getSyscon())
                      .withArrayClaim("codein", codein.toArray(new String[usr.getListUffint().size()]))
                      .withExpiresAt(expiresAt)
                      .sign(Algorithm.HMAC512(secret));
    //TODO aggiungere le authorities nel token??
    return token;
  }
  
  public Map<String,Object> isTokenValid(String token) throws InvalidTokenException {
    try {
      Algorithm algorithm = Algorithm.HMAC512(this.secret);
      JWTVerifier verifier = JWT.require(algorithm)
          .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      logger.trace("jwt.getIssuedAt: {}",jwt.getIssuedAt());
      logger.trace("jwt.getIssuedAt: {}",jwt.getExpiresAt());
      if(new Date().after(jwt.getExpiresAt())) { 
        logger.warn("Token expired: {}",jwt.getExpiresAt());
        throw new InvalidTokenException();
      }
      
      Map<String,Object> result = new HashMap<String,Object>();
      result.put("codein", jwt.getClaim("codein").asList(String.class));
      result.put("syscon",jwt.getClaim("syscon").asLong());
      return result;
    } catch (JWTVerificationException exception){
      logger.error("Exception during verification",exception);
      throw new InvalidTokenException();
    } catch (InvalidTokenException e) {
      //Voluntary exception
      throw e;
    } catch (Exception e) {
      logger.error("Generic error occurred.",e);
      throw new InvalidTokenException();
    }
  }
  
  protected String getIssuer() {
      return "appalti-rest";
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public String authenticate(String username, String password, String clientKey, String clientId, String sourceIp) throws InvalidUserException {
    logger.info("Request auth for user with username: {}",username);
    try {
      //1. usrsys
      UserSys usr = this.findUser(username, password);
      UserSysDto usrDto = new UserSysDto();
      usrDto.setSyscon(usr.getSyscon());
      usrDto.setSysultacc(usr.getSysultacc());
      usrDto.setListUffint(usr.getListUffint());
      usrDto.setSysab3(usr.getSysab3());
      //2. 
      this.findApplicationKey(this.toHexString(clientKey), clientId);
      
      usrDto.setSysultacc(new Date());
      usRepository.updateLastAccessDate(usrDto.getSysultacc(),usrDto.getSyscon());
      logger.debug("Aggiornata data ultimo access per usrDto: {}",usrDto);
      final Long usrSyscon = usrDto.getSyscon();
      
      //APPALTMS-6 + APPALTMS-5
      WConfigIdentity id = new WConfigIdentity("PG","it.eldasoft.associazioneUffintAbilitata");
      Optional<WConfig> op = wcRepository.findById(id);
      boolean filterUffintToBeApplied = true;
      filterUffintToBeApplied = op.isPresent() && "1".equalsIgnoreCase(op.get().getValore());
      logger.debug("filterUffintToBeApplied: {}",filterUffintToBeApplied);
      if(!filterUffintToBeApplied || "A".equalsIgnoreCase(usrDto.getSysab3())) {
    	  //TODO find all codein
    	  //TODO add all to its components
    	  usrDto.setListUffint(uffintRepository.findOnlyCodein().stream().map(e->{
    		  Usrein uein = new Usrein();
    		  UsreinIdentity idUserein = new UsreinIdentity();
    		  idUserein.setSyscon(usrSyscon);
    		  idUserein.setCodein(e);
    		  uein.setId(idUserein);
    		  return uein;
    	  }).collect(Collectors.toList()));
      }
      logger.debug("{}",usrDto);
      
      String token = generateToken(usrDto);
      logger.debug("token generato per usrDto: {}",usrDto);
      Wlogeventi evento = new Wlogeventi();
      evento.setCod_profilo("APPALTI_REST");
      evento.setCodapp("WS");
      evento.setCodevento(WlogEventiManager.COD_EVENTO_LOGIN);
      evento.setDescr("Generato token per appalti-rest");
      evento.setIpevento(sourceIp);
      evento.setLivevento(1);
      evento.setOggevento("authenticate");
      evento.setSyscon(usrSyscon);
      wleManager.saveWlogEventi(evento);
      logger.debug("Wlogeventi generato per usrDto: {}, wlogeventi: {}",usrDto, evento);
      return token;
    }catch(Exception e) {
      logger.error("Error on login",e);
      throw new InvalidUserException();
    }
  }
  
  private void findApplicationKey(String clientKey, String clientId) throws InvalidUserException{
    Optional<WApplicationKeys> opWk = wakRepository.findByClientidIgnoreCaseAndChiave(clientId, clientKey);
    opWk.orElseThrow(InvalidUserException::new);
    // 9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08
  }

  protected static  String toHexString(String key) {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    md.update(key.getBytes());
    byte byteData[] = md.digest();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }
}
