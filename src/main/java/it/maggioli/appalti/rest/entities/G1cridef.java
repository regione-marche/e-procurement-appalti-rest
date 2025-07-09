package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the g1cridef database table.
 * 
 */
@Entity
@NamedQuery(name="G1cridef.findAll", query="SELECT g FROM G1cridef g")
public class G1cridef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String descri;

	private BigDecimal esponente;

	private BigDecimal formato;

	private BigDecimal formula;

	private BigDecimal idgoevmod;

	private BigDecimal maxpun;

	private BigDecimal modmanu;

	private BigDecimal modpunti;

	private BigDecimal necvan;

	private String ngara;

	private BigDecimal numdeci;

	public G1cridef() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public BigDecimal getEsponente() {
		return this.esponente;
	}

	public void setEsponente(BigDecimal esponente) {
		this.esponente = esponente;
	}

	public BigDecimal getFormato() {
		return this.formato;
	}

	public void setFormato(BigDecimal formato) {
		this.formato = formato;
	}

	public BigDecimal getFormula() {
		return this.formula;
	}

	public void setFormula(BigDecimal formula) {
		this.formula = formula;
	}

	public BigDecimal getIdgoevmod() {
		return this.idgoevmod;
	}

	public void setIdgoevmod(BigDecimal idgoevmod) {
		this.idgoevmod = idgoevmod;
	}

	public BigDecimal getMaxpun() {
		return this.maxpun;
	}

	public void setMaxpun(BigDecimal maxpun) {
		this.maxpun = maxpun;
	}

	public BigDecimal getModmanu() {
		return this.modmanu;
	}

	public void setModmanu(BigDecimal modmanu) {
		this.modmanu = modmanu;
	}

	public BigDecimal getModpunti() {
		return this.modpunti;
	}

	public void setModpunti(BigDecimal modpunti) {
		this.modpunti = modpunti;
	}

	public BigDecimal getNecvan() {
		return this.necvan;
	}

	public void setNecvan(BigDecimal necvan) {
		this.necvan = necvan;
	}

	public String getNgara() {
		return this.ngara;
	}

	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	public BigDecimal getNumdeci() {
		return this.numdeci;
	}

	public void setNumdeci(BigDecimal numdeci) {
		this.numdeci = numdeci;
	}

}