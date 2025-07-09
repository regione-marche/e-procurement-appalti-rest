package it.maggioli.appalti.rest.manager;

import static it.maggioli.appalti.rest.specifications.BandoSpecification.getBandoDocumentoLottoSpecification;
import static it.maggioli.appalti.rest.specifications.EsitoSpecification.getEsitoSpecification;
import static it.maggioli.appalti.rest.utils.Transform.transform;
import static it.maggioli.appalti.rest.utils.Transform.transformCheckNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.configuration.response.ConfigurationResponse;
import it.maggioli.appalti.rest.dto.BandoDocumentoDto;
import it.maggioli.appalti.rest.dto.DatiGeneraliDto;
import it.maggioli.appalti.rest.dto.DettaglioDto;
import it.maggioli.appalti.rest.dto.EsitoLottoDto;
import it.maggioli.appalti.rest.dto.EsitoTestataDto;
import it.maggioli.appalti.rest.dto.IEsitoLottoDto;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.dto.StazioneAppaltanteDto;
import it.maggioli.appalti.rest.entities.views.ws.AderenteLotto;
import it.maggioli.appalti.rest.entities.views.ws.BandoDocumento;
import it.maggioli.appalti.rest.entities.views.ws.Esito;
import it.maggioli.appalti.rest.entities.views.ws.GareLotti;
import it.maggioli.appalti.rest.entities.views.ws.GareNAggiudicatari;
import it.maggioli.appalti.rest.functions.TransformAderenteLottoToSoggettoAderenteDto;
import it.maggioli.appalti.rest.functions.TransformBandoDocumentoToBandoDocumentoDto;
import it.maggioli.appalti.rest.functions.TransformEsitoToEsitoTestataDto;
import it.maggioli.appalti.rest.functions.TransformIEsitoLottoDtoToEsitoLottoDto;
import it.maggioli.appalti.rest.repositories.views.ws.AderenteLottoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.BandoDocumentoLottoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.EsitoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.GareLottiRepository;
import it.maggioli.appalti.rest.repositories.views.ws.GareNAggiudicatariRepository;

/**
 * Servizio per la gestione delle richieste per gli Esiti
 * @author gabriele.nencini
 *
 */
@Service
@SuppressWarnings("java:S3749")
public class EsitoManager {
  private static final Logger logger = LoggerFactory.getLogger(EsitoManager.class);
  private SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private TransformBandoDocumentoToBandoDocumentoDto functionToBandoDocumentoDto = new TransformBandoDocumentoToBandoDocumentoDto();
  private TransformIEsitoLottoDtoToEsitoLottoDto functionToEsitoLottoDto = new TransformIEsitoLottoDtoToEsitoLottoDto();
  private TransformAderenteLottoToSoggettoAderenteDto functionToSoggettoAderenteDto = new TransformAderenteLottoToSoggettoAderenteDto();
  @Autowired
  private EsitoRepository esitoRepository;
  @Autowired
  private BandoDocumentoLottoRepository bdRepository;
  @Autowired
  private GareNAggiudicatariRepository gnaRepository;
  @Autowired
  private GareLottiRepository glRepository;
  @Autowired
  private AderenteLottoRepository adlRepository;
  @Autowired
  private ConfigurationManager confManager;
  
  private TransformEsitoToEsitoTestataDto functionEsitoToTestata = new TransformEsitoToEsitoTestataDto();
  public Optional<PageDto<EsitoTestataDto>> getEsiti(final String stazioneAppaltante,
      final String oggetto,
      final String cig,
      final Integer tipoAppalto,
      final Date dataPubblicazioneDa,
      final Date dataPubblicazioneA,
      final Boolean proceduraTelematica,
      final Integer altriSoggetti,
      final Boolean sommaUrgenza,
      final Integer numAnniPubblicazione,int page, int pageSize,
      final Date dataUltimaModificaDA,
      final Date dataUltimaModificaA){
    PageRequest pageRequest = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
    
    GregorianCalendar dataMinimaPubblicazione = new GregorianCalendar();
    Integer annoMinimoPubblicazione = dataMinimaPubblicazione.get(Calendar.YEAR) - numAnniPubblicazione ;
    
    Page<Esito> pageEsito = esitoRepository.findAll(
            getEsitoSpecification(
                    stazioneAppaltante
                    , oggetto
                    , cig
                    , tipoAppalto
                    , dataPubblicazioneDa
                    , dataPubblicazioneA
                    , proceduraTelematica
                    , altriSoggetti
                    , sommaUrgenza
                    , annoMinimoPubblicazione
                    , dataUltimaModificaDA
                    , dataUltimaModificaA
            ), pageRequest);
    
    PageDto<EsitoTestataDto> pageDto = new PageDto<>();
    BeanUtils.copyProperties(pageEsito, pageDto,"content");
    pageDto.setContent(transform(pageEsito.getContent(), functionEsitoToTestata));

    return Optional.ofNullable(pageDto);
  }
  
  public void getEsitoLotto(String codiceGara) {
    List<IEsitoLottoDto> list = esitoRepository.findViewIEsitoLottoDto(codiceGara);
    logger.info("list is {}",list);
    if (list!=null)
      logger.info("list size {}",list.size());      
  }
  
  @Transactional(readOnly = true)
  public Optional<DettaglioDto<DatiGeneraliDto, BandoDocumentoDto, Object>> getDettaglioEsito(String codiceDiRiferimento) {
    //stazione appaltante
    long start = System.currentTimeMillis();
    Optional<Esito> opesito  = esitoRepository.findById(codiceDiRiferimento);
    
    if (opesito.isPresent()) {
      
      DettaglioDto<DatiGeneraliDto, BandoDocumentoDto, Object> dettaglioEsito = new DettaglioDto<>();
      
      Esito es = opesito.get();
      if (es.getGarpriv() != null) return Optional.empty(); //TODO +integrazione gare privatistiche (req:PORTAPPALT-130)
      
      StazioneAppaltanteDto sa = new StazioneAppaltanteDto();
      sa.setRup(es.getDescrup());
      sa.setCodice(es.getCodsa());
      sa.setDenominazione(es.getDescsa());
      dettaglioEsito.setStazioneAppaltante(sa);
      
      //dati generali (get esito)
      DatiGeneraliDto dg = new DatiGeneraliDto();
      dg.setTitolo(es.getOggetto());
      dg.setTipologiaAppalto(es.getDesctipoapp());
      dg.setDataPubblicazione(sdfDate.format(es.getDataesito()));
      dg.setStato(es.getDescstatoesito());
      dg.setProceduraRiferimento(es.getCodice());
      
      dettaglioEsito.setDatiGenerali(dg);
      
      //TODO insert dati per soggetti aderenti solo se configurazione abilitata
      ConfigurationResponse resp = confManager.getProperty(ConfigurationManager.GARE_ADERENTI_VIS);
      boolean filterSoggettAderentiVisible = Boolean.valueOf(resp.getValore());
      logger.debug("Filtro soggetti aderenti a {}",filterSoggettAderentiVisible);
      if (filterSoggettAderentiVisible) {
        logger.debug("Filtro soggetti aderenti a true");
        List<AderenteLotto> aderenteLottoList = adlRepository.getSoggettiAderenti(codiceDiRiferimento);
        if (aderenteLottoList != null && aderenteLottoList.size() > 0)
          dettaglioEsito.setSoggettiAderenti(transformCheckNull(aderenteLottoList, functionToSoggettoAderenteDto));
      }
      
      List<IEsitoLottoDto> esitiLotto = esitoRepository.findViewIEsitoLottoDto(es.getCodice());
      
      List<String> codiciPerAggiudicatari = null;
      List<EsitoLottoDto> listaEsitoLotto = null;
      if (!esitiLotto.isEmpty()) {
        codiciPerAggiudicatari = new ArrayList<>(esitiLotto.size());
        if (esitiLotto.size() > 1) { //ottimizzazione
          listaEsitoLotto = transform(esitiLotto, functionToEsitoLottoDto);
          dg.setDatiProceduralotti(listaEsitoLotto);
          codiciPerAggiudicatari.addAll(
                  esitiLotto.parallelStream()
                    .filter(esito -> esito != null && esito.getNgara() != null)
                    .map(IEsitoLottoDto::getNgara)
                  .collect(Collectors.toList())
          );
        } else {
          listaEsitoLotto = Collections.singletonList(functionToEsitoLottoDto.apply(esitiLotto.get(0)));
          dg.setDatiProceduralotti(listaEsitoLotto);
          codiciPerAggiudicatari.add(esitiLotto.get(0).getNgara());
        }
        
        logger.debug("codiciPerAggiudicatari: {}",codiciPerAggiudicatari);
      }
      
      
      //cerco gli atti per l'esito
      resp = confManager.getProperty(ConfigurationManager.GARE_ATTIDOCART29_VIS);
      boolean filterAttiDocVisible = Boolean.valueOf(resp.getValore());
      logger.info("{} -> {}",resp,filterAttiDocVisible);
      
      if (filterAttiDocVisible) {
        List<BandoDocumento> documentiAttiEsiti = bdRepository.findAttiDocumentiBando(codiceDiRiferimento);
        
        if (!documentiAttiEsiti.isEmpty()) {
          if (documentiAttiEsiti.size() > 1) {
            dg.setAttiDocumenti(transformCheckNull(documentiAttiEsiti, functionToBandoDocumentoDto));
          } else {
            if (Objects.nonNull(documentiAttiEsiti.get(0))) {
              dg.setAttiDocumenti(Collections.singletonList(functionToBandoDocumentoDto.apply(documentiAttiEsiti.get(0))));
            }
          }
        }
      }
      
      //documenti
      List<BandoDocumento> documentiEsiti = bdRepository.findAll(getBandoDocumentoLottoSpecification(es.getCodice(),null,Collections.singleton(4)));
      if (!documentiEsiti.isEmpty()) {
        if (documentiEsiti.size() > 1)
          dettaglioEsito.setDocumentazione(transformCheckNull(documentiEsiti, functionToBandoDocumentoDto));
        else if (Objects.nonNull(documentiEsiti.get(0)))
          dettaglioEsito.setDocumentazione(Collections.singletonList(functionToBandoDocumentoDto.apply(documentiEsiti.get(0))));
      }
      
      //ricerco gli aggiudicatari
      boolean opBool = esitoRepository.existsByCodiceAndIsaccordoquadroAndNaggiudicatari(codiceDiRiferimento, true, 1);
      final Map<String, List<String>> listAggByCodice = new HashMap<>();
      if (opBool) {
        //aggiudicatari multipli
//          List<GareNAggiudicatari> nAgg = gnaRepository.findByIdentityCodiceIn(codiciPerAggiudicatari);
        listAggByCodice.putAll(gnaRepository.findByIdentityCodiceInOrderByIdentityCodiceAscNumordAsc(codiciPerAggiudicatari).collect(Collectors.groupingBy(p -> p.getIdentity().getCodice(), Collectors.mapping(GareNAggiudicatari::getRagsoc, Collectors.toList()))));
      } else {
        //aggiudicatari singoli
//          List<GareLotti> glList = glRepository.findAllByNgaraInAndAggiudicatariaNotNull(codiciPerAggiudicatari);
        listAggByCodice.putAll(glRepository.findAllByNgaraInAndAggiudicatariaNotNull(codiciPerAggiudicatari).collect(Collectors.groupingBy(GareLotti::getNgara, Collectors.mapping(GareLotti::getAggiudicataria, Collectors.toList()))));
      }
      listaEsitoLotto.parallelStream().forEach(e-> e.setAggiudicatari(listAggByCodice.get(e.getCodiceGara())));
      logger.info("Time spent in method: {}", (System.currentTimeMillis() - start));
      return Optional.of(dettaglioEsito);
    }
    
    return Optional.empty();
  }
}
