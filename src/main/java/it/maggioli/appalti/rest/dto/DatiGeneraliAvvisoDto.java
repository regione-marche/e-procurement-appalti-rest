package it.maggioli.appalti.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per i dati generali di {@link it.maggioli.appalti.rest.entities.views.ws.Avviso Avviso}
 * @see DatiGeneraliDto
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "datiGeneraliAvviso",description = "Dati generali per gli Avvisi")
public class DatiGeneraliAvvisoDto extends DatiGeneraliDto {
  private String tipologiaAvviso;
  
  @ApiModelProperty(value = "Tipologia dell' Avviso")
  public String getTipologiaAvviso() {
    return tipologiaAvviso;
  }
  
  public void setTipologiaAvviso(String tipologiaAvviso) {
    this.tipologiaAvviso = tipologiaAvviso;
  }
  
  
  
//  @ApiModelProperty(name = "dataUltimaModifica",value = "Data di ultima modifica della comunicazione")
//  @JsonFormat(pattern = "dd/MM/yyyy")
//  public String getDataUltimaModifica() {
//    return dataUltimaModifica;
//  }
//  
//  public void setDataUltimaModifica(String dataUltimaModifica) {
//    this.dataUltimaModifica = dataUltimaModifica;
//  }

  @ApiModelProperty(name = "dataUltimaModifica",value = "Data di ultima modifica della comunicazione")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Override
  public Date getDataUltimaModifica() {
    return super.getDataUltimaModifica();
  }

  @Override
  public String toString() {
    return "DatiGeneraliAvvisoDto ["
        + (tipologiaAvviso != null ? "tipologiaAvviso=" + tipologiaAvviso + ", " : "")
        + (getTitolo() != null ? "getTitolo()=" + getTitolo() + ", " : "")
        + (getTipologiaAppalto() != null ? "getTipologiaAppalto()=" + getTipologiaAppalto() + ", " : "")
        + (getDataPubblicazione() != null ? "getDataPubblicazione()=" + getDataPubblicazione() + ", " : "")
        + (getDataScadenza() != null ? "getDataScadenza()=" + getDataScadenza() + ", " : "")
        + (getProceduraRiferimento() != null ? "getProceduraRiferimento()=" + getProceduraRiferimento() : "")
        + "]";
  }
}
