package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.DocumgaraPK;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the documgara database table.
 * 
 */
@Entity
@NamedQuery(name="Documgara.findAll", query="SELECT d FROM Documgara d")
@Table(name="documgara")
public class Documgara implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DocumgaraPK id;

	private String allmail;

	private BigDecimal busta;

	private String codcat;

	private BigDecimal contestoval;

	private Timestamp dataprov;

	private Timestamp datarilascio;

	private Timestamp datascadenza;

	private String descrizione;

	private String dittaagg;

	private BigDecimal durata;

	private BigDecimal fasele;

	private BigDecimal fasgar;

	private String gentel;

	private BigDecimal gruppo;

	private BigDecimal iddocdg;

	private String idprg;

	private String idstampa;

	private String isarchi;

	private BigDecimal modfirma;

	private String ngara;

	private BigDecimal numord;

	private String numprov;

	private String obbligatorio;

	private BigDecimal reqcap;

	private BigDecimal seztec;

	private BigDecimal statodoc;

	private BigDecimal tipodoc;

	private BigDecimal tipologia;

	private String urldoc;

	private BigDecimal valenza;

	public Documgara() {
	}

	public DocumgaraPK getId() {
		return this.id;
	}

	public void setId(DocumgaraPK id) {
		this.id = id;
	}

	public String getAllmail() {
		return this.allmail;
	}

	public void setAllmail(String allmail) {
		this.allmail = allmail;
	}

	public BigDecimal getBusta() {
		return this.busta;
	}

	public void setBusta(BigDecimal busta) {
		this.busta = busta;
	}

	public String getCodcat() {
		return this.codcat;
	}

	public void setCodcat(String codcat) {
		this.codcat = codcat;
	}

	public BigDecimal getContestoval() {
		return this.contestoval;
	}

	public void setContestoval(BigDecimal contestoval) {
		this.contestoval = contestoval;
	}

	public Timestamp getDataprov() {
		return this.dataprov;
	}

	public void setDataprov(Timestamp dataprov) {
		this.dataprov = dataprov;
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

	public String getDittaagg() {
		return this.dittaagg;
	}

	public void setDittaagg(String dittaagg) {
		this.dittaagg = dittaagg;
	}

	public BigDecimal getDurata() {
		return this.durata;
	}

	public void setDurata(BigDecimal durata) {
		this.durata = durata;
	}

	public BigDecimal getFasele() {
		return this.fasele;
	}

	public void setFasele(BigDecimal fasele) {
		this.fasele = fasele;
	}

	public BigDecimal getFasgar() {
		return this.fasgar;
	}

	public void setFasgar(BigDecimal fasgar) {
		this.fasgar = fasgar;
	}

	public String getGentel() {
		return this.gentel;
	}

	public void setGentel(String gentel) {
		this.gentel = gentel;
	}

	public BigDecimal getGruppo() {
		return this.gruppo;
	}

	public void setGruppo(BigDecimal gruppo) {
		this.gruppo = gruppo;
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

	public String getIdstampa() {
		return this.idstampa;
	}

	public void setIdstampa(String idstampa) {
		this.idstampa = idstampa;
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

	public BigDecimal getNumord() {
		return this.numord;
	}

	public void setNumord(BigDecimal numord) {
		this.numord = numord;
	}

	public String getNumprov() {
		return this.numprov;
	}

	public void setNumprov(String numprov) {
		this.numprov = numprov;
	}

	public String getObbligatorio() {
		return this.obbligatorio;
	}

	public void setObbligatorio(String obbligatorio) {
		this.obbligatorio = obbligatorio;
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

	public BigDecimal getStatodoc() {
		return this.statodoc;
	}

	public void setStatodoc(BigDecimal statodoc) {
		this.statodoc = statodoc;
	}

	public BigDecimal getTipodoc() {
		return this.tipodoc;
	}

	public void setTipodoc(BigDecimal tipodoc) {
		this.tipodoc = tipodoc;
	}

	public BigDecimal getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(BigDecimal tipologia) {
		this.tipologia = tipologia;
	}

	public String getUrldoc() {
		return this.urldoc;
	}

	public void setUrldoc(String urldoc) {
		this.urldoc = urldoc;
	}

	public BigDecimal getValenza() {
		return this.valenza;
	}

	public void setValenza(BigDecimal valenza) {
		this.valenza = valenza;
	}

}