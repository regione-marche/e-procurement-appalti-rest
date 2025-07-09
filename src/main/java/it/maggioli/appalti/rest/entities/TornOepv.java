package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the torn database table.
 * 
 */
@Entity
@Table(name = "torn")
public class TornOepv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String codgar;

	private String accappub;

	private String accqua;

	private String accser;

	private String acqalt;

	private BigDecimal aeimpmax;

	private BigDecimal aeimpmin;

	private BigDecimal aemodvis;

	private String aenote;

	private BigDecimal aeribmax;

	private BigDecimal aeribmin;

	private String altneg;

	private BigDecimal altrisog;

	private String ammopz;

	private String ammrin;

	private String ammvar;

	private BigDecimal annorif;

	private String apfinfc;

	private BigDecimal applegreg;

	private BigDecimal aqdurata;

	private BigDecimal aqnumope;

	private BigDecimal aqoper;

	private BigDecimal aqtempo;

	private String banweb;

	private String calcsoan;

	private String calcsome;

	private String cenint;

	private BigDecimal cliv1;

	private BigDecimal cliv2;

	private String codavscp;

	private String codcigaq;

	private String codgarcli;

	private String codnuts;

	private String codrup;

	private String codscp;

	private String compreq;

	private BigDecimal contoeco;

	private BigDecimal corgar;

	private BigDecimal critlic;

	private Timestamp datdoc;

	private Timestamp datneg;

	private Timestamp datrict;

	private Timestamp dattot;

	private Timestamp davvig;

	private Timestamp desdoc;

	private String desgreen;

	private Timestamp desoff;

	private String desopz;

	private String desqua;

	private String desrin;

	private String destor;

	private BigDecimal detlic;

	private Timestamp dfpuba;

	private Timestamp dgara;

	private Timestamp diband;

	private Timestamp dindoc;

	private Timestamp dinvit;

	private String docgar;

	private String docweb;

	private Timestamp dpubav;

	private Timestamp dpubavviso;

	private Timestamp dridoc;

	private Timestamp dteoff;

	private Timestamp dtepar;

	private Timestamp dtermrichcdp;

	private Timestamp dtermrichcpo;

	private Timestamp dtermrispcdp;

	private Timestamp dtermrispcpo;

	private Timestamp dtpubavviso;

	private Timestamp dultagg;

	private String elepar;

	private BigDecimal esineg;

	private BigDecimal garpriv;

	private String gartel;

	private BigDecimal idcommalbo;

	private BigDecimal impdoc;

	private BigDecimal imptor;

	private String infcom;

	private String inversa;

	private String isadesione;

	private String isarchi;

	private String isgreen;

	private BigDecimal istaut;

	private BigDecimal iterga;

	private String livacq;

	private String locgar;

	private String locoff;

	private String locpre;

	private BigDecimal maxope;

	private BigDecimal minope;

	private Timestamp modast;

	private BigDecimal modcont;

	private String modfin;

	private String modgar;

	private BigDecimal modlic;

	private BigDecimal modmano;

	private String modrea;

	private String motacc;

	private String nattot;

	private String navvig;

	private BigDecimal ngadit;

	private String ngaraaq;

	private String nobustamm;

	private BigDecimal nofdit;

	private String norma;

	private BigDecimal norma1;

	private String noteat;

	private String npnominacomm;

	private String nproat;

	private String nproti;

	private String nridoc;

	private String numavcp;

	private BigDecimal numope;

	private String oesoff;

	private String offaum;

	private BigDecimal offlot;

	private BigDecimal offtel;

	private String ogara;

	private BigDecimal oggcont;

	private String oradoc;

	private String oteoff;

	private String otepar;

	private String pagdoc;

	private BigDecimal pcodoc;

	private BigDecimal pcogar;

	private BigDecimal pcooff;

	private BigDecimal pcopre;

	private String preinf;

	private BigDecimal prerib;

	private String prerispp;

	private String profas;

	private BigDecimal profiloweb;

	private String progeu;

	private String prourg;

	private String pubprecd;

	private String pubprecsa;

	private String ricastae;

	private String ricmano;

	private String selope;

	private BigDecimal selpar;

	private String settore;

	private String sommaur;

	private String sortinv;

	private BigDecimal tattoc;

	private BigDecimal tattot;

	private String terrid;

	private BigDecimal tipforn;

	private BigDecimal tipgar;

	private BigDecimal tipgen;

	private BigDecimal tiplav;

	private BigDecimal tipneg;

	private String tiptor;

	private BigDecimal tus;

	private BigDecimal uffdet;

	private BigDecimal ultdetlic;

	private String urbasco;

	private String urega;

	private String urlavscp;

	private String urlscp;

	private String uuid;

	private String valoff;

	private String valtec;

	public TornOepv() {
	}

	public String getCodgar() {
		return this.codgar;
	}

	public void setCodgar(String codgar) {
		this.codgar = codgar;
	}

	public String getAccappub() {
		return this.accappub;
	}

	public void setAccappub(String accappub) {
		this.accappub = accappub;
	}

	public String getAccqua() {
		return this.accqua;
	}

	public void setAccqua(String accqua) {
		this.accqua = accqua;
	}

	public String getAccser() {
		return this.accser;
	}

	public void setAccser(String accser) {
		this.accser = accser;
	}

	public String getAcqalt() {
		return this.acqalt;
	}

	public void setAcqalt(String acqalt) {
		this.acqalt = acqalt;
	}

	public BigDecimal getAeimpmax() {
		return this.aeimpmax;
	}

	public void setAeimpmax(BigDecimal aeimpmax) {
		this.aeimpmax = aeimpmax;
	}

	public BigDecimal getAeimpmin() {
		return this.aeimpmin;
	}

	public void setAeimpmin(BigDecimal aeimpmin) {
		this.aeimpmin = aeimpmin;
	}

	public BigDecimal getAemodvis() {
		return this.aemodvis;
	}

	public void setAemodvis(BigDecimal aemodvis) {
		this.aemodvis = aemodvis;
	}

	public String getAenote() {
		return this.aenote;
	}

	public void setAenote(String aenote) {
		this.aenote = aenote;
	}

	public BigDecimal getAeribmax() {
		return this.aeribmax;
	}

	public void setAeribmax(BigDecimal aeribmax) {
		this.aeribmax = aeribmax;
	}

	public BigDecimal getAeribmin() {
		return this.aeribmin;
	}

	public void setAeribmin(BigDecimal aeribmin) {
		this.aeribmin = aeribmin;
	}

	public String getAltneg() {
		return this.altneg;
	}

	public void setAltneg(String altneg) {
		this.altneg = altneg;
	}

	public BigDecimal getAltrisog() {
		return this.altrisog;
	}

	public void setAltrisog(BigDecimal altrisog) {
		this.altrisog = altrisog;
	}

	public String getAmmopz() {
		return this.ammopz;
	}

	public void setAmmopz(String ammopz) {
		this.ammopz = ammopz;
	}

	public String getAmmrin() {
		return this.ammrin;
	}

	public void setAmmrin(String ammrin) {
		this.ammrin = ammrin;
	}

	public String getAmmvar() {
		return this.ammvar;
	}

	public void setAmmvar(String ammvar) {
		this.ammvar = ammvar;
	}

	public BigDecimal getAnnorif() {
		return this.annorif;
	}

	public void setAnnorif(BigDecimal annorif) {
		this.annorif = annorif;
	}

	public String getApfinfc() {
		return this.apfinfc;
	}

	public void setApfinfc(String apfinfc) {
		this.apfinfc = apfinfc;
	}

	public BigDecimal getApplegreg() {
		return this.applegreg;
	}

	public void setApplegreg(BigDecimal applegreg) {
		this.applegreg = applegreg;
	}

	public BigDecimal getAqdurata() {
		return this.aqdurata;
	}

	public void setAqdurata(BigDecimal aqdurata) {
		this.aqdurata = aqdurata;
	}

	public BigDecimal getAqnumope() {
		return this.aqnumope;
	}

	public void setAqnumope(BigDecimal aqnumope) {
		this.aqnumope = aqnumope;
	}

	public BigDecimal getAqoper() {
		return this.aqoper;
	}

	public void setAqoper(BigDecimal aqoper) {
		this.aqoper = aqoper;
	}

	public BigDecimal getAqtempo() {
		return this.aqtempo;
	}

	public void setAqtempo(BigDecimal aqtempo) {
		this.aqtempo = aqtempo;
	}

	public String getBanweb() {
		return this.banweb;
	}

	public void setBanweb(String banweb) {
		this.banweb = banweb;
	}

	public String getCalcsoan() {
		return this.calcsoan;
	}

	public void setCalcsoan(String calcsoan) {
		this.calcsoan = calcsoan;
	}

	public String getCalcsome() {
		return this.calcsome;
	}

	public void setCalcsome(String calcsome) {
		this.calcsome = calcsome;
	}

	public String getCenint() {
		return this.cenint;
	}

	public void setCenint(String cenint) {
		this.cenint = cenint;
	}

	public BigDecimal getCliv1() {
		return this.cliv1;
	}

	public void setCliv1(BigDecimal cliv1) {
		this.cliv1 = cliv1;
	}

	public BigDecimal getCliv2() {
		return this.cliv2;
	}

	public void setCliv2(BigDecimal cliv2) {
		this.cliv2 = cliv2;
	}

	public String getCodavscp() {
		return this.codavscp;
	}

	public void setCodavscp(String codavscp) {
		this.codavscp = codavscp;
	}

	public String getCodcigaq() {
		return this.codcigaq;
	}

	public void setCodcigaq(String codcigaq) {
		this.codcigaq = codcigaq;
	}

	public String getCodgarcli() {
		return this.codgarcli;
	}

	public void setCodgarcli(String codgarcli) {
		this.codgarcli = codgarcli;
	}

	public String getCodnuts() {
		return this.codnuts;
	}

	public void setCodnuts(String codnuts) {
		this.codnuts = codnuts;
	}

	public String getCodrup() {
		return this.codrup;
	}

	public void setCodrup(String codrup) {
		this.codrup = codrup;
	}

	public String getCodscp() {
		return this.codscp;
	}

	public void setCodscp(String codscp) {
		this.codscp = codscp;
	}

	public String getCompreq() {
		return this.compreq;
	}

	public void setCompreq(String compreq) {
		this.compreq = compreq;
	}

	public BigDecimal getContoeco() {
		return this.contoeco;
	}

	public void setContoeco(BigDecimal contoeco) {
		this.contoeco = contoeco;
	}

	public BigDecimal getCorgar() {
		return this.corgar;
	}

	public void setCorgar(BigDecimal corgar) {
		this.corgar = corgar;
	}

	public BigDecimal getCritlic() {
		return this.critlic;
	}

	public void setCritlic(BigDecimal critlic) {
		this.critlic = critlic;
	}

	public Timestamp getDatdoc() {
		return this.datdoc;
	}

	public void setDatdoc(Timestamp datdoc) {
		this.datdoc = datdoc;
	}

	public Timestamp getDatneg() {
		return this.datneg;
	}

	public void setDatneg(Timestamp datneg) {
		this.datneg = datneg;
	}

	public Timestamp getDatrict() {
		return this.datrict;
	}

	public void setDatrict(Timestamp datrict) {
		this.datrict = datrict;
	}

	public Timestamp getDattot() {
		return this.dattot;
	}

	public void setDattot(Timestamp dattot) {
		this.dattot = dattot;
	}

	public Timestamp getDavvig() {
		return this.davvig;
	}

	public void setDavvig(Timestamp davvig) {
		this.davvig = davvig;
	}

	public Timestamp getDesdoc() {
		return this.desdoc;
	}

	public void setDesdoc(Timestamp desdoc) {
		this.desdoc = desdoc;
	}

	public String getDesgreen() {
		return this.desgreen;
	}

	public void setDesgreen(String desgreen) {
		this.desgreen = desgreen;
	}

	public Timestamp getDesoff() {
		return this.desoff;
	}

	public void setDesoff(Timestamp desoff) {
		this.desoff = desoff;
	}

	public String getDesopz() {
		return this.desopz;
	}

	public void setDesopz(String desopz) {
		this.desopz = desopz;
	}

	public String getDesqua() {
		return this.desqua;
	}

	public void setDesqua(String desqua) {
		this.desqua = desqua;
	}

	public String getDesrin() {
		return this.desrin;
	}

	public void setDesrin(String desrin) {
		this.desrin = desrin;
	}

	public String getDestor() {
		return this.destor;
	}

	public void setDestor(String destor) {
		this.destor = destor;
	}

	public BigDecimal getDetlic() {
		return this.detlic;
	}

	public void setDetlic(BigDecimal detlic) {
		this.detlic = detlic;
	}

	public Timestamp getDfpuba() {
		return this.dfpuba;
	}

	public void setDfpuba(Timestamp dfpuba) {
		this.dfpuba = dfpuba;
	}

	public Timestamp getDgara() {
		return this.dgara;
	}

	public void setDgara(Timestamp dgara) {
		this.dgara = dgara;
	}

	public Timestamp getDiband() {
		return this.diband;
	}

	public void setDiband(Timestamp diband) {
		this.diband = diband;
	}

	public Timestamp getDindoc() {
		return this.dindoc;
	}

	public void setDindoc(Timestamp dindoc) {
		this.dindoc = dindoc;
	}

	public Timestamp getDinvit() {
		return this.dinvit;
	}

	public void setDinvit(Timestamp dinvit) {
		this.dinvit = dinvit;
	}

	public String getDocgar() {
		return this.docgar;
	}

	public void setDocgar(String docgar) {
		this.docgar = docgar;
	}

	public String getDocweb() {
		return this.docweb;
	}

	public void setDocweb(String docweb) {
		this.docweb = docweb;
	}

	public Timestamp getDpubav() {
		return this.dpubav;
	}

	public void setDpubav(Timestamp dpubav) {
		this.dpubav = dpubav;
	}

	public Timestamp getDpubavviso() {
		return this.dpubavviso;
	}

	public void setDpubavviso(Timestamp dpubavviso) {
		this.dpubavviso = dpubavviso;
	}

	public Timestamp getDridoc() {
		return this.dridoc;
	}

	public void setDridoc(Timestamp dridoc) {
		this.dridoc = dridoc;
	}

	public Timestamp getDteoff() {
		return this.dteoff;
	}

	public void setDteoff(Timestamp dteoff) {
		this.dteoff = dteoff;
	}

	public Timestamp getDtepar() {
		return this.dtepar;
	}

	public void setDtepar(Timestamp dtepar) {
		this.dtepar = dtepar;
	}

	public Timestamp getDtermrichcdp() {
		return this.dtermrichcdp;
	}

	public void setDtermrichcdp(Timestamp dtermrichcdp) {
		this.dtermrichcdp = dtermrichcdp;
	}

	public Timestamp getDtermrichcpo() {
		return this.dtermrichcpo;
	}

	public void setDtermrichcpo(Timestamp dtermrichcpo) {
		this.dtermrichcpo = dtermrichcpo;
	}

	public Timestamp getDtermrispcdp() {
		return this.dtermrispcdp;
	}

	public void setDtermrispcdp(Timestamp dtermrispcdp) {
		this.dtermrispcdp = dtermrispcdp;
	}

	public Timestamp getDtermrispcpo() {
		return this.dtermrispcpo;
	}

	public void setDtermrispcpo(Timestamp dtermrispcpo) {
		this.dtermrispcpo = dtermrispcpo;
	}

	public Timestamp getDtpubavviso() {
		return this.dtpubavviso;
	}

	public void setDtpubavviso(Timestamp dtpubavviso) {
		this.dtpubavviso = dtpubavviso;
	}

	public Timestamp getDultagg() {
		return this.dultagg;
	}

	public void setDultagg(Timestamp dultagg) {
		this.dultagg = dultagg;
	}

	public String getElepar() {
		return this.elepar;
	}

	public void setElepar(String elepar) {
		this.elepar = elepar;
	}

	public BigDecimal getEsineg() {
		return this.esineg;
	}

	public void setEsineg(BigDecimal esineg) {
		this.esineg = esineg;
	}

	public BigDecimal getGarpriv() {
		return this.garpriv;
	}

	public void setGarpriv(BigDecimal garpriv) {
		this.garpriv = garpriv;
	}

	public String getGartel() {
		return this.gartel;
	}

	public void setGartel(String gartel) {
		this.gartel = gartel;
	}

	public BigDecimal getIdcommalbo() {
		return this.idcommalbo;
	}

	public void setIdcommalbo(BigDecimal idcommalbo) {
		this.idcommalbo = idcommalbo;
	}

	public BigDecimal getImpdoc() {
		return this.impdoc;
	}

	public void setImpdoc(BigDecimal impdoc) {
		this.impdoc = impdoc;
	}

	public BigDecimal getImptor() {
		return this.imptor;
	}

	public void setImptor(BigDecimal imptor) {
		this.imptor = imptor;
	}

	public String getInfcom() {
		return this.infcom;
	}

	public void setInfcom(String infcom) {
		this.infcom = infcom;
	}

	public String getInversa() {
		return this.inversa;
	}

	public void setInversa(String inversa) {
		this.inversa = inversa;
	}

	public String getIsadesione() {
		return this.isadesione;
	}

	public void setIsadesione(String isadesione) {
		this.isadesione = isadesione;
	}

	public String getIsarchi() {
		return this.isarchi;
	}

	public void setIsarchi(String isarchi) {
		this.isarchi = isarchi;
	}

	public String getIsgreen() {
		return this.isgreen;
	}

	public void setIsgreen(String isgreen) {
		this.isgreen = isgreen;
	}

	public BigDecimal getIstaut() {
		return this.istaut;
	}

	public void setIstaut(BigDecimal istaut) {
		this.istaut = istaut;
	}

	public BigDecimal getIterga() {
		return this.iterga;
	}

	public void setIterga(BigDecimal iterga) {
		this.iterga = iterga;
	}

	public String getLivacq() {
		return this.livacq;
	}

	public void setLivacq(String livacq) {
		this.livacq = livacq;
	}

	public String getLocgar() {
		return this.locgar;
	}

	public void setLocgar(String locgar) {
		this.locgar = locgar;
	}

	public String getLocoff() {
		return this.locoff;
	}

	public void setLocoff(String locoff) {
		this.locoff = locoff;
	}

	public String getLocpre() {
		return this.locpre;
	}

	public void setLocpre(String locpre) {
		this.locpre = locpre;
	}

	public BigDecimal getMaxope() {
		return this.maxope;
	}

	public void setMaxope(BigDecimal maxope) {
		this.maxope = maxope;
	}

	public BigDecimal getMinope() {
		return this.minope;
	}

	public void setMinope(BigDecimal minope) {
		this.minope = minope;
	}

	public Timestamp getModast() {
		return this.modast;
	}

	public void setModast(Timestamp modast) {
		this.modast = modast;
	}

	public BigDecimal getModcont() {
		return this.modcont;
	}

	public void setModcont(BigDecimal modcont) {
		this.modcont = modcont;
	}

	public String getModfin() {
		return this.modfin;
	}

	public void setModfin(String modfin) {
		this.modfin = modfin;
	}

	public String getModgar() {
		return this.modgar;
	}

	public void setModgar(String modgar) {
		this.modgar = modgar;
	}

	public BigDecimal getModlic() {
		return this.modlic;
	}

	public void setModlic(BigDecimal modlic) {
		this.modlic = modlic;
	}

	public BigDecimal getModmano() {
		return this.modmano;
	}

	public void setModmano(BigDecimal modmano) {
		this.modmano = modmano;
	}

	public String getModrea() {
		return this.modrea;
	}

	public void setModrea(String modrea) {
		this.modrea = modrea;
	}

	public String getMotacc() {
		return this.motacc;
	}

	public void setMotacc(String motacc) {
		this.motacc = motacc;
	}

	public String getNattot() {
		return this.nattot;
	}

	public void setNattot(String nattot) {
		this.nattot = nattot;
	}

	public String getNavvig() {
		return this.navvig;
	}

	public void setNavvig(String navvig) {
		this.navvig = navvig;
	}

	public BigDecimal getNgadit() {
		return this.ngadit;
	}

	public void setNgadit(BigDecimal ngadit) {
		this.ngadit = ngadit;
	}

	public String getNgaraaq() {
		return this.ngaraaq;
	}

	public void setNgaraaq(String ngaraaq) {
		this.ngaraaq = ngaraaq;
	}

	public String getNobustamm() {
		return this.nobustamm;
	}

	public void setNobustamm(String nobustamm) {
		this.nobustamm = nobustamm;
	}

	public BigDecimal getNofdit() {
		return this.nofdit;
	}

	public void setNofdit(BigDecimal nofdit) {
		this.nofdit = nofdit;
	}

	public String getNorma() {
		return this.norma;
	}

	public void setNorma(String norma) {
		this.norma = norma;
	}

	public BigDecimal getNorma1() {
		return this.norma1;
	}

	public void setNorma1(BigDecimal norma1) {
		this.norma1 = norma1;
	}

	public String getNoteat() {
		return this.noteat;
	}

	public void setNoteat(String noteat) {
		this.noteat = noteat;
	}

	public String getNpnominacomm() {
		return this.npnominacomm;
	}

	public void setNpnominacomm(String npnominacomm) {
		this.npnominacomm = npnominacomm;
	}

	public String getNproat() {
		return this.nproat;
	}

	public void setNproat(String nproat) {
		this.nproat = nproat;
	}

	public String getNproti() {
		return this.nproti;
	}

	public void setNproti(String nproti) {
		this.nproti = nproti;
	}

	public String getNridoc() {
		return this.nridoc;
	}

	public void setNridoc(String nridoc) {
		this.nridoc = nridoc;
	}

	public String getNumavcp() {
		return this.numavcp;
	}

	public void setNumavcp(String numavcp) {
		this.numavcp = numavcp;
	}

	public BigDecimal getNumope() {
		return this.numope;
	}

	public void setNumope(BigDecimal numope) {
		this.numope = numope;
	}

	public String getOesoff() {
		return this.oesoff;
	}

	public void setOesoff(String oesoff) {
		this.oesoff = oesoff;
	}

	public String getOffaum() {
		return this.offaum;
	}

	public void setOffaum(String offaum) {
		this.offaum = offaum;
	}

	public BigDecimal getOfflot() {
		return this.offlot;
	}

	public void setOfflot(BigDecimal offlot) {
		this.offlot = offlot;
	}

	public BigDecimal getOfftel() {
		return this.offtel;
	}

	public void setOfftel(BigDecimal offtel) {
		this.offtel = offtel;
	}

	public String getOgara() {
		return this.ogara;
	}

	public void setOgara(String ogara) {
		this.ogara = ogara;
	}

	public BigDecimal getOggcont() {
		return this.oggcont;
	}

	public void setOggcont(BigDecimal oggcont) {
		this.oggcont = oggcont;
	}

	public String getOradoc() {
		return this.oradoc;
	}

	public void setOradoc(String oradoc) {
		this.oradoc = oradoc;
	}

	public String getOteoff() {
		return this.oteoff;
	}

	public void setOteoff(String oteoff) {
		this.oteoff = oteoff;
	}

	public String getOtepar() {
		return this.otepar;
	}

	public void setOtepar(String otepar) {
		this.otepar = otepar;
	}

	public String getPagdoc() {
		return this.pagdoc;
	}

	public void setPagdoc(String pagdoc) {
		this.pagdoc = pagdoc;
	}

	public BigDecimal getPcodoc() {
		return this.pcodoc;
	}

	public void setPcodoc(BigDecimal pcodoc) {
		this.pcodoc = pcodoc;
	}

	public BigDecimal getPcogar() {
		return this.pcogar;
	}

	public void setPcogar(BigDecimal pcogar) {
		this.pcogar = pcogar;
	}

	public BigDecimal getPcooff() {
		return this.pcooff;
	}

	public void setPcooff(BigDecimal pcooff) {
		this.pcooff = pcooff;
	}

	public BigDecimal getPcopre() {
		return this.pcopre;
	}

	public void setPcopre(BigDecimal pcopre) {
		this.pcopre = pcopre;
	}

	public String getPreinf() {
		return this.preinf;
	}

	public void setPreinf(String preinf) {
		this.preinf = preinf;
	}

	public BigDecimal getPrerib() {
		return this.prerib;
	}

	public void setPrerib(BigDecimal prerib) {
		this.prerib = prerib;
	}

	public String getPrerispp() {
		return this.prerispp;
	}

	public void setPrerispp(String prerispp) {
		this.prerispp = prerispp;
	}

	public String getProfas() {
		return this.profas;
	}

	public void setProfas(String profas) {
		this.profas = profas;
	}

	public BigDecimal getProfiloweb() {
		return this.profiloweb;
	}

	public void setProfiloweb(BigDecimal profiloweb) {
		this.profiloweb = profiloweb;
	}

	public String getProgeu() {
		return this.progeu;
	}

	public void setProgeu(String progeu) {
		this.progeu = progeu;
	}

	public String getProurg() {
		return this.prourg;
	}

	public void setProurg(String prourg) {
		this.prourg = prourg;
	}

	public String getPubprecd() {
		return this.pubprecd;
	}

	public void setPubprecd(String pubprecd) {
		this.pubprecd = pubprecd;
	}

	public String getPubprecsa() {
		return this.pubprecsa;
	}

	public void setPubprecsa(String pubprecsa) {
		this.pubprecsa = pubprecsa;
	}

	public String getRicastae() {
		return this.ricastae;
	}

	public void setRicastae(String ricastae) {
		this.ricastae = ricastae;
	}

	public String getRicmano() {
		return this.ricmano;
	}

	public void setRicmano(String ricmano) {
		this.ricmano = ricmano;
	}

	public String getSelope() {
		return this.selope;
	}

	public void setSelope(String selope) {
		this.selope = selope;
	}

	public BigDecimal getSelpar() {
		return this.selpar;
	}

	public void setSelpar(BigDecimal selpar) {
		this.selpar = selpar;
	}

	public String getSettore() {
		return this.settore;
	}

	public void setSettore(String settore) {
		this.settore = settore;
	}

	public String getSommaur() {
		return this.sommaur;
	}

	public void setSommaur(String sommaur) {
		this.sommaur = sommaur;
	}

	public String getSortinv() {
		return this.sortinv;
	}

	public void setSortinv(String sortinv) {
		this.sortinv = sortinv;
	}

	public BigDecimal getTattoc() {
		return this.tattoc;
	}

	public void setTattoc(BigDecimal tattoc) {
		this.tattoc = tattoc;
	}

	public BigDecimal getTattot() {
		return this.tattot;
	}

	public void setTattot(BigDecimal tattot) {
		this.tattot = tattot;
	}

	public String getTerrid() {
		return this.terrid;
	}

	public void setTerrid(String terrid) {
		this.terrid = terrid;
	}

	public BigDecimal getTipforn() {
		return this.tipforn;
	}

	public void setTipforn(BigDecimal tipforn) {
		this.tipforn = tipforn;
	}

	public BigDecimal getTipgar() {
		return this.tipgar;
	}

	public void setTipgar(BigDecimal tipgar) {
		this.tipgar = tipgar;
	}

	public BigDecimal getTipgen() {
		return this.tipgen;
	}

	public void setTipgen(BigDecimal tipgen) {
		this.tipgen = tipgen;
	}

	public BigDecimal getTiplav() {
		return this.tiplav;
	}

	public void setTiplav(BigDecimal tiplav) {
		this.tiplav = tiplav;
	}

	public BigDecimal getTipneg() {
		return this.tipneg;
	}

	public void setTipneg(BigDecimal tipneg) {
		this.tipneg = tipneg;
	}

	public String getTiptor() {
		return this.tiptor;
	}

	public void setTiptor(String tiptor) {
		this.tiptor = tiptor;
	}

	public BigDecimal getTus() {
		return this.tus;
	}

	public void setTus(BigDecimal tus) {
		this.tus = tus;
	}

	public BigDecimal getUffdet() {
		return this.uffdet;
	}

	public void setUffdet(BigDecimal uffdet) {
		this.uffdet = uffdet;
	}

	public BigDecimal getUltdetlic() {
		return this.ultdetlic;
	}

	public void setUltdetlic(BigDecimal ultdetlic) {
		this.ultdetlic = ultdetlic;
	}

	public String getUrbasco() {
		return this.urbasco;
	}

	public void setUrbasco(String urbasco) {
		this.urbasco = urbasco;
	}

	public String getUrega() {
		return this.urega;
	}

	public void setUrega(String urega) {
		this.urega = urega;
	}

	public String getUrlavscp() {
		return this.urlavscp;
	}

	public void setUrlavscp(String urlavscp) {
		this.urlavscp = urlavscp;
	}

	public String getUrlscp() {
		return this.urlscp;
	}

	public void setUrlscp(String urlscp) {
		this.urlscp = urlscp;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getValoff() {
		return this.valoff;
	}

	public void setValoff(String valoff) {
		this.valoff = valoff;
	}

	public String getValtec() {
		return this.valtec;
	}

	public void setValtec(String valtec) {
		this.valtec = valtec;
	}

}