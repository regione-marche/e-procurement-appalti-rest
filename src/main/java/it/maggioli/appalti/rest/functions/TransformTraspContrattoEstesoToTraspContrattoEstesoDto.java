package it.maggioli.appalti.rest.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import it.maggioli.appalti.rest.dto.TraspContrattoEstesoDto;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEsteso;


public class TransformTraspContrattoEstesoToTraspContrattoEstesoDto implements Function<TraspContrattoEsteso, TraspContrattoEstesoDto> {
  private final Map<String, List<String>> listAggByCodice;
  private final boolean aggiudicatariMultipli;
  public TransformTraspContrattoEstesoToTraspContrattoEstesoDto(Map<String, List<String>> listAggByCodice,boolean aggiudicatariMultipli) {
    this.listAggByCodice = listAggByCodice;
    this.aggiudicatariMultipli = aggiudicatariMultipli;
  }
  
  @Override
  public TraspContrattoEstesoDto apply(TraspContrattoEsteso t) {
    TraspContrattoEstesoDto dto = new TraspContrattoEstesoDto();
    BeanUtils.copyProperties(t, dto, "aggiudicatari");
    List<String> aggiudicatari = new ArrayList<String>();
    if(aggiudicatariMultipli) {
      //prevent null in case key is not mapped
      if(this.listAggByCodice.containsKey(t.getCodice())) {
        aggiudicatari.addAll(this.listAggByCodice.getOrDefault(t.getCodice(), new ArrayList<String>()));
      } else {
        if(Objects.nonNull(t.getDescaggiudicataria())) {
          aggiudicatari.add(t.getDescaggiudicataria());
        }
      }
    } else {
      if(Objects.nonNull(t.getDescaggiudicataria())) {
        aggiudicatari.add(t.getDescaggiudicataria());
      }
    }
    dto.setAggiudicatari(aggiudicatari);
    return dto;
  }

}
