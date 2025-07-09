package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the garpesi database table.
 * 
 */
@Entity
@Table(name = "garpesi")
public class Garpesi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GarpesiPK id;

	private String descrizione;

	private BigDecimal ordine;

	private String valore;

	private String descexcel;

	public Garpesi() {
	}

	public GarpesiPK getId() {
		return this.id;
	}

	public void setId(GarpesiPK id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigDecimal getOrdine() {
		return this.ordine;
	}

	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

	public String getValore() {
		return this.valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public String getDescexcel() {
		return descexcel;
	}

	public void setDescexcel(String descexcel) {
		this.descexcel = descexcel;
	}

}