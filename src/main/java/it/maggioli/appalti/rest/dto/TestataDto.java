package it.maggioli.appalti.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * dati generali di testata dell'entità richiesta
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "datiTestata",description = "dati generali di testata dell'entità richiesta")
public abstract class TestataDto {
  private static final String EUROPE_TIMEZONE = "Europe/Rome";
  private String stazioneAppaltante;
  private String titolo;
  private String tipologiaAppalto;
  private String cig;
  private Double importo;
  private String dataPubblicazione;
  private String riferimentoProcedura;
  private String stato;
  private Date dataUltimaModifica;
  
  @ApiModelProperty(value = "stazione appaltante")
  public String getStazioneAppaltante() {
    return stazioneAppaltante;
  }
  
  public void setStazioneAppaltante(String stazioneAppaltante) {
    this.stazioneAppaltante = stazioneAppaltante;
  }
  
  @ApiModelProperty(value = "titolo")
  public String getTitolo() {
    return titolo;
  }
  
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }
  
  @ApiModelProperty(value = "tipologia appalto")
  public String getTipologiaAppalto() {
    return tipologiaAppalto;
  }
  
  public void setTipologiaAppalto(String tipologiaAppalto) {
    this.tipologiaAppalto = tipologiaAppalto;
  }
  
  @ApiModelProperty(value = "CIG")
  public String getCig() {
    return cig;
  }
  
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  @ApiModelProperty(value = "importo a base di gara")
  public Double getImporto() {
    return importo;
  }
  
  public void setImporto(Double importo) {
    this.importo = importo;
  }
  
  @ApiModelProperty(value = "data di pubblicazione",example = "2020-01-13 14:00")
  public String getDataPubblicazione() {
    return dataPubblicazione;
  }
  
  public void setDataPubblicazione(String dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }
  
  @ApiModelProperty(value = "riferimento della procedura")
  public String getRiferimentoProcedura() {
    return riferimentoProcedura;
  }
  
  public void setRiferimentoProcedura(String riferimentoProcedura) {
    this.riferimentoProcedura = riferimentoProcedura;
  }
  
  @ApiModelProperty(value = "stato")
  public String getStato() {
    return stato;
  }
  
  public void setStato(String stato) {
    this.stato = stato;
  }

  @ApiModelProperty(value = "Data ultima modifica")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  @JsonProperty("dataUltimaModifica")
  public Date getDataUltimaModifica() {
    return dataUltimaModifica;
  }

  public void setDataUltimaModifica(Date dataUltimaModifica) {
    this.dataUltimaModifica = dataUltimaModifica;
  }
  
  
}
