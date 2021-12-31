package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.Avviso Avviso}
 * @see TestataDto
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "datiTestataAvviso",description = "dati generali di testata per gli Avvisi")
public class AvvisoTestataDto extends TestataDto {
  private String dataScadenza;
  private String tipologiaAvviso;
  
  @ApiModelProperty(value = "tipologia dell'Avviso",reference = "tipologia#descrizione")
  public String getTipologiaAvviso() {
    return tipologiaAvviso;
  }
  
  public void setTipologiaAvviso(String tipologiaAvviso) {
    this.tipologiaAvviso = tipologiaAvviso;
  }

  @ApiModelProperty(value = "data di scadenza dell'Avviso",example = "2020-12-25 12:35")
  public String getDataScadenza() {
    return dataScadenza;
  }
  
  public void setDataScadenza(String dataScadenza) {
    this.dataScadenza = dataScadenza;
  }
  
  @ApiModelProperty(hidden=true,value = "NOT USED")
  @Override
  public String getCig() {return null;}
  @ApiModelProperty(hidden=true,value = "NOT USED")
  @Override
  public Double getImporto() {return null;}
  @ApiModelProperty(hidden=true,value = "NOT USED")
  @Override
  public String getStato() {return null;}

  @Override
  public String toString() {
    return "AvvisoTestataDto ["
        + (getStazioneAppaltante() != null ? "getStazioneAppaltante()=" + getStazioneAppaltante() + ", " : "")
        + (getTitolo() != null ? "getTitolo()=" + getTitolo() + ", " : "")
        + (getTipologiaAppalto() != null ? "getTipologiaAppalto()=" + getTipologiaAppalto() + ", " : "")
        + (getTipologiaAvviso() != null ? "getTipologiaAvviso()=" + getTipologiaAvviso() + ", " : "")
        + (getDataPubblicazione() != null ? "getDataPubblicazione()=" + getDataPubblicazione() : "")
        + "]";
  }

}
