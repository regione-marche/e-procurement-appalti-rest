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
  
}