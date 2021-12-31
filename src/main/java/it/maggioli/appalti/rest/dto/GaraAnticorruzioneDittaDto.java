package it.maggioli.appalti.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzioneDitta GareAnticorruzioneDitta}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "partecipante")
public class GaraAnticorruzioneDittaDto {
  private String ragsoc;
  private String codfisc;
  private String idfiscest;
  private String descruolo;
  
  @JsonProperty(value = "ragioneSociale")
  public String getRagsoc() {
    return ragsoc;
  }
  
  public void setRagsoc(String ragsoc) {
    this.ragsoc = ragsoc;
  }
  
  @JsonProperty(value = "codiceFiscale")
  public String getCodfisc() {
    return codfisc;
  }
  
  public void setCodfisc(String codfisc) {
    this.codfisc = codfisc;
  }
  
  @JsonProperty(value = "idFiscaleEstero")
  public String getIdfiscest() {
    return idfiscest;
  }
  
  public void setIdfiscest(String idfiscest) {
    this.idfiscest = idfiscest;
  }
  
  @JsonProperty(value = "ruolo")
  public String getDescruolo() {
    return descruolo;
  }
  
  public void setDescruolo(String descruolo) {
    this.descruolo = descruolo;
  }

  @Override
  public String toString() {
    return "GaraAnticorruzioneDittaDto ["
        + (ragsoc != null ? "ragsoc=" + ragsoc + ", " : "")
        + (codfisc != null ? "codfisc=" + codfisc + ", " : "")
        + (idfiscest != null ? "idfiscest=" + idfiscest + ", " : "")
        + (descruolo != null ? "descruolo=" + descruolo : "")
        + "]";
  }
  
  
}
