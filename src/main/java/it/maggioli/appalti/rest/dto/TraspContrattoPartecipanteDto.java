package it.maggioli.appalti.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TraspContrattoPartecipanteDto {
  private String codice;
  private String ditta;
  private String ragsoc;
  private String codfisc;
  private String partiva;
  private Boolean rti;
  private Boolean mandataria;
  
  private List<TraspContrattoPartecipanteDto> listaRti;
  
  @JsonIgnore
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  @JsonIgnore
  public String getDitta() {
    return ditta;
  }
  
  public void setDitta(String ditta) {
    this.ditta = ditta;
  }
  
  @JsonProperty("ragioneSociale")
  public String getRagsoc() {
    return ragsoc;
  }
  
  public void setRagsoc(String ragsoc) {
    this.ragsoc = ragsoc;
  }
  
  @JsonProperty("codiceFiscale")
  public String getCodfisc() {
    return codfisc;
  }
  
  public void setCodfisc(String codfisc) {
    this.codfisc = codfisc;
  }
  
  @JsonProperty("partitaIva")
  public String getPartiva() {
    return partiva;
  }
  
  public void setPartiva(String partiva) {
    this.partiva = partiva;
  }
  
  @JsonProperty("rti")
  public Boolean getRti() {
    return rti;
  }
  
  public void setRti(Boolean rti) {
    this.rti = rti;
  }
  
  @JsonProperty("mandataria")
  public Boolean getMandataria() {
    return mandataria;
  }

  public void setMandataria(Boolean mandataria) {
    this.mandataria = mandataria;
  }

  @JsonProperty("componentiRti")
  public List<TraspContrattoPartecipanteDto> getListaRti() {
    return listaRti;
  }

  public void setListaRti(List<TraspContrattoPartecipanteDto> listaRti) {
    this.listaRti = listaRti;
  }

  @Override
  public String toString() {
    final int maxLen = 5;
    return "TraspContrattoPartecipante ["
        + (codice != null ? "codice=" + codice + ", " : "")
        + (ditta != null ? "ditta=" + ditta + ", " : "")
        + (rti != null ? "rti=" + rti + ", " : "")
        + (listaRti != null ? "listaRti=" + listaRti.subList(0, Math.min(listaRti.size(), maxLen)) : "")
        + "]";
  }
  
  
}
