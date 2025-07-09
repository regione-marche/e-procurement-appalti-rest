package it.maggioli.appalti.rest.entities.views.ws.identities;

import java.io.Serializable;

/**
 * Classe che rappresenta la chiave della vista vwslfscodiciaggiudicazioni 
 * @author gabriele.nencini
 *
 */
public class LfsAggiudicazioniIdentity implements Serializable{
  private static final long serialVersionUID = 1L;
  private String codicegara;
  private String codicelotto;
  
  public LfsAggiudicazioniIdentity() {
    
  }
  
  public LfsAggiudicazioniIdentity(String codicegara,String codicelotto) {
    this.codicegara = codicegara;
    this.codicelotto = codicelotto;
  }

  
  /**
   * @return the codicegara
   */
  public String getCodicegara() {
    return codicegara;
  }

  
  /**
   * @param codicegara the codicegara to set
   */
  public void setCodicegara(String codicegara) {
    this.codicegara = codicegara;
  }

  
  /**
   * @return the codicelotto
   */
  public String getCodicelotto() {
    return codicelotto;
  }

  
  /**
   * @param codicelotto the codicelotto to set
   */
  public void setCodicelotto(String codicelotto) {
    this.codicelotto = codicelotto;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codicegara == null) ? 0 : codicegara.hashCode());
    result = prime * result + ((codicelotto == null) ? 0 : codicelotto.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    LfsAggiudicazioniIdentity other = (LfsAggiudicazioniIdentity) obj;
    if (codicegara == null) {
      if (other.codicegara != null) return false;
    } else if (!codicegara.equals(other.codicegara)) return false;
    if (codicelotto == null) {
      if (other.codicelotto != null) return false;
    } else if (!codicelotto.equals(other.codicelotto)) return false;
    return true;
  }
  
  
}
