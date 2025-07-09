package it.maggioli.appalti.rest.entities.views.ws.identities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AdempimentiAnticorIdentity implements Serializable {

  private static final long serialVersionUID = 1L;
  public String  codein;
  public Integer annorif;

  public AdempimentiAnticorIdentity() {
  }
  
  public AdempimentiAnticorIdentity(String codein, Integer annorif) {
    this.codein = codein;
    this.annorif = annorif;
  }

  /**
   * @return the codein
   */
  public String getCodein() {
    return codein;
  }
  
  /**
   * @param codein the codein to set
   */
  public void setCodein(String codein) {
    this.codein = codein;
  }
  
  /**
   * @return the annorif
   */
  public Integer getAnnorif() {
    return annorif;
  }

  /**
   * @param annorif the annorif to set
   */
  public void setAnnorif(Integer annorif) {
    this.annorif = annorif;
  }

  @Override
  public String toString() {
    return "AdempimentiAnticorIdentity ["
        + (codein != null ? "codein=" + codein + ", " : "")
        + (annorif != null ? "annorif=" + annorif : "")
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((annorif == null) ? 0 : annorif.hashCode());
    result = prime * result + ((codein == null) ? 0 : codein.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    AdempimentiAnticorIdentity other = (AdempimentiAnticorIdentity) obj;
    if (annorif == null) {
      if (other.annorif != null) return false;
    } else if (!annorif.equals(other.annorif)) return false;
    if (codein == null) {
      if (other.codein != null) return false;
    } else if (!codein.equals(other.codein)) return false;
    return true;
  }
  
}