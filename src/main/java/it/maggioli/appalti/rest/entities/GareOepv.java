package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The persistent class for the gare database table.
 * 
 */
@Entity
@Table(name = "gare")
public class GareOepv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String ngara;

	private BigDecimal alainf;

	private BigDecimal alasup;

	private BigDecimal appdef;

	private BigDecimal applegregg;

	private BigDecimal bustalotti;

	private String calcsoang;

	private String carrello;

	private String catiga;

	private String clavor;

	private BigDecimal cliv1;

	private BigDecimal cliv2;

	private String codcig;

	private String codcom;

	private String coddef;

	private String codgar1;

	private String codiga;

	private String conten;

	private BigDecimal corgar1;

	private BigDecimal critlicg;

	private String cupmst;

	private String cupprg;

	private Timestamp daatto;

	private Timestamp dacert;

	private Timestamp dacqcig;

	private Timestamp daggeff;

	private Timestamp datliq;

	private Timestamp datneg;

	private Timestamp dattammescl;

	private Timestamp dattoa;

	private Timestamp dattog;

	private Timestamp davpre;

	private Timestamp davvigg;

	private Timestamp davvprvreq;

	private Timestamp dcomag;

	private Timestamp dcomaggsa;

	private Timestamp dcomdittagg;

	private Timestamp dcomdittnag;

	private Timestamp dcomng;

	private Timestamp dconvditte;

	private Timestamp desdoc;

	private Timestamp desoff;

	private BigDecimal detlicg;

	private Timestamp dfpubag;

	private Timestamp dibandg;

	private Timestamp dindoc;

	private Timestamp dinlavg;

	private Timestamp dinvdoctec;

	private Timestamp dinvit;

	private String ditta;

	private String dittap;

	private Timestamp dlettaggprov;

	private Timestamp dlettcomescl;

	private Timestamp dlettrichcc;

	private Timestamp dproaa;

	private Timestamp dpubavg;

	private Timestamp dquiet;

	private Timestamp driccaptec;

	private Timestamp dricesp;

	private Timestamp drichdoccr;

	private Timestamp driczdoccr;

	private Timestamp dsedpubeva;

	private Timestamp dteoff;

	private Timestamp dteparg;

	private Timestamp dtermdoccr;

	private Timestamp dtermprescc;

	private Timestamp dtermrichcdpg;

	private Timestamp dtermrichcpog;

	private Timestamp dtermrispcdpg;

	private Timestamp dtermrispcpog;

	private Timestamp dvapdocamm;

	private Timestamp dvcompreq;

	private Timestamp dverag;

	private Timestamp dvprov;

	private Timestamp dvvccdocamm;

	private Timestamp dvverchcc;

	private Timestamp dvvidonoff;

	private Timestamp dvvreqsedris;

	private String elencoe;

	private BigDecimal esineg;

	private String estimp;

	private BigDecimal fasgar;

	private BigDecimal garoff;

	private BigDecimal genere;

	private BigDecimal iaggiu;

	private BigDecimal iagpro;

	private BigDecimal idiaut;

	private BigDecimal idric;

	private BigDecimal impapp;

	private BigDecimal impcom;

	private BigDecimal impcor;

	private BigDecimal impecu;

	private BigDecimal impgar;

	private BigDecimal impiga;

	private BigDecimal impliq;

	private BigDecimal impmis;

	private BigDecimal impnrc;

	private BigDecimal impnrl;

	private BigDecimal impnrm;

	private BigDecimal impsco;

	private BigDecimal impsic;

	private BigDecimal impsmi;

	private String indist;

	private String isriconclusa;

	private BigDecimal istaut;

	private String istcre;

	private BigDecimal ivalav;

	private BigDecimal limmax;

	private BigDecimal limmin;

	private BigDecimal livpro;

	private String locint;

	private String loclav;

	private BigDecimal masear;

	private BigDecimal masest;

	private BigDecimal masprod;

	private BigDecimal masprof;

	private BigDecimal masres;

	private BigDecimal massim;

	private BigDecimal media;

	private BigDecimal modastg;

	private String modcau;

	private String modfin;

	private String modgarg;

	private BigDecimal modlicg;

	private String motcon;

	private String motiva;

	private String naggeff;

	private BigDecimal nappfi;

	private String nattammescl;

	private String nattoa;

	private String nattog;

	private String navpre;

	private String navvigg;

	private String ncomag;

	private String ncomdittagg;

	private String ncomdittnag;

	private String ncomng;

	private BigDecimal nespe2;

	private String nlettcomescl;

	private String nlettrichcc;

	private String nmaximo;

	private BigDecimal nofmed;

	private BigDecimal nofval;

	private String nomima;

	private String nomssl;

	@Column(name = "not_gar")
	private String notGar;

	private String notcompreq;

	private String notcor;

	private String notega;

	private String notmis;

	private String nproaa;

	private String nproag;

	private String nproce;

	private String nproreq;

	private String nproti;

	private String nprova;

	private String nquiet;

	private String nrepat;

	private BigDecimal nsorte;

	private BigDecimal numele;

	private BigDecimal numera;

	private String numssl;

	private String nvprov;

	private String oesoff;

	private BigDecimal oggcont;

	private BigDecimal onprge;

	private String onsogrib;

	private String oteoff;

	private String oteparg;

	private BigDecimal pgarof;

	private String preced;

	private BigDecimal precut;

	private String preinf;

	private String prosla;

	private String respre;

	private BigDecimal ribagg;

	private BigDecimal ribcal;

	private BigDecimal riboepv;

	private BigDecimal ribpro;

	private Timestamp ricdoc;

	private Timestamp ricpre;

	private String ridiso;

	private String segreta;

	private String seguen;

	private String sicinc;

	private BigDecimal stepgar;

	private String subgar;

	private BigDecimal taggeff;

	private BigDecimal tattammescl;

	private BigDecimal tattoa;

	private BigDecimal tattog;

	private BigDecimal temesi;

	private String terrid;

	private BigDecimal teutil;

	private BigDecimal tiatto;

	private BigDecimal tipgarg;

	private BigDecimal tiplav;

	private BigDecimal tipneg;

	private Timestamp vercan;

	private String vernum;

	public GareOepv() {
	}

	public String getNgara() {
		return this.ngara;
	}

	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	public BigDecimal getAlainf() {
		return this.alainf;
	}

	public void setAlainf(BigDecimal alainf) {
		this.alainf = alainf;
	}

	public BigDecimal getAlasup() {
		return this.alasup;
	}

	public void setAlasup(BigDecimal alasup) {
		this.alasup = alasup;
	}

	public BigDecimal getAppdef() {
		return this.appdef;
	}

	public void setAppdef(BigDecimal appdef) {
		this.appdef = appdef;
	}

	public BigDecimal getApplegregg() {
		return this.applegregg;
	}

	public void setApplegregg(BigDecimal applegregg) {
		this.applegregg = applegregg;
	}

	public BigDecimal getBustalotti() {
		return this.bustalotti;
	}

	public void setBustalotti(BigDecimal bustalotti) {
		this.bustalotti = bustalotti;
	}

	public String getCalcsoang() {
		return this.calcsoang;
	}

	public void setCalcsoang(String calcsoang) {
		this.calcsoang = calcsoang;
	}

	public String getCarrello() {
		return this.carrello;
	}

	public void setCarrello(String carrello) {
		this.carrello = carrello;
	}

	public String getCatiga() {
		return this.catiga;
	}

	public void setCatiga(String catiga) {
		this.catiga = catiga;
	}

	public String getClavor() {
		return this.clavor;
	}

	public void setClavor(String clavor) {
		this.clavor = clavor;
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

	public String getCodcig() {
		return this.codcig;
	}

	public void setCodcig(String codcig) {
		this.codcig = codcig;
	}

	public String getCodcom() {
		return this.codcom;
	}

	public void setCodcom(String codcom) {
		this.codcom = codcom;
	}

	public String getCoddef() {
		return this.coddef;
	}

	public void setCoddef(String coddef) {
		this.coddef = coddef;
	}

	public String getCodgar1() {
		return this.codgar1;
	}

	public void setCodgar1(String codgar1) {
		this.codgar1 = codgar1;
	}

	public String getCodiga() {
		return this.codiga;
	}

	public void setCodiga(String codiga) {
		this.codiga = codiga;
	}

	public String getConten() {
		return this.conten;
	}

	public void setConten(String conten) {
		this.conten = conten;
	}

	public BigDecimal getCorgar1() {
		return this.corgar1;
	}

	public void setCorgar1(BigDecimal corgar1) {
		this.corgar1 = corgar1;
	}

	public BigDecimal getCritlicg() {
		return this.critlicg;
	}

	public void setCritlicg(BigDecimal critlicg) {
		this.critlicg = critlicg;
	}

	public String getCupmst() {
		return this.cupmst;
	}

	public void setCupmst(String cupmst) {
		this.cupmst = cupmst;
	}

	public String getCupprg() {
		return this.cupprg;
	}

	public void setCupprg(String cupprg) {
		this.cupprg = cupprg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDaatto() {
		return this.daatto;
	}

	public void setDaatto(Timestamp daatto) {
		this.daatto = daatto;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDacert() {
		return this.dacert;
	}

	public void setDacert(Timestamp dacert) {
		this.dacert = dacert;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDacqcig() {
		return this.dacqcig;
	}

	public void setDacqcig(Timestamp dacqcig) {
		this.dacqcig = dacqcig;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDaggeff() {
		return this.daggeff;
	}

	public void setDaggeff(Timestamp daggeff) {
		this.daggeff = daggeff;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDatliq() {
		return this.datliq;
	}

	public void setDatliq(Timestamp datliq) {
		this.datliq = datliq;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDatneg() {
		return this.datneg;
	}

	public void setDatneg(Timestamp datneg) {
		this.datneg = datneg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDattammescl() {
		return this.dattammescl;
	}

	public void setDattammescl(Timestamp dattammescl) {
		this.dattammescl = dattammescl;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDattoa() {
		return this.dattoa;
	}

	public void setDattoa(Timestamp dattoa) {
		this.dattoa = dattoa;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDattog() {
		return this.dattog;
	}

	public void setDattog(Timestamp dattog) {
		this.dattog = dattog;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDavpre() {
		return this.davpre;
	}

	public void setDavpre(Timestamp davpre) {
		this.davpre = davpre;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDavvigg() {
		return this.davvigg;
	}

	public void setDavvigg(Timestamp davvigg) {
		this.davvigg = davvigg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDavvprvreq() {
		return this.davvprvreq;
	}

	public void setDavvprvreq(Timestamp davvprvreq) {
		this.davvprvreq = davvprvreq;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDcomag() {
		return this.dcomag;
	}

	public void setDcomag(Timestamp dcomag) {
		this.dcomag = dcomag;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDcomaggsa() {
		return this.dcomaggsa;
	}

	public void setDcomaggsa(Timestamp dcomaggsa) {
		this.dcomaggsa = dcomaggsa;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDcomdittagg() {
		return this.dcomdittagg;
	}

	public void setDcomdittagg(Timestamp dcomdittagg) {
		this.dcomdittagg = dcomdittagg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDcomdittnag() {
		return this.dcomdittnag;
	}

	public void setDcomdittnag(Timestamp dcomdittnag) {
		this.dcomdittnag = dcomdittnag;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDcomng() {
		return this.dcomng;
	}

	public void setDcomng(Timestamp dcomng) {
		this.dcomng = dcomng;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDconvditte() {
		return this.dconvditte;
	}

	public void setDconvditte(Timestamp dconvditte) {
		this.dconvditte = dconvditte;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDesdoc() {
		return this.desdoc;
	}

	public void setDesdoc(Timestamp desdoc) {
		this.desdoc = desdoc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDesoff() {
		return this.desoff;
	}

	public void setDesoff(Timestamp desoff) {
		this.desoff = desoff;
	}

	public BigDecimal getDetlicg() {
		return this.detlicg;
	}

	public void setDetlicg(BigDecimal detlicg) {
		this.detlicg = detlicg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDfpubag() {
		return this.dfpubag;
	}

	public void setDfpubag(Timestamp dfpubag) {
		this.dfpubag = dfpubag;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDibandg() {
		return this.dibandg;
	}

	public void setDibandg(Timestamp dibandg) {
		this.dibandg = dibandg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDindoc() {
		return this.dindoc;
	}

	public void setDindoc(Timestamp dindoc) {
		this.dindoc = dindoc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDinlavg() {
		return this.dinlavg;
	}

	public void setDinlavg(Timestamp dinlavg) {
		this.dinlavg = dinlavg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDinvdoctec() {
		return this.dinvdoctec;
	}

	public void setDinvdoctec(Timestamp dinvdoctec) {
		this.dinvdoctec = dinvdoctec;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDinvit() {
		return this.dinvit;
	}

	public void setDinvit(Timestamp dinvit) {
		this.dinvit = dinvit;
	}

	public String getDitta() {
		return this.ditta;
	}

	public void setDitta(String ditta) {
		this.ditta = ditta;
	}

	public String getDittap() {
		return this.dittap;
	}

	public void setDittap(String dittap) {
		this.dittap = dittap;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDlettaggprov() {
		return this.dlettaggprov;
	}

	public void setDlettaggprov(Timestamp dlettaggprov) {
		this.dlettaggprov = dlettaggprov;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDlettcomescl() {
		return this.dlettcomescl;
	}

	public void setDlettcomescl(Timestamp dlettcomescl) {
		this.dlettcomescl = dlettcomescl;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDlettrichcc() {
		return this.dlettrichcc;
	}

	public void setDlettrichcc(Timestamp dlettrichcc) {
		this.dlettrichcc = dlettrichcc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDproaa() {
		return this.dproaa;
	}

	public void setDproaa(Timestamp dproaa) {
		this.dproaa = dproaa;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDpubavg() {
		return this.dpubavg;
	}

	public void setDpubavg(Timestamp dpubavg) {
		this.dpubavg = dpubavg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDquiet() {
		return this.dquiet;
	}

	public void setDquiet(Timestamp dquiet) {
		this.dquiet = dquiet;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDriccaptec() {
		return this.driccaptec;
	}

	public void setDriccaptec(Timestamp driccaptec) {
		this.driccaptec = driccaptec;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDricesp() {
		return this.dricesp;
	}

	public void setDricesp(Timestamp dricesp) {
		this.dricesp = dricesp;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDrichdoccr() {
		return this.drichdoccr;
	}

	public void setDrichdoccr(Timestamp drichdoccr) {
		this.drichdoccr = drichdoccr;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDriczdoccr() {
		return this.driczdoccr;
	}

	public void setDriczdoccr(Timestamp driczdoccr) {
		this.driczdoccr = driczdoccr;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDsedpubeva() {
		return this.dsedpubeva;
	}

	public void setDsedpubeva(Timestamp dsedpubeva) {
		this.dsedpubeva = dsedpubeva;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDteoff() {
		return this.dteoff;
	}

	public void setDteoff(Timestamp dteoff) {
		this.dteoff = dteoff;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDteparg() {
		return this.dteparg;
	}

	public void setDteparg(Timestamp dteparg) {
		this.dteparg = dteparg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDtermdoccr() {
		return this.dtermdoccr;
	}

	public void setDtermdoccr(Timestamp dtermdoccr) {
		this.dtermdoccr = dtermdoccr;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDtermprescc() {
		return this.dtermprescc;
	}

	public void setDtermprescc(Timestamp dtermprescc) {
		this.dtermprescc = dtermprescc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDtermrichcdpg() {
		return this.dtermrichcdpg;
	}

	public void setDtermrichcdpg(Timestamp dtermrichcdpg) {
		this.dtermrichcdpg = dtermrichcdpg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDtermrichcpog() {
		return this.dtermrichcpog;
	}

	public void setDtermrichcpog(Timestamp dtermrichcpog) {
		this.dtermrichcpog = dtermrichcpog;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDtermrispcdpg() {
		return this.dtermrispcdpg;
	}

	public void setDtermrispcdpg(Timestamp dtermrispcdpg) {
		this.dtermrispcdpg = dtermrispcdpg;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDtermrispcpog() {
		return this.dtermrispcpog;
	}

	public void setDtermrispcpog(Timestamp dtermrispcpog) {
		this.dtermrispcpog = dtermrispcpog;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDvapdocamm() {
		return this.dvapdocamm;
	}

	public void setDvapdocamm(Timestamp dvapdocamm) {
		this.dvapdocamm = dvapdocamm;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDvcompreq() {
		return this.dvcompreq;
	}

	public void setDvcompreq(Timestamp dvcompreq) {
		this.dvcompreq = dvcompreq;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDverag() {
		return this.dverag;
	}

	public void setDverag(Timestamp dverag) {
		this.dverag = dverag;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDvprov() {
		return this.dvprov;
	}

	public void setDvprov(Timestamp dvprov) {
		this.dvprov = dvprov;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDvvccdocamm() {
		return this.dvvccdocamm;
	}

	public void setDvvccdocamm(Timestamp dvvccdocamm) {
		this.dvvccdocamm = dvvccdocamm;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDvverchcc() {
		return this.dvverchcc;
	}

	public void setDvverchcc(Timestamp dvverchcc) {
		this.dvverchcc = dvverchcc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDvvidonoff() {
		return this.dvvidonoff;
	}

	public void setDvvidonoff(Timestamp dvvidonoff) {
		this.dvvidonoff = dvvidonoff;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDvvreqsedris() {
		return this.dvvreqsedris;
	}

	public void setDvvreqsedris(Timestamp dvvreqsedris) {
		this.dvvreqsedris = dvvreqsedris;
	}

	public String getElencoe() {
		return this.elencoe;
	}

	public void setElencoe(String elencoe) {
		this.elencoe = elencoe;
	}

	public BigDecimal getEsineg() {
		return this.esineg;
	}

	public void setEsineg(BigDecimal esineg) {
		this.esineg = esineg;
	}

	public String getEstimp() {
		return this.estimp;
	}

	public void setEstimp(String estimp) {
		this.estimp = estimp;
	}

	public BigDecimal getFasgar() {
		return this.fasgar;
	}

	public void setFasgar(BigDecimal fasgar) {
		this.fasgar = fasgar;
	}

	public BigDecimal getGaroff() {
		return this.garoff;
	}

	public void setGaroff(BigDecimal garoff) {
		this.garoff = garoff;
	}

	public BigDecimal getGenere() {
		return this.genere;
	}

	public void setGenere(BigDecimal genere) {
		this.genere = genere;
	}

	public BigDecimal getIaggiu() {
		return this.iaggiu;
	}

	public void setIaggiu(BigDecimal iaggiu) {
		this.iaggiu = iaggiu;
	}

	public BigDecimal getIagpro() {
		return this.iagpro;
	}

	public void setIagpro(BigDecimal iagpro) {
		this.iagpro = iagpro;
	}

	public BigDecimal getIdiaut() {
		return this.idiaut;
	}

	public void setIdiaut(BigDecimal idiaut) {
		this.idiaut = idiaut;
	}

	public BigDecimal getIdric() {
		return this.idric;
	}

	public void setIdric(BigDecimal idric) {
		this.idric = idric;
	}

	public BigDecimal getImpapp() {
		return this.impapp;
	}

	public void setImpapp(BigDecimal impapp) {
		this.impapp = impapp;
	}

	public BigDecimal getImpcom() {
		return this.impcom;
	}

	public void setImpcom(BigDecimal impcom) {
		this.impcom = impcom;
	}

	public BigDecimal getImpcor() {
		return this.impcor;
	}

	public void setImpcor(BigDecimal impcor) {
		this.impcor = impcor;
	}

	public BigDecimal getImpecu() {
		return this.impecu;
	}

	public void setImpecu(BigDecimal impecu) {
		this.impecu = impecu;
	}

	public BigDecimal getImpgar() {
		return this.impgar;
	}

	public void setImpgar(BigDecimal impgar) {
		this.impgar = impgar;
	}

	public BigDecimal getImpiga() {
		return this.impiga;
	}

	public void setImpiga(BigDecimal impiga) {
		this.impiga = impiga;
	}

	public BigDecimal getImpliq() {
		return this.impliq;
	}

	public void setImpliq(BigDecimal impliq) {
		this.impliq = impliq;
	}

	public BigDecimal getImpmis() {
		return this.impmis;
	}

	public void setImpmis(BigDecimal impmis) {
		this.impmis = impmis;
	}

	public BigDecimal getImpnrc() {
		return this.impnrc;
	}

	public void setImpnrc(BigDecimal impnrc) {
		this.impnrc = impnrc;
	}

	public BigDecimal getImpnrl() {
		return this.impnrl;
	}

	public void setImpnrl(BigDecimal impnrl) {
		this.impnrl = impnrl;
	}

	public BigDecimal getImpnrm() {
		return this.impnrm;
	}

	public void setImpnrm(BigDecimal impnrm) {
		this.impnrm = impnrm;
	}

	public BigDecimal getImpsco() {
		return this.impsco;
	}

	public void setImpsco(BigDecimal impsco) {
		this.impsco = impsco;
	}

	public BigDecimal getImpsic() {
		return this.impsic;
	}

	public void setImpsic(BigDecimal impsic) {
		this.impsic = impsic;
	}

	public BigDecimal getImpsmi() {
		return this.impsmi;
	}

	public void setImpsmi(BigDecimal impsmi) {
		this.impsmi = impsmi;
	}

	public String getIndist() {
		return this.indist;
	}

	public void setIndist(String indist) {
		this.indist = indist;
	}

	public String getIsriconclusa() {
		return this.isriconclusa;
	}

	public void setIsriconclusa(String isriconclusa) {
		this.isriconclusa = isriconclusa;
	}

	public BigDecimal getIstaut() {
		return this.istaut;
	}

	public void setIstaut(BigDecimal istaut) {
		this.istaut = istaut;
	}

	public String getIstcre() {
		return this.istcre;
	}

	public void setIstcre(String istcre) {
		this.istcre = istcre;
	}

	public BigDecimal getIvalav() {
		return this.ivalav;
	}

	public void setIvalav(BigDecimal ivalav) {
		this.ivalav = ivalav;
	}

	public BigDecimal getLimmax() {
		return this.limmax;
	}

	public void setLimmax(BigDecimal limmax) {
		this.limmax = limmax;
	}

	public BigDecimal getLimmin() {
		return this.limmin;
	}

	public void setLimmin(BigDecimal limmin) {
		this.limmin = limmin;
	}

	public BigDecimal getLivpro() {
		return this.livpro;
	}

	public void setLivpro(BigDecimal livpro) {
		this.livpro = livpro;
	}

	public String getLocint() {
		return this.locint;
	}

	public void setLocint(String locint) {
		this.locint = locint;
	}

	public String getLoclav() {
		return this.loclav;
	}

	public void setLoclav(String loclav) {
		this.loclav = loclav;
	}

	public BigDecimal getMasear() {
		return this.masear;
	}

	public void setMasear(BigDecimal masear) {
		this.masear = masear;
	}

	public BigDecimal getMasest() {
		return this.masest;
	}

	public void setMasest(BigDecimal masest) {
		this.masest = masest;
	}

	public BigDecimal getMasprod() {
		return this.masprod;
	}

	public void setMasprod(BigDecimal masprod) {
		this.masprod = masprod;
	}

	public BigDecimal getMasprof() {
		return this.masprof;
	}

	public void setMasprof(BigDecimal masprof) {
		this.masprof = masprof;
	}

	public BigDecimal getMasres() {
		return this.masres;
	}

	public void setMasres(BigDecimal masres) {
		this.masres = masres;
	}

	public BigDecimal getMassim() {
		return this.massim;
	}

	public void setMassim(BigDecimal massim) {
		this.massim = massim;
	}

	public BigDecimal getMedia() {
		return this.media;
	}

	public void setMedia(BigDecimal media) {
		this.media = media;
	}

	public BigDecimal getModastg() {
		return this.modastg;
	}

	public void setModastg(BigDecimal modastg) {
		this.modastg = modastg;
	}

	public String getModcau() {
		return this.modcau;
	}

	public void setModcau(String modcau) {
		this.modcau = modcau;
	}

	public String getModfin() {
		return this.modfin;
	}

	public void setModfin(String modfin) {
		this.modfin = modfin;
	}

	public String getModgarg() {
		return this.modgarg;
	}

	public void setModgarg(String modgarg) {
		this.modgarg = modgarg;
	}

	public BigDecimal getModlicg() {
		return this.modlicg;
	}

	public void setModlicg(BigDecimal modlicg) {
		this.modlicg = modlicg;
	}

	public String getMotcon() {
		return this.motcon;
	}

	public void setMotcon(String motcon) {
		this.motcon = motcon;
	}

	public String getMotiva() {
		return this.motiva;
	}

	public void setMotiva(String motiva) {
		this.motiva = motiva;
	}

	public String getNaggeff() {
		return this.naggeff;
	}

	public void setNaggeff(String naggeff) {
		this.naggeff = naggeff;
	}

	public BigDecimal getNappfi() {
		return this.nappfi;
	}

	public void setNappfi(BigDecimal nappfi) {
		this.nappfi = nappfi;
	}

	public String getNattammescl() {
		return this.nattammescl;
	}

	public void setNattammescl(String nattammescl) {
		this.nattammescl = nattammescl;
	}

	public String getNattoa() {
		return this.nattoa;
	}

	public void setNattoa(String nattoa) {
		this.nattoa = nattoa;
	}

	public String getNattog() {
		return this.nattog;
	}

	public void setNattog(String nattog) {
		this.nattog = nattog;
	}

	public String getNavpre() {
		return this.navpre;
	}

	public void setNavpre(String navpre) {
		this.navpre = navpre;
	}

	public String getNavvigg() {
		return this.navvigg;
	}

	public void setNavvigg(String navvigg) {
		this.navvigg = navvigg;
	}

	public String getNcomag() {
		return this.ncomag;
	}

	public void setNcomag(String ncomag) {
		this.ncomag = ncomag;
	}

	public String getNcomdittagg() {
		return this.ncomdittagg;
	}

	public void setNcomdittagg(String ncomdittagg) {
		this.ncomdittagg = ncomdittagg;
	}

	public String getNcomdittnag() {
		return this.ncomdittnag;
	}

	public void setNcomdittnag(String ncomdittnag) {
		this.ncomdittnag = ncomdittnag;
	}

	public String getNcomng() {
		return this.ncomng;
	}

	public void setNcomng(String ncomng) {
		this.ncomng = ncomng;
	}

	public BigDecimal getNespe2() {
		return this.nespe2;
	}

	public void setNespe2(BigDecimal nespe2) {
		this.nespe2 = nespe2;
	}

	public String getNlettcomescl() {
		return this.nlettcomescl;
	}

	public void setNlettcomescl(String nlettcomescl) {
		this.nlettcomescl = nlettcomescl;
	}

	public String getNlettrichcc() {
		return this.nlettrichcc;
	}

	public void setNlettrichcc(String nlettrichcc) {
		this.nlettrichcc = nlettrichcc;
	}

	public String getNmaximo() {
		return this.nmaximo;
	}

	public void setNmaximo(String nmaximo) {
		this.nmaximo = nmaximo;
	}

	public BigDecimal getNofmed() {
		return this.nofmed;
	}

	public void setNofmed(BigDecimal nofmed) {
		this.nofmed = nofmed;
	}

	public BigDecimal getNofval() {
		return this.nofval;
	}

	public void setNofval(BigDecimal nofval) {
		this.nofval = nofval;
	}

	public String getNomima() {
		return this.nomima;
	}

	public void setNomima(String nomima) {
		this.nomima = nomima;
	}

	public String getNomssl() {
		return this.nomssl;
	}

	public void setNomssl(String nomssl) {
		this.nomssl = nomssl;
	}

	public String getNotGar() {
		return this.notGar;
	}

	public void setNotGar(String notGar) {
		this.notGar = notGar;
	}

	public String getNotcompreq() {
		return this.notcompreq;
	}

	public void setNotcompreq(String notcompreq) {
		this.notcompreq = notcompreq;
	}

	public String getNotcor() {
		return this.notcor;
	}

	public void setNotcor(String notcor) {
		this.notcor = notcor;
	}

	public String getNotega() {
		return this.notega;
	}

	public void setNotega(String notega) {
		this.notega = notega;
	}

	public String getNotmis() {
		return this.notmis;
	}

	public void setNotmis(String notmis) {
		this.notmis = notmis;
	}

	public String getNproaa() {
		return this.nproaa;
	}

	public void setNproaa(String nproaa) {
		this.nproaa = nproaa;
	}

	public String getNproag() {
		return this.nproag;
	}

	public void setNproag(String nproag) {
		this.nproag = nproag;
	}

	public String getNproce() {
		return this.nproce;
	}

	public void setNproce(String nproce) {
		this.nproce = nproce;
	}

	public String getNproreq() {
		return this.nproreq;
	}

	public void setNproreq(String nproreq) {
		this.nproreq = nproreq;
	}

	public String getNproti() {
		return this.nproti;
	}

	public void setNproti(String nproti) {
		this.nproti = nproti;
	}

	public String getNprova() {
		return this.nprova;
	}

	public void setNprova(String nprova) {
		this.nprova = nprova;
	}

	public String getNquiet() {
		return this.nquiet;
	}

	public void setNquiet(String nquiet) {
		this.nquiet = nquiet;
	}

	public String getNrepat() {
		return this.nrepat;
	}

	public void setNrepat(String nrepat) {
		this.nrepat = nrepat;
	}

	public BigDecimal getNsorte() {
		return this.nsorte;
	}

	public void setNsorte(BigDecimal nsorte) {
		this.nsorte = nsorte;
	}

	public BigDecimal getNumele() {
		return this.numele;
	}

	public void setNumele(BigDecimal numele) {
		this.numele = numele;
	}

	public BigDecimal getNumera() {
		return this.numera;
	}

	public void setNumera(BigDecimal numera) {
		this.numera = numera;
	}

	public String getNumssl() {
		return this.numssl;
	}

	public void setNumssl(String numssl) {
		this.numssl = numssl;
	}

	public String getNvprov() {
		return this.nvprov;
	}

	public void setNvprov(String nvprov) {
		this.nvprov = nvprov;
	}

	public String getOesoff() {
		return this.oesoff;
	}

	public void setOesoff(String oesoff) {
		this.oesoff = oesoff;
	}

	public BigDecimal getOggcont() {
		return this.oggcont;
	}

	public void setOggcont(BigDecimal oggcont) {
		this.oggcont = oggcont;
	}

	public BigDecimal getOnprge() {
		return this.onprge;
	}

	public void setOnprge(BigDecimal onprge) {
		this.onprge = onprge;
	}

	public String getOnsogrib() {
		return this.onsogrib;
	}

	public void setOnsogrib(String onsogrib) {
		this.onsogrib = onsogrib;
	}

	public String getOteoff() {
		return this.oteoff;
	}

	public void setOteoff(String oteoff) {
		this.oteoff = oteoff;
	}

	public String getOteparg() {
		return this.oteparg;
	}

	public void setOteparg(String oteparg) {
		this.oteparg = oteparg;
	}

	public BigDecimal getPgarof() {
		return this.pgarof;
	}

	public void setPgarof(BigDecimal pgarof) {
		this.pgarof = pgarof;
	}

	public String getPreced() {
		return this.preced;
	}

	public void setPreced(String preced) {
		this.preced = preced;
	}

	public BigDecimal getPrecut() {
		return this.precut;
	}

	public void setPrecut(BigDecimal precut) {
		this.precut = precut;
	}

	public String getPreinf() {
		return this.preinf;
	}

	public void setPreinf(String preinf) {
		this.preinf = preinf;
	}

	public String getProsla() {
		return this.prosla;
	}

	public void setProsla(String prosla) {
		this.prosla = prosla;
	}

	public String getRespre() {
		return this.respre;
	}

	public void setRespre(String respre) {
		this.respre = respre;
	}

	public BigDecimal getRibagg() {
		return this.ribagg;
	}

	public void setRibagg(BigDecimal ribagg) {
		this.ribagg = ribagg;
	}

	public BigDecimal getRibcal() {
		return this.ribcal;
	}

	public void setRibcal(BigDecimal ribcal) {
		this.ribcal = ribcal;
	}

	public BigDecimal getRiboepv() {
		return this.riboepv;
	}

	public void setRiboepv(BigDecimal riboepv) {
		this.riboepv = riboepv;
	}

	public BigDecimal getRibpro() {
		return this.ribpro;
	}

	public void setRibpro(BigDecimal ribpro) {
		this.ribpro = ribpro;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getRicdoc() {
		return this.ricdoc;
	}

	public void setRicdoc(Timestamp ricdoc) {
		this.ricdoc = ricdoc;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getRicpre() {
		return this.ricpre;
	}

	public void setRicpre(Timestamp ricpre) {
		this.ricpre = ricpre;
	}

	public String getRidiso() {
		return this.ridiso;
	}

	public void setRidiso(String ridiso) {
		this.ridiso = ridiso;
	}

	public String getSegreta() {
		return this.segreta;
	}

	public void setSegreta(String segreta) {
		this.segreta = segreta;
	}

	public String getSeguen() {
		return this.seguen;
	}

	public void setSeguen(String seguen) {
		this.seguen = seguen;
	}

	public String getSicinc() {
		return this.sicinc;
	}

	public void setSicinc(String sicinc) {
		this.sicinc = sicinc;
	}

	public BigDecimal getStepgar() {
		return this.stepgar;
	}

	public void setStepgar(BigDecimal stepgar) {
		this.stepgar = stepgar;
	}

	public String getSubgar() {
		return this.subgar;
	}

	public void setSubgar(String subgar) {
		this.subgar = subgar;
	}

	public BigDecimal getTaggeff() {
		return this.taggeff;
	}

	public void setTaggeff(BigDecimal taggeff) {
		this.taggeff = taggeff;
	}

	public BigDecimal getTattammescl() {
		return this.tattammescl;
	}

	public void setTattammescl(BigDecimal tattammescl) {
		this.tattammescl = tattammescl;
	}

	public BigDecimal getTattoa() {
		return this.tattoa;
	}

	public void setTattoa(BigDecimal tattoa) {
		this.tattoa = tattoa;
	}

	public BigDecimal getTattog() {
		return this.tattog;
	}

	public void setTattog(BigDecimal tattog) {
		this.tattog = tattog;
	}

	public BigDecimal getTemesi() {
		return this.temesi;
	}

	public void setTemesi(BigDecimal temesi) {
		this.temesi = temesi;
	}

	public String getTerrid() {
		return this.terrid;
	}

	public void setTerrid(String terrid) {
		this.terrid = terrid;
	}

	public BigDecimal getTeutil() {
		return this.teutil;
	}

	public void setTeutil(BigDecimal teutil) {
		this.teutil = teutil;
	}

	public BigDecimal getTiatto() {
		return this.tiatto;
	}

	public void setTiatto(BigDecimal tiatto) {
		this.tiatto = tiatto;
	}

	public BigDecimal getTipgarg() {
		return this.tipgarg;
	}

	public void setTipgarg(BigDecimal tipgarg) {
		this.tipgarg = tipgarg;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getVercan() {
		return this.vercan;
	}

	public void setVercan(Timestamp vercan) {
		this.vercan = vercan;
	}

	public String getVernum() {
		return this.vernum;
	}

	public void setVernum(String vernum) {
		this.vernum = vernum;
	}

}