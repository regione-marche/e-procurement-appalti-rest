package it.maggioli.appalti.rest.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la tabella <code>gene.impr</code>
 * 
 * @author gabriele.nencini
 *
 */
@Entity
@DynamicUpdate
@Table(name="impr")
public class Impr {
  @Id
  private String codimp;
  private String nomimp;
  private String nomest;
  private Integer gfiimp;
  private String vinimp;
  private String indimp;
  private String nciimp;
  private String locimp;
  private String proimp;
  private String capimp;
  private String telimp;
  private String faximp;
  private String cfimp;
  private String pivimp;
  private String dofimp;
  private Date discif;
  private String nisanc;
  private Date disanc;
  private Date dtrisoa;
  private Date dversoa;
  private String ncciaa;
  private Date dcciaa;
  private String banapp;
  private String setatt;
  private String codatt;
  private BigDecimal capsoc;
  private String codcas;
  private BigDecimal volaff;
  private String cgenimp;
  private Date dgenimp;
  private String annoti;
  private String criimp;
  private Integer natgiui;
  private String regdit;
  private String pcciaa;
  private Integer nazimp;
  private String emaiip;
  private String codcit;
  private Integer tipimp;
  private Integer tiprti;
  private String telcel;
  private String mgsflg;
  private Date dscanc;
  private Date duranc;
  private String abilpr;
  private Date dabpre;
  private String iscnos;
  private Integer graabi;
  private Date disnos;
  private Date dscnos;
  private String rinnos;
  private Date drinos;
  private Date dantim;
  private String interd;
  private String zoneat;
  private String ncercc;
  private Date dcercc;
  private String coorba;
  private String codbic;
  private String ninps;
  private Date dinps;
  private String ninail;
  private Date dinail;
  private String ncedil;
  private Date dcedil;
  private String linps;
  private String linail;
  private String lcedil;
  private Integer octsoa;
  private String numiso;
  private Date datiso;
  private Integer octiso;
  private String indweb;
  private Date datmod;
  private String emailpec;
  private String daestern;
  private String emai2ip;
  private String sogmov;
  private Integer inctec;
  private Integer tipalb;
  private String albtec;
  private Date datalb;
  private String proalb;
  private Integer tcapre;
  private String ncapre;
  private String cnatec;
  private Date dnatec;
  private String pronas;
  private String sextec;
  private Date dinvreg;
  private Date delareg;
  private String oggsoc;
  private String soggdurc;
  private Integer settprod;
  private String posinail;
  private String posinps;
  private String codcedil;
  private String acertatt;
  private String aistprev;
  private String assobbl;
  private String ismpmi;
  private String iscrcciaa;
  private Integer cladim;
  private String iscriwl;
  private String wlprefe;
  private String wlsezio;
  private Date wldiscri;
  private Date wldscad;
  private String wlincorso;
  @Column(name = "art80_stato")
  private Integer art80stato;
  @Column(name = "art80_data_richiesta")
  private Date art80datarichiesta;
  @Column(name = "art80_data_lettura")
  private Date art80datalettura;
  private String cognome;
  private String nome;
//  @Column(name = "art80_uff_codein")
//  private String art80uffcodein;
  private String iscriae;
  private Date aedscad;
  private String aeincorso;
  private String iscriesp;
  private String iscrirat;
  private Integer rating;
  private Date ratdscad;
  private String ratincorso;
  @Column(name = "endpoint_nso")
  private String endpointnso;
  private String ultdic;
  private String sociounico;
  private Integer regfisc;
  private Date dintsoa;
  
  @OneToMany(fetch = FetchType.LAZY,mappedBy = "id.codime9")
  private List<Ragimp> raggruppamento;
  
  public Impr() {
  }
  
  public Impr(String codimp, String emai2ip, String emaiip) {
	  this.codimp  =codimp;
	  this.emai2ip=emai2ip;
	  this.emaiip=emaiip;
  }
  /**
   * @return the codimp
   */
  public String getCodimp() {
    return codimp;
  }
  
  /**
   * @param codimp the codimp to set
   */
  public void setCodimp(String codimp) {
    this.codimp = codimp;
  }
  
  /**
   * @return the nomimp
   */
  public String getNomimp() {
    return nomimp;
  }
  
  /**
   * @param nomimp the nomimp to set
   */
  public void setNomimp(String nomimp) {
    this.nomimp = nomimp;
  }
  
  /**
   * @return the nomest
   */
  public String getNomest() {
    return nomest;
  }
  
  /**
   * @param nomest the nomest to set
   */
  public void setNomest(String nomest) {
    this.nomest = nomest;
  }
  
  /**
   * @return the gfiimp
   */
  public Integer getGfiimp() {
    return gfiimp;
  }
  
  /**
   * @param gfiimp the gfiimp to set
   */
  public void setGfiimp(Integer gfiimp) {
    this.gfiimp = gfiimp;
  }
  
  /**
   * @return the vinimp
   */
  public String getVinimp() {
    return vinimp;
  }
  
  /**
   * @param vinimp the vinimp to set
   */
  public void setVinimp(String vinimp) {
    this.vinimp = vinimp;
  }
  
  /**
   * @return the indimp
   */
  public String getIndimp() {
    return indimp;
  }
  
  /**
   * @param indimp the indimp to set
   */
  public void setIndimp(String indimp) {
    this.indimp = indimp;
  }
  
  /**
   * @return the nciimp
   */
  public String getNciimp() {
    return nciimp;
  }
  
  /**
   * @param nciimp the nciimp to set
   */
  public void setNciimp(String nciimp) {
    this.nciimp = nciimp;
  }
  
  /**
   * @return the locimp
   */
  public String getLocimp() {
    return locimp;
  }
  
  /**
   * @param locimp the locimp to set
   */
  public void setLocimp(String locimp) {
    this.locimp = locimp;
  }
  
  /**
   * @return the proimp
   */
  public String getProimp() {
    return proimp;
  }
  
  /**
   * @param proimp the proimp to set
   */
  public void setProimp(String proimp) {
    this.proimp = proimp;
  }
  
  /**
   * @return the capimp
   */
  public String getCapimp() {
    return capimp;
  }
  
  /**
   * @param capimp the capimp to set
   */
  public void setCapimp(String capimp) {
    this.capimp = capimp;
  }
  
  /**
   * @return the telimp
   */
  public String getTelimp() {
    return telimp;
  }
  
  /**
   * @param telimp the telimp to set
   */
  public void setTelimp(String telimp) {
    this.telimp = telimp;
  }
  
  /**
   * @return the faximp
   */
  public String getFaximp() {
    return faximp;
  }
  
  /**
   * @param faximp the faximp to set
   */
  public void setFaximp(String faximp) {
    this.faximp = faximp;
  }
  
  /**
   * @return the cfimp
   */
  public String getCfimp() {
    return cfimp;
  }
  
  /**
   * @param cfimp the cfimp to set
   */
  public void setCfimp(String cfimp) {
    this.cfimp = cfimp;
  }
  
  /**
   * @return the pivimp
   */
  public String getPivimp() {
    return pivimp;
  }
  
  /**
   * @param pivimp the pivimp to set
   */
  public void setPivimp(String pivimp) {
    this.pivimp = pivimp;
  }
  
  /**
   * @return the dofimp
   */
  public String getDofimp() {
    return dofimp;
  }
  
  /**
   * @param dofimp the dofimp to set
   */
  public void setDofimp(String dofimp) {
    this.dofimp = dofimp;
  }
  
  /**
   * @return the discif
   */
  public Date getDiscif() {
    return discif;
  }
  
  /**
   * @param discif the discif to set
   */
  public void setDiscif(Date discif) {
    this.discif = discif;
  }
  
  /**
   * @return the nisanc
   */
  public String getNisanc() {
    return nisanc;
  }
  
  /**
   * @param nisanc the nisanc to set
   */
  public void setNisanc(String nisanc) {
    this.nisanc = nisanc;
  }
  
  /**
   * @return the disanc
   */
  public Date getDisanc() {
    return disanc;
  }
  
  /**
   * @param disanc the disanc to set
   */
  public void setDisanc(Date disanc) {
    this.disanc = disanc;
  }
  
  /**
   * @return the dtrisoa
   */
  public Date getDtrisoa() {
    return dtrisoa;
  }
  
  /**
   * @param dtrisoa the dtrisoa to set
   */
  public void setDtrisoa(Date dtrisoa) {
    this.dtrisoa = dtrisoa;
  }
  
  /**
   * @return the dversoa
   */
  public Date getDversoa() {
    return dversoa;
  }
  
  /**
   * @param dversoa the dversoa to set
   */
  public void setDversoa(Date dversoa) {
    this.dversoa = dversoa;
  }
  
  /**
   * @return the ncciaa
   */
  public String getNcciaa() {
    return ncciaa;
  }
  
  /**
   * @param ncciaa the ncciaa to set
   */
  public void setNcciaa(String ncciaa) {
    this.ncciaa = ncciaa;
  }
  
  /**
   * @return the dcciaa
   */
  public Date getDcciaa() {
    return dcciaa;
  }
  
  /**
   * @param dcciaa the dcciaa to set
   */
  public void setDcciaa(Date dcciaa) {
    this.dcciaa = dcciaa;
  }
  
  /**
   * @return the banapp
   */
  public String getBanapp() {
    return banapp;
  }
  
  /**
   * @param banapp the banapp to set
   */
  public void setBanapp(String banapp) {
    this.banapp = banapp;
  }
  
  /**
   * @return the setatt
   */
  public String getSetatt() {
    return setatt;
  }
  
  /**
   * @param setatt the setatt to set
   */
  public void setSetatt(String setatt) {
    this.setatt = setatt;
  }
  
  /**
   * @return the codatt
   */
  public String getCodatt() {
    return codatt;
  }
  
  /**
   * @param codatt the codatt to set
   */
  public void setCodatt(String codatt) {
    this.codatt = codatt;
  }
  
  /**
   * @return the capsoc
   */
  public BigDecimal getCapsoc() {
    return capsoc;
  }
  
  /**
   * @param capsoc the capsoc to set
   */
  public void setCapsoc(BigDecimal capsoc) {
    this.capsoc = capsoc;
  }
  
  /**
   * @return the codcas
   */
  public String getCodcas() {
    return codcas;
  }
  
  /**
   * @param codcas the codcas to set
   */
  public void setCodcas(String codcas) {
    this.codcas = codcas;
  }
  
  /**
   * @return the volaff
   */
  public BigDecimal getVolaff() {
    return volaff;
  }
  
  /**
   * @param volaff the volaff to set
   */
  public void setVolaff(BigDecimal volaff) {
    this.volaff = volaff;
  }
  
  /**
   * @return the cgenimp
   */
  public String getCgenimp() {
    return cgenimp;
  }
  
  /**
   * @param cgenimp the cgenimp to set
   */
  public void setCgenimp(String cgenimp) {
    this.cgenimp = cgenimp;
  }
  
  /**
   * @return the dgenimp
   */
  public Date getDgenimp() {
    return dgenimp;
  }
  
  /**
   * @param dgenimp the dgenimp to set
   */
  public void setDgenimp(Date dgenimp) {
    this.dgenimp = dgenimp;
  }
  
  /**
   * @return the annoti
   */
  public String getAnnoti() {
    return annoti;
  }
  
  /**
   * @param annoti the annoti to set
   */
  public void setAnnoti(String annoti) {
    this.annoti = annoti;
  }
  
  /**
   * @return the criimp
   */
  public String getCriimp() {
    return criimp;
  }
  
  /**
   * @param criimp the criimp to set
   */
  public void setCriimp(String criimp) {
    this.criimp = criimp;
  }
  
  /**
   * @return the natgiui
   */
  public Integer getNatgiui() {
    return natgiui;
  }
  
  /**
   * @param natgiui the natgiui to set
   */
  public void setNatgiui(Integer natgiui) {
    this.natgiui = natgiui;
  }
  
  /**
   * @return the regdit
   */
  public String getRegdit() {
    return regdit;
  }
  
  /**
   * @param regdit the regdit to set
   */
  public void setRegdit(String regdit) {
    this.regdit = regdit;
  }
  
  /**
   * @return the pcciaa
   */
  public String getPcciaa() {
    return pcciaa;
  }
  
  /**
   * @param pcciaa the pcciaa to set
   */
  public void setPcciaa(String pcciaa) {
    this.pcciaa = pcciaa;
  }
  
  /**
   * @return the nazimp
   */
  public Integer getNazimp() {
    return nazimp;
  }
  
  /**
   * @param nazimp the nazimp to set
   */
  public void setNazimp(Integer nazimp) {
    this.nazimp = nazimp;
  }
  
  /**
   * @return the emaiip
   */
  public String getEmaiip() {
    return emaiip;
  }
  
  /**
   * @param emaiip the emaiip to set
   */
  public void setEmaiip(String emaiip) {
    this.emaiip = emaiip;
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
   * @return the tipimp
   */
  public Integer getTipimp() {
    return tipimp;
  }
  
  /**
   * @param tipimp the tipimp to set
   */
  public void setTipimp(Integer tipimp) {
    this.tipimp = tipimp;
  }
  
  /**
   * @return the tiprti
   */
  public Integer getTiprti() {
    return tiprti;
  }
  
  /**
   * @param tiprti the tiprti to set
   */
  public void setTiprti(Integer tiprti) {
    this.tiprti = tiprti;
  }
  
  /**
   * @return the telcel
   */
  public String getTelcel() {
    return telcel;
  }
  
  /**
   * @param telcel the telcel to set
   */
  public void setTelcel(String telcel) {
    this.telcel = telcel;
  }
  
  /**
   * @return the mgsflg
   */
  public String getMgsflg() {
    return mgsflg;
  }
  
  /**
   * @param mgsflg the mgsflg to set
   */
  public void setMgsflg(String mgsflg) {
    this.mgsflg = mgsflg;
  }
  
  /**
   * @return the dscanc
   */
  public Date getDscanc() {
    return dscanc;
  }
  
  /**
   * @param dscanc the dscanc to set
   */
  public void setDscanc(Date dscanc) {
    this.dscanc = dscanc;
  }
  
  /**
   * @return the duranc
   */
  public Date getDuranc() {
    return duranc;
  }
  
  /**
   * @param duranc the duranc to set
   */
  public void setDuranc(Date duranc) {
    this.duranc = duranc;
  }
  
  /**
   * @return the abilpr
   */
  public String getAbilpr() {
    return abilpr;
  }
  
  /**
   * @param abilpr the abilpr to set
   */
  public void setAbilpr(String abilpr) {
    this.abilpr = abilpr;
  }
  
  /**
   * @return the dabpre
   */
  public Date getDabpre() {
    return dabpre;
  }
  
  /**
   * @param dabpre the dabpre to set
   */
  public void setDabpre(Date dabpre) {
    this.dabpre = dabpre;
  }
  
  /**
   * @return the iscnos
   */
  public String getIscnos() {
    return iscnos;
  }
  
  /**
   * @param iscnos the iscnos to set
   */
  public void setIscnos(String iscnos) {
    this.iscnos = iscnos;
  }
  
  /**
   * @return the graabi
   */
  public Integer getGraabi() {
    return graabi;
  }
  
  /**
   * @param graabi the graabi to set
   */
  public void setGraabi(Integer graabi) {
    this.graabi = graabi;
  }
  
  /**
   * @return the disnos
   */
  public Date getDisnos() {
    return disnos;
  }
  
  /**
   * @param disnos the disnos to set
   */
  public void setDisnos(Date disnos) {
    this.disnos = disnos;
  }
  
  /**
   * @return the dscnos
   */
  public Date getDscnos() {
    return dscnos;
  }
  
  /**
   * @param dscnos the dscnos to set
   */
  public void setDscnos(Date dscnos) {
    this.dscnos = dscnos;
  }
  
  /**
   * @return the rinnos
   */
  public String getRinnos() {
    return rinnos;
  }
  
  /**
   * @param rinnos the rinnos to set
   */
  public void setRinnos(String rinnos) {
    this.rinnos = rinnos;
  }
  
  /**
   * @return the drinos
   */
  public Date getDrinos() {
    return drinos;
  }
  
  /**
   * @param drinos the drinos to set
   */
  public void setDrinos(Date drinos) {
    this.drinos = drinos;
  }
  
  /**
   * @return the dantim
   */
  public Date getDantim() {
    return dantim;
  }
  
  /**
   * @param dantim the dantim to set
   */
  public void setDantim(Date dantim) {
    this.dantim = dantim;
  }
  
  /**
   * @return the interd
   */
  public String getInterd() {
    return interd;
  }
  
  /**
   * @param interd the interd to set
   */
  public void setInterd(String interd) {
    this.interd = interd;
  }
  
  /**
   * @return the zoneat
   */
  public String getZoneat() {
    return zoneat;
  }
  
  /**
   * @param zoneat the zoneat to set
   */
  public void setZoneat(String zoneat) {
    this.zoneat = zoneat;
  }
  
  /**
   * @return the ncercc
   */
  public String getNcercc() {
    return ncercc;
  }
  
  /**
   * @param ncercc the ncercc to set
   */
  public void setNcercc(String ncercc) {
    this.ncercc = ncercc;
  }
  
  /**
   * @return the dcercc
   */
  public Date getDcercc() {
    return dcercc;
  }
  
  /**
   * @param dcercc the dcercc to set
   */
  public void setDcercc(Date dcercc) {
    this.dcercc = dcercc;
  }
  
  /**
   * @return the coorba
   */
  public String getCoorba() {
    return coorba;
  }
  
  /**
   * @param coorba the coorba to set
   */
  public void setCoorba(String coorba) {
    this.coorba = coorba;
  }
  
  /**
   * @return the codbic
   */
  public String getCodbic() {
    return codbic;
  }
  
  /**
   * @param codbic the codbic to set
   */
  public void setCodbic(String codbic) {
    this.codbic = codbic;
  }
  
  /**
   * @return the ninps
   */
  public String getNinps() {
    return ninps;
  }
  
  /**
   * @param ninps the ninps to set
   */
  public void setNinps(String ninps) {
    this.ninps = ninps;
  }
  
  /**
   * @return the dinps
   */
  public Date getDinps() {
    return dinps;
  }
  
  /**
   * @param dinps the dinps to set
   */
  public void setDinps(Date dinps) {
    this.dinps = dinps;
  }
  
  /**
   * @return the ninail
   */
  public String getNinail() {
    return ninail;
  }
  
  /**
   * @param ninail the ninail to set
   */
  public void setNinail(String ninail) {
    this.ninail = ninail;
  }
  
  /**
   * @return the dinail
   */
  public Date getDinail() {
    return dinail;
  }
  
  /**
   * @param dinail the dinail to set
   */
  public void setDinail(Date dinail) {
    this.dinail = dinail;
  }
  
  /**
   * @return the ncedil
   */
  public String getNcedil() {
    return ncedil;
  }
  
  /**
   * @param ncedil the ncedil to set
   */
  public void setNcedil(String ncedil) {
    this.ncedil = ncedil;
  }
  
  /**
   * @return the dcedil
   */
  public Date getDcedil() {
    return dcedil;
  }
  
  /**
   * @param dcedil the dcedil to set
   */
  public void setDcedil(Date dcedil) {
    this.dcedil = dcedil;
  }
  
  /**
   * @return the linps
   */
  public String getLinps() {
    return linps;
  }
  
  /**
   * @param linps the linps to set
   */
  public void setLinps(String linps) {
    this.linps = linps;
  }
  
  /**
   * @return the linail
   */
  public String getLinail() {
    return linail;
  }
  
  /**
   * @param linail the linail to set
   */
  public void setLinail(String linail) {
    this.linail = linail;
  }
  
  /**
   * @return the lcedil
   */
  public String getLcedil() {
    return lcedil;
  }
  
  /**
   * @param lcedil the lcedil to set
   */
  public void setLcedil(String lcedil) {
    this.lcedil = lcedil;
  }
  
  /**
   * @return the octsoa
   */
  public Integer getOctsoa() {
    return octsoa;
  }
  
  /**
   * @param octsoa the octsoa to set
   */
  public void setOctsoa(Integer octsoa) {
    this.octsoa = octsoa;
  }
  
  /**
   * @return the numiso
   */
  public String getNumiso() {
    return numiso;
  }
  
  /**
   * @param numiso the numiso to set
   */
  public void setNumiso(String numiso) {
    this.numiso = numiso;
  }
  
  /**
   * @return the datiso
   */
  public Date getDatiso() {
    return datiso;
  }
  
  /**
   * @param datiso the datiso to set
   */
  public void setDatiso(Date datiso) {
    this.datiso = datiso;
  }
  
  /**
   * @return the octiso
   */
  public Integer getOctiso() {
    return octiso;
  }
  
  /**
   * @param octiso the octiso to set
   */
  public void setOctiso(Integer octiso) {
    this.octiso = octiso;
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
   * @return the datmod
   */
  public Date getDatmod() {
    return datmod;
  }
  
  /**
   * @param datmod the datmod to set
   */
  public void setDatmod(Date datmod) {
    this.datmod = datmod;
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
   * @return the daestern
   */
  public String getDaestern() {
    return daestern;
  }
  
  /**
   * @param daestern the daestern to set
   */
  public void setDaestern(String daestern) {
    this.daestern = daestern;
  }
  
  /**
   * @return the emai2ip
   */
  public String getEmai2ip() {
    return emai2ip;
  }
  
  /**
   * @param emai2ip the emai2ip to set
   */
  public void setEmai2ip(String emai2ip) {
    this.emai2ip = emai2ip;
  }
  
  /**
   * @return the sogmov
   */
  public String getSogmov() {
    return sogmov;
  }
  
  /**
   * @param sogmov the sogmov to set
   */
  public void setSogmov(String sogmov) {
    this.sogmov = sogmov;
  }
  
  /**
   * @return the inctec
   */
  public Integer getInctec() {
    return inctec;
  }
  
  /**
   * @param inctec the inctec to set
   */
  public void setInctec(Integer inctec) {
    this.inctec = inctec;
  }
  
  /**
   * @return the tipalb
   */
  public Integer getTipalb() {
    return tipalb;
  }
  
  /**
   * @param tipalb the tipalb to set
   */
  public void setTipalb(Integer tipalb) {
    this.tipalb = tipalb;
  }
  
  /**
   * @return the albtec
   */
  public String getAlbtec() {
    return albtec;
  }
  
  /**
   * @param albtec the albtec to set
   */
  public void setAlbtec(String albtec) {
    this.albtec = albtec;
  }
  
  /**
   * @return the datalb
   */
  public Date getDatalb() {
    return datalb;
  }
  
  /**
   * @param datalb the datalb to set
   */
  public void setDatalb(Date datalb) {
    this.datalb = datalb;
  }
  
  /**
   * @return the proalb
   */
  public String getProalb() {
    return proalb;
  }
  
  /**
   * @param proalb the proalb to set
   */
  public void setProalb(String proalb) {
    this.proalb = proalb;
  }
  
  /**
   * @return the tcapre
   */
  public Integer getTcapre() {
    return tcapre;
  }
  
  /**
   * @param tcapre the tcapre to set
   */
  public void setTcapre(Integer tcapre) {
    this.tcapre = tcapre;
  }
  
  /**
   * @return the ncapre
   */
  public String getNcapre() {
    return ncapre;
  }
  
  /**
   * @param ncapre the ncapre to set
   */
  public void setNcapre(String ncapre) {
    this.ncapre = ncapre;
  }
  
  /**
   * @return the cnatec
   */
  public String getCnatec() {
    return cnatec;
  }
  
  /**
   * @param cnatec the cnatec to set
   */
  public void setCnatec(String cnatec) {
    this.cnatec = cnatec;
  }
  
  /**
   * @return the dnatec
   */
  public Date getDnatec() {
    return dnatec;
  }
  
  /**
   * @param dnatec the dnatec to set
   */
  public void setDnatec(Date dnatec) {
    this.dnatec = dnatec;
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
   * @return the sextec
   */
  public String getSextec() {
    return sextec;
  }
  
  /**
   * @param sextec the sextec to set
   */
  public void setSextec(String sextec) {
    this.sextec = sextec;
  }
  
  /**
   * @return the dinvreg
   */
  public Date getDinvreg() {
    return dinvreg;
  }
  
  /**
   * @param dinvreg the dinvreg to set
   */
  public void setDinvreg(Date dinvreg) {
    this.dinvreg = dinvreg;
  }
  
  /**
   * @return the delareg
   */
  public Date getDelareg() {
    return delareg;
  }
  
  /**
   * @param delareg the delareg to set
   */
  public void setDelareg(Date delareg) {
    this.delareg = delareg;
  }
  
  /**
   * @return the oggsoc
   */
  public String getOggsoc() {
    return oggsoc;
  }
  
  /**
   * @param oggsoc the oggsoc to set
   */
  public void setOggsoc(String oggsoc) {
    this.oggsoc = oggsoc;
  }
  
  /**
   * @return the soggdurc
   */
  public String getSoggdurc() {
    return soggdurc;
  }
  
  /**
   * @param soggdurc the soggdurc to set
   */
  public void setSoggdurc(String soggdurc) {
    this.soggdurc = soggdurc;
  }
  
  /**
   * @return the settprod
   */
  public Integer getSettprod() {
    return settprod;
  }
  
  /**
   * @param settprod the settprod to set
   */
  public void setSettprod(Integer settprod) {
    this.settprod = settprod;
  }
  
  /**
   * @return the posinail
   */
  public String getPosinail() {
    return posinail;
  }
  
  /**
   * @param posinail the posinail to set
   */
  public void setPosinail(String posinail) {
    this.posinail = posinail;
  }
  
  /**
   * @return the posinps
   */
  public String getPosinps() {
    return posinps;
  }
  
  /**
   * @param posinps the posinps to set
   */
  public void setPosinps(String posinps) {
    this.posinps = posinps;
  }
  
  /**
   * @return the codcedil
   */
  public String getCodcedil() {
    return codcedil;
  }
  
  /**
   * @param codcedil the codcedil to set
   */
  public void setCodcedil(String codcedil) {
    this.codcedil = codcedil;
  }
  
  /**
   * @return the acertatt
   */
  public String getAcertatt() {
    return acertatt;
  }
  
  /**
   * @param acertatt the acertatt to set
   */
  public void setAcertatt(String acertatt) {
    this.acertatt = acertatt;
  }
  
  /**
   * @return the aistprev
   */
  public String getAistprev() {
    return aistprev;
  }
  
  /**
   * @param aistprev the aistprev to set
   */
  public void setAistprev(String aistprev) {
    this.aistprev = aistprev;
  }
  
  /**
   * @return the assobbl
   */
  public String getAssobbl() {
    return assobbl;
  }
  
  /**
   * @param assobbl the assobbl to set
   */
  public void setAssobbl(String assobbl) {
    this.assobbl = assobbl;
  }
  
  /**
   * @return the ismpmi
   */
  public String getIsmpmi() {
    return ismpmi;
  }
  
  /**
   * @param ismpmi the ismpmi to set
   */
  public void setIsmpmi(String ismpmi) {
    this.ismpmi = ismpmi;
  }
  
  /**
   * @return the iscrcciaa
   */
  public String getIscrcciaa() {
    return iscrcciaa;
  }
  
  /**
   * @param iscrcciaa the iscrcciaa to set
   */
  public void setIscrcciaa(String iscrcciaa) {
    this.iscrcciaa = iscrcciaa;
  }
  
  /**
   * @return the cladim
   */
  public Integer getCladim() {
    return cladim;
  }
  
  /**
   * @param cladim the cladim to set
   */
  public void setCladim(Integer cladim) {
    this.cladim = cladim;
  }
  
  /**
   * @return the iscriwl
   */
  public String getIscriwl() {
    return iscriwl;
  }
  
  /**
   * @param iscriwl the iscriwl to set
   */
  public void setIscriwl(String iscriwl) {
    this.iscriwl = iscriwl;
  }
  
  /**
   * @return the wlprefe
   */
  public String getWlprefe() {
    return wlprefe;
  }
  
  /**
   * @param wlprefe the wlprefe to set
   */
  public void setWlprefe(String wlprefe) {
    this.wlprefe = wlprefe;
  }
  
  /**
   * @return the wlsezio
   */
  public String getWlsezio() {
    return wlsezio;
  }
  
  /**
   * @param wlsezio the wlsezio to set
   */
  public void setWlsezio(String wlsezio) {
    this.wlsezio = wlsezio;
  }
  
  /**
   * @return the wldiscri
   */
  public Date getWldiscri() {
    return wldiscri;
  }
  
  /**
   * @param wldiscri the wldiscri to set
   */
  public void setWldiscri(Date wldiscri) {
    this.wldiscri = wldiscri;
  }
  
  /**
   * @return the wldscad
   */
  public Date getWldscad() {
    return wldscad;
  }
  
  /**
   * @param wldscad the wldscad to set
   */
  public void setWldscad(Date wldscad) {
    this.wldscad = wldscad;
  }
  
  /**
   * @return the wlincorso
   */
  public String getWlincorso() {
    return wlincorso;
  }
  
  /**
   * @param wlincorso the wlincorso to set
   */
  public void setWlincorso(String wlincorso) {
    this.wlincorso = wlincorso;
  }
  
  /**
   * @return the art80stato
   */
  public Integer getArt80stato() {
    return art80stato;
  }
  
  /**
   * @param art80stato the art80stato to set
   */
  public void setArt80stato(Integer art80stato) {
    this.art80stato = art80stato;
  }
  
  /**
   * @return the art80datarichiesta
   */
  public Date getArt80datarichiesta() {
    return art80datarichiesta;
  }
  
  /**
   * @param art80datarichiesta the art80datarichiesta to set
   */
  public void setArt80datarichiesta(Date art80datarichiesta) {
    this.art80datarichiesta = art80datarichiesta;
  }
  
  /**
   * @return the art80datalettura
   */
  public Date getArt80datalettura() {
    return art80datalettura;
  }
  
  /**
   * @param art80datalettura the art80datalettura to set
   */
  public void setArt80datalettura(Date art80datalettura) {
    this.art80datalettura = art80datalettura;
  }
  
  /**
   * @return the cognome
   */
  public String getCognome() {
    return cognome;
  }
  
  /**
   * @param cognome the cognome to set
   */
  public void setCognome(String cognome) {
    this.cognome = cognome;
  }
  
  /**
   * @return the nome
   */
  public String getNome() {
    return nome;
  }
  
  /**
   * @param nome the nome to set
   */
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  /**
   * @return the iscriae
   */
  public String getIscriae() {
    return iscriae;
  }
  
  /**
   * @param iscriae the iscriae to set
   */
  public void setIscriae(String iscriae) {
    this.iscriae = iscriae;
  }
  
  /**
   * @return the aedscad
   */
  public Date getAedscad() {
    return aedscad;
  }
  
  /**
   * @param aedscad the aedscad to set
   */
  public void setAedscad(Date aedscad) {
    this.aedscad = aedscad;
  }
  
  /**
   * @return the aeincorso
   */
  public String getAeincorso() {
    return aeincorso;
  }
  
  /**
   * @param aeincorso the aeincorso to set
   */
  public void setAeincorso(String aeincorso) {
    this.aeincorso = aeincorso;
  }
  
  /**
   * @return the iscriesp
   */
  public String getIscriesp() {
    return iscriesp;
  }
  
  /**
   * @param iscriesp the iscriesp to set
   */
  public void setIscriesp(String iscriesp) {
    this.iscriesp = iscriesp;
  }
  
  /**
   * @return the iscrirat
   */
  public String getIscrirat() {
    return iscrirat;
  }
  
  /**
   * @param iscrirat the iscrirat to set
   */
  public void setIscrirat(String iscrirat) {
    this.iscrirat = iscrirat;
  }
  
  /**
   * @return the rating
   */
  public Integer getRating() {
    return rating;
  }
  
  /**
   * @param rating the rating to set
   */
  public void setRating(Integer rating) {
    this.rating = rating;
  }
  
  /**
   * @return the ratdscad
   */
  public Date getRatdscad() {
    return ratdscad;
  }
  
  /**
   * @param ratdscad the ratdscad to set
   */
  public void setRatdscad(Date ratdscad) {
    this.ratdscad = ratdscad;
  }
  
  /**
   * @return the ratincorso
   */
  public String getRatincorso() {
    return ratincorso;
  }
  
  /**
   * @param ratincorso the ratincorso to set
   */
  public void setRatincorso(String ratincorso) {
    this.ratincorso = ratincorso;
  }
  
  /**
   * @return the endpointnso
   */
  public String getEndpointnso() {
    return endpointnso;
  }
  
  /**
   * @param endpointnso the endpointnso to set
   */
  public void setEndpointnso(String endpointnso) {
    this.endpointnso = endpointnso;
  }
  
  /**
   * @return the ultdic
   */
  public String getUltdic() {
    return ultdic;
  }
  
  /**
   * @param ultdic the ultdic to set
   */
  public void setUltdic(String ultdic) {
    this.ultdic = ultdic;
  }
  
  /**
   * @return the sociounico
   */
  public String getSociounico() {
    return sociounico;
  }
  
  /**
   * @param sociounico the sociounico to set
   */
  public void setSociounico(String sociounico) {
    this.sociounico = sociounico;
  }
  
  /**
   * @return the regfisc
   */
  public Integer getRegfisc() {
    return regfisc;
  }
  
  /**
   * @param regfisc the regfisc to set
   */
  public void setRegfisc(Integer regfisc) {
    this.regfisc = regfisc;
  }
  
  /**
   * @return the dintsoa
   */
  public Date getDintsoa() {
    return dintsoa;
  }
  
  /**
   * @param dintsoa the dintsoa to set
   */
  public void setDintsoa(Date dintsoa) {
    this.dintsoa = dintsoa;
  }

  
  /**
   * @return the raggruppamento
   */
  public List<Ragimp> getRaggruppamento() {
    return raggruppamento;
  }

  
  /**
   * @param raggruppamento the raggruppamento to set
   */
  public void setRaggruppamento(List<Ragimp> raggruppamento) {
    this.raggruppamento = raggruppamento;
  }

  @Override
  public String toString() {
    return "Impr ["
        + (codimp != null ? "codimp=" + codimp + ", " : "")
        + (nomimp != null ? "nomimp=" + nomimp + ", " : "")
        + (cfimp != null ? "cfimp=" + cfimp + ", " : "")
        + (pivimp != null ? "pivimp=" + pivimp : "")
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codimp == null) ? 0 : codimp.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Impr other = (Impr) obj;
    if (codimp == null) {
      if (other.codimp != null) return false;
    } else if (!codimp.equals(other.codimp)) return false;
    return true;
}

}
