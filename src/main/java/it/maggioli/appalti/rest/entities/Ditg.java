package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.DitgPK;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the ditg database table.
 * 
 */
@Entity
@Table(name="ditg")
public class Ditg implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DitgPK id;

	private BigDecimal abilitaz;

	private String acqauto;

	private BigDecimal acquisizione;

	private String altnot;

	private String ammgar;

	private BigDecimal amminversa;

	private String ammris;

	private String annoff;

	private String anonim;

	private String catimok;

	private String congalt;

	private BigDecimal congmot;

	private String congruo;

	private String coordsic;

	private Timestamp dabilitaz;

	private Timestamp datoff;

	private Timestamp datrdom;

	private Timestamp datreq;

	private Timestamp datrinuncia;

	private Timestamp datroff;

	private Timestamp datrreq;

	private Timestamp dattivaz;

	private Timestamp dinvig;

	private String dittainv;

	private Timestamp dlettrichgiu;

	private Timestamp dprdom;

	private Timestamp dproff;

	private Timestamp drevoca;

	private Timestamp dricezgiu;

	private Timestamp dricind;

	private Timestamp dricrin;

	private Timestamp dscad;

	private Timestamp dsortev;

	private Timestamp dsospe;

	private Timestamp dtermpresgiu;

	private Timestamp dvcommtecn;

	private Timestamp dvcontradd;

	private String estimp;

	private BigDecimal fasgar;

	private BigDecimal iaggiuele;

	private String imeuro;

	private BigDecimal impappd;

	private BigDecimal impcano;

	private BigDecimal impmano;

	private BigDecimal impoff;

	private BigDecimal impoff1;

	private BigDecimal impperm;

	private BigDecimal impsicazi;

	private String inosserv;

	private String invgar;

	private String invoff;

	private String ispeddom;

	private String ispedoff;

	private String ispedreq;

	private String isrilancio;

	private String legdtok;

	private BigDecimal mezdom;

	private BigDecimal mezoff;

	private BigDecimal mezreq;

	private BigDecimal moties;

	private String motrinuncia;

	private String ncomope;

	private String ngaraexp;

	private String nomimo;

	private String notavval;

	private String notpdom;

	private String notpoff;

	private String notpreq;

	private BigDecimal npenalita;

	private String nplettrichgiu;

	private String nprdom;

	private String npricezgiu;

	private String nproff;

	private BigDecimal nprogg;

	private String nprotg;

	private String nprreq;

	private String nspeddom;

	private String nspedoff;

	private String nspedreq;

	private BigDecimal numordinv;

	private BigDecimal numordpl;

	private String nvcommtecn;

	private String nvcontradd;

	private String oggricezgiu;

	private String oradom;

	private String oraoff;

	private String orardom;

	private String orareq;

	private String oraroff;

	private String orarreq;

	private String partgar;

	private BigDecimal percmano;

	private BigDecimal plidom;

	private BigDecimal plioff;

	private BigDecimal puneco;

	private BigDecimal punecorip;

	private BigDecimal punecorip1;

	private BigDecimal puntalt;

	private BigDecimal puntec;

	private BigDecimal puntecrip;

	private BigDecimal puntecrip1;

	private BigDecimal puntprz;

	private String reqmin;

	private String reqtorre;

	private BigDecimal ribauo;

	private BigDecimal ribimp;

	private BigDecimal riboepv;

	private String ricavval;

	private String ricsub;

	private BigDecimal ritdom;

	private BigDecimal ritoff;

	private BigDecimal ritreq;

	private String rtofferta;

	private BigDecimal scrdom;

	private BigDecimal scroff;

	private BigDecimal scrreq;

	private String soaok;

	private String sortinv;

	private BigDecimal staggi;

	private BigDecimal staggiali;

	private BigDecimal statodgueamm;

	private BigDecimal statodguepreq;

	private BigDecimal strin;

	private BigDecimal tiprin;

	public Ditg() {
	}

	public DitgPK getId() {
		return this.id;
	}

	public void setId(DitgPK id) {
		this.id = id;
	}

	public BigDecimal getAbilitaz() {
		return this.abilitaz;
	}

	public void setAbilitaz(BigDecimal abilitaz) {
		this.abilitaz = abilitaz;
	}

	public String getAcqauto() {
		return this.acqauto;
	}

	public void setAcqauto(String acqauto) {
		this.acqauto = acqauto;
	}

	public BigDecimal getAcquisizione() {
		return this.acquisizione;
	}

	public void setAcquisizione(BigDecimal acquisizione) {
		this.acquisizione = acquisizione;
	}

	public String getAltnot() {
		return this.altnot;
	}

	public void setAltnot(String altnot) {
		this.altnot = altnot;
	}

	public String getAmmgar() {
		return this.ammgar;
	}

	public void setAmmgar(String ammgar) {
		this.ammgar = ammgar;
	}

	public BigDecimal getAmminversa() {
		return this.amminversa;
	}

	public void setAmminversa(BigDecimal amminversa) {
		this.amminversa = amminversa;
	}

	public String getAmmris() {
		return this.ammris;
	}

	public void setAmmris(String ammris) {
		this.ammris = ammris;
	}

	public String getAnnoff() {
		return this.annoff;
	}

	public void setAnnoff(String annoff) {
		this.annoff = annoff;
	}

	public String getAnonim() {
		return this.anonim;
	}

	public void setAnonim(String anonim) {
		this.anonim = anonim;
	}

	public String getCatimok() {
		return this.catimok;
	}

	public void setCatimok(String catimok) {
		this.catimok = catimok;
	}

	public String getCongalt() {
		return this.congalt;
	}

	public void setCongalt(String congalt) {
		this.congalt = congalt;
	}

	public BigDecimal getCongmot() {
		return this.congmot;
	}

	public void setCongmot(BigDecimal congmot) {
		this.congmot = congmot;
	}

	public String getCongruo() {
		return this.congruo;
	}

	public void setCongruo(String congruo) {
		this.congruo = congruo;
	}

	public String getCoordsic() {
		return this.coordsic;
	}

	public void setCoordsic(String coordsic) {
		this.coordsic = coordsic;
	}

	public Timestamp getDabilitaz() {
		return this.dabilitaz;
	}

	public void setDabilitaz(Timestamp dabilitaz) {
		this.dabilitaz = dabilitaz;
	}

	public Timestamp getDatoff() {
		return this.datoff;
	}

	public void setDatoff(Timestamp datoff) {
		this.datoff = datoff;
	}

	public Timestamp getDatrdom() {
		return this.datrdom;
	}

	public void setDatrdom(Timestamp datrdom) {
		this.datrdom = datrdom;
	}

	public Timestamp getDatreq() {
		return this.datreq;
	}

	public void setDatreq(Timestamp datreq) {
		this.datreq = datreq;
	}

	public Timestamp getDatrinuncia() {
		return this.datrinuncia;
	}

	public void setDatrinuncia(Timestamp datrinuncia) {
		this.datrinuncia = datrinuncia;
	}

	public Timestamp getDatroff() {
		return this.datroff;
	}

	public void setDatroff(Timestamp datroff) {
		this.datroff = datroff;
	}

	public Timestamp getDatrreq() {
		return this.datrreq;
	}

	public void setDatrreq(Timestamp datrreq) {
		this.datrreq = datrreq;
	}

	public Timestamp getDattivaz() {
		return this.dattivaz;
	}

	public void setDattivaz(Timestamp dattivaz) {
		this.dattivaz = dattivaz;
	}

	public Timestamp getDinvig() {
		return this.dinvig;
	}

	public void setDinvig(Timestamp dinvig) {
		this.dinvig = dinvig;
	}

	public String getDittainv() {
		return this.dittainv;
	}

	public void setDittainv(String dittainv) {
		this.dittainv = dittainv;
	}

	public Timestamp getDlettrichgiu() {
		return this.dlettrichgiu;
	}

	public void setDlettrichgiu(Timestamp dlettrichgiu) {
		this.dlettrichgiu = dlettrichgiu;
	}

	public Timestamp getDprdom() {
		return this.dprdom;
	}

	public void setDprdom(Timestamp dprdom) {
		this.dprdom = dprdom;
	}

	public Timestamp getDproff() {
		return this.dproff;
	}

	public void setDproff(Timestamp dproff) {
		this.dproff = dproff;
	}

	public Timestamp getDrevoca() {
		return this.drevoca;
	}

	public void setDrevoca(Timestamp drevoca) {
		this.drevoca = drevoca;
	}

	public Timestamp getDricezgiu() {
		return this.dricezgiu;
	}

	public void setDricezgiu(Timestamp dricezgiu) {
		this.dricezgiu = dricezgiu;
	}

	public Timestamp getDricind() {
		return this.dricind;
	}

	public void setDricind(Timestamp dricind) {
		this.dricind = dricind;
	}

	public Timestamp getDricrin() {
		return this.dricrin;
	}

	public void setDricrin(Timestamp dricrin) {
		this.dricrin = dricrin;
	}

	public Timestamp getDscad() {
		return this.dscad;
	}

	public void setDscad(Timestamp dscad) {
		this.dscad = dscad;
	}

	public Timestamp getDsortev() {
		return this.dsortev;
	}

	public void setDsortev(Timestamp dsortev) {
		this.dsortev = dsortev;
	}

	public Timestamp getDsospe() {
		return this.dsospe;
	}

	public void setDsospe(Timestamp dsospe) {
		this.dsospe = dsospe;
	}

	public Timestamp getDtermpresgiu() {
		return this.dtermpresgiu;
	}

	public void setDtermpresgiu(Timestamp dtermpresgiu) {
		this.dtermpresgiu = dtermpresgiu;
	}

	public Timestamp getDvcommtecn() {
		return this.dvcommtecn;
	}

	public void setDvcommtecn(Timestamp dvcommtecn) {
		this.dvcommtecn = dvcommtecn;
	}

	public Timestamp getDvcontradd() {
		return this.dvcontradd;
	}

	public void setDvcontradd(Timestamp dvcontradd) {
		this.dvcontradd = dvcontradd;
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

	public BigDecimal getIaggiuele() {
		return this.iaggiuele;
	}

	public void setIaggiuele(BigDecimal iaggiuele) {
		this.iaggiuele = iaggiuele;
	}

	public String getImeuro() {
		return this.imeuro;
	}

	public void setImeuro(String imeuro) {
		this.imeuro = imeuro;
	}

	public BigDecimal getImpappd() {
		return this.impappd;
	}

	public void setImpappd(BigDecimal impappd) {
		this.impappd = impappd;
	}

	public BigDecimal getImpcano() {
		return this.impcano;
	}

	public void setImpcano(BigDecimal impcano) {
		this.impcano = impcano;
	}

	public BigDecimal getImpmano() {
		return this.impmano;
	}

	public void setImpmano(BigDecimal impmano) {
		this.impmano = impmano;
	}

	public BigDecimal getImpoff() {
		return this.impoff;
	}

	public void setImpoff(BigDecimal impoff) {
		this.impoff = impoff;
	}

	public BigDecimal getImpoff1() {
		return this.impoff1;
	}

	public void setImpoff1(BigDecimal impoff1) {
		this.impoff1 = impoff1;
	}

	public BigDecimal getImpperm() {
		return this.impperm;
	}

	public void setImpperm(BigDecimal impperm) {
		this.impperm = impperm;
	}

	public BigDecimal getImpsicazi() {
		return this.impsicazi;
	}

	public void setImpsicazi(BigDecimal impsicazi) {
		this.impsicazi = impsicazi;
	}

	public String getInosserv() {
		return this.inosserv;
	}

	public void setInosserv(String inosserv) {
		this.inosserv = inosserv;
	}

	public String getInvgar() {
		return this.invgar;
	}

	public void setInvgar(String invgar) {
		this.invgar = invgar;
	}

	public String getInvoff() {
		return this.invoff;
	}

	public void setInvoff(String invoff) {
		this.invoff = invoff;
	}

	public String getIspeddom() {
		return this.ispeddom;
	}

	public void setIspeddom(String ispeddom) {
		this.ispeddom = ispeddom;
	}

	public String getIspedoff() {
		return this.ispedoff;
	}

	public void setIspedoff(String ispedoff) {
		this.ispedoff = ispedoff;
	}

	public String getIspedreq() {
		return this.ispedreq;
	}

	public void setIspedreq(String ispedreq) {
		this.ispedreq = ispedreq;
	}

	public String getIsrilancio() {
		return this.isrilancio;
	}

	public void setIsrilancio(String isrilancio) {
		this.isrilancio = isrilancio;
	}

	public String getLegdtok() {
		return this.legdtok;
	}

	public void setLegdtok(String legdtok) {
		this.legdtok = legdtok;
	}

	public BigDecimal getMezdom() {
		return this.mezdom;
	}

	public void setMezdom(BigDecimal mezdom) {
		this.mezdom = mezdom;
	}

	public BigDecimal getMezoff() {
		return this.mezoff;
	}

	public void setMezoff(BigDecimal mezoff) {
		this.mezoff = mezoff;
	}

	public BigDecimal getMezreq() {
		return this.mezreq;
	}

	public void setMezreq(BigDecimal mezreq) {
		this.mezreq = mezreq;
	}

	public BigDecimal getMoties() {
		return this.moties;
	}

	public void setMoties(BigDecimal moties) {
		this.moties = moties;
	}

	public String getMotrinuncia() {
		return this.motrinuncia;
	}

	public void setMotrinuncia(String motrinuncia) {
		this.motrinuncia = motrinuncia;
	}

	public String getNcomope() {
		return this.ncomope;
	}

	public void setNcomope(String ncomope) {
		this.ncomope = ncomope;
	}

	public String getNgaraexp() {
		return this.ngaraexp;
	}

	public void setNgaraexp(String ngaraexp) {
		this.ngaraexp = ngaraexp;
	}

	public String getNomimo() {
		return this.nomimo;
	}

	public void setNomimo(String nomimo) {
		this.nomimo = nomimo;
	}

	public String getNotavval() {
		return this.notavval;
	}

	public void setNotavval(String notavval) {
		this.notavval = notavval;
	}

	public String getNotpdom() {
		return this.notpdom;
	}

	public void setNotpdom(String notpdom) {
		this.notpdom = notpdom;
	}

	public String getNotpoff() {
		return this.notpoff;
	}

	public void setNotpoff(String notpoff) {
		this.notpoff = notpoff;
	}

	public String getNotpreq() {
		return this.notpreq;
	}

	public void setNotpreq(String notpreq) {
		this.notpreq = notpreq;
	}

	public BigDecimal getNpenalita() {
		return this.npenalita;
	}

	public void setNpenalita(BigDecimal npenalita) {
		this.npenalita = npenalita;
	}

	public String getNplettrichgiu() {
		return this.nplettrichgiu;
	}

	public void setNplettrichgiu(String nplettrichgiu) {
		this.nplettrichgiu = nplettrichgiu;
	}

	public String getNprdom() {
		return this.nprdom;
	}

	public void setNprdom(String nprdom) {
		this.nprdom = nprdom;
	}

	public String getNpricezgiu() {
		return this.npricezgiu;
	}

	public void setNpricezgiu(String npricezgiu) {
		this.npricezgiu = npricezgiu;
	}

	public String getNproff() {
		return this.nproff;
	}

	public void setNproff(String nproff) {
		this.nproff = nproff;
	}

	public BigDecimal getNprogg() {
		return this.nprogg;
	}

	public void setNprogg(BigDecimal nprogg) {
		this.nprogg = nprogg;
	}

	public String getNprotg() {
		return this.nprotg;
	}

	public void setNprotg(String nprotg) {
		this.nprotg = nprotg;
	}

	public String getNprreq() {
		return this.nprreq;
	}

	public void setNprreq(String nprreq) {
		this.nprreq = nprreq;
	}

	public String getNspeddom() {
		return this.nspeddom;
	}

	public void setNspeddom(String nspeddom) {
		this.nspeddom = nspeddom;
	}

	public String getNspedoff() {
		return this.nspedoff;
	}

	public void setNspedoff(String nspedoff) {
		this.nspedoff = nspedoff;
	}

	public String getNspedreq() {
		return this.nspedreq;
	}

	public void setNspedreq(String nspedreq) {
		this.nspedreq = nspedreq;
	}

	public BigDecimal getNumordinv() {
		return this.numordinv;
	}

	public void setNumordinv(BigDecimal numordinv) {
		this.numordinv = numordinv;
	}

	public BigDecimal getNumordpl() {
		return this.numordpl;
	}

	public void setNumordpl(BigDecimal numordpl) {
		this.numordpl = numordpl;
	}

	public String getNvcommtecn() {
		return this.nvcommtecn;
	}

	public void setNvcommtecn(String nvcommtecn) {
		this.nvcommtecn = nvcommtecn;
	}

	public String getNvcontradd() {
		return this.nvcontradd;
	}

	public void setNvcontradd(String nvcontradd) {
		this.nvcontradd = nvcontradd;
	}

	public String getOggricezgiu() {
		return this.oggricezgiu;
	}

	public void setOggricezgiu(String oggricezgiu) {
		this.oggricezgiu = oggricezgiu;
	}

	public String getOradom() {
		return this.oradom;
	}

	public void setOradom(String oradom) {
		this.oradom = oradom;
	}

	public String getOraoff() {
		return this.oraoff;
	}

	public void setOraoff(String oraoff) {
		this.oraoff = oraoff;
	}

	public String getOrardom() {
		return this.orardom;
	}

	public void setOrardom(String orardom) {
		this.orardom = orardom;
	}

	public String getOrareq() {
		return this.orareq;
	}

	public void setOrareq(String orareq) {
		this.orareq = orareq;
	}

	public String getOraroff() {
		return this.oraroff;
	}

	public void setOraroff(String oraroff) {
		this.oraroff = oraroff;
	}

	public String getOrarreq() {
		return this.orarreq;
	}

	public void setOrarreq(String orarreq) {
		this.orarreq = orarreq;
	}

	public String getPartgar() {
		return this.partgar;
	}

	public void setPartgar(String partgar) {
		this.partgar = partgar;
	}

	public BigDecimal getPercmano() {
		return this.percmano;
	}

	public void setPercmano(BigDecimal percmano) {
		this.percmano = percmano;
	}

	public BigDecimal getPlidom() {
		return this.plidom;
	}

	public void setPlidom(BigDecimal plidom) {
		this.plidom = plidom;
	}

	public BigDecimal getPlioff() {
		return this.plioff;
	}

	public void setPlioff(BigDecimal plioff) {
		this.plioff = plioff;
	}

	public BigDecimal getPuneco() {
		return this.puneco;
	}

	public void setPuneco(BigDecimal puneco) {
		this.puneco = puneco;
	}

	public BigDecimal getPunecorip() {
		return this.punecorip;
	}

	public void setPunecorip(BigDecimal punecorip) {
		this.punecorip = punecorip;
	}

	public BigDecimal getPunecorip1() {
		return this.punecorip1;
	}

	public void setPunecorip1(BigDecimal punecorip1) {
		this.punecorip1 = punecorip1;
	}

	public BigDecimal getPuntalt() {
		return this.puntalt;
	}

	public void setPuntalt(BigDecimal puntalt) {
		this.puntalt = puntalt;
	}

	public BigDecimal getPuntec() {
		return this.puntec;
	}

	public void setPuntec(BigDecimal puntec) {
		this.puntec = puntec;
	}

	public BigDecimal getPuntecrip() {
		return this.puntecrip;
	}

	public void setPuntecrip(BigDecimal puntecrip) {
		this.puntecrip = puntecrip;
	}

	public BigDecimal getPuntecrip1() {
		return this.puntecrip1;
	}

	public void setPuntecrip1(BigDecimal puntecrip1) {
		this.puntecrip1 = puntecrip1;
	}

	public BigDecimal getPuntprz() {
		return this.puntprz;
	}

	public void setPuntprz(BigDecimal puntprz) {
		this.puntprz = puntprz;
	}

	public String getReqmin() {
		return this.reqmin;
	}

	public void setReqmin(String reqmin) {
		this.reqmin = reqmin;
	}

	public String getReqtorre() {
		return this.reqtorre;
	}

	public void setReqtorre(String reqtorre) {
		this.reqtorre = reqtorre;
	}

	public BigDecimal getRibauo() {
		return this.ribauo;
	}

	public void setRibauo(BigDecimal ribauo) {
		this.ribauo = ribauo;
	}

	public BigDecimal getRibimp() {
		return this.ribimp;
	}

	public void setRibimp(BigDecimal ribimp) {
		this.ribimp = ribimp;
	}

	public BigDecimal getRiboepv() {
		return this.riboepv;
	}

	public void setRiboepv(BigDecimal riboepv) {
		this.riboepv = riboepv;
	}

	public String getRicavval() {
		return this.ricavval;
	}

	public void setRicavval(String ricavval) {
		this.ricavval = ricavval;
	}

	public String getRicsub() {
		return this.ricsub;
	}

	public void setRicsub(String ricsub) {
		this.ricsub = ricsub;
	}

	public BigDecimal getRitdom() {
		return this.ritdom;
	}

	public void setRitdom(BigDecimal ritdom) {
		this.ritdom = ritdom;
	}

	public BigDecimal getRitoff() {
		return this.ritoff;
	}

	public void setRitoff(BigDecimal ritoff) {
		this.ritoff = ritoff;
	}

	public BigDecimal getRitreq() {
		return this.ritreq;
	}

	public void setRitreq(BigDecimal ritreq) {
		this.ritreq = ritreq;
	}

	public String getRtofferta() {
		return this.rtofferta;
	}

	public void setRtofferta(String rtofferta) {
		this.rtofferta = rtofferta;
	}

	public BigDecimal getScrdom() {
		return this.scrdom;
	}

	public void setScrdom(BigDecimal scrdom) {
		this.scrdom = scrdom;
	}

	public BigDecimal getScroff() {
		return this.scroff;
	}

	public void setScroff(BigDecimal scroff) {
		this.scroff = scroff;
	}

	public BigDecimal getScrreq() {
		return this.scrreq;
	}

	public void setScrreq(BigDecimal scrreq) {
		this.scrreq = scrreq;
	}

	public String getSoaok() {
		return this.soaok;
	}

	public void setSoaok(String soaok) {
		this.soaok = soaok;
	}

	public String getSortinv() {
		return this.sortinv;
	}

	public void setSortinv(String sortinv) {
		this.sortinv = sortinv;
	}

	public BigDecimal getStaggi() {
		return this.staggi;
	}

	public void setStaggi(BigDecimal staggi) {
		this.staggi = staggi;
	}

	public BigDecimal getStaggiali() {
		return this.staggiali;
	}

	public void setStaggiali(BigDecimal staggiali) {
		this.staggiali = staggiali;
	}

	public BigDecimal getStatodgueamm() {
		return this.statodgueamm;
	}

	public void setStatodgueamm(BigDecimal statodgueamm) {
		this.statodgueamm = statodgueamm;
	}

	public BigDecimal getStatodguepreq() {
		return this.statodguepreq;
	}

	public void setStatodguepreq(BigDecimal statodguepreq) {
		this.statodguepreq = statodguepreq;
	}

	public BigDecimal getStrin() {
		return this.strin;
	}

	public void setStrin(BigDecimal strin) {
		this.strin = strin;
	}

	public BigDecimal getTiprin() {
		return this.tiprin;
	}

	public void setTiprin(BigDecimal tiprin) {
		this.tiprin = tiprin;
	}

}