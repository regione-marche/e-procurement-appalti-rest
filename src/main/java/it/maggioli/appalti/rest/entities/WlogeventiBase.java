package it.maggioli.appalti.rest.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Classe di supporto creata perchè avere un metodo rest che ha come parametro una entita è una vulnerability critical
 * @author gabriele.nencini
 *
 */
public class WlogeventiBase {
  private Long idevento;
  private String codapp;
  private String cod_profilo;
  private Long syscon;
  private String ipevento;
  private Date dataora;
  private String oggevento;
  private Integer livevento;
  private String codevento;
  private String descr;
  private String errmsg;
  
  public Long getIdevento() {
    return idevento;
  }
  
  public void setIdevento(Long idevento) {
    this.idevento = idevento;
  }
  
  public String getCodapp() {
    return codapp;
  }
  
  public void setCodapp(String codapp) {
    this.codapp = codapp;
  }
  
  public String getCod_profilo() {
    return cod_profilo;
  }
  
  public void setCod_profilo(String cod_profilo) {
    this.cod_profilo = cod_profilo;
  }
  
  public Long getSyscon() {
    return syscon;
  }
  
  public void setSyscon(Long syscon) {
    this.syscon = syscon;
  }
  
  public String getIpevento() {
    return ipevento;
  }
  
  public void setIpevento(String ipevento) {
    this.ipevento = ipevento;
  }
  
  public Date getDataora() {
    return dataora;
  }

  public void setDataora(Date dataora) {
    this.dataora = dataora;
  }
  
  public String getOggevento() {
    return oggevento;
  }
  
  public void setOggevento(String oggevento) {
    this.oggevento = oggevento;
  }
  
  public Integer getLivevento() {
    return livevento;
  }
  
  public void setLivevento(Integer livevento) {
    this.livevento = livevento;
  }
  
  public String getCodevento() {
    return codevento;
  }
  
  public void setCodevento(String codevento) {
    this.codevento = codevento;
  }
  
  public String getDescr() {
    return descr;
  }
  
  public void setDescr(String descr) {
    this.descr = descr;
  }
  
  public String getErrmsg() {
    return errmsg;
  }
  
  public void setErrmsg(String errmsg) {
    this.errmsg = errmsg;
  }
  
}
