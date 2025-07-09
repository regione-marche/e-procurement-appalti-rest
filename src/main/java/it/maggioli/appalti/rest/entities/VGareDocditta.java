package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the v_gare_docditta database table.
 * 
 */
@Entity
@Table(name="v_gare_docditta")
public class VGareDocditta implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal busta;

	private String bustadesc;

	private BigDecimal bustaord;

	private String codgar;

	private String codimp;

	private BigDecimal contestoval;

	private Timestamp datadis;

	private Timestamp datalettura;

	private Timestamp datapub;

	private Timestamp datarilascio;

	private Timestamp datascadenza;

	private String descrizione;

	private String dignomdoc;

	private String docannul;

	private String doctel;

	private BigDecimal fasele;

	private String firmacheck;

	private Timestamp firmacheckts;

	private String gentel;

	@Id	
	private BigDecimal iddocdg;

	private String idprg;

	private String isarchi;

	private BigDecimal modfirma;

	private String ngara;

	private BigDecimal norddoci;

	private String notedoci;

	private BigDecimal numord;

	private String obbligatorio;

	private String orarilascio;

	private BigDecimal proveni;

	private BigDecimal reqcap;

	private BigDecimal seztec;

	private BigDecimal situazdoci;

	private BigDecimal sysconlet;

	private BigDecimal tipodoc;

	public VGareDocditta() {
	}

	public BigDecimal getBusta() {
		return this.busta;
	}

	public void setBusta(BigDecimal busta) {
		this.busta = busta;
	}

	public String getBustadesc() {
		return this.bustadesc;
	}

	public void setBustadesc(String bustadesc) {
		this.bustadesc = bustadesc;
	}

	public BigDecimal getBustaord() {
		return this.bustaord;
	}

	public void setBustaord(BigDecimal bustaord) {
		this.bustaord = bustaord;
	}

	public String getCodgar() {
		return this.codgar;
	}

	public void setCodgar(String codgar) {
		this.codgar = codgar;
	}

	public String getCodimp() {
		return this.codimp;
	}

	public void setCodimp(String codimp) {
		this.codimp = codimp;
	}

	public BigDecimal getContestoval() {
		return this.contestoval;
	}

	public void setContestoval(BigDecimal contestoval) {
		this.contestoval = contestoval;
	}

	public Timestamp getDatadis() {
		return this.datadis;
	}

	public void setDatadis(Timestamp datadis) {
		this.datadis = datadis;
	}

	public Timestamp getDatalettura() {
		return this.datalettura;
	}

	public void setDatalettura(Timestamp datalettura) {
		this.datalettura = datalettura;
	}

	public Timestamp getDatapub() {
		return this.datapub;
	}

	public void setDatapub(Timestamp datapub) {
		this.datapub = datapub;
	}

	public Timestamp getDatarilascio() {
		return this.datarilascio;
	}

	public void setDatarilascio(Timestamp datarilascio) {
		this.datarilascio = datarilascio;
	}

	public Timestamp getDatascadenza() {
		return this.datascadenza;
	}

	public void setDatascadenza(Timestamp datascadenza) {
		this.datascadenza = datascadenza;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDignomdoc() {
		return this.dignomdoc;
	}

	public void setDignomdoc(String dignomdoc) {
		this.dignomdoc = dignomdoc;
	}

	public String getDocannul() {
		return this.docannul;
	}

	public void setDocannul(String docannul) {
		this.docannul = docannul;
	}

	public String getDoctel() {
		return this.doctel;
	}

	public void setDoctel(String doctel) {
		this.doctel = doctel;
	}

	public BigDecimal getFasele() {
		return this.fasele;
	}

	public void setFasele(BigDecimal fasele) {
		this.fasele = fasele;
	}

	public String getFirmacheck() {
		return this.firmacheck;
	}

	public void setFirmacheck(String firmacheck) {
		this.firmacheck = firmacheck;
	}

	public Timestamp getFirmacheckts() {
		return this.firmacheckts;
	}

	public void setFirmacheckts(Timestamp firmacheckts) {
		this.firmacheckts = firmacheckts;
	}

	public String getGentel() {
		return this.gentel;
	}

	public void setGentel(String gentel) {
		this.gentel = gentel;
	}

	public BigDecimal getIddocdg() {
		return this.iddocdg;
	}

	public void setIddocdg(BigDecimal iddocdg) {
		this.iddocdg = iddocdg;
	}

	public String getIdprg() {
		return this.idprg;
	}

	public void setIdprg(String idprg) {
		this.idprg = idprg;
	}

	public String getIsarchi() {
		return this.isarchi;
	}

	public void setIsarchi(String isarchi) {
		this.isarchi = isarchi;
	}

	public BigDecimal getModfirma() {
		return this.modfirma;
	}

	public void setModfirma(BigDecimal modfirma) {
		this.modfirma = modfirma;
	}

	public String getNgara() {
		return this.ngara;
	}

	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	public BigDecimal getNorddoci() {
		return this.norddoci;
	}

	public void setNorddoci(BigDecimal norddoci) {
		this.norddoci = norddoci;
	}

	public String getNotedoci() {
		return this.notedoci;
	}

	public void setNotedoci(String notedoci) {
		this.notedoci = notedoci;
	}

	public BigDecimal getNumord() {
		return this.numord;
	}

	public void setNumord(BigDecimal numord) {
		this.numord = numord;
	}

	public String getObbligatorio() {
		return this.obbligatorio;
	}

	public void setObbligatorio(String obbligatorio) {
		this.obbligatorio = obbligatorio;
	}

	public String getOrarilascio() {
		return this.orarilascio;
	}

	public void setOrarilascio(String orarilascio) {
		this.orarilascio = orarilascio;
	}

	public BigDecimal getProveni() {
		return this.proveni;
	}

	public void setProveni(BigDecimal proveni) {
		this.proveni = proveni;
	}

	public BigDecimal getReqcap() {
		return this.reqcap;
	}

	public void setReqcap(BigDecimal reqcap) {
		this.reqcap = reqcap;
	}

	public BigDecimal getSeztec() {
		return this.seztec;
	}

	public void setSeztec(BigDecimal seztec) {
		this.seztec = seztec;
	}

	public BigDecimal getSituazdoci() {
		return this.situazdoci;
	}

	public void setSituazdoci(BigDecimal situazdoci) {
		this.situazdoci = situazdoci;
	}

	public BigDecimal getSysconlet() {
		return this.sysconlet;
	}

	public void setSysconlet(BigDecimal sysconlet) {
		this.sysconlet = sysconlet;
	}

	public BigDecimal getTipodoc() {
		return this.tipodoc;
	}

	public void setTipodoc(BigDecimal tipodoc) {
		this.tipodoc = tipodoc;
	}

}