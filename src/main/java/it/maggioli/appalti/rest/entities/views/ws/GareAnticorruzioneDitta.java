package it.maggioli.appalti.rest.entities.views.ws;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_gare_anticor_ditte</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_gare_anticor_ditte")
public class GareAnticorruzioneDitta {
  private Long idanticorlotti;
  /*
   * id fittizio in quanto jpa obbliga ad averlo
   */
  @Id
  private Long idanticorpartecip;
  private String aggiudicataria;
  private String ragsoc;
  private String codfisc;
  private String idfiscest;
  private Integer codruolo;
  private String descruolo;
  
  public Long getIdanticorlotti() {
    return idanticorlotti;
  }
  
  public void setIdanticorlotti(Long idanticorlotti) {
    this.idanticorlotti = idanticorlotti;
  }
  
  public Long getIdanticorpartecip() {
    return idanticorpartecip;
  }
  
  public void setIdanticorpartecip(Long idanticorpartecip) {
    this.idanticorpartecip = idanticorpartecip;
  }
  
  public String getAggiudicataria() {
    return aggiudicataria;
  }
  
  public void setAggiudicataria(String aggiudicataria) {
    this.aggiudicataria = aggiudicataria;
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
  
  public String getIdfiscest() {
    return idfiscest;
  }
  
  public void setIdfiscest(String idfiscest) {
    this.idfiscest = idfiscest;
  }
  
  public Integer getCodruolo() {
    return codruolo;
  }
  
  public void setCodruolo(Integer codruolo) {
    this.codruolo = codruolo;
  }
  
  public String getDescruolo() {
    return descruolo;
  }
  
  public void setDescruolo(String descruolo) {
    this.descruolo = descruolo;
  }

  @Override
  public String toString() {
    return "GareAnticorruzioneDitta ["
        + (idanticorlotti != null ? "idanticorlotti=" + idanticorlotti + ", " : "")
        + (idanticorpartecip != null ? "idanticorpartecip=" + idanticorpartecip + ", " : "")
        + (codfisc != null ? "codfisc=" + codfisc + ", " : "")
        + (idfiscest != null ? "idfiscest=" + idfiscest + ", " : "")
        + (descruolo != null ? "descruolo=" + descruolo : "")
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codfisc == null) ? 0 : codfisc.hashCode());
    result = prime * result + ((codruolo == null) ? 0 : codruolo.hashCode());
    result = prime * result + ((idanticorlotti == null) ? 0 : idanticorlotti.hashCode());
    result = prime * result + ((idanticorpartecip == null) ? 0 : idanticorpartecip.hashCode());
    result = prime * result + ((idfiscest == null) ? 0 : idfiscest.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    GareAnticorruzioneDitta other = (GareAnticorruzioneDitta) obj;
    if (codfisc == null) {
      if (other.codfisc != null) return false;
    } else if (!codfisc.equals(other.codfisc)) return false;
    if (codruolo == null) {
      if (other.codruolo != null) return false;
    } else if (!codruolo.equals(other.codruolo)) return false;
    if (idanticorlotti == null) {
      if (other.idanticorlotti != null) return false;
    } else if (!idanticorlotti.equals(other.idanticorlotti)) return false;
    if (idanticorpartecip == null) {
      if (other.idanticorpartecip != null) return false;
    } else if (!idanticorpartecip.equals(other.idanticorpartecip)) return false;
    if (idfiscest == null) {
      if (other.idfiscest != null) return false;
    } else if (!idfiscest.equals(other.idfiscest)) return false;
    return true;
  }
  
  
}
