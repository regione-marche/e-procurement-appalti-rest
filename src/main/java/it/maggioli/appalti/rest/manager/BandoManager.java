package it.maggioli.appalti.rest.manager;

import static it.maggioli.appalti.rest.utils.Transform.transform;
import static it.maggioli.appalti.rest.utils.Transform.transformCheckNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.maggioli.appalti.rest.configuration.response.ConfigurationResponse;
import it.maggioli.appalti.rest.dto.BandoDocumentoDto;
import it.maggioli.appalti.rest.dto.BandoTestataDto;
import it.maggioli.appalti.rest.dto.ComunicazioneDto;
import it.maggioli.appalti.rest.dto.DatiGeneraliDto;
import it.maggioli.appalti.rest.dto.DettaglioDto;
import it.maggioli.appalti.rest.dto.FileDto;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.dto.StazioneAppaltanteDto;
import it.maggioli.appalti.rest.entities.Cais;
import it.maggioli.appalti.rest.entities.Wdocdig;
import it.maggioli.appalti.rest.entities.identities.WdocdigIdentity;
import it.maggioli.appalti.rest.entities.views.ws.Bando;
import it.maggioli.appalti.rest.entities.views.ws.BandoDettaglio;
import it.maggioli.appalti.rest.entities.views.ws.BandoDocumento;
import it.maggioli.appalti.rest.entities.views.ws.Comunicazione;
import it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento;
import it.maggioli.appalti.rest.entities.views.ws.GareLotti;
import it.maggioli.appalti.rest.enums.DocumentoGruppoEnum;
import it.maggioli.appalti.rest.enums.StatoInCorsoScadutoEnum;
import it.maggioli.appalti.rest.functions.TransformBandoDocumentoToBandoDocumentoDto;
import it.maggioli.appalti.rest.functions.TransformBandoToBandoTestataDto;
import it.maggioli.appalti.rest.functions.TransformComunicazioneDocumentoToComunicazioneDocumentoDto;
import it.maggioli.appalti.rest.functions.TransformComunicazioneToComunicazioneDto;
import it.maggioli.appalti.rest.functions.TransformGareCategorieToCategoriePrestazioniDto;
import it.maggioli.appalti.rest.functions.TransformGareLottiToGareLottiDto;
import it.maggioli.appalti.rest.repositories.CaisRepository;
import it.maggioli.appalti.rest.repositories.WdocdigRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoDettaglioRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoDocumentoLottoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.ComunicazioneDocumentoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.ComunicazioneRepository;
import it.maggioli.appalti.rest.repositories.views.ws.GareLottiRepository;
import it.maggioli.appalti.rest.repositories.views.ws.PuntoIstruttoreRepository;
import it.maggioli.appalti.rest.repositories.views.ws.PuntoOrdinanteRepository;
import it.maggioli.appalti.rest.specifications.BandoSpecification;
import it.maggioli.appalti.rest.utils.Transform;

/**
 * Servizio per la gestione delle richieste per il Bando di Gara
 * @author gabriele.nencini
 *
 */
@Service
@SuppressWarnings("java:S3749")
public class BandoManager implements Serializable {
  private static final long serialVersionUID = 1L;
  private static final Logger logger = LoggerFactory.getLogger(BandoManager.class);
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
  @Autowired
  private BandoRepository baRepository;
  @Autowired
  private CaisRepository cRepository;

  private TransformBandoToBandoTestataDto bandoToBandoTestata = new TransformBandoToBandoTestataDto();
  private TransformBandoDocumentoToBandoDocumentoDto bandoDocToBandoDocDTO = new TransformBandoDocumentoToBandoDocumentoDto();

  public PageDto<BandoTestataDto> getElencoBandi(
          String stazioneAppaltante
          , String titolo
          , String cig
          , Integer tipoAppalto
          , Date dataPubblicazioneDa
          , Date dataPubblicazioneA
          , Date dataScadenzaDa
          , Date dataScadenzaA
          , Boolean sommaUrgenza
          , StatoInCorsoScadutoEnum statoInCorsoScaduto
          , Integer numAnniPubblicazione
          , Date dataUltimaModificaDA
          , Date dataUltimaModificaA
          , int page
          , int pageSize
        ) {
    logger.debug("START - getElencoBandi");

    PageRequest pageRequest = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
    GregorianCalendar dataMinimaPubblicazione = new GregorianCalendar();
    Integer annoMinimoPubblicazione = dataMinimaPubblicazione.get(Calendar.YEAR) - numAnniPubblicazione;

    Page<Bando> pageBa = baRepository.findAll(
            BandoSpecification.getBandoSpecification(
                    stazioneAppaltante, titolo, cig, tipoAppalto, dataPubblicazioneDa, dataPubblicazioneA,
                    dataScadenzaDa, dataScadenzaA, null, null, null,
                    sommaUrgenza, statoInCorsoScaduto, annoMinimoPubblicazione,dataUltimaModificaDA, dataUltimaModificaA
            ), pageRequest);

    PageDto<BandoTestataDto> pageDto = new PageDto<>();
    BeanUtils.copyProperties(pageBa, pageDto, "content");
    pageDto.setContent(Transform.transform(pageBa.getContent(), bandoToBandoTestata));

    logger.debug("END - getElencoBandi");
    return pageDto;
  }

  public Optional<DettaglioDto<DatiGeneraliDto,BandoDocumentoDto,ComunicazioneDto>> getBandoDettaglio(String riferimentoProcedura) {
    logger.debug("START - getBandoDettaglio");

    Optional<BandoDettaglio> ob = baDetRepository.findById(riferimentoProcedura);
    if(ob.isPresent()) {
      
      DettaglioDto<DatiGeneraliDto,BandoDocumentoDto,ComunicazioneDto> dettaglioDto = new DettaglioDto<>();
      
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
      datiGenerali.setDatiProceduralotti(transform(lottiList, functionGareLottiDto));
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
      if(documentiLotto.size()>0) {
        Map<Integer, List<BandoDocumento>> gruppoDocumentiLotto = documentiLotto.stream()
            .filter(documento -> documento!=null && documento.getGruppo()!=null)
            .collect(Collectors.groupingBy(BandoDocumento::getGruppo));
        logger.debug("gruppoDocumentiLotto.keySet(): {}",gruppoDocumentiLotto.keySet());
        if(!filterDocinvitoPubblicaVisible) {
          gruppoDocumentiLotto.remove(6);
        }
        
        List<BandoDocumento> listOfDocumentiGara = gruppoDocumentiLotto.get(1);
        if(listOfDocumentiGara!=null && listOfDocumentiGara.size()>0) {
          logger.debug("gruppoDocumentiLotto.get(1): {}",listOfDocumentiGara.size());
          dettaglioDto.setDocumentazione(transformCheckNull(listOfDocumentiGara, bandoDocToBandoDocDTO));
        }
        
      }
      
      //TODO filter by conf params
      resp = confManager.getProperty(ConfigurationManager.GARE_ATTIDOCART29_VIS);
      boolean filterAttiDocVisible = Boolean.valueOf(resp.getValore());
      logger.info("{} -> {}",resp,filterAttiDocVisible);
      
      if(filterAttiDocVisible) {
        List<BandoDocumento> listOfAltriDocumenti = bdlRepository.findAttiDocumentiBando(riferimentoProcedura);
        if(listOfAltriDocumenti!=null && listOfAltriDocumenti.size()>0) {
          datiGenerali.setAttiDocumenti(transformCheckNull(listOfAltriDocumenti, bandoDocToBandoDocDTO));
        }
      }
      
      List<Comunicazione> comunicazioniGara = comRepository.findAll(BandoSpecification.getComunicazioneSpecification(riferimentoProcedura,sa.getCodice()));
      logger.debug("comunicazioniGara.size: {}", comunicazioniGara.size());
      dettaglioDto.setComunicazioni(transformCheckNull(comunicazioniGara, functionComunicazione));
      
      logger.info("{}", dettaglioDto);
      return Optional.of(dettaglioDto);
    }
    logger.debug("END - getBandoDettaglio");

    return Optional.empty();
  }
  
  public Optional<FileDto> downloadFileDaComunicazione(Long idcom, Long iddoc,String filedoc) {
    //controllo che il file richiesto sia effettivamente per quella comunicazione 
    //e che questa sia nella vista delle comunicazioni pubbliche
    ComunicazioneDocumento doc = comDocRepository.findByIdprg_idcom_iddoc_filedoc("PG", idcom, iddoc, filedoc);
    if(doc!=null) {
      Optional<Wdocdig> op = wdocdigRepository.findById(new WdocdigIdentity("PG", doc.getIddoc()));
      if(op.isPresent()) {
        return Optional.of(new FileDto(op.get().getDignomdoc(), Base64.getEncoder().encodeToString(op.get().getDigogg())));
      }
    }
    return Optional.empty();
  }
  
  public Optional<FileDto> downloadFileDaEsito(Long iddoc,String nomeFile, String proceduraRiferimento) {
    return getFileToDownload(
            bdlRepository.findEsitoFile(iddoc, proceduraRiferimento, nomeFile, Collections.singleton(4))
    );
  }
  
  public Optional<FileDto> downloadFileDaGara(Long iddoc,String nomeFile, String proceduraRiferimento) {
    return getFileToDownload(iddoc, nomeFile, proceduraRiferimento, DocumentoGruppoEnum.getListByValues());
  }

  public Optional<FileDto> downloadFileDaAvviso(Long iddoc,String nomeFile, String proceduraRiferimento) {
    //controllo che il file richiesto sia effettivamente per quella gara pubblica
    return getFileToDownload(
            bdlRepository.findByIdAndCodiceAndNgaraAndNomefileAndGruppoIn(
                    iddoc, proceduraRiferimento, proceduraRiferimento, nomeFile, Collections.singletonList(1)
            )
    );
  }
  
  public Optional<FileDto> downloadAttoDocumentoFileDaGara(Long iddoc,String nomeFile, String proceduraRiferimento) {
    return getFileToDownload(iddoc, nomeFile, proceduraRiferimento, Arrays.asList(10, 15));
  }

  private Optional<FileDto> getFileToDownload(Long iddoc, String nomeFile, String proceduraRiferimento, Collection<Integer> listByValues) {
    return getFileToDownload(
            bdlRepository.findByIdAndCodiceAndNomefileAndGruppoIn(
                    iddoc, proceduraRiferimento, nomeFile, listByValues
            )
    );
  }

  private Optional<FileDto> getFileToDownload(BandoDocumento doc) {
    Optional<FileDto> toReturn = Optional.empty();
    //controllo che il file richiesto sia effettivamente per quella gara pubblica
    if(doc != null) {
      Wdocdig docDig = wdocdigRepository.findById(new WdocdigIdentity("PG", doc.getId())).orElse(null);
      if(docDig != null)
        toReturn = Optional.of(new FileDto(docDig.getDignomdoc(), Base64.getEncoder().encodeToString(docDig.getDigogg())));
    }
    return toReturn;
  }

  public List<Cais> getCategorieMerceologiche(String codiceCategoria) {
	List<Cais> cais = null;
	if(StringUtils.isBlank(codiceCategoria)) {
		cais = cRepository.findByisarchiNot("1");
	} else {
		cais = cRepository.findByIsarchiNotAndCaisim("1", codiceCategoria);
	}    
	return cais;
  }
}
