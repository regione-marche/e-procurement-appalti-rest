package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.VrWInvcomdesPK;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the w_invcomdes database table.
 * 
 */
@Entity
@Table(name="w_invcomdes")
public class VrWInvcomdes implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VrWInvcomdesPK id;

	private BigDecimal comtipma;

	private String descc;

	private String descodent;

	private String descodsog;

	private Timestamp desdatcons;

	private Timestamp desdatinv;

	@Column(name="desdatinv_s")
	private String desdatinvS;

	private Timestamp desdatlet;

	private String deserrore;

	private String desesitopec;

	private BigDecimal desiddocdig;

	private String desintest;

	private String desmail;

	private String desstato;

	private String destesto;

	private String messageid;

	public VrWInvcomdes() {
	}

	public VrWInvcomdesPK getId() {
		return this.id;
	}

	public void setId(VrWInvcomdesPK id) {
		this.id = id;
	}

	public BigDecimal getComtipma() {
		return this.comtipma;
	}

	public void setComtipma(BigDecimal comtipma) {
		this.comtipma = comtipma;
	}

	public String getDescc() {
		return this.descc;
	}

	public void setDescc(String descc) {
		this.descc = descc;
	}

	public String getDescodent() {
		return this.descodent;
	}

	public void setDescodent(String descodent) {
		this.descodent = descodent;
	}

	public String getDescodsog() {
		return this.descodsog;
	}

	public void setDescodsog(String descodsog) {
		this.descodsog = descodsog;
	}

	public Timestamp getDesdatcons() {
		return this.desdatcons;
	}

	public void setDesdatcons(Timestamp desdatcons) {
		this.desdatcons = desdatcons;
	}

	public Timestamp getDesdatinv() {
		return this.desdatinv;
	}

	public void setDesdatinv(Timestamp desdatinv) {
		this.desdatinv = desdatinv;
	}

	public String getDesdatinvS() {
		return this.desdatinvS;
	}

	public void setDesdatinvS(String desdatinvS) {
		this.desdatinvS = desdatinvS;
	}

	public Timestamp getDesdatlet() {
		return this.desdatlet;
	}

	public void setDesdatlet(Timestamp desdatlet) {
		this.desdatlet = desdatlet;
	}

	public String getDeserrore() {
		return this.deserrore;
	}

	public void setDeserrore(String deserrore) {
		this.deserrore = deserrore;
	}

	public String getDesesitopec() {
		return this.desesitopec;
	}

	public void setDesesitopec(String desesitopec) {
		this.desesitopec = desesitopec;
	}

	public BigDecimal getDesiddocdig() {
		return this.desiddocdig;
	}

	public void setDesiddocdig(BigDecimal desiddocdig) {
		this.desiddocdig = desiddocdig;
	}

	public String getDesintest() {
		return this.desintest;
	}

	public void setDesintest(String desintest) {
		this.desintest = desintest;
	}

	public String getDesmail() {
		return this.desmail;
	}

	public void setDesmail(String desmail) {
		this.desmail = desmail;
	}

	public String getDesstato() {
		return this.desstato;
	}

	public void setDesstato(String desstato) {
		this.desstato = desstato;
	}

	public String getDestesto() {
		return this.destesto;
	}

	public void setDestesto(String destesto) {
		this.destesto = destesto;
	}

	public String getMessageid() {
		return this.messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

}