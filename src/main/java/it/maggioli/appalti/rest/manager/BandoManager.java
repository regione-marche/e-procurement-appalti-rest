package it.maggioli.appalti.rest.manager;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.maggioli.appalti.rest.configuration.response.ConfigurationResponse;
import it.maggioli.appalti.rest.dto.BandoDocumentoDto;
import it.maggioli.appalti.rest.dto.ComunicazioneDto;
import it.maggioli.appalti.rest.dto.DatiGeneraliDto;
import it.maggioli.appalti.rest.dto.DettaglioDto;
import it.maggioli.appalti.rest.dto.FileDto;
import it.maggioli.appalti.rest.dto.StazioneAppaltanteDto;
import it.maggioli.appalti.rest.entities.Wdocdig;
import it.maggioli.appalti.rest.entities.identities.WdocdigIdentity;
import it.maggioli.appalti.rest.entities.views.ws.BandoDettaglio;
import it.maggioli.appalti.rest.entities.views.ws.BandoDocumento;
import it.maggioli.appalti.rest.entities.views.ws.Comunicazione;
import it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento;
import it.maggioli.appalti.rest.entities.views.ws.GareLotti;
import it.maggioli.appalti.rest.enums.DocumentoGruppoEnum;
import it.maggioli.appalti.rest.functions.TransformBandoDocumentoToBandoDocumentoDto;
import it.maggioli.appalti.rest.functions.TransformComunicazioneDocumentoToComunicazioneDocumentoDto;
import it.maggioli.appalti.rest.functions.TransformComunicazioneToComunicazioneDto;
import it.maggioli.appalti.rest.functions.TransformGareCategorieToCategoriePrestazioniDto;
import it.maggioli.appalti.rest.functions.TransformGareLottiToGareLottiDto;
import it.maggioli.appalti.rest.repositories.WdocdigRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoDettaglioRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoDocumentoLottoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.ComunicazioneDocumentoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.ComunicazioneRepository;
import it.maggioli.appalti.rest.repositories.views.ws.GareLottiRepository;
import it.maggioli.appalti.rest.repositories.views.ws.PuntoIstruttoreRepository;
import it.maggioli.appalti.rest.repositories.views.ws.PuntoOrdinanteRepository;
import it.maggioli.appalti.rest.specifications.BandoSpecification;

/**
 * Servizio per la gestione delle richieste per il Bando di Gara
 * @author gabriele.nencini
 *
 */
@Service
public class BandoManager implements Serializable {
  private static final long serialVersionUID = 1L;
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private TransformComunicazioneToComunicazioneDto functionComunicazione = new TransformComunicazioneToComunicazioneDto(new TransformComunicazioneDocumentoToComunicazioneDocumentoDto());
  
  @Autowired
  private BandoDettaglioRepository baDetRepository;
  @Autowired
  private PuntoOrdinanteRepository poRepository;
  @Autowired
  private PuntoIstruttoreRepository piRepository;
  @Autowired
  private BandoDocumentoLottoRepository bdlRepository;
  @Autowired
  private GareLottiRepository glRepository;
  @Autowired
  private ComunicazioneRepository comRepository;
  @Autowired
  private ComunicazioneDocumentoRepository comDocRepository;
  @Autowired
  private WdocdigRepository wdocdigRepository;
  @Autowired
  private ConfigurationManager confManager;
  
  public Optional<DettaglioDto<DatiGeneraliDto,BandoDocumentoDto,ComunicazioneDto>> getBandoDettaglio(String riferimentoProcedura) {
    Optional<BandoDettaglio> ob = baDetRepository.findById(riferimentoProcedura);
    if(ob.isPresent()) {
      
      DettaglioDto<DatiGeneraliDto,BandoDocumentoDto,ComunicazioneDto> dettaglioDto = new DettaglioDto<DatiGeneraliDto,BandoDocumentoDto,ComunicazioneDto>();
      
      BandoDettaglio bd = ob.get();
      
      // ottimizzazione su v_ws_dettaglio_bando -> comment from WSGareAppaltoSoapImpl
      StazioneAppaltanteDto sa = new StazioneAppaltanteDto();
      sa.setCodice(bd.getSACodice());
      sa.setDenominazione(bd.getSADescrizione());
      sa.setRup(bd.getSARup());
      sa.setPuntoOrdinante(poRepository.getSysuteFromCodice(riferimentoProcedura));
      sa.setPuntoIstruttore(piRepository.getSysuteFromCodice(riferimentoProcedura));
      dettaglioDto.setStazioneAppaltante(sa);
      
      DatiGeneraliDto datiGenerali = new DatiGeneraliDto();
      datiGenerali.setTitolo(bd.getOggetto());
      datiGenerali.setTipologiaAppalto(bd.getTipoAppalto());
      datiGenerali.setProceduraGara(bd.getTipoProcedura());
      datiGenerali.setCriterioAggiudicazione(bd.getTipoAggiudicazione());
      datiGenerali.setImportoBaseGara(bd.getImporto());
      if(Objects.nonNull(bd.getDataPubblicazione()))
        datiGenerali.setDataPubblicazione(sdfDate.format(bd.getDataPubblicazione()));
      if(Objects.nonNull(bd.getDataTermine()))
        datiGenerali.setDataScadenza(sdfDate.format(bd.getDataTermine())+" entro le "+bd.getOraTermine());
      datiGenerali.setStato(bd.getStato());
      datiGenerali.setProceduraRiferimento(riferimentoProcedura);
      if(Objects.nonNull(bd.getDataUltimaModifica()))
        datiGenerali.setDataUltimaModifica(bd.getDataUltimaModifica());
      dettaglioDto.setDatiGenerali(datiGenerali);
      // FIND LOTTI
      List<GareLotti> lottiList = glRepository.findAllByCodice(bd.getCodice());
      
      TransformGareLottiToGareLottiDto functionGareLottiDto = new TransformGareLottiToGareLottiDto(new TransformGareCategorieToCategoriePrestazioniDto());
      datiGenerali.setDatiProceduralotti(lottiList.stream().map(e->functionGareLottiDto.apply(e)).collect(Collectors.toList()));
      logger.debug("Lotti: {}",lottiList.size());
      // FIND DOCUMENTI
      
      
      logger.debug("DocumentoGruppoEnum.values().length: {}",DocumentoGruppoEnum.values().length);
      logger.trace("DocumentoGruppo.getListByValues(): {}",DocumentoGruppoEnum.getListByValues());
      //Ottengo tutti i documenti per gruppo
      List<BandoDocumento> documentiLotto = bdlRepository.findAll(BandoSpecification.getBandoDocumentoLottoSpecification(riferimentoProcedura,null,DocumentoGruppoEnum.getListByValues()));
      logger.debug("documentiLotto size {}",documentiLotto.size());
      //raggruppo i documenti per gruppo
      
      //TODO filtrare i doc per 4 secondo parametro
      ConfigurationResponse resp = confManager.getProperty(ConfigurationManager.GARE_DOCINVITOPUBBLICA_VIS);
      boolean filterDocinvitoPubblicaVisible = Boolean.valueOf(resp.getValore());
      logger.info("{} -> {}",resp,filterDocinvitoPubblicaVisible);
      TransformBandoDocumentoToBandoDocumentoDto function = new TransformBandoDocumentoToBandoDocumentoDto();
      if(documentiLotto.size()>0) {
        Map<Integer, List<BandoDocumento>> gruppoDocumentiLotto = documentiLotto.stream()
            .filter(e->e!=null && e.getGruppo()!=null)
            .collect(Collectors.groupingBy(BandoDocumento::getGruppo));
        logger.debug("gruppoDocumentiLotto.keySet(): {}",gruppoDocumentiLotto.keySet());
        if(!filterDocinvitoPubblicaVisible) {
          gruppoDocumentiLotto.remove(6);
        }
        
        List<BandoDocumento> listOfDocumentiGara = gruppoDocumentiLotto.get(1);
        if(listOfDocumentiGara!=null && listOfDocumentiGara.size()>0) {
          logger.debug("gruppoDocumentiLotto.get(1): {}",listOfDocumentiGara.size());
          dettaglioDto.setDocumentazione(listOfDocumentiGara.stream().filter(Objects::nonNull).map(function::apply).collect(Collectors.toList()));
        }
        
      }
      
      //TODO filter by conf params
      resp = confManager.getProperty(ConfigurationManager.GARE_ATTIDOCART29_VIS);
      boolean filterAttiDocVisible = Boolean.valueOf(resp.getValore());
      logger.info("{} -> {}",resp,filterAttiDocVisible);
      
      if(filterAttiDocVisible) {
        List<BandoDocumento> listOfAltriDocumenti = bdlRepository.findAttiDocumentiBando(riferimentoProcedura);
        if(listOfAltriDocumenti!=null && listOfAltriDocumenti.size()>0) {
          datiGenerali.setAttiDocumenti(listOfAltriDocumenti.stream().map(e->function.apply(e)).collect(Collectors.toList()));
        }
      }
      
      List<Comunicazione> comunicazioniGara = comRepository.findAll(BandoSpecification.getComunicazioneSpecification(riferimentoProcedura,sa.getCodice()));
      logger.debug("comunicazioniGara.size: {}",comunicazioniGara.size());
      dettaglioDto.setComunicazioni(comunicazioniGara.stream().map(e->functionComunicazione.apply(e)).collect(Collectors.toList()));
      
      logger.info("{}",dettaglioDto);
      return Optional.of(dettaglioDto);
    }
    return Optional.empty();
  }
  
  public Optional<FileDto> downloadFileDaComunicazione(Long idcom, Long iddoc,String filedoc) {
    //controllo che il file richiesto sia effettivamente per quella comunicazione 
    //e che questa sia nella vista delle comunicazioni pubbliche
    ComunicazioneDocumento doc = comDocRepository.findByIdprg_idcom_iddoc_filedoc("PG", idcom, iddoc, filedoc);
    if(doc!=null) {
      Optional<Wdocdig> op = wdocdigRepository.findById(new WdocdigIdentity("PG", doc.getIddoc()));
      if(op.isPresent()) {
        return Optional.of(new FileDto(op.get().getDignomdoc(),Base64.encodeBase64String(op.get().getDigogg())));
      }
    }
    return Optional.empty();
  }
  
  public Optional<FileDto> downloadFileDaEsito(Long iddoc,String nomeFile, String proceduraRiferimento) {
    //controllo che il file richiesto sia effettivamente per quella gara pubblica
    Optional<BandoDocumento> opdoc = bdlRepository.findById(iddoc);
    if(opdoc.isPresent()) {
      BandoDocumento doc = opdoc.get();
      if(doc.getCodice().equals(proceduraRiferimento) 
          && StringUtils.isEmpty(doc.getNgara()) 
          && doc.getGruppo()==4 //gruppo documenti per l'esito
          && doc.getNomefile().equals(nomeFile)) {
        Optional<Wdocdig> op = wdocdigRepository.findById(new WdocdigIdentity("PG", doc.getId()));
        if(op.isPresent()) {
          return Optional.of(new FileDto(op.get().getDignomdoc(),Base64.encodeBase64String(op.get().getDigogg())));
        }
      }
    }
    return Optional.empty();
  }
  
  public Optional<FileDto> downloadFileDaGara(Long iddoc,String nomeFile, String proceduraRiferimento) {
    //controllo che il file richiesto sia effettivamente per quella gara pubblica
    Optional<BandoDocumento> opdoc = bdlRepository.findById(iddoc);
    if(opdoc.isPresent()) {
      BandoDocumento doc = opdoc.get();
      if(doc.getCodice().equals(proceduraRiferimento) 
          && StringUtils.isEmpty(doc.getNgara()) 
          && DocumentoGruppoEnum.getListByValues().contains(doc.getGruppo())
          && doc.getNomefile().equals(nomeFile)) {
        Optional<Wdocdig> op = wdocdigRepository.findById(new WdocdigIdentity("PG", doc.getId()));
        if(op.isPresent()) {
          return Optional.of(new FileDto(op.get().getDignomdoc(),Base64.encodeBase64String(op.get().getDigogg())));
        }
      }
    }
    return Optional.empty();
  }
  
  public Optional<FileDto> downloadFileDaAvviso(Long iddoc,String nomeFile, String proceduraRiferimento) {
    //controllo che il file richiesto sia effettivamente per quella gara pubblica
    Optional<BandoDocumento> opdoc = bdlRepository.findById(iddoc);
    if(opdoc.isPresent()) {
      BandoDocumento doc = opdoc.get();
      if(doc.getCodice().equals(proceduraRiferimento) 
          && doc.getNgara().equals(proceduraRiferimento) 
          && doc.getGruppo()==1
          && doc.getNomefile().equals(nomeFile)) {
        Optional<Wdocdig> op = wdocdigRepository.findById(new WdocdigIdentity("PG", doc.getId()));
        if(op.isPresent()) {
          return Optional.of(new FileDto(op.get().getDignomdoc(),Base64.encodeBase64String(op.get().getDigogg())));
        }
      }
    }
    return Optional.empty();
  }
  
  public Optional<FileDto> downloadAttoDocumentoFileDaGara(Long iddoc,String nomeFile, String proceduraRiferimento) {
    //controllo che il file richiesto sia effettivamente per quella gara pubblica
    Optional<BandoDocumento> opdoc = bdlRepository.findById(iddoc);
    if(opdoc.isPresent()) {
      BandoDocumento doc = opdoc.get();
      logger.info("{}={} : {}",doc.getCodice(),proceduraRiferimento,doc.getCodice().equals(proceduraRiferimento) );
      logger.info("doc.getGruppo() : {}",doc.getGruppo() );
      logger.info("{}={} : {}",doc.getNomefile(),nomeFile,doc.getNomefile().equals(nomeFile) );
      if(doc.getCodice().equals(proceduraRiferimento) 
          && (doc.getGruppo()==10 || doc.getGruppo()==15) 
          && doc.getNomefile().equals(nomeFile)) {
        Optional<Wdocdig> op = wdocdigRepository.findById(new WdocdigIdentity("PG", doc.getId()));
        if(op.isPresent()) {
          return Optional.of(new FileDto(op.get().getDignomdoc(),Base64.encodeBase64String(op.get().getDigogg())));
        }
      }
    }
    return Optional.empty();
  }
  
}
