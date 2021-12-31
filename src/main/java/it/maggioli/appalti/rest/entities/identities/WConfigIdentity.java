package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.springframework.lang.NonNull;

/**
 * Classe che rappresenta la chiave della tabella <code>w_config</code>
 * @author gabriele.nencini
 *
 */
@Embeddable
public class WConfigIdentity implements Serializable {
  private static final long serialVersionUID = 1L;
  @NonNull
  private String codapp;
  @NonNull
  private String chiave;
  
  public WConfigIdentity() {}
  
  public WConfigIdentity(String codapp, String chiave) {
    this.codapp = codapp;
    this.chiave = chiave;
  }

  public String getCodapp() {
    return codapp;
  }
  
  public void setCodapp(String codapp) {
    this.codapp = codapp;
  }
  
  public String getChiave() {
    return chiave;
  }
  
  public void setChiave(String chiave) {
    this.chiave = chiave;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((chiave == null) ? 0 : chiave.hashCode());
    result = prime * result + ((codapp == null) ? 0 : codapp.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    WConfigIdentity other = (WConfigIdentity) obj;
    if (chiave == null) {
      if (other.chiave != null) return false;
    } else if (!chiave.equals(other.chiave)) return false;
    if (codapp == null) {
      if (other.codapp != null) return false;
    } else if (!codapp.equals(other.codapp)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "WConfigIdentity [" + (codapp != null ? "codapp=" + codapp + ", " : "") + (chiave != null ? "chiave=" + chiave : "") + "]";
  }
  
  
}

