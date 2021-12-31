package it.maggioli.appalti.rest.manager;

import static it.maggioli.appalti.rest.specifications.AvvisoSpecification.getAvvisoSpecification;
import static it.maggioli.appalti.rest.specifications.BandoSpecification.getBandoDocumentoLottoSpecification;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.maggioli.appalti.rest.configuration.response.ConfigurationResponse;
import it.maggioli.appalti.rest.dto.AvvisoTestataDto;
import it.maggioli.appalti.rest.dto.BandoDocumentoDto;
import it.maggioli.appalti.rest.dto.ComunicazioneDto;
import it.maggioli.appalti.rest.dto.DatiGeneraliAvvisoDto;
import it.maggioli.appalti.rest.dto.DettaglioDto;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.dto.StazioneAppaltanteDto;
import it.maggioli.appalti.rest.entities.views.ws.AderenteLotto;
import it.maggioli.appalti.rest.entities.views.ws.Avviso;
import it.maggioli.appalti.rest.entities.views.ws.Comunicazione;
import it.maggioli.appalti.rest.enums.StatoInCorsoScadutoEnum;
import it.maggioli.appalti.rest.functions.TransformAderenteLottoToSoggettoAderenteDto;
import it.maggioli.appalti.rest.functions.TransformAvvisoToAvvisoTestataDto;
import it.maggioli.appalti.rest.functions.TransformBandoDocumentoToBandoDocumentoDto;
import it.maggioli.appalti.rest.functions.TransformComunicazioneDocumentoToComunicazioneDocumentoDto;
import it.maggioli.appalti.rest.functions.TransformComunicazioneToComunicazioneDto;
import it.maggioli.appalti.rest.repositories.views.ws.AderenteLottoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.AvvisoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoDocumentoLottoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.ComunicazioneRepository;
import it.maggioli.appalti.rest.specifications.BandoSpecification;

/**
 * Servizio che gestisce le richieste per gli Avvisi
 * @author gabriele.nencini
 *
 */
@Service
public class AvvisoManager {
  private static final Logger logger = LoggerFactory.getLogger(AvvisoManager.class);
  private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private TransformAvvisoToAvvisoTestataDto functionToTestata = new TransformAvvisoToAvvisoTestataDto();
  private TransformBandoDocumentoToBandoDocumentoDto functionToBandoDocumentoDto = new TransformBandoDocumentoToBandoDocumentoDto();
  private TransformAderenteLottoToSoggettoAderenteDto functionToSoggettoAderenteDto = new TransformAderenteLottoToSoggettoAderenteDto();
  @Autowired
  private AvvisoRepository avRepository;
  @Autowired
  private BandoDocumentoLottoRepository bdlRepository;
  @Autowired
  private ComunicazioneRepository comRepository;
  @Autowired
  private AderenteLottoRepository adlRepository;
  @Autowired
  private ConfigurationManager cfgManager;
  
  public Optional<PageDto<AvvisoTestataDto>> getAvvisi(final String stazioneAppaltante,
      final String oggetto,
      final Integer tipoAvviso,
      final Date dataPubblicazioneDa,
      final Date dataPubblicazioneA,
      final Date dataScadenzaDa,
      final Date dataScadenzaA,
      final Integer altriSoggetti,
      final StatoInCorsoScadutoEnum statoInCorsoScaduto,
      final Integer numAnniPubblicazione,int page, int pageSize,
      final Date dataUltimaModificaDA,
      final Date dataUltimaModificaA){
    long start = System.currentTimeMillis();
    //A1081 tabellato
    
    GregorianCalendar dataMinimaPubblicazione = new GregorianCalendar();
    Integer annoMinimoPubblicazione = dataMinimaPubblicazione.get(Calendar.YEAR) - numAnniPubblicazione ;
    
    PageRequest pageRequest = PageRequest.of(page>0?page-1:0, pageSize);
    Page<Avviso> pagedAvv = avRepository.findAll(getAvvisoSpecification(stazioneAppaltante,
      oggetto,
      tipoAvviso,
      dataPubblicazioneDa,
      dataPubblicazioneA,
      dataScadenzaDa,
      dataScadenzaA,
      altriSoggetti,
      statoInCorsoScaduto,
      annoMinimoPubblicazione,
      dataUltimaModificaDA,
      dataUltimaModificaA), pageRequest );
    
    PageDto<AvvisoTestataDto> pageDto = new PageDto<AvvisoTestataDto>();
    BeanUtils.copyProperties(pagedAvv, pageDto);
    pageDto.setContent(pagedAvv.getContent().stream().map(functionToTestata::apply).collect(Collectors.toList()));
    logger.info("Total time spent in method: {}",(System.currentTimeMillis()-start));
    return Optional.of(pageDto);
  }
  
  public Optional<DettaglioDto<DatiGeneraliAvvisoDto, BandoDocumentoDto, ComunicazioneDto>> getDettaglioAvviso(String proceduraRiferimento){
    Optional<Avviso> opAvviso = avRepository.findById(proceduraRiferimento);
    if(opAvviso.isPresent()) {
      DettaglioDto<DatiGeneraliAvvisoDto, BandoDocumentoDto, ComunicazioneDto> dettaglio = new DettaglioDto<DatiGeneraliAvvisoDto, BandoDocumentoDto, ComunicazioneDto>();
      Avviso av = opAvviso.get();
      
      StazioneAppaltanteDto sa = new StazioneAppaltanteDto();
      sa.setCodice(av.getCodsa());
      sa.setDenominazione(av.getDescsa());
      dettaglio.setStazioneAppaltante(sa);
      
      DatiGeneraliAvvisoDto datiGen = new DatiGeneraliAvvisoDto();
      if(Objects.nonNull(av.getDatpub()))
        datiGen.setDataPubblicazione(sdfDate.format(av.getDatpub()));
      if(Objects.nonNull(av.getDataorascadenza()))
        datiGen.setDataScadenza(sdfDate.format(av.getDataorascadenza()));
      if(Objects.nonNull(av.getDultagg()))
        datiGen.setDataUltimaModifica(av.getDultagg());
      datiGen.setProceduraRiferimento(proceduraRiferimento);
      datiGen.setTipologiaAppalto(av.getDesctipoapp());
      datiGen.setTipologiaAvviso(av.getDesctipoavv());
      datiGen.setTitolo(av.getOggetto());
      
      dettaglio.setDatiGenerali(datiGen);
      
      //TODO insert dati per soggetti aderenti solo se configurazione abilitata
      ConfigurationResponse resp = cfgManager.getProperty(ConfigurationManager.GARE_ADERENTI_VIS);
      boolean filterSoggettAderentiVisible = Boolean.valueOf(resp.getValore());
      logger.debug("Filtro soggetti aderenti a {}",filterSoggettAderentiVisible);
      if(filterSoggettAderentiVisible) {
        logger.debug("Filtro soggetti aderenti a true");
        List<AderenteLotto> aderenteLottoList = adlRepository.getSoggettiAderenti(proceduraRiferimento);
        if(aderenteLottoList!=null && aderenteLottoList.size()>0) {
          dettaglio.setSoggettiAderenti(aderenteLottoList.stream().filter(Objects::isNull).map(functionToSoggettoAderenteDto::apply).collect(Collectors.toList()));
        }
      }
      // i documenti di un avviso hanno codice gara = codice lotto e sono
      // sull'avviso perche' i lotti non esistono
      dettaglio.setDocumentazione(bdlRepository.findAll(getBandoDocumentoLottoSpecification(av.getCodice(),av.getCodice(),Collections.singleton(1)))
                                                        .stream().filter(Objects::nonNull).map(functionToBandoDocumentoDto::apply).collect(Collectors.toList()));
      
      //comunicazioni + documenti
      List<Comunicazione> comunicazioniGara = comRepository.findAll(BandoSpecification.getComunicazioneSpecification(proceduraRiferimento,sa.getCodice()));
      if(!comunicazioniGara.isEmpty()) {
        TransformComunicazioneToComunicazioneDto functionComunicazione = new TransformComunicazioneToComunicazioneDto(new TransformComunicazioneDocumentoToComunicazioneDocumentoDto());
        dettaglio.setComunicazioni(comunicazioniGara.stream().filter(Objects::nonNull).map(functionComunicazione::apply).collect(Collectors.toList()));
      }
      return Optional.of(dettaglio);
    }
    
    return Optional.empty();
  }
}
