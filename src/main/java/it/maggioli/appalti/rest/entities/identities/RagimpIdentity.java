package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import it.maggioli.appalti.rest.entities.Impr;

@Embeddable
public class RagimpIdentity implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private String codime9;
  @OneToOne
  @JoinColumn(name = "coddic",unique = true,nullable = false)
  private Impr coddic;
  
  /**
   * @return the codime9
   */
  public String getCodime9() {
    return codime9;
  }
  
  /**
   * @param codime9 the codime9 to set
   */
  public void setCodime9(String codime9) {
    this.codime9 = codime9;
  }
  
  /**
   * @return the coddic
   */
  public Impr getCoddic() {
    return coddic;
  }
  
  /**
   * @param coddic the coddic to set
   */
  public void setCoddic(Impr coddic) {
    this.coddic = coddic;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((coddic == null) ? 0 : coddic.hashCode());
    result = prime * result + ((codime9 == null) ? 0 : codime9.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    RagimpIdentity other = (RagimpIdentity) obj;
    if (coddic == null) {
      if (other.coddic != null) return false;
    } else if (!coddic.equals(other.coddic)) return false;
    if (codime9 == null) {
      if (other.codime9 != null) return false;
    } else if (!codime9.equals(other.codime9)) return false;
    return true;
  }

  
  
}
