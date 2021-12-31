package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UsreinIdentity implements Serializable{
  private static final long serialVersionUID = 1L;
  private Long syscon;
  private String codein;
  
  public Long getSyscon() {
    return syscon;
  }
  
  public void setSyscon(Long syscon) {
    this.syscon = syscon;
  }
  
  public String getCodein() {
    return codein;
  }
  
  public void setCodein(String codein) {
    this.codein = codein;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codein == null) ? 0 : codein.hashCode());
    result = prime * result + ((syscon == null) ? 0 : syscon.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    UsreinIdentity other = (UsreinIdentity) obj;
    if (codein == null) {
      if (other.codein != null) return false;
    } else if (!codein.equals(other.codein)) return false;
    if (syscon == null) {
      if (other.syscon != null) return false;
    } else if (!syscon.equals(other.syscon)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "UsreinIdentity [" + (syscon != null ? "syscon=" + syscon + ", " : "") + (codein != null ? "codein=" + codein : "") + "]";
  }
  
}
