package it.maggioli.appalti.rest.entities.views.ws;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_ws_trasp_contratti_dett_rti")
public class TraspContrattoPartecipanteRti {
  private String codimprti;
  @Id
  private String ragsoc;
  private String codfisc;
  private String partiva;
  private Boolean mandataria;
  
  public String getCodimprti() {
    return codimprti;
  }
  
  public void setCodimprti(String codimprti) {
    this.codimprti = codimprti;
  }
  
  public String getRagsoc() {
    return ragsoc;
  }
  
  public void setRagsoc(String ragsoc) {
    this.ragsoc = ragsoc;
  }
  
  public String getCodfisc() {
    return codfisc;
  }
  
  public void setCodfisc(String codfisc) {
    this.codfisc = codfisc;
  }
  
  public String getPartiva() {
    return partiva;
  }
  
  public void setPartiva(String partiva) {
    this.partiva = partiva;
  }
  
  public Boolean getMandataria() {
    return mandataria;
  }
  
  public void setMandataria(Boolean mandataria) {
    this.mandataria = mandataria;
  }

  @Override
  public String toString() {
    return "TraspContrattoPartecipanteRti ["
        + (codimprti != null ? "codimprti=" + codimprti + ", " : "")
        + (codfisc != null ? "codfisc=" + codfisc + ", " : "")
        + (partiva != null ? "partiva=" + partiva + ", " : "")
        + (mandataria != null ? "mandataria=" + mandataria : "")
        + "]";
  }
  
  
}
