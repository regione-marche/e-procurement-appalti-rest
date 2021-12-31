package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per testata {@link it.maggioli.appalti.rest.entities.views.ws.Bando Bando}
 * @see TestataDto
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "testataBando")
public class BandoTestataDto extends TestataDto {
  private String dataScadenza;
  
  @ApiModelProperty(value = "data di scadenza del bando",example = "2020-01-13 14:00")
  public String getDataScadenza() {
    return dataScadenza;
  }
  
  public void setDataScadenza(String dataScadenza) {
    this.dataScadenza = dataScadenza;
  }

  @Override
  public String toString() {
    return "BandoTestataDto ["
        + (getTitolo() != null ? "getTitolo()=" + getTitolo() + ", " : "")
        + (getTipologiaAppalto() != null ? "getTipologiaAppalto()=" + getTipologiaAppalto() + ", " : "")
        + (getCig() != null ? "getCig()=" + getCig() + ", " : "")
        + (getRiferimentoProcedura() != null ? "getRiferimentoProcedura()=" + getRiferimentoProcedura() + ", " : "")
        + (getStato() != null ? "getStato()=" + getStato() : "")
        + "]";
  }
  
}
