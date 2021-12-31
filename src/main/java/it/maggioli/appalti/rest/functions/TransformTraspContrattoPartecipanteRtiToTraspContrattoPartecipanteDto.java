package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import org.springframework.beans.BeanUtils;

import it.maggioli.appalti.rest.dto.TraspContrattoPartecipanteDto;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoPartecipanteRti;


public class TransformTraspContrattoPartecipanteRtiToTraspContrattoPartecipanteDto implements Function<TraspContrattoPartecipanteRti, TraspContrattoPartecipanteDto> {

  @Override
  public TraspContrattoPartecipanteDto apply(TraspContrattoPartecipanteRti t) {
    TraspContrattoPartecipanteDto dto = new TraspContrattoPartecipanteDto();
    BeanUtils.copyProperties(t, dto);
    return dto;
  }

}
