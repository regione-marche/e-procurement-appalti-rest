package it.maggioli.appalti.rest.functions;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.maggioli.appalti.rest.dto.TraspContrattoPartecipanteDto;
import it.maggioli.appalti.rest.entities.views.ws.GareNAggiudicatari;
import it.maggioli.appalti.rest.repositories.views.ws.TraspContrattoPartecipanteRepository;


public class TransformGareNAggiudicatariToTraspContrattoPartecipanteDto
    implements Function<GareNAggiudicatari, TraspContrattoPartecipanteDto> {
  private final TraspContrattoPartecipanteRepository tcpRepository;
  private final TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto function;
  
  public TransformGareNAggiudicatariToTraspContrattoPartecipanteDto(TraspContrattoPartecipanteRepository tcpRepository,TransformTraspContrattoPartecipanteToTraspContrattoPartecipanteDto function) {
    this.tcpRepository = tcpRepository;
    this.function = function;
  }

  @Transactional(propagation = Propagation.REQUIRED)
  @Override
  public TraspContrattoPartecipanteDto apply(GareNAggiudicatari t) {
    TraspContrattoPartecipanteDto dto = new TraspContrattoPartecipanteDto();
    dto.setCodfisc(t.getCodfisc());
    dto.setCodice(t.getIdentity().getCodice());
    dto.setDitta(t.getIdentity().getDitta());
    dto.setPartiva(t.getPartiva());
    dto.setRagsoc(t.getRagsoc());
    dto.setRti(t.getRti()); // rti ???
    
    if(t.getRti().booleanValue()) {
      dto.setListaRti(this.tcpRepository.findAllByCodice(dto.getCodice()).map(function::apply).collect(Collectors.toList()));
    }
    
    return dto;
  }

}
