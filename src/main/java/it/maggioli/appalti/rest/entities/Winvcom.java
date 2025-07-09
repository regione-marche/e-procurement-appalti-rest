package it.maggioli.appalti.rest.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Immutable;

import it.maggioli.appalti.rest.entities.identities.WinvcomIdentity;

@Entity
@Immutable
@Table(name="w_invcom")
public class Winvcom {
  @EmbeddedId
  private WinvcomIdentity id = new WinvcomIdentity();
  @Column(insertable = false,updatable = false)
  private String comkey1;
  private Date comdatins;
  private String comstato;
  private String comtipo;
  private Date comdatastato;
  /**
   * @return the id
   */
  public WinvcomIdentity getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(WinvcomIdentity id) {
    this.id = id;
  }
  
  /**
   * @return the comkey1
   */
  public String getComkey1() {
    return comkey1;
  }
  
  /**
   * @param comkey1 the comkey1 to set
   */
  public void setComkey1(String comkey1) {
    this.comkey1 = comkey1;
  }
  
  /**
   * @return the comdatins
   */
  public Date getComdatins() {
    return comdatins;
  }
  
  /**
   * @param comdatins the comdatins to set
   */
  public void setComdatins(Date comdatins) {
    this.comdatins = comdatins;
  }
  
  /**
   * @return the comstato
   */
  public String getComstato() {
    return comstato;
  }
  
  /**
   * @param comstato the comstato to set
   */
  public void setComstato(String comstato) {
    this.comstato = comstato;
  }
  
  /**
   * @return the comtipo
   */
  public String getComtipo() {
    return comtipo;
  }
  
  /**
   * @param comtipo the comtipo to set
   */
  public void setComtipo(String comtipo) {
    this.comtipo = comtipo;
  }
  
  /**
   * @return the comdatastato
   */
  public Date getComdatastato() {
    return comdatastato;
  }
  
  /**
   * @param comdatastato the comdatastato to set
   */
  public void setComdatastato(Date comdatastato) {
    this.comdatastato = comdatastato;
  }

  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return "Winvcom ["
        + (id != null ? "id=" + id + ", " : "")
        + (comkey1 != null ? "comkey1=" + comkey1 + ", " : "")
        + (comdatastato != null ? "comdatastato=" + sdf.format(comdatastato) : "")
        + "]";
  }
  
  
}
