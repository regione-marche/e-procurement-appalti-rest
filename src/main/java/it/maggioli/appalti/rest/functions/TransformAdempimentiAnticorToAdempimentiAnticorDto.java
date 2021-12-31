package it.maggioli.appalti.rest.functions;

import java.util.function.Function;

import it.maggioli.appalti.rest.dto.AdempimentoAnticorruzioneDto;
import it.maggioli.appalti.rest.entities.views.ws.AdempimentiAnticor;


public class TransformAdempimentiAnticorToAdempimentiAnticorDto implements Function<AdempimentiAnticor, AdempimentoAnticorruzioneDto> {

  @Override
  public AdempimentoAnticorruzioneDto apply(AdempimentiAnticor t) {
    AdempimentoAnticorruzioneDto dto = new AdempimentoAnticorruzioneDto();
    dto.setAnnoRiferimento(t.getIdentity().getAnnorif());
    dto.setCodice(t.getIdentity().getCodein());
    dto.setCodiceFiscaleSA(t.getCfein());
    dto.setDataAggiornamento(t.getDataaggiornamento());
    dto.setDataApprovazione(t.getDataapprovazione());
    dto.setDataPubblicazione(t.getDatapubblicazione());
    dto.setPubblicato(t.getPubblicato());
    dto.setStazioneAppaltante(t.getNomein());
    dto.setUrl(t.getUrlsito());
    return dto;
  }

}
