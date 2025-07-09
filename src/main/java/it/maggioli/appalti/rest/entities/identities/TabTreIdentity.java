package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class TabTreIdentity implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(hidden = true)
  @Column(name="tab3cod")
  public String codice;
  @Column(name="tab3tip")
  public String valore;

  /**
   * @return the codice
   */
  public String getCodice() {
    return codice;
  }
  
  /**
   * @param codice the codice to set
   */
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  /**
   * @return the valore
   */
  public String getValore() {
    return valore;
  }
  
  /**
   * @param valore the valore to set
   */
  public void setValore(String valore) {
    this.valore = valore;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codice == null) ? 0 : codice.hashCode());
    result = prime * result + ((valore == null) ? 0 : valore.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TabTreIdentity other = (TabTreIdentity) obj;
    if (codice == null) {
      if (other.codice != null) return false;
    } else if (!codice.equals(other.codice)) return false;
    if (valore == null) {
      if (other.valore != null) return false;
    } else if (!valore.equals(other.valore)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "TabTreIdentity [" + (codice != null ? "codice=" + codice + ", " : "") + (valore != null ? "valore=" + valore : "") + "]";
  }

}
