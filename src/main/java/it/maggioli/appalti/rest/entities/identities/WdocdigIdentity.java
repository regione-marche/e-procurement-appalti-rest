package it.maggioli.appalti.rest.entities.identities;


import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Classe che rappresenta la chiave della tabella <code>w_docdig</code>
 * @author gabriele.nencini
 *
 */
@Embeddable
public class WdocdigIdentity implements Serializable {
  private static final long serialVersionUID = 1L;
  private String idprg;
  private Long iddocdig;
  
  public WdocdigIdentity() {
  }
  
  public WdocdigIdentity(String idprg, Long iddocdig) {
    this.idprg = idprg;
    this.iddocdig = iddocdig;
  }

  public String getIdprg() {
    return idprg;
  }
  
  public void setIdprg(String idprg) {
    this.idprg = idprg;
  }
  
  public Long getIddocdig() {
    return iddocdig;
  }
  
  public void setIddocdig(Long iddocdig) {
    this.iddocdig = iddocdig;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((iddocdig == null) ? 0 : iddocdig.hashCode());
    result = prime * result + ((idprg == null) ? 0 : idprg.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    WdocdigIdentity other = (WdocdigIdentity) obj;
    if (iddocdig == null) {
      if (other.iddocdig != null) return false;
    } else if (!iddocdig.equals(other.iddocdig)) return false;
    if (idprg == null) {
      if (other.idprg != null) return false;
    } else if (!idprg.equals(other.idprg)) return false;
    return true;
  }
  
  
}
