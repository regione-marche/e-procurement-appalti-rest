package it.maggioli.appalti.rest.manager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import it.maggioli.appalti.rest.dto.AggiudicazioniDto;
import it.maggioli.appalti.rest.dto.PageDto;
import it.maggioli.appalti.rest.dto.TabulatoDto;
import it.maggioli.appalti.rest.entities.TabTre;
import it.maggioli.appalti.rest.entities.views.ws.LfsAggiudicazioni;
import it.maggioli.appalti.rest.functions.TransformLfsAggiudicazioniToAggiudicazioniDto;
import it.maggioli.appalti.rest.repositories.TabulatoTreRepository;
import it.maggioli.appalti.rest.repositories.TabulatoUnoRepository;
import it.maggioli.appalti.rest.repositories.views.ws.LfsAggiudicazioniRepository;

import static it.maggioli.appalti.rest.utils.Transform.transform;

/**
 * Classe per gestire i dati da esportare per LFS
 * @author gabriele.nencini
 *
 */
@Service
public class LfsManager {
  @Autowired
  private LfsAggiudicazioniRepository lfsAggRepository;
  @Autowired
  private TabulatoTreRepository tab3Repository;
  @Autowired
  private TabulatoUnoRepository tab1Repository;
  @Autowired
  private TransformLfsAggiudicazioniToAggiudicazioniDto ftoAggiudicazioniDto;
  
  public PageDto<AggiudicazioniDto> getLfsAggiudicazioniByUffint(int page, int pageSize, List<String> uffint){
    PageRequest pageable = PageRequest.of(page>0?page-1:0, pageSize);
    Page<LfsAggiudicazioni> pageLfs = lfsAggRepository.findAllByUffintIn(pageable, uffint);
    PageDto<AggiudicazioniDto> pageDto = new PageDto<AggiudicazioniDto>();
    BeanUtils.copyProperties(pageLfs, pageDto,"content");//to prevent issues with hibernate session
    pageDto.setContent(transform(pageLfs.getContent(), ftoAggiudicazioniDto));
    return pageDto;
  }
  
  @Transactional
  public List<AggiudicazioniDto> getLfsAggiudicazioniByCodgarAndUffint(String codgar, List<String> uffint){
    return lfsAggRepository.findAllByIdentityCodicegaraAndUffintIn(codgar,uffint).map(ftoAggiudicazioniDto::apply).collect(Collectors.toList());
  }
  @Transactional
  public List<AggiudicazioniDto> getLfsAggiudicazioniByCigAndUffint(String cig, List<String> uffint){
    return lfsAggRepository.findAllByCigAndUffintIn(cig,uffint).map(ftoAggiudicazioniDto::apply).collect(Collectors.toList());
  }
  @Transactional
  public List<AggiudicazioniDto> getLfsAggiudicazioniByCigAndUffint(List<String> cig, List<String> uffint){
    Map<Integer,String> mapNaz = tab1Repository.findDtoByCodiceFilteringArchOrderByOrdinamento("Ag010").parallelStream().collect(Collectors.toMap(TabulatoDto::getId, TabulatoDto::getDescrizione));
    Map<String,String> mapProv = tab3Repository.findAllByIdCodice("Agx15").filter(el->!"1".equals(el.getArchiviato())).collect(Collectors.toMap(el->el.getId().getValore(), TabTre::getDescrizione,(el1,el2)->el2));
    ftoAggiudicazioniDto.setMapProv(mapProv);
    ftoAggiudicazioniDto.setMapNaz(mapNaz);
    return lfsAggRepository.findAllByCigInAndUffintIn(cig,uffint).map(ftoAggiudicazioniDto::apply).collect(Collectors.toList());
  }
  

}
