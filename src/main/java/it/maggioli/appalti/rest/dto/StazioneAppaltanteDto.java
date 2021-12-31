package it.maggioli.appalti.rest.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is a copy of the class it.maggioli.eldasoft.sil.gare.ws.StazioneAppaltanteBandoType
 *  in the WSAppalti project
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "stazioneAppaltante")
public class StazioneAppaltanteDto {
  private String codice;
  private String denominazione;
  private String rup;
  private List<String> puntoOrdinante;
  private List<String> puntoIstruttore;
  
  @ApiModelProperty(name = "codice",value = "Codice di riferimento della stazione appaltante")
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  @ApiModelProperty(name = "denominazione",value = "Denominazione della stazione appaltante")
  public String getDenominazione() {
    return denominazione;
  }

  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
  }
  
  @ApiModelProperty(name = "rup",value = "Responsabile unico procedimento")
  public String getRup() {
    return rup;
  }
  
  public void setRup(String rup) {
    this.rup = rup;
  }
  
  @ApiModelProperty(name = "puntoOrdinante",value = "Lista dei punti ordinanti")
  public List<String> getPuntoOrdinante() {
    return puntoOrdinante;
  }
  
  public void setPuntoOrdinante(List<String> puntoOrdinante) {
    this.puntoOrdinante = puntoOrdinante;
  }
  
  @ApiModelProperty(name = "puntoIstruttore",value = "Lista dei punti istruttori")
  public List<String> getPuntoIstruttore() {
    return puntoIstruttore;
  }
  
  public void setPuntoIstruttore(List<String> puntoIstruttore) {
    this.puntoIstruttore = puntoIstruttore;
  }
  
  @Override
  public String toString() {
    final int maxLen = 10;
    return "StazioneAppaltanteDto ["
    + (codice != null ? "codice=" + codice + ", " : "")
    + (denominazione != null ? "denominazione=" + denominazione + ", " : "")
    + (rup != null ? "rup=" + rup + ", " : "")
    + (puntoOrdinante != null ? "puntoOrdinante=" + puntoOrdinante.subList(0, Math.min(puntoOrdinante.size(), maxLen)) + ", " : "")
    + (puntoIstruttore != null ? "puntoIstruttore=" + puntoIstruttore.subList(0, Math.min(puntoIstruttore.size(), maxLen)) : "")
    + "]";
  }
  
}
