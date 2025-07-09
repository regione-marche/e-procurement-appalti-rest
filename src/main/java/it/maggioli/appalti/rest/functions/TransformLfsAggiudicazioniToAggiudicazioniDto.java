package it.maggioli.appalti.rest.functions;

import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.maggioli.appalti.rest.dto.AggiudicazioniDto;
import it.maggioli.appalti.rest.entities.views.ws.LfsAggiudicazioni;

/**
 * Funzione di trasformazione dati da {@link LfsAggiudicazioni} a {@link AggiudicazioniDto}
 * @author gabriele.nencini
 *
 */
@Component
@SuppressWarnings("java:S3749")
public class TransformLfsAggiudicazioniToAggiudicazioniDto implements Function<LfsAggiudicazioni, AggiudicazioniDto> {

  @Autowired
  private TransformImprToOeDto functionImprToOeDto;
  
  private Map<String,String> mapProv;
  private Map<Integer,String> mapNaz;
  
  
  /**
   * @param mapNaz the mapNaz to set
   */
  public void setMapNaz(Map<Integer, String> mapNaz) {
    this.mapNaz = mapNaz;
  }

  /**
   * @param mapProv the mapProv to set
   */
  public void setMapProv(Map<String, String> mapProv) {
    this.mapProv = mapProv;
  }

  @Override
  public AggiudicazioniDto apply(LfsAggiudicazioni t) {
    AggiudicazioniDto dto = new AggiudicazioniDto();
    BeanUtils.copyProperties(t, dto);
    dto.setCodicegara(t.getIdentity().getCodicegara());
    dto.setCodicelotto(t.getIdentity().getCodicelotto());
    if(mapProv!=null) {
      functionImprToOeDto.setMapProv(mapProv);
    }
    if(mapNaz!=null) {
      functionImprToOeDto.setMapNaz(mapNaz);
    }
    dto.setAggiudicataria(functionImprToOeDto.apply(t.getAggiudicataria()));
    return dto;
  }

}
