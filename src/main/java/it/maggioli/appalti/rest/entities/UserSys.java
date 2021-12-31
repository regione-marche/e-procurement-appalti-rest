package it.maggioli.appalti.rest.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Classe che mappa la tabella <code>usrsys</code>
 * @author gabriele.nencini
 *
 */
@Entity
@Table(name="usrsys")
@DynamicUpdate
public class UserSys {
  @Transient
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @Id
  private Long syscon;
  private String sysute;
  private String sysnom;
  private String syspwd;
  private Date sysdat;
  private String sysab1;
  private String sysab2;
  private String sysab3;
  private Long sysliv;
  private String syspwbou;
  private String codimp;
  private Double impimp;
  private String sysabg;
  private Long syslig;
  private String sysabc;
  private Long syslic;
  private String sysabu;
  private String codtec;
  private String abilap;
  private String syspri;
  private String codtei;
  private String uducla1;
  private Integer flag_ldap;
  private String dn;
  private Long syscongrp;
  private String sysdisab;
  private String email;
  private Date sysscad;
  private Long sysuffapp;
  private String emailpec;
  private Integer meruolo;
  private Integer syscateg;
  private String syscf;
  private String syslogin;
  private String sysabap;
  private Date sysultacc;
  
  @OneToMany(fetch = FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  @JoinColumn(name = "syscon")
  private List<Usrein> listUffint;
  
  public Long getSyscon() {
    return syscon;
  }
  
  public void setSyscon(Long syscon) {
    this.syscon = syscon;
  }
  
  public String getSysute() {
    return sysute;
  }
  
  public void setSysute(String sysute) {
    this.sysute = sysute;
  }
  
  public String getSysnom() {
    return sysnom;
  }
  
  public void setSysnom(String sysnom) {
    this.sysnom = sysnom;
  }
  
  public String getSyspwd() {
    return syspwd;
  }
  
  public void setSyspwd(String syspwd) {
    this.syspwd = syspwd;
  }
  
  public Date getSysdat() {
    return sysdat;
  }
  
  public void setSysdat(Date sysdat) {
    this.sysdat = sysdat;
  }
  
  public String getSysab1() {
    return sysab1;
  }
  
  public void setSysab1(String sysab1) {
    this.sysab1 = sysab1;
  }
  
  public String getSysab2() {
    return sysab2;
  }
  
  public void setSysab2(String sysab2) {
    this.sysab2 = sysab2;
  }
  
  public String getSysab3() {
    return sysab3;
  }
  
  public void setSysab3(String sysab3) {
    this.sysab3 = sysab3;
  }
  
  public Long getSysliv() {
    return sysliv;
  }
  
  public void setSysliv(Long sysliv) {
    this.sysliv = sysliv;
  }
  
  public String getSyspwbou() {
    return syspwbou;
  }
  
  public void setSyspwbou(String syspwbou) {
    this.syspwbou = syspwbou;
  }
  
  public String getCodimp() {
    return codimp;
  }
  
  public void setCodimp(String codimp) {
    this.codimp = codimp;
  }
  
  public Double getImpimp() {
    return impimp;
  }
  
  public void setImpimp(Double impimp) {
    this.impimp = impimp;
  }
  
  public String getSysabg() {
    return sysabg;
  }
  
  public void setSysabg(String sysabg) {
    this.sysabg = sysabg;
  }
  
  public Long getSyslig() {
    return syslig;
  }
  
  public void setSyslig(Long syslig) {
    this.syslig = syslig;
  }
  
  public String getSysabc() {
    return sysabc;
  }
  
  public void setSysabc(String sysabc) {
    this.sysabc = sysabc;
  }
  
  public Long getSyslic() {
    return syslic;
  }
  
  public void setSyslic(Long syslic) {
    this.syslic = syslic;
  }
  
  public String getSysabu() {
    return sysabu;
  }
  
  public void setSysabu(String sysabu) {
    this.sysabu = sysabu;
  }
  
  public String getCodtec() {
    return codtec;
  }
  
  public void setCodtec(String codtec) {
    this.codtec = codtec;
  }
  
  public String getAbilap() {
    return abilap;
  }
  
  public void setAbilap(String abilap) {
    this.abilap = abilap;
  }
  
  public String getSyspri() {
    return syspri;
  }
  
  public void setSyspri(String syspri) {
    this.syspri = syspri;
  }
  
  public String getCodtei() {
    return codtei;
  }
  
  public void setCodtei(String codtei) {
    this.codtei = codtei;
  }
  
  public String getUducla1() {
    return uducla1;
  }
  
  public void setUducla1(String uducla1) {
    this.uducla1 = uducla1;
  }
  
  public Integer getFlag_ldap() {
    return flag_ldap;
  }
  
  public void setFlag_ldap(Integer flag_ldap) {
    this.flag_ldap = flag_ldap;
  }
  
  public String getDn() {
    return dn;
  }
  
  public void setDn(String dn) {
    this.dn = dn;
  }
  
  public Long getSyscongrp() {
    return syscongrp;
  }
  
  public void setSyscongrp(Long syscongrp) {
    this.syscongrp = syscongrp;
  }
  
  public String getSysdisab() {
    return sysdisab;
  }
  
  public void setSysdisab(String sysdisab) {
    this.sysdisab = sysdisab;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public Date getSysscad() {
    return sysscad;
  }
  
  public void setSysscad(Date sysscad) {
    this.sysscad = sysscad;
  }
  
  public Long getSysuffapp() {
    return sysuffapp;
  }
  
  public void setSysuffapp(Long sysuffapp) {
    this.sysuffapp = sysuffapp;
  }
  
  public String getEmailpec() {
    return emailpec;
  }
  
  public void setEmailpec(String emailpec) {
    this.emailpec = emailpec;
  }
  
  public Integer getMeruolo() {
    return meruolo;
  }
  
  public void setMeruolo(Integer meruolo) {
    this.meruolo = meruolo;
  }
  
  public Integer getSyscateg() {
    return syscateg;
  }
  
  public void setSyscateg(Integer syscateg) {
    this.syscateg = syscateg;
  }
  
  public String getSyscf() {
    return syscf;
  }
  
  public void setSyscf(String syscf) {
    this.syscf = syscf;
  }
  
  public String getSyslogin() {
    return syslogin;
  }
  
  public void setSyslogin(String syslogin) {
    this.syslogin = syslogin;
  }
  
  public String getSysabap() {
    return sysabap;
  }
  
  public void setSysabap(String sysabap) {
    this.sysabap = sysabap;
  }
  
  public Date getSysultacc() {
    return sysultacc;
  }
  
  public void setSysultacc(Date sysultacc) {
    this.sysultacc = sysultacc;
  }
  
  public List<Usrein> getListUffint() {
    return listUffint;
  }
  
  public void setListUffint(List<Usrein> listUffint) {
    this.listUffint = listUffint;
  }

  @Override
  public String toString() {
    return "UserSys ["
        + (syscon != null ? "syscon=" + syscon + ", " : "")
        + (syslogin != null ? "syslogin=" + syslogin + ", " : "")
        + (sysultacc != null ? "sysultacc=" + sdf.format(sysultacc) : "")
        + "]";
  }
  
  
}
