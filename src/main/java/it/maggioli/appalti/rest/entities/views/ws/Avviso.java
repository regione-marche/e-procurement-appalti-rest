package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_avvisi</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_avvisi")
public class Avviso {
  private String ngara;
  private String codgar;
  @Id
  private String codice;
  private Integer codtipoapp;
  private String desctipoapp;
  private Integer codtipoavv;
  private String desctipoavv;
  private String oggetto;
  private String codsa;
  private String descsa;
  private String cfiscsa;
  private Integer codtipsa;
  private String desctipsa;
  private String provsede;
  private String comsede;
  private String indsede;
  private String respproc;
  private String descrup;
  private Date datpub;
  private String isarchi;
  private Date datascadenza;
  private String orascadenza;
  private Date dataorascadenza;
  private Double annoinizioperscadenza;
  private Date dultagg;
  private String codscp;
  private String urlscp;
  private Integer altrisog;
  
  public String getNgara() {
    return ngara;
  }
  
  public void setNgara(String ngara) {
    this.ngara = ngara;
  }
  
  public String getCodgar() {
    return codgar;
  }
  
  public void setCodgar(String codgar) {
    this.codgar = codgar;
  }
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public Integer getCodtipoapp() {
    return codtipoapp;
  }
  
  public void setCodtipoapp(Integer codtipoapp) {
    this.codtipoapp = codtipoapp;
  }
  
  public String getDesctipoapp() {
    return desctipoapp;
  }
  
  public void setDesctipoapp(String desctipoapp) {
    this.desctipoapp = desctipoapp;
  }
  
  public Integer getCodtipoavv() {
    return codtipoavv;
  }
  
  public void setCodtipoavv(Integer codtipoavv) {
    this.codtipoavv = codtipoavv;
  }
  
  public String getDesctipoavv() {
    return desctipoavv;
  }
  
  public void setDesctipoavv(String desctipoavv) {
    this.desctipoavv = desctipoavv;
  }
  
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  public String getCodsa() {
    return codsa;
  }
  
  public void setCodsa(String codsa) {
    this.codsa = codsa;
  }
  
  public String getDescsa() {
    return descsa;
  }
  
  public void setDescsa(String descsa) {
    this.descsa = descsa;
  }
  
  public String getCfiscsa() {
    return cfiscsa;
  }
  
  public void setCfiscsa(String cfiscsa) {
    this.cfiscsa = cfiscsa;
  }
  
  public Integer getCodtipsa() {
    return codtipsa;
  }
  
  public void setCodtipsa(Integer codtipsa) {
    this.codtipsa = codtipsa;
  }
  
  public String getDesctipsa() {
    return desctipsa;
  }
  
  public void setDesctipsa(String desctipsa) {
    this.desctipsa = desctipsa;
  }
  
  public String getProvsede() {
    return provsede;
  }
  
  public void setProvsede(String provsede) {
    this.provsede = provsede;
  }
  
  public String getComsede() {
    return comsede;
  }
  
  public void setComsede(String comsede) {
    this.comsede = comsede;
  }
  
  public String getIndsede() {
    return indsede;
  }
  
  public void setIndsede(String indsede) {
    this.indsede = indsede;
  }
  
  public String getRespproc() {
    return respproc;
  }
  
  public void setRespproc(String respproc) {
    this.respproc = respproc;
  }
  
  public String getDescrup() {
    return descrup;
  }
  
  public void setDescrup(String descrup) {
    this.descrup = descrup;
  }
  
  public Date getDatpub() {
    return datpub;
  }
  
  public void setDatpub(Date datpub) {
    this.datpub = datpub;
  }
  
  public String getIsarchi() {
    return isarchi;
  }
  
  public void setIsarchi(String isarchi) {
    this.isarchi = isarchi;
  }
  
  public Date getDatascadenza() {
    return datascadenza;
  }
  
  public void setDatascadenza(Date datascadenza) {
    this.datascadenza = datascadenza;
  }
  
  public String getOrascadenza() {
    return orascadenza;
  }
  
  public void setOrascadenza(String orascadenza) {
    this.orascadenza = orascadenza;
  }
  
  public Date getDataorascadenza() {
    return dataorascadenza;
  }
  
  public void setDataorascadenza(Date dataorascadenza) {
    this.dataorascadenza = dataorascadenza;
  }
  
  public Double getAnnoinizioperscadenza() {
    return annoinizioperscadenza;
  }
  
  public void setAnnoinizioperscadenza(Double annoinizioperscadenza) {
    this.annoinizioperscadenza = annoinizioperscadenza;
  }
  
  public Date getDultagg() {
    return dultagg;
  }
  
  public void setDultagg(Date dultagg) {
    this.dultagg = dultagg;
  }
  
  public String getCodscp() {
    return codscp;
  }
  
  public void setCodscp(String codscp) {
    this.codscp = codscp;
  }
  
  public String getUrlscp() {
    return urlscp;
  }
  
  public void setUrlscp(String urlscp) {
    this.urlscp = urlscp;
  }
  
  public Integer getAltrisog() {
    return altrisog;
  }
  
  public void setAltrisog(Integer altrisog) {
    this.altrisog = altrisog;
  }
  
}
