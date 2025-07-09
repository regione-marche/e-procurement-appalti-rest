package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_ws_trasp_contratti_estesa")
public class TraspContrattoEstesoDataAcqCig extends TraspContrattoBasic {
  private Date dtepar;
  private String otepar;
  private Date dteoff;
  private String oteoff;
  private String dataoraterminepar;
  private String dataoratermineoff;
  private Date dataacquisizionecig;
  private String nrepat;
  /**
   * @return the dtepar
   */
  public Date getDtepar() {
    return dtepar;
  }
  
  /**
   * @param dtepar the dtepar to set
   */
  public void setDtepar(Date dtepar) {
    this.dtepar = dtepar;
  }
  
  /**
   * @return the otepar
   */
  public String getOtepar() {
    return otepar;
  }
  
  /**
   * @param otepar the otepar to set
   */
  public void setOtepar(String otepar) {
    this.otepar = otepar;
  }

  /**
   * @return the dteoff
   */
  public Date getDteoff() {
    return dteoff;
  }
  
  /**
   * @param dteoff the dteoff to set
   */
  public void setDteoff(Date dteoff) {
    this.dteoff = dteoff;
  }
  
  /**
   * @return the oteoff
   */
  public String getOteoff() {
    return oteoff;
  }
  
  /**
   * @param oteoff the oteoff to set
   */
  public void setOteoff(String oteoff) {
    this.oteoff = oteoff;
  }
  
  /**
   * @return the dataoraterminepar
   */
  public String getDataoraterminepar() {
    return dataoraterminepar;
  }
  
  /**
   * @param dataoraterminepar the dataoraterminepar to set
   */
  public void setDataoraterminepar(String dataoraterminepar) {
    this.dataoraterminepar = dataoraterminepar;
  }
  
  /**
   * @return the dataoratermineoff
   */
  public String getDataoratermineoff() {
    return dataoratermineoff;
  }
  
  /**
   * @param dataoratermineoff the dataoratermineoff to set
   */
  public void setDataoratermineoff(String dataoratermineoff) {
    this.dataoratermineoff = dataoratermineoff;
  }

  /**
   * @return the dataacquisizionecig
   */
  public Date getDataacquisizionecig() {
    return dataacquisizionecig;
  }
  
  /**
   * @param dataacquisizionecig the dataacquisizionecig to set
   */
  public void setDataacquisizionecig(Date dataacquisizionecig) {
    this.dataacquisizionecig = dataacquisizionecig;
  }

  public String getNrepat() {
    return nrepat;
  }

  public void setNrepat(String nrepat) {
    this.nrepat = nrepat;
  }
}
