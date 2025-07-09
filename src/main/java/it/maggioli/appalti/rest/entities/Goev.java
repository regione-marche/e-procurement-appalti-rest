package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.GoevPK;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the goev database table.
 * 
 */
@Entity
@Table(name="goev")
public class Goev implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GoevPK id;

	private String despar;

	private String isnoprz;

	private BigDecimal livpar;

	private BigDecimal maxpun;

	private BigDecimal minpun;

	private BigDecimal necvan1;

	private BigDecimal norpar;

	private BigDecimal norpar1;

	private BigDecimal seztec;

	private BigDecimal tipcal;

	private BigDecimal tippar;

	public Goev() {
	}

	public GoevPK getId() {
		return this.id;
	}

	public void setId(GoevPK id) {
		this.id = id;
	}

	public String getDespar() {
		return this.despar;
	}

	public void setDespar(String despar) {
		this.despar = despar;
	}

	public String getIsnoprz() {
		return this.isnoprz;
	}

	public void setIsnoprz(String isnoprz) {
		this.isnoprz = isnoprz;
	}

	public BigDecimal getLivpar() {
		return this.livpar;
	}

	public void setLivpar(BigDecimal livpar) {
		this.livpar = livpar;
	}

	public BigDecimal getMaxpun() {
		return this.maxpun;
	}

	public void setMaxpun(BigDecimal maxpun) {
		this.maxpun = maxpun;
	}

	public BigDecimal getMinpun() {
		return this.minpun;
	}

	public void setMinpun(BigDecimal minpun) {
		this.minpun = minpun;
	}

	public BigDecimal getNecvan1() {
		return this.necvan1;
	}

	public void setNecvan1(BigDecimal necvan1) {
		this.necvan1 = necvan1;
	}

	public BigDecimal getNorpar() {
		return this.norpar;
	}

	public void setNorpar(BigDecimal norpar) {
		this.norpar = norpar;
	}

	public BigDecimal getNorpar1() {
		return this.norpar1;
	}

	public void setNorpar1(BigDecimal norpar1) {
		this.norpar1 = norpar1;
	}

	public BigDecimal getSeztec() {
		return this.seztec;
	}

	public void setSeztec(BigDecimal seztec) {
		this.seztec = seztec;
	}

	public BigDecimal getTipcal() {
		return this.tipcal;
	}

	public void setTipcal(BigDecimal tipcal) {
		this.tipcal = tipcal;
	}

	public BigDecimal getTippar() {
		return this.tippar;
	}

	public void setTippar(BigDecimal tippar) {
		this.tippar = tippar;
	}

}