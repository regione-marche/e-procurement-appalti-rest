package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WinvcomIdentity implements Serializable{
  private static final long serialVersionUID = 1L;
  public String idprg;
  public String idcom;

  public WinvcomIdentity() {
  }

  
  /**
   * @return the idprg
   */
  public String getIdprg() {
    return idprg;
  }

  
  /**
   * @param idprg the idprg to set
   */
  public void setIdprg(String idprg) {
    this.idprg = idprg;
  }

  
  /**
   * @return the idcom
   */
  public String getIdcom() {
    return idcom;
  }

  
  /**
   * @param idcom the idcom to set
   */
  public void setIdcom(String idcom) {
    this.idcom = idcom;
  }


  @Override
  public String toString() {
    return "WinvcomIdentity [" + (idprg != null ? "idprg=" + idprg + ", " : "") + (idcom != null ? "idcom=" + idcom : "") + "]";
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idcom == null) ? 0 : idcom.hashCode());
    result = prime * result + ((idprg == null) ? 0 : idprg.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    WinvcomIdentity other = (WinvcomIdentity) obj;
    if (idcom == null) {
      if (other.idcom != null) return false;
    } else if (!idcom.equals(other.idcom)) return false;
    if (idprg == null) {
      if (other.idprg != null) return false;
    } else if (!idprg.equals(other.idprg)) return false;
    return true;
  }
  
  
}
