package it.maggioli.appalti.rest.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import it.maggioli.appalti.rest.entities.identities.GarecontIdentity;

/**
 * Classe che mappa la tabella <code>garecont</code> <br>
 * Annotata con {@link DynamicUpdate} per semplificarne l'eventuale aggiornamento
 * 
 * @author gabriele.nencini
 *
 */
@Entity
@DynamicUpdate
@Table(name = "garecont")
public class Garecont {

  @EmbeddedId
  private GarecontIdentity id;
  private String           codimp;
  private String           incorso;
  private Date             dverbc;
  private String           consant;
  private String           motant;
  private Date             davves;
  private Integer          ngiorit;
  private String           modpag;
  private String           lavsub;
  private BigDecimal       percav;
  private Date             dteres;
  private Date             dcertu;
  private BigDecimal       impliq;
  private String           isnconf;
  private String           desnconf;
  private String           note;
  private Integer          nmespro;
  private String           coorba;
  private Integer          stato;
  private BigDecimal       impiva;
  private BigDecimal       imptot;
  private Date             datdef;
  private Date             dattra;
  private Date             datlet;
  private Date             datrev;
  private String           motrev;
  private Date             datrif;
  private Integer          pcoese;
  private Integer          pcofat;
  private String           nproat;
  private String           idprg;
  private Long             iddocdg;
  private String           cenint;
  private String           locese;
  private String           locfat;
  private Date             dscapo;
  private String           npropo;
  private Date             dsvipo;
  private String           nsvipo;
  private Date             datres;
  private BigDecimal       impqua;
  private String           pubtrasp;
  private String           lregco;
  private String           nregco;
  private Date             dregco;
  private String           ngaral;
  private String           banapp;
  private String           numcont;
  private String           codbic;
  private String           esecscig;
  private String           ragcons;
  private String           varcons;
  private Date             dconsd;
  private String           contspe;
  private Date             dproat;
  private String           nprotcoorba;
  private Date             dprotcoorba;

  /**
   * @return the id
   */
  public GarecontIdentity getId() {
    return id;
  }

  /**
   * @param id
   *        the id to set
   */
  public void setId(GarecontIdentity id) {
    this.id = id;
  }

  /**
   * @return the codimp
   */
  public String getCodimp() {
    return codimp;
  }

  /**
   * @param codimp
   *        the codimp to set
   */
  public void setCodimp(String codimp) {
    this.codimp = codimp;
  }

  /**
   * @return the incorso
   */
  public String getIncorso() {
    return incorso;
  }

  /**
   * @param incorso
   *        the incorso to set
   */
  public void setIncorso(String incorso) {
    this.incorso = incorso;
  }

  /**
   * @return the dverbc
   */
  public Date getDverbc() {
    return dverbc;
  }

  /**
   * @param dverbc
   *        the dverbc to set
   */
  public void setDverbc(Date dverbc) {
    this.dverbc = dverbc;
  }

  /**
   * @return the consant
   */
  public String getConsant() {
    return consant;
  }

  /**
   * @param consant
   *        the consant to set
   */
  public void setConsant(String consant) {
    this.consant = consant;
  }

  /**
   * @return the motant
   */
  public String getMotant() {
    return motant;
  }

  /**
   * @param motant
   *        the motant to set
   */
  public void setMotant(String motant) {
    this.motant = motant;
  }

  /**
   * @return the davves
   */
  public Date getDavves() {
    return davves;
  }

  /**
   * @param davves
   *        the davves to set
   */
  public void setDavves(Date davves) {
    this.davves = davves;
  }

  /**
   * @return the ngiorit
   */
  public Integer getNgiorit() {
    return ngiorit;
  }

  /**
   * @param ngiorit
   *        the ngiorit to set
   */
  public void setNgiorit(Integer ngiorit) {
    this.ngiorit = ngiorit;
  }

  /**
   * @return the modpag
   */
  public String getModpag() {
    return modpag;
  }

  /**
   * @param modpag
   *        the modpag to set
   */
  public void setModpag(String modpag) {
    this.modpag = modpag;
  }

  /**
   * @return the lavsub
   */
  public String getLavsub() {
    return lavsub;
  }

  /**
   * @param lavsub
   *        the lavsub to set
   */
  public void setLavsub(String lavsub) {
    this.lavsub = lavsub;
  }

  /**
   * @return the percav
   */
  public BigDecimal getPercav() {
    return percav;
  }

  /**
   * @param percav
   *        the percav to set
   */
  public void setPercav(BigDecimal percav) {
    this.percav = percav;
  }

  /**
   * @return the dteres
   */
  public Date getDteres() {
    return dteres;
  }

  /**
   * @param dteres
   *        the dteres to set
   */
  public void setDteres(Date dteres) {
    this.dteres = dteres;
  }

  /**
   * @return the dcertu
   */
  public Date getDcertu() {
    return dcertu;
  }

  /**
   * @param dcertu
   *        the dcertu to set
   */
  public void setDcertu(Date dcertu) {
    this.dcertu = dcertu;
  }

  /**
   * @return the impliq
   */
  public BigDecimal getImpliq() {
    return impliq;
  }

  /**
   * @param impliq
   *        the impliq to set
   */
  public void setImpliq(BigDecimal impliq) {
    this.impliq = impliq;
  }

  /**
   * @return the isnconf
   */
  public String getIsnconf() {
    return isnconf;
  }

  /**
   * @param isnconf
   *        the isnconf to set
   */
  public void setIsnconf(String isnconf) {
    this.isnconf = isnconf;
  }

  /**
   * @return the desnconf
   */
  public String getDesnconf() {
    return desnconf;
  }

  /**
   * @param desnconf
   *        the desnconf to set
   */
  public void setDesnconf(String desnconf) {
    this.desnconf = desnconf;
  }

  /**
   * @return the note
   */
  public String getNote() {
    return note;
  }

  /**
   * @param note
   *        the note to set
   */
  public void setNote(String note) {
    this.note = note;
  }

  /**
   * @return the nmespro
   */
  public Integer getNmespro() {
    return nmespro;
  }

  /**
   * @param nmespro
   *        the nmespro to set
   */
  public void setNmespro(Integer nmespro) {
    this.nmespro = nmespro;
  }

  /**
   * @return the coorba
   */
  public String getCoorba() {
    return coorba;
  }

  /**
   * @param coorba
   *        the coorba to set
   */
  public void setCoorba(String coorba) {
    this.coorba = coorba;
  }

  /**
   * @return the stato
   */
  public Integer getStato() {
    return stato;
  }

  /**
   * @param stato
   *        the stato to set
   */
  public void setStato(Integer stato) {
    this.stato = stato;
  }

  /**
   * @return the impiva
   */
  public BigDecimal getImpiva() {
    return impiva;
  }

  /**
   * @param impiva
   *        the impiva to set
   */
  public void setImpiva(BigDecimal impiva) {
    this.impiva = impiva;
  }

  /**
   * @return the imptot
   */
  public BigDecimal getImptot() {
    return imptot;
  }

  /**
   * @param imptot
   *        the imptot to set
   */
  public void setImptot(BigDecimal imptot) {
    this.imptot = imptot;
  }

  /**
   * @return the datdef
   */
  public Date getDatdef() {
    return datdef;
  }

  /**
   * @param datdef
   *        the datdef to set
   */
  public void setDatdef(Date datdef) {
    this.datdef = datdef;
  }

  /**
   * @return the dattra
   */
  public Date getDattra() {
    return dattra;
  }

  /**
   * @param dattra
   *        the dattra to set
   */
  public void setDattra(Date dattra) {
    this.dattra = dattra;
  }

  /**
   * @return the datlet
   */
  public Date getDatlet() {
    return datlet;
  }

  /**
   * @param datlet
   *        the datlet to set
   */
  public void setDatlet(Date datlet) {
    this.datlet = datlet;
  }

  /**
   * @return the datrev
   */
  public Date getDatrev() {
    return datrev;
  }

  /**
   * @param datrev
   *        the datrev to set
   */
  public void setDatrev(Date datrev) {
    this.datrev = datrev;
  }

  /**
   * @return the motrev
   */
  public String getMotrev() {
    return motrev;
  }

  /**
   * @param motrev
   *        the motrev to set
   */
  public void setMotrev(String motrev) {
    this.motrev = motrev;
  }

  /**
   * @return the datrif
   */
  public Date getDatrif() {
    return datrif;
  }

  /**
   * @param datrif
   *        the datrif to set
   */
  public void setDatrif(Date datrif) {
    this.datrif = datrif;
  }

  /**
   * @return the pcoese
   */
  public Integer getPcoese() {
    return pcoese;
  }

  /**
   * @param pcoese
   *        the pcoese to set
   */
  public void setPcoese(Integer pcoese) {
    this.pcoese = pcoese;
  }

  /**
   * @return the pcofat
   */
  public Integer getPcofat() {
    return pcofat;
  }

  /**
   * @param pcofat
   *        the pcofat to set
   */
  public void setPcofat(Integer pcofat) {
    this.pcofat = pcofat;
  }

  /**
   * @return the nproat
   */
  public String getNproat() {
    return nproat;
  }

  /**
   * @param nproat
   *        the nproat to set
   */
  public void setNproat(String nproat) {
    this.nproat = nproat;
  }

  /**
   * @return the idprg
   */
  public String getIdprg() {
    return idprg;
  }

  /**
   * @param idprg
   *        the idprg to set
   */
  public void setIdprg(String idprg) {
    this.idprg = idprg;
  }

  /**
   * @return the iddocdg
   */
  public Long getIddocdg() {
    return iddocdg;
  }

  /**
   * @param iddocdg
   *        the iddocdg to set
   */
  public void setIddocdg(Long iddocdg) {
    this.iddocdg = iddocdg;
  }

  /**
   * @return the cenint
   */
  public String getCenint() {
    return cenint;
  }

  /**
   * @param cenint
   *        the cenint to set
   */
  public void setCenint(String cenint) {
    this.cenint = cenint;
  }

  /**
   * @return the locese
   */
  public String getLocese() {
    return locese;
  }

  /**
   * @param locese
   *        the locese to set
   */
  public void setLocese(String locese) {
    this.locese = locese;
  }

  /**
   * @return the locfat
   */
  public String getLocfat() {
    return locfat;
  }

  /**
   * @param locfat
   *        the locfat to set
   */
  public void setLocfat(String locfat) {
    this.locfat = locfat;
  }

  /**
   * @return the dscapo
   */
  public Date getDscapo() {
    return dscapo;
  }

  /**
   * @param dscapo
   *        the dscapo to set
   */
  public void setDscapo(Date dscapo) {
    this.dscapo = dscapo;
  }

  /**
   * @return the npropo
   */
  public String getNpropo() {
    return npropo;
  }

  /**
   * @param npropo
   *        the npropo to set
   */
  public void setNpropo(String npropo) {
    this.npropo = npropo;
  }

  /**
   * @return the dsvipo
   */
  public Date getDsvipo() {
    return dsvipo;
  }

  /**
   * @param dsvipo
   *        the dsvipo to set
   */
  public void setDsvipo(Date dsvipo) {
    this.dsvipo = dsvipo;
  }

  /**
   * @return the nsvipo
   */
  public String getNsvipo() {
    return nsvipo;
  }

  /**
   * @param nsvipo
   *        the nsvipo to set
   */
  public void setNsvipo(String nsvipo) {
    this.nsvipo = nsvipo;
  }

  /**
   * @return the datres
   */
  public Date getDatres() {
    return datres;
  }

  /**
   * @param datres
   *        the datres to set
   */
  public void setDatres(Date datres) {
    this.datres = datres;
  }

  /**
   * @return the impqua
   */
  public BigDecimal getImpqua() {
    return impqua;
  }

  /**
   * @param impqua
   *        the impqua to set
   */
  public void setImpqua(BigDecimal impqua) {
    this.impqua = impqua;
  }

  /**
   * @return the pubtrasp
   */
  public String getPubtrasp() {
    return pubtrasp;
  }

  /**
   * @param pubtrasp
   *        the pubtrasp to set
   */
  public void setPubtrasp(String pubtrasp) {
    this.pubtrasp = pubtrasp;
  }

  /**
   * @return the lregco
   */
  public String getLregco() {
    return lregco;
  }

  /**
   * @param lregco
   *        the lregco to set
   */
  public void setLregco(String lregco) {
    this.lregco = lregco;
  }

  /**
   * @return the nregco
   */
  public String getNregco() {
    return nregco;
  }

  /**
   * @param nregco
   *        the nregco to set
   */
  public void setNregco(String nregco) {
    this.nregco = nregco;
  }

  /**
   * @return the dregco
   */
  public Date getDregco() {
    return dregco;
  }

  /**
   * @param dregco
   *        the dregco to set
   */
  public void setDregco(Date dregco) {
    this.dregco = dregco;
  }

  /**
   * @return the ngaral
   */
  public String getNgaral() {
    return ngaral;
  }

  /**
   * @param ngaral
   *        the ngaral to set
   */
  public void setNgaral(String ngaral) {
    this.ngaral = ngaral;
  }

  /**
   * @return the banapp
   */
  public String getBanapp() {
    return banapp;
  }

  /**
   * @param banapp
   *        the banapp to set
   */
  public void setBanapp(String banapp) {
    this.banapp = banapp;
  }

  /**
   * @return the numcont
   */
  public String getNumcont() {
    return numcont;
  }

  /**
   * @param numcont
   *        the numcont to set
   */
  public void setNumcont(String numcont) {
    this.numcont = numcont;
  }

  /**
   * @return the codbic
   */
  public String getCodbic() {
    return codbic;
  }

  /**
   * @param codbic
   *        the codbic to set
   */
  public void setCodbic(String codbic) {
    this.codbic = codbic;
  }

  /**
   * @return the esecscig
   */
  public String getEsecscig() {
    return esecscig;
  }

  /**
   * @param esecscig
   *        the esecscig to set
   */
  public void setEsecscig(String esecscig) {
    this.esecscig = esecscig;
  }

  /**
   * @return the ragcons
   */
  public String getRagcons() {
    return ragcons;
  }

  /**
   * @param ragcons
   *        the ragcons to set
   */
  public void setRagcons(String ragcons) {
    this.ragcons = ragcons;
  }

  /**
   * @return the varcons
   */
  public String getVarcons() {
    return varcons;
  }

  /**
   * @param varcons
   *        the varcons to set
   */
  public void setVarcons(String varcons) {
    this.varcons = varcons;
  }

  /**
   * @return the dconsd
   */
  public Date getDconsd() {
    return dconsd;
  }

  /**
   * @param dconsd
   *        the dconsd to set
   */
  public void setDconsd(Date dconsd) {
    this.dconsd = dconsd;
  }

  /**
   * @return the contspe
   */
  public String getContspe() {
    return contspe;
  }

  /**
   * @param contspe
   *        the contspe to set
   */
  public void setContspe(String contspe) {
    this.contspe = contspe;
  }

  /**
   * @return the dproat
   */
  public Date getDproat() {
    return dproat;
  }

  /**
   * @param dproat
   *        the dproat to set
   */
  public void setDproat(Date dproat) {
    this.dproat = dproat;
  }

  /**
   * @return the nprotcoorba
   */
  public String getNprotcoorba() {
    return nprotcoorba;
  }

  /**
   * @param nprotcoorba
   *        the nprotcoorba to set
   */
  public void setNprotcoorba(String nprotcoorba) {
    this.nprotcoorba = nprotcoorba;
  }

  /**
   * @return the dprotcoorba
   */
  public Date getDprotcoorba() {
    return dprotcoorba;
  }

  /**
   * @param dprotcoorba
   *        the dprotcoorba to set
   */
  public void setDprotcoorba(Date dprotcoorba) {
    this.dprotcoorba = dprotcoorba;
  }

}
