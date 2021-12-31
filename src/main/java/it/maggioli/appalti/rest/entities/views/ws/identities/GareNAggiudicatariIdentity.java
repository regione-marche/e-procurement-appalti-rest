package it.maggioli.appalti.rest.entities.views.ws.identities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class GareNAggiudicatariIdentity implements Serializable {
  private static final long serialVersionUID = 1L;
  private String codice;
  private String ditta;
  
  public GareNAggiudicatariIdentity() {
  }

  public GareNAggiudicatariIdentity(String codice, String ditta) {
    this.codice = codice;
    this.ditta = ditta;
  }

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codice == null) ? 0 : codice.hashCode());
    result = prime * result + ((ditta == null) ? 0 : ditta.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    GareNAggiudicatariIdentity other = (GareNAggiudicatariIdentity) obj;
    if (codice == null) {
      if (other.codice != null) return false;
    } else if (!codice.equals(other.codice)) return false;
    if (ditta == null) {
      if (other.ditta != null) return false;
    } else if (!ditta.equals(other.ditta)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "GareNAggiudicatariIdentity ["
        + (codice != null ? "codice=" + codice + ", " : "")
        + (ditta != null ? "ditta=" + ditta : "")
        + "]";
  }
  
}
