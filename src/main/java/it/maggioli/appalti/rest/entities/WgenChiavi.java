package it.maggioli.appalti.rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="w_genchiavi")
public class WgenChiavi {
  @Id
  private String tabella;
  private Long chiave;
  
  public String getTabella() {
    return tabella;
  }
  
  public void setTabella(String tabella) {
    this.tabella = tabella;
  }
  
  public Long getChiave() {
    return chiave;
  }
  
  public void setChiave(Long chiave) {
    this.chiave = chiave;
  }

  @Override
  public String toString() {
    return "WgenChiavi [" + (tabella != null ? "tabella=" + tabella + ", " : "") + (chiave != null ? "chiave=" + chiave : "") + "]";
  }
  
}
