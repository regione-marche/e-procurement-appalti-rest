package it.maggioli.appalti.rest.manager;

import static it.maggioli.appalti.rest.specifications.ContrattoSpecification.getContrattoEstesoSpecification;
import static it.maggioli.appalti.rest.specifications.ContrattoSpecification.getContrattoSpecification;
import static it.maggioli.appalti.rest.utils.Transform.transform;
import static it.maggioli.appalti.rest.utils.Transform.transformCheckNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.dto.TraspContrattoDettaglioDto;
import it.maggioli.appalti.rest.dto.TraspContrattoDto;
import it.maggioli.appalti.rest.dto.TraspContrattoEstesoDacDto;
import it.maggioli.appalti.rest.dto.TraspContrattoEstesoDto;
import it.maggioli.appalti.rest.entities.Wlogeventi;
import it.maggioli.appalti.rest.entities.views.ws.GareNAggiudicatari;
import it.maggioli.appalti.rest.entities.views.ws.ITraspContrattoCountGroupByCodice;
import it.maggioli.appalti.rest.entities.views.ws.TraspContratto;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEsteso;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEstesoDataAcqCig;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoPartecipante;
import it.maggioli.appalti.rest.functions.TransformGareNAggiudicatariToTraspContrattoPartecipanteDto;
import it.maggioli.appalti.rest.functions.TransformTraspContrattoEstesoDACToTraspContrattoEstesoDto;
import it.maggioli.appalti.rest.functions.TransformTraspContrattoEstesoToTraspContrattoEstesoDto;
import it.maggioli.appalti.rest.functions.TransformTraspContrattoPartecipanteRtiToTraspContrattoPartecipanteDto;
import it.maggioli.appalti.rest.functions.TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto;
import it.maggioli.appalti.rest.functions.TransformTraspContrattoToTraspContrattoDto;
import it.maggioli.appalti.rest.repositories.ImprRepository;
import it.maggioli.appalti.rest.repositories.views.ws.GareNAggiudicatariRepository;
import it.maggioli.appalti.rest.repositories.views.ws.TraspContrattoEstesoDataAcqCigRepository;
import it.maggioli.appalti.rest.repositories.views.ws.TraspContrattoEstesoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.TraspContrattoPartecipanteRepository;
import it.maggioli.appalti.rest.repositories.views.ws.TraspContrattoRepository;

@Component
public class TraspManager {
  private static final Logger logger = LoggerFactory.getLogger(TraspManager.class);
  
  @Autowired
  private TraspContrattoRepository tcRepository;
  @Autowired
  private GareNAggiudicatariRepository gnaRepository;
  @Autowired
  private TraspContrattoPartecipanteRepository tcpRepository;
  @Autowired
  private TraspContrattoEstesoRepository tceRepository;
  @Autowired
  private TraspContrattoEstesoDataAcqCigRepository tcedacRepository;
  @Autowired
  private ImprRepository imprRepository;
  @Autowired
  private WlogEventiManager wleManager;
  
  //TODO Ulteriori Filtri
  @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
  public PageDto<TraspContrattoDto> getContratti(int page, int pageSize, String cig, String codiceStazioneAppaltante, String oggetto, Date dataPubblicazioneEsitoDa,Date dataPubblicazioneEsitoA){
    PageRequest pageRequest = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
    Page<TraspContratto> pageData = tcRepository.findAll(getContrattoSpecification(cig, codiceStazioneAppaltante, oggetto, dataPubblicazioneEsitoDa,dataPubblicazioneEsitoA),pageRequest);
    
    Map<String,Long> mapOfAggiudicatariaMultipla = tcRepository.getTraspContrattoCountGreaterThanOneGroupByCodice().collect(Collectors.toMap(ITraspContrattoCountGroupByCodice::getCodice, ITraspContrattoCountGroupByCodice::getNelem));
    /*
     * 
     * se è aggiudicataria singola, allora non eseguo query ulteriori a DB, ma prendo il campo NOTO
     * 
     * se è aggiudicataria multipla allora carico tutti gli aggiudicatari
     */
    Map<String, List<String>> listAggByCodice = new HashMap<String, List<String>>();
    if(!mapOfAggiudicatariaMultipla.isEmpty()) {
      //creo una mappa con chiave il codice e valore la lista delle ragioni sociali delle aggiudicatarie
      listAggByCodice.putAll(gnaRepository.findByIdentityCodiceInOrderByIdentityCodiceAscNumordAsc(mapOfAggiudicatariaMultipla.keySet()).collect(Collectors.groupingBy(p -> p.getIdentity().getCodice(), Collectors.mapping(GareNAggiudicatari::getRagsoc, Collectors.toList()))));
    }
    //quindi se tutte sono aggiudicatarie singole faccio una piccola modifica altrimenti devo prendere i dati dalle query.
    TransformTraspContrattoToTraspContrattoDto function = new TransformTraspContrattoToTraspContrattoDto(listAggByCodice,!mapOfAggiudicatariaMultipla.isEmpty());
    
    PageDto<TraspContrattoDto> pageDto = new PageDto<TraspContrattoDto>();
    BeanUtils.copyProperties(pageData, pageDto,"content");
    pageDto.setContent(pageData.getContent().stream().map(function::apply).collect(Collectors.toList()));
    return pageDto;
  }

  @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
  public TraspContrattoDettaglioDto getContratto(String riferimentoProcedura) {
    Optional<TraspContratto> opContratto = tcRepository.findById(riferimentoProcedura);
    if(opContratto.isPresent()) {
      TraspContratto c = opContratto.get();
      TraspContrattoDettaglioDto dto = new TraspContrattoDettaglioDto();
      BeanUtils.copyProperties(c, dto,"partecipanti");//a causa di problemi di sessione con il lazy loading non inserisco i partecipanti
      Set<String> codimpItaliane = imprRepository.findCodimpByNazimp(Integer.valueOf(1));
      TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto function = new TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto(new TransformTraspContrattoPartecipanteRtiToTraspContrattoPartecipanteDto(codimpItaliane),codimpItaliane);
      //ottengo la lista degli operatori invitati
      logger.debug("c.getPartecipanti(): {}",(c.getPartecipanti()!=null?c.getPartecipanti().size():"null"));
      if(c.getPartecipanti()!=null && c.getPartecipanti().size()>0) {
        dto.setPartecipanti(c.getPartecipanti().stream().filter(Objects::nonNull).map(function::apply).collect(Collectors.toList()));
      }
      // verifico che sia multi aggiudicante in caso devo inserire la lista di tutti gli aggiudicatari
      if(tcRepository.existsByCodiceAndSingolaaggiudicataria(c.getCodice(), 1)) {
        TransformGareNAggiudicatariToTraspContrattoPartecipanteDto function2 = new TransformGareNAggiudicatariToTraspContrattoPartecipanteDto(tcpRepository, function);
        dto.setAggiudicatariDto(gnaRepository.findByIdentityCodiceOrderByNumord(c.getCodice()).filter(Objects::nonNull).map(function2::apply).collect(Collectors.toList()));
      } else {
        // se è aggiudicataria singola, tra gli invitati pesco la aggiudicataria singola 
        //query di hibernate dal DB? meglio
        TraspContrattoPartecipante aggiudicataria = c.getAggiudicataria();
        logger.debug("c.getAggiudicataria(): {}",aggiudicataria);
        if(aggiudicataria!=null) {
//          if(aggiudicataria.getRti().booleanValue()) {
//            aggiudicataria.getListaRti().size();//quick fix lazy loading
//            logger.info("c.getAggiudicataria().getListaRti() [{}]",aggiudicataria.getListaRti().size());
//          }
          dto.setAggiudicatariDto(Collections.singletonList(function.apply(aggiudicataria)));
        }
      }
      
      return dto;
    }
    return null;
  }
  
  @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
  public PageDto<TraspContrattoEstesoDto> getContrattiEstesa(int page, int pageSize, String cig, String codiceStazioneAppaltante, String oggetto,Date dataPubblicazioneGaraDa,Date dataPubblicazioneGaraA, Date dataPubblicazioneEsitoDa,Date dataPubblicazioneEsitoA, List<String> codein,Long syscon, String sourceIp) throws Exception{
    PageRequest pageRequest = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
    Page<TraspContrattoEsteso> pageData = tceRepository.findAll(getContrattoEstesoSpecification(cig, codiceStazioneAppaltante, oggetto,dataPubblicazioneGaraDa,dataPubblicazioneGaraA, dataPubblicazioneEsitoDa,dataPubblicazioneEsitoA, codein),pageRequest);
    
    Map<String,Long> mapOfAggiudicatariaMultipla = tceRepository.getTraspContrattoCountGreaterThanOneGroupByCodice().filter(e->codein.contains(e.getCodiceprop())).collect(Collectors.toMap(ITraspContrattoCountGroupByCodice::getCodice, ITraspContrattoCountGroupByCodice::getNelem));
    /*
     * 
     * se è aggiudicataria singola, allora non eseguo query ulteriori a DB, ma prendo il campo NOTO
     * 
     * se è aggiudicataria multipla allora carico tutti gli aggiudicatari
     */
    Map<String, List<String>> listAggByCodice = new HashMap<String, List<String>>();
    if(!mapOfAggiudicatariaMultipla.isEmpty()) {
      //creo una mappa con chiave il codice e valore la lista delle ragioni sociali delle aggiudicatarie
      listAggByCodice.putAll(gnaRepository.findByIdentityCodiceInOrderByIdentityCodiceAscNumordAsc(mapOfAggiudicatariaMultipla.keySet()).collect(Collectors.groupingBy(p -> p.getIdentity().getCodice(), Collectors.mapping(GareNAggiudicatari::getRagsoc, Collectors.toList()))));
    }
    //quindi se tutte sono aggiudicatarie singole faccio una piccola modifica altrimenti devo prendere i dati dalle query.
    TransformTraspContrattoEstesoToTraspContrattoEstesoDto function = new TransformTraspContrattoEstesoToTraspContrattoEstesoDto(listAggByCodice,!mapOfAggiudicatariaMultipla.isEmpty());
    
    PageDto<TraspContrattoEstesoDto> pageDto = new PageDto<TraspContrattoEstesoDto>();
    BeanUtils.copyProperties(pageData, pageDto,"content");
    pageDto.setContent(pageData.getContent().stream().map(function::apply).collect(Collectors.toList()));
    
    Wlogeventi evento = new Wlogeventi();
    evento.setCod_profilo("APPALTI_REST");
    evento.setCodapp("WS");
    evento.setCodevento(WlogEventiManager.COD_EVENTO_OPEN_APPLICATION);
    evento.setDescr("Richiesto Elenco Trasparenza Esteso");
    evento.setIpevento(sourceIp);
    evento.setLivevento(1);
    evento.setOggevento("getContrattiEstesa");
    evento.setSyscon(syscon);
    wleManager.saveWlogEventi(evento);
    
    return pageDto;
  }
  
  @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
  public PageDto<TraspContrattoEstesoDacDto> getContrattiEstesa(int page, int pageSize, String cig, String codiceStazioneAppaltante, String oggetto,Date dataPubblicazioneGaraDa,Date dataPubblicazioneGaraA, Date dataPubblicazioneEsitoDa,Date dataPubblicazioneEsitoA, Date dataAcquisizioneCigDa, Date dataAcquisizioneCigA, List<String> codein,Long syscon, String sourceIp) throws Exception{
	  Pageable pageRequest = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
    
    //TODO get everything
    
    
    Page<TraspContrattoEstesoDataAcqCig> pageData = tcedacRepository.findAll(getContrattoEstesoSpecification(cig, codiceStazioneAppaltante, oggetto,dataPubblicazioneGaraDa,dataPubblicazioneGaraA, dataPubblicazioneEsitoDa,dataPubblicazioneEsitoA,dataAcquisizioneCigDa, dataAcquisizioneCigA, codein),pageRequest);
    
    Map<String,Long> mapOfAggiudicatariaMultipla = tceRepository.getTraspContrattoCountGreaterThanOneGroupByCodice().filter(e->codein.contains(e.getCodiceprop())).collect(Collectors.toMap(ITraspContrattoCountGroupByCodice::getCodice, ITraspContrattoCountGroupByCodice::getNelem));
    /*
     * 
     * se è aggiudicataria singola, allora non eseguo query ulteriori a DB, ma prendo il campo NOTO
     * 
     * se è aggiudicataria multipla allora carico tutti gli aggiudicatari
     */
    Map<String, List<String>> listAggByCodice = new HashMap<String, List<String>>();
    if(!mapOfAggiudicatariaMultipla.isEmpty()) {
      //creo una mappa con chiave il codice e valore la lista delle ragioni sociali delle aggiudicatarie
      listAggByCodice.putAll(gnaRepository.findByIdentityCodiceInOrderByIdentityCodiceAscNumordAsc(mapOfAggiudicatariaMultipla.keySet()).collect(Collectors.groupingBy(p -> p.getIdentity().getCodice(), Collectors.mapping(GareNAggiudicatari::getRagsoc, Collectors.toList()))));
    }
    //quindi se tutte sono aggiudicatarie singole faccio una piccola modifica altrimenti devo prendere i dati dalle query.
    TransformTraspContrattoEstesoDACToTraspContrattoEstesoDto function = new TransformTraspContrattoEstesoDACToTraspContrattoEstesoDto(listAggByCodice,!mapOfAggiudicatariaMultipla.isEmpty());
    
    PageDto<TraspContrattoEstesoDacDto> pageDto = new PageDto<TraspContrattoEstesoDacDto>();
    BeanUtils.copyProperties(pageData, pageDto,"content");
    pageDto.setContent(transform(pageData.getContent(), function));
    
    Wlogeventi evento = new Wlogeventi();
    evento.setCod_profilo("APPALTI_REST");
    evento.setCodapp("WS");
    evento.setCodevento(WlogEventiManager.COD_EVENTO_OPEN_APPLICATION);
    evento.setDescr("Richiesto Elenco Trasparenza Esteso");
    evento.setIpevento(sourceIp);
    evento.setLivevento(1);
    evento.setOggevento("getContrattiEstesa");
    evento.setSyscon(syscon);
    wleManager.saveWlogEventi(evento);
    
    return pageDto;
  }
  
  @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW,rollbackFor = {ParseException.class})
  public TraspContrattoDettaglioDto getContrattoEsteso(String riferimentoProcedura, List<String> codein,Long syscon, String sourceIp) throws Exception {
    
    Optional<TraspContrattoEsteso> opContratto = tceRepository.findById(riferimentoProcedura);
    if (opContratto.isPresent()) {
      //TODO mi prendo il codice dell'italia
      Set<String> codimpItaliane = imprRepository.findCodimpByNazimp(Integer.valueOf(1));
      logger.info("Found {} italiane",codimpItaliane.size());
      //TODO trovo solo quelle che effettivamente sono italiane (20% ???) e poi imposto il flag italiana=false in base alla mappa chiave, valore ;)
      
      TraspContrattoEsteso c = opContratto.get();
      //controllo che effettivamente la gara richiesta sia visibile dall'utente in questione
      if (codein.contains(c.getCodiceprop())) {
        TraspContrattoDettaglioDto dto = new TraspContrattoDettaglioDto();
        BeanUtils.copyProperties(c, dto, "partecipanti");// a causa di problemi di sessione con il lazy loading non inserisco i partecipanti
        TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto function = new TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto(new TransformTraspContrattoPartecipanteRtiToTraspContrattoPartecipanteDto(codimpItaliane),codimpItaliane);
        // ottengo la lista degli operatori invitati
        Date now = new Date();
        if(c.getDteoff()!=null) {
          //dteoff di torn
          if(logger.isTraceEnabled()) {
            SimpleDateFormat sdfSimple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            logger.trace("{} - {}",sdfSimple.format(now),sdfSimple.format(c.getDteoff()));
          }
          if(now.after(c.getDteoff())) {
            List<TraspContrattoPartecipante> partecipanti = c.getPartecipanti();
            logger.debug("c.getPartecipanti(): {}", (partecipanti != null ? partecipanti.size() : "null"));
            if (partecipanti != null && partecipanti.size() > 0)
              dto.setPartecipanti(transformCheckNull(partecipanti, function));
          }
        }
        // verifico che sia multi aggiudicante in caso devo inserire la lista di tutti gli aggiudicatari
        if (tcRepository.existsByCodiceAndSingolaaggiudicataria(c.getCodice(), 1)) {
          TransformGareNAggiudicatariToTraspContrattoPartecipanteDto function2 = new TransformGareNAggiudicatariToTraspContrattoPartecipanteDto(tcpRepository, function);
          dto.setAggiudicatariDto(gnaRepository.findByIdentityCodiceOrderByNumord(c.getCodice()).filter(Objects::nonNull).map(function2::apply).collect(Collectors.toList()));
        } else {
          // se è aggiudicataria singola, tra gli invitati pesco la aggiudicataria singola
          // query di hibernate dal DB? meglio
          TraspContrattoPartecipante aggiudicataria = c.getAggiudicataria();
          logger.debug("c.getAggiudicataria(): {}", aggiudicataria);
          if (aggiudicataria != null) {
//            if (aggiudicataria.getRti().booleanValue()) {
//              aggiudicataria.getListaRti().size();// quick fix lazy loading
//              logger.info("c.getAggiudicataria().getListaRti() [{}]", aggiudicataria.getListaRti().size());
//            }
            dto.setAggiudicatariDto(Collections.singletonList(function.apply(aggiudicataria)));
          }
        }
        logger.debug("{}",dto);
        dto.getPartecipanti();
        dto.getAggiudicatariDto();
        Wlogeventi evento = new Wlogeventi();
        evento.setCod_profilo("APPALTI_REST");
        evento.setCodapp("WS");
        evento.setCodevento(WlogEventiManager.COD_EVENTO_OPEN_APPLICATION);
        evento.setDescr("Richiesto Dettaglio Trasparenza Esteso");
        evento.setIpevento(sourceIp);
        evento.setLivevento(1);
        evento.setOggevento(riferimentoProcedura);
        evento.setSyscon(syscon);
        wleManager.saveWlogEventi(evento);
        
        return dto;
      }
    }
    return null;
  }
}
