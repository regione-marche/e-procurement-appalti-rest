package it.maggioli.appalti.rest.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Questa classe mappa la tabella <code>uffint</code>
 * <br>Marcata come Immutable per evitare modifiche
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "uffint")
public class Uffint {
  @Id
  private String codein;
  private String nomein;
  private String viaein;
  private String nciein;
  private String citein;
  private String proein;
  private String capein;
  private String telein;
  private String faxein;
  private String cfein;
  private String dofein;
  private String lnaein;
  private Date dnaein;
  private String ivaein;
  private String notein;
  private String codsta;
  private Integer natgiu;
  private Integer tipoin;
  private String numicc;
  private Date daticc;
  private String proicc;
  private String codcit;
  private Integer codnaz;
  private String emaiin;
  private String codres;
  private String nomres;
  private Date resini;
  private Date resfin;
  private String prouff;
  private String indweb;
  private String profco;
  private String idammin;
  private String userid;
  private String pronas;
  private String emailpec;
  private String emai2in;
  private Date datfin;
  private String codfe;
  private String iscuc;
  private String cfanac;
  private String codipa;
  private String endpoint_nso;
  private String codcons_nso;
  
  /**
   * @return the codein
   */
  public String getCodein() {
    return codein;
  }
  
  /**
   * @param codein the codein to set
   */
  public void setCodein(String codein) {
    this.codein = codein;
  }
  
  /**
   * @return the nomein
   */
  public String getNomein() {
    return nomein;
  }
  
  /**
   * @param nomein the nomein to set
   */
  public void setNomein(String nomein) {
    this.nomein = nomein;
  }
  
  /**
   * @return the viaein
   */
  public String getViaein() {
    return viaein;
  }
  
  /**
   * @param viaein the viaein to set
   */
  public void setViaein(String viaein) {
    this.viaein = viaein;
  }
  
  /**
   * @return the nciein
   */
  public String getNciein() {
    return nciein;
  }
  
  /**
   * @param nciein the nciein to set
   */
  public void setNciein(String nciein) {
    this.nciein = nciein;
  }
  
  /**
   * @return the citein
   */
  public String getCitein() {
    return citein;
  }
  
  /**
   * @param citein the citein to set
   */
  public void setCitein(String citein) {
    this.citein = citein;
  }
  
  /**
   * @return the proein
   */
  public String getProein() {
    return proein;
  }
  
  /**
   * @param proein the proein to set
   */
  public void setProein(String proein) {
    this.proein = proein;
  }
  
  /**
   * @return the capein
   */
  public String getCapein() {
    return capein;
  }
  
  /**
   * @param capein the capein to set
   */
  public void setCapein(String capein) {
    this.capein = capein;
  }
  
  /**
   * @return the telein
   */
  public String getTelein() {
    return telein;
  }
  
  /**
   * @param telein the telein to set
   */
  public void setTelein(String telein) {
    this.telein = telein;
  }
  
  /**
   * @return the faxein
   */
  public String getFaxein() {
    return faxein;
  }
  
  /**
   * @param faxein the faxein to set
   */
  public void setFaxein(String faxein) {
    this.faxein = faxein;
  }
  
  /**
   * @return the cfein
   */
  public String getCfein() {
    return cfein;
  }
  
  /**
   * @param cfein the cfein to set
   */
  public void setCfein(String cfein) {
    this.cfein = cfein;
  }
  
  /**
   * @return the dofein
   */
  public String getDofein() {
    return dofein;
  }
  
  /**
   * @param dofein the dofein to set
   */
  public void setDofein(String dofein) {
    this.dofein = dofein;
  }
  
  /**
   * @return the lnaein
   */
  public String getLnaein() {
    return lnaein;
  }
  
  /**
   * @param lnaein the lnaein to set
   */
  public void setLnaein(String lnaein) {
    this.lnaein = lnaein;
  }
  
  /**
   * @return the dnaein
   */
  public Date getDnaein() {
    return dnaein;
  }
  
  /**
   * @param dnaein the dnaein to set
   */
  public void setDnaein(Date dnaein) {
    this.dnaein = dnaein;
  }
  
  /**
   * @return the ivaein
   */
  public String getIvaein() {
    return ivaein;
  }
  
  /**
   * @param ivaein the ivaein to set
   */
  public void setIvaein(String ivaein) {
    this.ivaein = ivaein;
  }
  
  /**
   * @return the notein
   */
  public String getNotein() {
    return notein;
  }
  
  /**
   * @param notein the notein to set
   */
  public void setNotein(String notein) {
    this.notein = notein;
  }
  
  /**
   * @return the codsta
   */
  public String getCodsta() {
    return codsta;
  }
  
  /**
   * @param codsta the codsta to set
   */
  public void setCodsta(String codsta) {
    this.codsta = codsta;
  }
  
  /**
   * @return the natgiu
   */
  public Integer getNatgiu() {
    return natgiu;
  }
  
  /**
   * @param natgiu the natgiu to set
   */
  public void setNatgiu(Integer natgiu) {
    this.natgiu = natgiu;
  }
  
  /**
   * @return the tipoin
   */
  public Integer getTipoin() {
    return tipoin;
  }
  
  /**
   * @param tipoin the tipoin to set
   */
  public void setTipoin(Integer tipoin) {
    this.tipoin = tipoin;
  }
  
  /**
   * @return the numicc
   */
  public String getNumicc() {
    return numicc;
  }
  
  /**
   * @param numicc the numicc to set
   */
  public void setNumicc(String numicc) {
    this.numicc = numicc;
  }
  
  /**
   * @return the daticc
   */
  public Date getDaticc() {
    return daticc;
  }
  
  /**
   * @param daticc the daticc to set
   */
  public void setDaticc(Date daticc) {
    this.daticc = daticc;
  }
  
  /**
   * @return the proicc
   */
  public String getProicc() {
    return proicc;
  }
  
  /**
   * @param proicc the proicc to set
   */
  public void setProicc(String proicc) {
    this.proicc = proicc;
  }
  
  /**
   * @return the codcit
   */
  public String getCodcit() {
    return codcit;
  }
  
  /**
   * @param codcit the codcit to set
   */
  public void setCodcit(String codcit) {
    this.codcit = codcit;
  }
  
  /**
   * @return the codnaz
   */
  public Integer getCodnaz() {
    return codnaz;
  }
  
  /**
   * @param codnaz the codnaz to set
   */
  public void setCodnaz(Integer codnaz) {
    this.codnaz = codnaz;
  }
  
  /**
   * @return the emaiin
   */
  public String getEmaiin() {
    return emaiin;
  }
  
  /**
   * @param emaiin the emaiin to set
   */
  public void setEmaiin(String emaiin) {
    this.emaiin = emaiin;
  }
  
  /**
   * @return the codres
   */
  public String getCodres() {
    return codres;
  }
  
  /**
   * @param codres the codres to set
   */
  public void setCodres(String codres) {
    this.codres = codres;
  }
  
  /**
   * @return the nomres
   */
  public String getNomres() {
    return nomres;
  }
  
  /**
   * @param nomres the nomres to set
   */
  public void setNomres(String nomres) {
    this.nomres = nomres;
  }
  
  /**
   * @return the resini
   */
  public Date getResini() {
    return resini;
  }
  
  /**
   * @param resini the resini to set
   */
  public void setResini(Date resini) {
    this.resini = resini;
  }
  
  /**
   * @return the resfin
   */
  public Date getResfin() {
    return resfin;
  }
  
  /**
   * @param resfin the resfin to set
   */
  public void setResfin(Date resfin) {
    this.resfin = resfin;
  }
  
  /**
   * @return the prouff
   */
  public String getProuff() {
    return prouff;
  }
  
  /**
   * @param prouff the prouff to set
   */
  public void setProuff(String prouff) {
    this.prouff = prouff;
  }
  
  /**
   * @return the indweb
   */
  public String getIndweb() {
    return indweb;
  }
  
  /**
   * @param indweb the indweb to set
   */
  public void setIndweb(String indweb) {
    this.indweb = indweb;
  }
  
  /**
   * @return the profco
   */
  public String getProfco() {
    return profco;
  }
  
  /**
   * @param profco the profco to set
   */
  public void setProfco(String profco) {
    this.profco = profco;
  }
  
  /**
   * @return the idammin
   */
  public String getIdammin() {
    return idammin;
  }
  
  /**
   * @param idammin the idammin to set
   */
  public void setIdammin(String idammin) {
    this.idammin = idammin;
  }
  
  /**
   * @return the userid
   */
  public String getUserid() {
    return userid;
  }
  
  /**
   * @param userid the userid to set
   */
  public void setUserid(String userid) {
    this.userid = userid;
  }
  
  /**
   * @return the pronas
   */
  public String getPronas() {
    return pronas;
  }
  
  /**
   * @param pronas the pronas to set
   */
  public void setPronas(String pronas) {
    this.pronas = pronas;
  }
  
  /**
   * @return the emailpec
   */
  public String getEmailpec() {
    return emailpec;
  }
  
  /**
   * @param emailpec the emailpec to set
   */
  public void setEmailpec(String emailpec) {
    this.emailpec = emailpec;
  }
  
  /**
   * @return the emai2in
   */
  public String getEmai2in() {
    return emai2in;
  }
  
  /**
   * @param emai2in the emai2in to set
   */
  public void setEmai2in(String emai2in) {
    this.emai2in = emai2in;
  }
  
  /**
   * @return the datfin
   */
  public Date getDatfin() {
    return datfin;
  }
  
  /**
   * @param datfin the datfin to set
   */
  public void setDatfin(Date datfin) {
    this.datfin = datfin;
  }
  
  /**
   * @return the codfe
   */
  public String getCodfe() {
    return codfe;
  }
  
  /**
   * @param codfe the codfe to set
   */
  public void setCodfe(String codfe) {
    this.codfe = codfe;
  }
  
  /**
   * @return the iscuc
   */
  public String getIscuc() {
    return iscuc;
  }
  
  /**
   * @param iscuc the iscuc to set
   */
  public void setIscuc(String iscuc) {
    this.iscuc = iscuc;
  }
  
  /**
   * @return the cfanac
   */
  public String getCfanac() {
    return cfanac;
  }
  
  /**
   * @param cfanac the cfanac to set
   */
  public void setCfanac(String cfanac) {
    this.cfanac = cfanac;
  }
  
  /**
   * @return the codipa
   */
  public String getCodipa() {
    return codipa;
  }
  
  /**
   * @param codipa the codipa to set
   */
  public void setCodipa(String codipa) {
    this.codipa = codipa;
  }
  
  /**
   * @return the endpoint_nso
   */
  public String getEndpoint_nso() {
    return endpoint_nso;
  }
  
  /**
   * @param endpoint_nso the endpoint_nso to set
   */
  public void setEndpoint_nso(String endpoint_nso) {
    this.endpoint_nso = endpoint_nso;
  }
  
  /**
   * @return the codcons_nso
   */
  public String getCodcons_nso() {
    return codcons_nso;
  }
  
  /**
   * @param codcons_nso the codcons_nso to set
   */
  public void setCodcons_nso(String codcons_nso) {
    this.codcons_nso = codcons_nso;
  }
  
  
}
