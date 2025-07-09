package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.DpunCgPK;

import java.math.BigDecimal;


/**
 * The persistent class for the dpun_cg database table.
 * 
 */
@Entity
@Table(name="dpun_cg")
public class DpunCg implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DpunCgPK id;

	private BigDecimal coeffi;

	private BigDecimal coeffirip;

	private BigDecimal coeffirip1;

	private BigDecimal impoff;

	private BigDecimal punteg;

	private BigDecimal puntegrip;

	private BigDecimal puntegrip1;

	public DpunCg() {
	}

	public DpunCgPK getId() {
		return this.id;
	}

	public void setId(DpunCgPK id) {
		this.id = id;
	}

	public BigDecimal getCoeffi() {
		return this.coeffi;
	}

	public void setCoeffi(BigDecimal coeffi) {
		this.coeffi = coeffi;
	}

	public BigDecimal getCoeffirip() {
		return this.coeffirip;
	}

	public void setCoeffirip(BigDecimal coeffirip) {
		this.coeffirip = coeffirip;
	}

	public BigDecimal getCoeffirip1() {
		return this.coeffirip1;
	}

	public void setCoeffirip1(BigDecimal coeffirip1) {
		this.coeffirip1 = coeffirip1;
	}

	public BigDecimal getImpoff() {
		return this.impoff;
	}

	public void setImpoff(BigDecimal impoff) {
		this.impoff = impoff;
	}

	public BigDecimal getPunteg() {
		return this.punteg;
	}

	public void setPunteg(BigDecimal punteg) {
		this.punteg = punteg;
	}

	public BigDecimal getPuntegrip() {
		return this.puntegrip;
	}

	public void setPuntegrip(BigDecimal puntegrip) {
		this.puntegrip = puntegrip;
	}

	public BigDecimal getPuntegrip1() {
		return this.puntegrip1;
	}

	public void setPuntegrip1(BigDecimal puntegrip1) {
		this.puntegrip1 = puntegrip1;
	}

}