package it.maggioli.appalti.rest.manager;

import static it.maggioli.appalti.rest.specifications.AnticorruzioneSpecification.getAvvisoSpecification;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.maggioli.appalti.rest.dto.AdempimentoAnticorruzioneDto;
import it.maggioli.appalti.rest.dto.GaraAntiCorruzioneDto;
import it.maggioli.appalti.rest.dto.GaraAnticorruzioneDittaDto;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.entities.views.ws.AdempimentiAnticor;
import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzione;
import it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzioneDitta;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltanteL190;
import it.maggioli.appalti.rest.functions.TransformAdempimentiAnticorToAdempimentiAnticorDto;
import it.maggioli.appalti.rest.functions.TransformGareAnticorruzioneDittaToGareAnticorruzioneDittaDto;
import it.maggioli.appalti.rest.functions.TransformGareAnticorruzioneToGaraAnticorruzioneDto;
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
public class L190Manager {
  
  private final Logger logger = LoggerFactory.getLogger(getClass());
  
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
    //TODO leggere tutte le ditte relative alla gara
    
    Set<Long> ids = pageGareAntic.getContent().stream().map(e->e.getIdanticorlotti()).collect(Collectors.toSet());
    logger.info("Found unique ids {}",ids.size());
    List<GareAnticorruzioneDitta> listDitte = gadRepository.findByIdanticorlottiIn(ids);
    logger.info("Found Ditte {}",listDitte.size());
    //TODO impostare i dati secondo la discriminante aggiudicataria e non
    
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
    pageDto.setContent(pageGareAntic.getContent().stream()
        .map(functionGaraToDto::apply)
        .collect(Collectors.toList()));
    
    return pageDto;
  }
  
  public PageDto<AdempimentoAnticorruzioneDto> getElencoAdempimenti(int page,
      int pageSize,
      Integer annorif){
    PageRequest pageRequest = PageRequest.of(page>0?page-1:0, pageSize);
    Page<AdempimentiAnticor> pageResult = aaRepository.findAllByIdentityAnnorif(pageRequest, annorif);
    
    logger.info("{}",pageResult.getContent());
    PageDto<AdempimentoAnticorruzioneDto> pageDto = new PageDto<AdempimentoAnticorruzioneDto>();
    BeanUtils.copyProperties(pageResult, pageDto,"content");
    pageDto.setContent(pageResult.getContent().stream().map(functionAdempimentiAnticorToDto::apply).collect(Collectors.toList()));
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
    
    Page<GareAnticorruzione> pageGareAntic = gaRepository.findAll(getAvvisoSpecification(annorif, codiceStazioneAppaltante, codicegara, cig, oggetto),pageRequest);
    PageDto<GaraAntiCorruzioneDto> pageDto = new PageDto<GaraAntiCorruzioneDto>();
    BeanUtils.copyProperties(pageGareAntic, pageDto,"content","partecipanti","assegnatari");
    //TODO leggere tutte le ditte relative alla gara
    
    Set<Long> ids = pageGareAntic.getContent().stream().map(e->e.getIdanticorlotti()).collect(Collectors.toSet());
    logger.info("Found unique ids {}",ids.size());
    List<GareAnticorruzioneDitta> listDitte = gadRepository.findByIdanticorlottiIn(ids);
    logger.info("Found Ditte {}",listDitte.size());
    //TODO impostare i dati secondo la discriminante aggiudicataria e non
    
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
    pageDto.setContent(pageGareAntic.getContent().stream()
                                                   .map(functionGaraToDto::apply)
                                                   .collect(Collectors.toList()));
    
    return pageDto;
  }
}
