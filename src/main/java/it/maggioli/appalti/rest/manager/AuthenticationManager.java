package it.maggioli.appalti.rest.manager;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
import it.maggioli.appalti.rest.entities.UserSys;
import it.maggioli.appalti.rest.entities.WApplicationKeys;
import it.maggioli.appalti.rest.entities.WConfig;
import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.entities.identities.WConfigIdentity;
import it.maggioli.appalti.rest.exceptions.InvalidTokenException;
import it.maggioli.appalti.rest.exceptions.InvalidUserException;
import it.maggioli.appalti.rest.repositories.UserSysRepository;
import it.maggioli.appalti.rest.repositories.WApplicationKeysRepository;
import it.maggioli.appalti.rest.repositories.WConfigRepository;

/**
 * Servizio per la gestione dell'autenticazione
 * @author gabriele.nencini
 *
 */
@Service
public class AuthenticationManager {
  private Logger logger = LoggerFactory.getLogger(getClass());
  
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
    
    //TODO
    
    logger.info("issuer: {}",issuer);
    this.md = MessageDigest.getInstance("SHA-256");
  }
  
  private String decode(String value) {
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
      return new String(decriptatorePsw.getDatoCifrato());
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
      usr = usRepository.save(usr);
      logger.debug("{}",usr);
      return generateToken(usr);
  }
  
  @Transactional(propagation = Propagation.MANDATORY)
  protected String generateToken(UserSys usr) {
    long nowmillis = System.currentTimeMillis();
    Date now = new Date(nowmillis);
    Date expiresAt = new Date(nowmillis + tokenExpTime);
    logger.debug("expiresAt {}",expiresAt);
    String cf = usr.getSyscf()==null ? usr.getSyslogin() : usr.getSyscf();
    logger.info("codein[{}]",usr.getListUffint().size());
    List<String> codein = usr.getListUffint().parallelStream().map(e->e.getId().getCodein()).collect(Collectors.toList());
    logger.trace("codein[{}]",codein);
    String token = JWT.create()
                      .withIssuedAt(now)
                      .withSubject(cf)
                      .withIssuer(getIssuer())
                      .withAudience(cf)
                      .withClaim("USER_CF", cf)
                      .withClaim("USER_NAME", usr.getSyslogin())
                      .withClaim("USER_SURNAME", usr.getSysute())
                      .withClaim("syscon", usr.getSyscon())
                      .withArrayClaim("codein", codein.toArray(new String[usr.getListUffint().size()]))
                      .withExpiresAt(expiresAt)
                      .sign(Algorithm.HMAC512(secret));
    logger.info("token: {}",token);
    //TODO save token to DB
    return token;
  }
  
  public Map<String,Object> isTokenValid(String token) throws InvalidTokenException {
    try {
      Algorithm algorithm = Algorithm.HMAC512(this.secret);
      JWTVerifier verifier = JWT.require(algorithm)
          .withIssuer(getIssuer())
          .build(); //Reusable verifier instance
      DecodedJWT jwt = verifier.verify(token);
      logger.info("jwt.getIssuedAt: {}",jwt.getIssuedAt());
      logger.info("jwt.getIssuedAt: {}",jwt.getExpiresAt());
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
    try {
      return InetAddress.getLocalHost().getHostAddress();
    } catch (UnknownHostException e) {
      return this.issuer;
    }
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public String authenticate(String username, String password, String clientKey, String clientId, String sourceIp) throws InvalidUserException {
    logger.info("Request auth for user with username: {}",username);
    try {
      //1. usrsys
      UserSys usr = this.findUser(username, password);
      //2. 
      this.findApplicationKey(this.toHexString(clientKey), clientId);
      
      usr.setSysultacc(new Date());
      usr = usRepository.save(usr);
      logger.debug("{}",usr);
      
      //TODO save data
      String token = generateToken(usr);
      
      Wlogeventi evento = new Wlogeventi();
      evento.setCod_profilo("APPALTI_REST");
      evento.setCodapp("WS");
      evento.setCodevento(WlogEventiManager.COD_EVENTO_LOGIN);
      evento.setDescr("Generato token per appalti-rest");
      evento.setIpevento(sourceIp);
      evento.setLivevento(1);
      evento.setOggevento("authenticate");
      evento.setSyscon(usr.getSyscon());
      wleManager.saveWlogEventi(evento);
      return token;
    }catch(Exception e) {
      logger.error("Error on login",e);
      throw new InvalidUserException();
    }
  }
  
  private void findApplicationKey(String clientKey, String clientId) throws InvalidUserException{
    Optional<WApplicationKeys> opWk = wakRepository.findByClientidIgnoreCaseAndChiave(clientId, clientKey);
    opWk.orElseThrow(InvalidUserException::new);
  }
  
  protected String toHexString(String key) {
    md.update(key.getBytes());
    byte byteData[] = md.digest();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }
}
