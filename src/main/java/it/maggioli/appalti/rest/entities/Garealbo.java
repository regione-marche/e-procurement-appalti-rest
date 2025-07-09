package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.GarealboPK;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the garealbo database table.
 * 
 */
@Entity
@NamedQuery(name="Garealbo.findAll", query="SELECT g FROM Garealbo g")
public class Garealbo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GarealboPK id;

	private String aggnumord;

	private BigDecimal apprin;

	private BigDecimal cadenzaman;

	private String coordsic;

	private BigDecimal ctrlaggiu;

	private Timestamp ctrldata;

	private String ctrlele;

	private BigDecimal ctrlgg;

	private BigDecimal ctrlimp;

	private String ctrlimpga;

	private String ctrlprov;

	private Timestamp dinizval;

	private Timestamp dtermval;

	private BigDecimal gpreavrin;

	private String isarchi;

	private String iscrirt;

	private String oggetto;

	private String periodo;

	private String pubope;

	private String reqtorre;

	private BigDecimal rifiscr;

	private BigDecimal tcongelamento;

	private BigDecimal tipoalgo;

	private BigDecimal tipoclass;

	private String tipoele;

	private BigDecimal tipologia;

	private BigDecimal valiscr;

	public Garealbo() {
	}

	public GarealboPK getId() {
		return this.id;
	}

	public void setId(GarealboPK id) {
		this.id = id;
	}

	public String getAggnumord() {
		return this.aggnumord;
	}

	public void setAggnumord(String aggnumord) {
		this.aggnumord = aggnumord;
	}

	public BigDecimal getApprin() {
		return this.apprin;
	}

	public void setApprin(BigDecimal apprin) {
		this.apprin = apprin;
	}

	public BigDecimal getCadenzaman() {
		return this.cadenzaman;
	}

	public void setCadenzaman(BigDecimal cadenzaman) {
		this.cadenzaman = cadenzaman;
	}

	public String getCoordsic() {
		return this.coordsic;
	}

	public void setCoordsic(String coordsic) {
		this.coordsic = coordsic;
	}

	public BigDecimal getCtrlaggiu() {
		return this.ctrlaggiu;
	}

	public void setCtrlaggiu(BigDecimal ctrlaggiu) {
		this.ctrlaggiu = ctrlaggiu;
	}

	public Timestamp getCtrldata() {
		return this.ctrldata;
	}

	public void setCtrldata(Timestamp ctrldata) {
		this.ctrldata = ctrldata;
	}

	public String getCtrlele() {
		return this.ctrlele;
	}

	public void setCtrlele(String ctrlele) {
		this.ctrlele = ctrlele;
	}

	public BigDecimal getCtrlgg() {
		return this.ctrlgg;
	}

	public void setCtrlgg(BigDecimal ctrlgg) {
		this.ctrlgg = ctrlgg;
	}

	public BigDecimal getCtrlimp() {
		return this.ctrlimp;
	}

	public void setCtrlimp(BigDecimal ctrlimp) {
		this.ctrlimp = ctrlimp;
	}

	public String getCtrlimpga() {
		return this.ctrlimpga;
	}

	public void setCtrlimpga(String ctrlimpga) {
		this.ctrlimpga = ctrlimpga;
	}

	public String getCtrlprov() {
		return this.ctrlprov;
	}

	public void setCtrlprov(String ctrlprov) {
		this.ctrlprov = ctrlprov;
	}

	public Timestamp getDinizval() {
		return this.dinizval;
	}

	public void setDinizval(Timestamp dinizval) {
		this.dinizval = dinizval;
	}

	public Timestamp getDtermval() {
		return this.dtermval;
	}

	public void setDtermval(Timestamp dtermval) {
		this.dtermval = dtermval;
	}

	public BigDecimal getGpreavrin() {
		return this.gpreavrin;
	}

	public void setGpreavrin(BigDecimal gpreavrin) {
		this.gpreavrin = gpreavrin;
	}

	public String getIsarchi() {
		return this.isarchi;
	}

	public void setIsarchi(String isarchi) {
		this.isarchi = isarchi;
	}

	public String getIscrirt() {
		return this.iscrirt;
	}

	public void setIscrirt(String iscrirt) {
		this.iscrirt = iscrirt;
	}

	public String getOggetto() {
		return this.oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getPubope() {
		return this.pubope;
	}

	public void setPubope(String pubope) {
		this.pubope = pubope;
	}

	public String getReqtorre() {
		return this.reqtorre;
	}

	public void setReqtorre(String reqtorre) {
		this.reqtorre = reqtorre;
	}

	public BigDecimal getRifiscr() {
		return this.rifiscr;
	}

	public void setRifiscr(BigDecimal rifiscr) {
		this.rifiscr = rifiscr;
	}

	public BigDecimal getTcongelamento() {
		return this.tcongelamento;
	}

	public void setTcongelamento(BigDecimal tcongelamento) {
		this.tcongelamento = tcongelamento;
	}

	public BigDecimal getTipoalgo() {
		return this.tipoalgo;
	}

	public void setTipoalgo(BigDecimal tipoalgo) {
		this.tipoalgo = tipoalgo;
	}

	public BigDecimal getTipoclass() {
		return this.tipoclass;
	}

	public void setTipoclass(BigDecimal tipoclass) {
		this.tipoclass = tipoclass;
	}

	public String getTipoele() {
		return this.tipoele;
	}

	public void setTipoele(String tipoele) {
		this.tipoele = tipoele;
	}

	public BigDecimal getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(BigDecimal tipologia) {
		this.tipologia = tipologia;
	}

	public BigDecimal getValiscr() {
		return this.valiscr;
	}

	public void setValiscr(BigDecimal valiscr) {
		this.valiscr = valiscr;
	}

}