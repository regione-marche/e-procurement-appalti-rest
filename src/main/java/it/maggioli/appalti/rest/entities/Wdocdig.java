package it.maggioli.appalti.rest.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import it.maggioli.appalti.rest.entities.identities.WdocdigIdentity;

/**
 * Classe che mappa la tabella <code>w_docdig</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="w_docdig")
public class Wdocdig {
  @EmbeddedId
  private WdocdigIdentity identity;
  
  private String digent;
  private String digkey1;
  private String digkey2;
  private String digkey3;
  private String digkey4;
  private String digkey5;
  private String digtipdoc;
  private String dignomdoc;
  private String digdesdoc;
  private byte[] digogg;
  private Integer digfirma;
  
  public WdocdigIdentity getIdentity() {
    return identity;
  }
  
  public void setIdentity(WdocdigIdentity identity) {
    this.identity = identity;
  }
  
  public String getDigent() {
    return digent;
  }
  
  public void setDigent(String digent) {
    this.digent = digent;
  }
  
  public String getDigkey1() {
    return digkey1;
  }
  
  public void setDigkey1(String digkey1) {
    this.digkey1 = digkey1;
  }
  
  public String getDigkey2() {
    return digkey2;
  }
  
  public void setDigkey2(String digkey2) {
    this.digkey2 = digkey2;
  }
  
  public String getDigkey3() {
    return digkey3;
  }
  
  public void setDigkey3(String digkey3) {
    this.digkey3 = digkey3;
  }
  
  public String getDigkey4() {
    return digkey4;
  }
  
  public void setDigkey4(String digkey4) {
    this.digkey4 = digkey4;
  }
  
  public String getDigkey5() {
    return digkey5;
  }
  
  public void setDigkey5(String digkey5) {
    this.digkey5 = digkey5;
  }
  
  public String getDigtipdoc() {
    return digtipdoc;
  }
  
  public void setDigtipdoc(String digtipdoc) {
    this.digtipdoc = digtipdoc;
  }
  
  public String getDignomdoc() {
    return dignomdoc;
  }
  
  public void setDignomdoc(String dignomdoc) {
    this.dignomdoc = dignomdoc;
  }
  
  public String getDigdesdoc() {
    return digdesdoc;
  }
  
  public void setDigdesdoc(String digdesdoc) {
    this.digdesdoc = digdesdoc;
  }
  
  public byte[] getDigogg() {
    return digogg;
  }
  
  public void setDigogg(byte[] digogg) {
    this.digogg = digogg;
  }
  
  public Integer getDigfirma() {
    return digfirma;
  }
  
  public void setDigfirma(Integer digfirma) {
    this.digfirma = digfirma;
  }
  
  
}
