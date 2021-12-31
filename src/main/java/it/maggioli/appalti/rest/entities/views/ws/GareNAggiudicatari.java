package it.maggioli.appalti.rest.entities.views.ws;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import it.maggioli.appalti.rest.entities.views.ws.identities.GareNAggiudicatariIdentity;

/**
 * Classe che mappa la vista <code>v_ws_gare_n_aggiudicatari</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_gare_n_aggiudicatari")
public class GareNAggiudicatari {
  @EmbeddedId
  private GareNAggiudicatariIdentity identity;

  private Integer numord;
  private String ragsoc;
  private String codfisc;
  private String partiva;
  private Boolean rti;
  
  public GareNAggiudicatariIdentity getIdentity() {
    return identity;
  }
  
  public void setIdentity(GareNAggiudicatariIdentity identity) {
    this.identity = identity;
  }
  
  public Integer getNumord() {
    return numord;
  }
  
  public void setNumord(Integer numord) {
    this.numord = numord;
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
  
  public String getForGroupBy() {
    return this.identity.getCodice();
  }

  @Override
  public String toString() {
    return "GareNAggiudicatari ["
        + (identity != null ? "identity=" + identity + ", " : "")
        + (numord != null ? "numord=" + numord + ", " : "")
        + (codfisc != null ? "codfisc=" + codfisc + ", " : "")
        + (partiva != null ? "partiva=" + partiva + ", " : "")
        + (rti != null ? "rti=" + rti : "")
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((identity == null) ? 0 : identity.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    GareNAggiudicatari other = (GareNAggiudicatari) obj;
    if (identity == null) {
      if (other.identity != null) return false;
    } else if (!identity.equals(other.identity)) return false;
    return true;
  }
  
}
