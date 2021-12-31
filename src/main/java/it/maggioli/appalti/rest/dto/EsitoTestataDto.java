package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;

/**
 * Data Transfer Object per i dati di testata {@link it.maggioli.appalti.rest.entities.views.ws.Esito Esito}
 * @see TestataDto
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "esitoTestata",description = "dati di testata degli esiti")
public class EsitoTestataDto extends TestataDto {

  @Override
  public String toString() {
    return "EsitoTestataDto ["
        + (getStazioneAppaltante() != null ? "getStazioneAppaltante()=" + getStazioneAppaltante() + ", " : "")
        + (getTitolo() != null ? "getTitolo()=" + getTitolo() + ", " : "")
        + (getTipologiaAppalto() != null ? "getTipologiaAppalto()=" + getTipologiaAppalto() + ", " : "")
        + (getCig() != null ? "getCig()=" + getCig() + ", " : "")
        + (getStato() != null ? "getStato()=" + getStato() : "")
        + "]";
  }

}
