package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the tecni database table.
 * 
 */
@Entity
@Table(name="tecni")
public class Tecni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String codtec;

	private String albtec;

	private String captec;

	private String cftec;

	private String cgentei;

	private String cittec;

	private String cnatec;

	private String codstu;

	private String cogtei;

	private BigDecimal concapre;

	private Timestamp datalb;

	private Timestamp datmod;

	private Timestamp dfitec;

	private Timestamp dgentei;

	private Timestamp dintec;

	private Timestamp dnatec;

	private String doftec;

	private String ema2tec;

	private String emailpec;

	private String ematec;

	private String faxtec;

	private BigDecimal inctec;

	private String indtec;

	private String iscco1;

	private BigDecimal isccol;

	private String loctec;

	private String mgsflg;

	private BigDecimal naztei;

	private String ncapre;

	private String ncitec;

	private String nometei;

	private String nomtec;

	private String nottec;

	private String pivatec;

	private String proalb;

	private String pronas;

	private String protec;

	private String sextei;

	private BigDecimal syscon;

	private BigDecimal tcapre;

	private String telcel;

	private String teltec;

	private BigDecimal tipalb;

	private String webpwd;

	private String webusr;

	public Tecni() {
	}

	public String getCodtec() {
		return this.codtec;
	}

	public void setCodtec(String codtec) {
		this.codtec = codtec;
	}

	public String getAlbtec() {
		return this.albtec;
	}

	public void setAlbtec(String albtec) {
		this.albtec = albtec;
	}

	public String getCaptec() {
		return this.captec;
	}

	public void setCaptec(String captec) {
		this.captec = captec;
	}

	public String getCftec() {
		return this.cftec;
	}

	public void setCftec(String cftec) {
		this.cftec = cftec;
	}

	public String getCgentei() {
		return this.cgentei;
	}

	public void setCgentei(String cgentei) {
		this.cgentei = cgentei;
	}

	public String getCittec() {
		return this.cittec;
	}

	public void setCittec(String cittec) {
		this.cittec = cittec;
	}

	public String getCnatec() {
		return this.cnatec;
	}

	public void setCnatec(String cnatec) {
		this.cnatec = cnatec;
	}

	public String getCodstu() {
		return this.codstu;
	}

	public void setCodstu(String codstu) {
		this.codstu = codstu;
	}

	public String getCogtei() {
		return this.cogtei;
	}

	public void setCogtei(String cogtei) {
		this.cogtei = cogtei;
	}

	public BigDecimal getConcapre() {
		return this.concapre;
	}

	public void setConcapre(BigDecimal concapre) {
		this.concapre = concapre;
	}

	public Timestamp getDatalb() {
		return this.datalb;
	}

	public void setDatalb(Timestamp datalb) {
		this.datalb = datalb;
	}

	public Timestamp getDatmod() {
		return this.datmod;
	}

	public void setDatmod(Timestamp datmod) {
		this.datmod = datmod;
	}

	public Timestamp getDfitec() {
		return this.dfitec;
	}

	public void setDfitec(Timestamp dfitec) {
		this.dfitec = dfitec;
	}

	public Timestamp getDgentei() {
		return this.dgentei;
	}

	public void setDgentei(Timestamp dgentei) {
		this.dgentei = dgentei;
	}

	public Timestamp getDintec() {
		return this.dintec;
	}

	public void setDintec(Timestamp dintec) {
		this.dintec = dintec;
	}

	public Timestamp getDnatec() {
		return this.dnatec;
	}

	public void setDnatec(Timestamp dnatec) {
		this.dnatec = dnatec;
	}

	public String getDoftec() {
		return this.doftec;
	}

	public void setDoftec(String doftec) {
		this.doftec = doftec;
	}

	public String getEma2tec() {
		return this.ema2tec;
	}

	public void setEma2tec(String ema2tec) {
		this.ema2tec = ema2tec;
	}

	public String getEmailpec() {
		return this.emailpec;
	}

	public void setEmailpec(String emailpec) {
		this.emailpec = emailpec;
	}

	public String getEmatec() {
		return this.ematec;
	}

	public void setEmatec(String ematec) {
		this.ematec = ematec;
	}

	public String getFaxtec() {
		return this.faxtec;
	}

	public void setFaxtec(String faxtec) {
		this.faxtec = faxtec;
	}

	public BigDecimal getInctec() {
		return this.inctec;
	}

	public void setInctec(BigDecimal inctec) {
		this.inctec = inctec;
	}

	public String getIndtec() {
		return this.indtec;
	}

	public void setIndtec(String indtec) {
		this.indtec = indtec;
	}

	public String getIscco1() {
		return this.iscco1;
	}

	public void setIscco1(String iscco1) {
		this.iscco1 = iscco1;
	}

	public BigDecimal getIsccol() {
		return this.isccol;
	}

	public void setIsccol(BigDecimal isccol) {
		this.isccol = isccol;
	}

	public String getLoctec() {
		return this.loctec;
	}

	public void setLoctec(String loctec) {
		this.loctec = loctec;
	}

	public String getMgsflg() {
		return this.mgsflg;
	}

	public void setMgsflg(String mgsflg) {
		this.mgsflg = mgsflg;
	}

	public BigDecimal getNaztei() {
		return this.naztei;
	}

	public void setNaztei(BigDecimal naztei) {
		this.naztei = naztei;
	}

	public String getNcapre() {
		return this.ncapre;
	}

	public void setNcapre(String ncapre) {
		this.ncapre = ncapre;
	}

	public String getNcitec() {
		return this.ncitec;
	}

	public void setNcitec(String ncitec) {
		this.ncitec = ncitec;
	}

	public String getNometei() {
		return this.nometei;
	}

	public void setNometei(String nometei) {
		this.nometei = nometei;
	}

	public String getNomtec() {
		return this.nomtec;
	}

	public void setNomtec(String nomtec) {
		this.nomtec = nomtec;
	}

	public String getNottec() {
		return this.nottec;
	}

	public void setNottec(String nottec) {
		this.nottec = nottec;
	}

	public String getPivatec() {
		return this.pivatec;
	}

	public void setPivatec(String pivatec) {
		this.pivatec = pivatec;
	}

	public String getProalb() {
		return this.proalb;
	}

	public void setProalb(String proalb) {
		this.proalb = proalb;
	}

	public String getPronas() {
		return this.pronas;
	}

	public void setPronas(String pronas) {
		this.pronas = pronas;
	}

	public String getProtec() {
		return this.protec;
	}

	public void setProtec(String protec) {
		this.protec = protec;
	}

	public String getSextei() {
		return this.sextei;
	}

	public void setSextei(String sextei) {
		this.sextei = sextei;
	}

	public BigDecimal getSyscon() {
		return this.syscon;
	}

	public void setSyscon(BigDecimal syscon) {
		this.syscon = syscon;
	}

	public BigDecimal getTcapre() {
		return this.tcapre;
	}

	public void setTcapre(BigDecimal tcapre) {
		this.tcapre = tcapre;
	}

	public String getTelcel() {
		return this.telcel;
	}

	public void setTelcel(String telcel) {
		this.telcel = telcel;
	}

	public String getTeltec() {
		return this.teltec;
	}

	public void setTeltec(String teltec) {
		this.teltec = teltec;
	}

	public BigDecimal getTipalb() {
		return this.tipalb;
	}

	public void setTipalb(BigDecimal tipalb) {
		this.tipalb = tipalb;
	}

	public String getWebpwd() {
		return this.webpwd;
	}

	public void setWebpwd(String webpwd) {
		this.webpwd = webpwd;
	}

	public String getWebusr() {
		return this.webusr;
	}

	public void setWebusr(String webusr) {
		this.webusr = webusr;
	}

}