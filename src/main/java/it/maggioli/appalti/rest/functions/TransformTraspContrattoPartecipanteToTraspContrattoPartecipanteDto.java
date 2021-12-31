package it.maggioli.appalti.rest.functions;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.TraspContrattoPartecipanteDto;
import it.maggioli.appalti.rest.entities.views.ws.TraspContrattoPartecipante;

@Transactional(propagation = Propagation.REQUIRED)
public class TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto
    implements Function<TraspContrattoPartecipante, TraspContrattoPartecipanteDto> {

  private final TransformTraspContrattoPartecipanteRtiToTraspContrattoPartecipanteDto functionPartecipanti;
  
  public TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto(
      TransformTraspContrattoPartecipanteRtiToTraspContrattoPartecipanteDto functionPartecipanti) {
    this.functionPartecipanti = functionPartecipanti;
  }

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public TraspContrattoPartecipanteDto apply(TraspContrattoPartecipante t) {
    TraspContrattoPartecipanteDto dto = new TraspContrattoPartecipanteDto();
    BeanUtils.copyProperties(t, dto,"listaRti");
    if(t.getRti()) {
      dto.setListaRti(t.getListaRti().stream().map(functionPartecipanti::apply).collect(Collectors.toList()));
    }
    return dto;
  }

}
