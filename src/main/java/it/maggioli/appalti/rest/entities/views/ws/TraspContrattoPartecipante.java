package it.maggioli.appalti.rest.entities.views.ws;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_ws_trasp_contratti_partecip")
public class TraspContrattoPartecipante {
  private String codice;
  //Id needed for Hibernate
  @Id
  private String ditta;
  private String ragsoc;
  private String codfisc;
  private String partiva;
  private Boolean rti;
  
  @OneToMany(fetch = FetchType.LAZY,mappedBy = "codimprti")
  @OrderBy("mandataria desc,ragsoc asc")
  private List<TraspContrattoPartecipanteRti> listaRti;
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public String getDitta() {
    return ditta;
  }
  
  public void setDitta(String ditta) {
    this.ditta = ditta;
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
  
  public Boolean getRti() {
    return rti;
  }
  
  public void setRti(Boolean rti) {
    this.rti = rti;
  }

  
  public List<TraspContrattoPartecipanteRti> getListaRti() {
    return listaRti;
  }

  
  public void setListaRti(List<TraspContrattoPartecipanteRti> listaRti) {
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
