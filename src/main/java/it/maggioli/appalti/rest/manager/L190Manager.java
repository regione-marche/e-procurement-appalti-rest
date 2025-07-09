package it.maggioli.appalti.rest.manager;

import static it.maggioli.appalti.rest.specifications.AnticorruzioneSpecification.getAvvisoSpecification;
import static it.maggioli.appalti.rest.utils.Transform.transform;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.anticor.entities.Anticor;
import it.maggioli.appalti.rest.anticor.entities.Anticorlotti;
import it.maggioli.appalti.rest.anticor.repositories.AnticorlottiRepository;
import it.maggioli.appalti.rest.dto.AdempimentoAnticorruzioneDto;
import it.maggioli.appalti.rest.dto.GaraAntiCorruzioneDto;
import it.maggioli.appalti.rest.dto.GaraAnticorruzioneDittaDto;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.entities.Garecont;
import it.maggioli.appalti.rest.entities.Uffint;
import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.entities.views.ws.AdempimentiAnticor;
import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzione;
import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzioneDitta;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltanteL190;
import it.maggioli.appalti.rest.exceptions.Error404Exception;
import it.maggioli.appalti.rest.functions.TransformAdempimentiAnticorToAdempimentiAnticorDto;
import it.maggioli.appalti.rest.functions.TransformGareAnticorruzioneDittaToGareAnticorruzioneDittaDto;
import it.maggioli.appalti.rest.functions.TransformGareAnticorruzioneToGaraAnticorruzioneDto;
import it.maggioli.appalti.rest.repositories.GareRepository;
import it.maggioli.appalti.rest.repositories.GarecontRepository;
import it.maggioli.appalti.rest.repositories.UffintRepository;
import it.maggioli.appalti.rest.repositories.views.ws.AdempimentiAnticorRepository;
import it.maggioli.appalti.rest.repositories.views.ws.GareAnticorruzioneDittaRepository;
import it.maggioli.appalti.rest.repositories.views.ws.GareAnticorruzioneRepository;
import it.maggioli.appalti.rest.repositories.views.ws.StazioneAppaltanteL190Repository;

/**
 * Servizio per la gestione delle richieste per la Legge 190 (Anticorruzione)
 * @author gabriele.nencini
 *
 */
@Service
@SuppressWarnings("java:S3749")
public class L190Manager {
  
  private static final Logger logger = LoggerFactory.getLogger(L190Manager.class);
  
  private final TransformGareAnticorruzioneDittaToGareAnticorruzioneDittaDto functionDitteToDto = new TransformGareAnticorruzioneDittaToGareAnticorruzioneDittaDto();
  private final TransformGareAnticorruzioneToGaraAnticorruzioneDto functionGaraToDto = new TransformGareAnticorruzioneToGaraAnticorruzioneDto();
  private final TransformAdempimentiAnticorToAdempimentiAnticorDto functionAdempimentiAnticorToDto = new TransformAdempimentiAnticorToAdempimentiAnticorDto();
  
  @Autowired
  private StazioneAppaltanteL190Repository saRepository;
  @Autowired
  private GareAnticorruzioneRepository gaRepository;
  @Autowired
  private GareAnticorruzioneDittaRepository gadRepository;
  @Autowired
  private AdempimentiAnticorRepository aaRepository;
  @Autowired
  private GarecontRepository gcRepository;
  @Autowired
  private AnticorlottiRepository alRepository;
  @Autowired
  private UffintRepository uffRepository;
  @Autowired
  private WlogEventiManager wleManager;
  
  public List<StazioneAppaltanteL190> getAllStazioneAppaltanteL190(){
    return saRepository.findDistinctByDenominazioneNotNullOrderByCodiceAsc();
  }
  
  /**
   * 
   * Restituisce i dati legati alla legge 190.<br>
   * I dati fanno riferimenti alla vista v_ws_gare_anticor
   * 
   * @param page - il numero di pagina da richiedere (parte da 1)
   * @param pageSize - il numero massimo di elementi per pagina da restituire
   * @param annorif - anno di riferimento dei dati
   * @param codiceStazioneAppaltante - codice della stazione appaltante
   * @param codicegara - codice interno della gara (campo codicegara nuovo)
   * @param cig - cig di riferimento
   * @param oggetto - oggetto
   * @param dataPubblicazione - data in cui è stato pubblicato su portale appalti (campo datapubbl nuovo)
   * @return {@link PageDto}
   */
  @Deprecated
  public PageDto<GaraAntiCorruzioneDto> getElencoDati(
      int page,
      int pageSize,
      Integer annorif,
      String codiceStazioneAppaltante,
      String codicegara,
      String cig,
      String oggetto,
      Date dataPubblicazione
  ){
    
    PageRequest pageRequest = PageRequest.of(page>0?page-1:0, pageSize);
    
    Page<GareAnticorruzione> pageGareAntic = gaRepository.findAll(getAvvisoSpecification(annorif, codiceStazioneAppaltante, codicegara, cig, oggetto, dataPubblicazione),pageRequest);
    PageDto<GaraAntiCorruzioneDto> pageDto = new PageDto<GaraAntiCorruzioneDto>();
    BeanUtils.copyProperties(pageGareAntic, pageDto,"content","partecipanti","assegnatari");
    // leggere tutte le ditte relative alla gara
    
    Set<Long> ids = pageGareAntic.getContent().stream().map(GareAnticorruzione::getIdanticorlotti).collect(Collectors.toSet());
    logger.info("Found unique ids {}",ids.size());
    List<GareAnticorruzioneDitta> listDitte = gadRepository.findByIdanticorlottiIn(ids);
    logger.info("Found Ditte {}",listDitte.size());
    // impostare i dati secondo la discriminante aggiudicataria e non
    
    /*
     * uso java 8 per fare una mappa di mappe:
     * mappa con chiave l'dentificativo del lotto (getIdanticorlotti)
     *  - sub mappa con chiave il booleano (stringa con valore 1 o 2) per sapere se è assegnataria o meno
     */
    final Map<Long, Map<String, List<GaraAnticorruzioneDittaDto>>> mapsForAll = listDitte
        .stream()
        .collect(Collectors.groupingBy(GareAnticorruzioneDitta::getIdanticorlotti,TreeMap::new,
            Collectors.groupingBy(GareAnticorruzioneDitta::getAggiudicataria,
                Collectors.mapping(functionDitteToDto::apply, Collectors.toList()))));
    //inserisco la mappa nella funzione di trasformazione
    functionGaraToDto.setMapsForAll(mapsForAll);
    pageDto.setContent(transform(pageGareAntic.getContent(), functionGaraToDto));
    
    return pageDto;
  }
  
  public PageDto<AdempimentoAnticorruzioneDto> getElencoAdempimenti(int page,
      int pageSize,
      Integer annorif){
    PageRequest pageRequest = PageRequest.of(page>0?page-1:0, pageSize);
    Page<AdempimentiAnticor> pageResult = aaRepository.findAllByIdentityAnnorif(pageRequest, annorif);
    
    logger.info("{}",pageResult.getContent());
    PageDto<AdempimentoAnticorruzioneDto> pageDto = new PageDto<>();
    BeanUtils.copyProperties(pageResult, pageDto,"content");
    pageDto.setContent(transform(pageResult.getContent(), functionAdempimentiAnticorToDto));

    return pageDto;
  }
  public PageDto<GaraAntiCorruzioneDto> getElencoDati(
      int page,
      int pageSize,
      Integer annorif,
      String codiceStazioneAppaltante,
      String codicegara,
      String cig,
      String oggetto
      ){
    
    PageRequest pageRequest = PageRequest.of(page>0?page-1:0, pageSize);
    
    Page<GareAnticorruzione> pageGareAntic = gaRepository.findAll(getAvvisoSpecification(annorif, codiceStazioneAppaltante, codicegara, cig, oggetto), pageRequest);
    PageDto<GaraAntiCorruzioneDto> pageDto = new PageDto<>();
    BeanUtils.copyProperties(pageGareAntic, pageDto,"content","partecipanti","assegnatari");
    // leggere tutte le ditte relative alla gara
    
    Set<Long> ids = pageGareAntic.getContent().stream().map(GareAnticorruzione::getIdanticorlotti).collect(Collectors.toSet());
    logger.info("Found unique ids {}",ids.size());
    List<GareAnticorruzioneDitta> listDitte = gadRepository.findByIdanticorlottiIn(ids);
    logger.info("Found Ditte {}",listDitte.size());
    // impostare i dati secondo la discriminante aggiudicataria e non

    /*
     * uso java 8 per fare una mappa di mappe:
     * mappa con chiave l'dentificativo del lotto (getIdanticorlotti)
     *  - sub mappa con chiave il booleano (stringa con valore 1 o 2) per sapere se è assegnataria o meno
     */
    final Map<Long, Map<String, List<GaraAnticorruzioneDittaDto>>> mapsForAll =
            listDitte
              .stream()
            .collect(
                Collectors.groupingBy(
                    GareAnticorruzioneDitta::getIdanticorlotti
                    , TreeMap::new
                    , Collectors.groupingBy(
                            GareAnticorruzioneDitta::getAggiudicataria
                            , Collectors.mapping(functionDitteToDto::apply, Collectors.toList())
                      )
                )
            );
    //inserisco la mappa nella funzione di trasformazione
    functionGaraToDto.setMapsForAll(mapsForAll);
    pageDto.setContent(transform(pageGareAntic.getContent(), functionGaraToDto));
    
    return pageDto;
  }
  
  @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
  public Optional<Integer> updateDatiCig(String cig,String codiceFiscaleSA , Double importoLiquidato, Date dataInizio, Date dataFine, Integer opzione, Long syscon, String sourceIp) throws Exception {
    logger.info("Called updateDatiCig for cig {},cf {} with: [importoLiquidato: {}, dataInizio: {}, dataFine: {}, opzione: {}]",cig,codiceFiscaleSA,importoLiquidato,  dataInizio, dataFine, opzione);
    // 1 cerco la uffint
    List<Uffint> listaUffint = uffRepository.findByCfein(codiceFiscaleSA);
    if(listaUffint.isEmpty()) throw new Error404Exception("Impossibile trovare il Codice Fiscale '"+codiceFiscaleSA+"'");
    Set<String> codeinList = listaUffint.stream().map(Uffint::getCodein).collect(Collectors.toSet());
    // 2 cerco le garecont
    String aggiudicataria = gcRepository.checkForUpdateWithUffintHQL(cig, codeinList);
    if(StringUtils.isBlank(aggiudicataria))  throw new Error404Exception("Il cig '"+cig+"' non ha aggiudicatari o non fa riferimento al Codice Fiscale '"+codiceFiscaleSA+"'");
    List<Garecont> listToUpdate = gcRepository.findForUpdateWithUffintHQL(cig, codeinList);
    if(listToUpdate.isEmpty()) throw new Error404Exception("Impossibile trovare il cig '"+cig+"' o non fa riferimento al Codice Fiscale '"+codiceFiscaleSA+"'");
    String descrEvent = "Aggiornamento completo dei dati in Garecont, totale dati aggiornati: ";
    
    logger.info("Garecont trovate: {}",listToUpdate.size());
    switch(opzione) {
    case 1:
      logger.info("Sovrascrivere completamente i dati per il cig {}",cig);
      listToUpdate.forEach(el->{
        if(importoLiquidato!=null) {
          el.setImpliq(BigDecimal.valueOf(importoLiquidato));
        }
        if(dataInizio!=null) {
          el.setDverbc(dataInizio);
        }
        if(dataFine!=null) {
          el.setDcertu(dataFine);
        }
      });
      break;
    case 2:
      logger.info("Sovrascrivo dati solo per condizione per il cig {}",cig);
      descrEvent = "Aggiornamento parziale dei dati in Garecont, massimo numero di dati aggiornati: ";
      listToUpdate.forEach(el->{
        if(importoLiquidato!=null) {
          BigDecimal impLiq = BigDecimal.valueOf(importoLiquidato);
          if(el.getImpliq()==null || el.getImpliq().compareTo(impLiq)==-1){
            el.setImpliq(impLiq);
          }
        }
        if(el.getDverbc()==null) {
          el.setDverbc(dataInizio);
        }
        if(el.getDcertu()==null) {
          el.setDcertu(dataFine);
        }
      });
      break;
    default:
      return Optional.empty();
    }
    gcRepository.saveAll(listToUpdate);
    
    // inserimento w_logeventi
    Wlogeventi evento = new Wlogeventi();
    evento.setCod_profilo("APPALTI_REST");
    evento.setCodapp("WS");
    evento.setCodevento("UPDATE_GARECONT");
    evento.setDescr(descrEvent+listToUpdate.size());
    evento.setIpevento(sourceIp);
    evento.setLivevento(1);
    evento.setOggevento(cig);
    evento.setSyscon(syscon);
    wleManager.saveWlogEventi(evento);
    
    return Optional.of(listToUpdate.size());
  }
  
  @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
  public Optional<Integer> updateDatiAnticorCig(String cig, Double importoLiquidato, Date dataInizio, Date dataFine,String cfSa, Integer opzione, Long syscon, String sourceIp) throws Exception {
    logger.info("Called updateDatiAnticorCig for cig {},cf {} with: [importoLiquidato: {}, dataInizio: {}, dataFine: {}, opzione: {}]",cig,cfSa,importoLiquidato,  dataInizio, dataFine, opzione);
    // 1 cerco la uffint
    List<Uffint> listaUffint = uffRepository.findByCfein(cfSa);
    Set<String> codeinList = listaUffint.stream().map(Uffint::getCodein).collect(Collectors.toSet());
    Anticorlotti probe = new Anticorlotti();
    probe.setCig(cig);
    ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues();
    Example<Anticorlotti> ex = Example.of(probe, matcher);
    List<Anticorlotti> listaAnticor = alRepository.findAll(ex);
    logger.info("Con cig {} trovati AnticorLotti[{}]",cig,listaAnticor.size());
    if(listaAnticor.isEmpty()) return Optional.empty();
    Map<Anticor,Anticorlotti> mapOfData =
            listaAnticor.stream()
              .filter(this::isNotCompleted)
              .filter(el -> codeinList.contains(el.getAnticor().getCodein()))
            .collect(Collectors.toMap(Anticorlotti::getAnticor, Function.identity()));
    if(mapOfData.isEmpty()
      || updateAnticor(importoLiquidato, dataInizio, dataFine, opzione, mapOfData).isEmpty()) return Optional.empty();
    logger.info("Aggiornato il cig {} per la SA con C.F. {}",cig,cfSa);
//    Wlogeventi evento = new Wlogeventi();
//    evento.setCod_profilo("APPALTI_REST");
//    evento.setCodapp("WS");
//    evento.setCodevento("UPDATE_ANTICORLOTTI");
//    evento.setDescr("Aggiornati per cfSa:'"+cfSa+"' anticorlotti: "+mapOfData.size());
//    evento.setIpevento(sourceIp);
//    evento.setLivevento(1);
//    evento.setOggevento(cig);
//    evento.setSyscon(syscon);
//    wleManager.saveWlogEventi(evento);
    return Optional.of(mapOfData.size());
  }

  private Optional<Integer> updateAnticor(Double importoLiquidato, Date dataInizio, Date dataFine, Integer opzione,
                                       Map<Anticor, Anticorlotti> mapOfData) {
    switch(opzione) {
    case 1:
      mapOfData.forEach((k, v)->{
        if(importoLiquidato !=null)
          v.setImpsommeliq(importoLiquidato);
        if(dataInizio !=null)
          v.setDatainizio(dataInizio);
        if(dataFine !=null)
          v.setDataultimazione(dataFine);
      });
      break;
    case 2:
      mapOfData.forEach((k, v)->{
        if(importoLiquidato !=null && (v.getImpsommeliq()==null || v.getImpsommeliq()< importoLiquidato))
          v.setImpsommeliq(importoLiquidato);
        if(v.getDatainizio()==null)
          v.setDatainizio(dataInizio);
        if(v.getDataultimazione()==null)
          v.setDataultimazione(dataFine);
      });
      break;
    default:
      return Optional.empty();
    }
    alRepository.saveAll(mapOfData.values());
    return Optional.of(mapOfData.size());
  }

  private boolean isNotCompleted(Anticorlotti anticor) {
    return !"1".equalsIgnoreCase(anticor.getAnticor().getCompletato());
  }

}
