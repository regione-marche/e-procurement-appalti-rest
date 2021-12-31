package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import it.maggioli.appalti.rest.dto.SoggettoAderenteDto;
import it.maggioli.appalti.rest.entities.views.ws.AderenteLotto;

public class TransformAderenteLottoToSoggettoAderenteDto implements Function<AderenteLotto, SoggettoAderenteDto> {

  @Override
  public SoggettoAderenteDto apply(AderenteLotto t) {
    SoggettoAderenteDto dto = new SoggettoAderenteDto();
    dto.setCodiceFiscale(t.getCfein());
    dto.setDenominazione(dto.getDenominazione());
    return dto;
  }

}
