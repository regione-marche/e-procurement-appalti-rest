package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.DitgammiPK;

import java.math.BigDecimal;


/**
 * The persistent class for the ditgammis database table.
 * 
 */
@Entity
@Table(name="ditgammis")
@NamedQuery(name="Ditgammi.findAll", query="SELECT d FROM Ditgammi d")
public class Ditgammi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DitgammiPK id;

	private BigDecimal ammgar;

	private String detmotescl;

	private BigDecimal motivescl;

	public Ditgammi() {
	}

	public DitgammiPK getId() {
		return this.id;
	}

	public void setId(DitgammiPK id) {
		this.id = id;
	}

	public BigDecimal getAmmgar() {
		return this.ammgar;
	}

	public void setAmmgar(BigDecimal ammgar) {
		this.ammgar = ammgar;
	}

	public String getDetmotescl() {
		return this.detmotescl;
	}

	public void setDetmotescl(String detmotescl) {
		this.detmotescl = detmotescl;
	}

	public BigDecimal getMotivescl() {
		return this.motivescl;
	}

	public void setMotivescl(BigDecimal motivescl) {
		this.motivescl = motivescl;
	}

}