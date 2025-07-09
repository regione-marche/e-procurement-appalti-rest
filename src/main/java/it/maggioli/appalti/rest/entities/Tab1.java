package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

import it.maggioli.appalti.rest.entities.identities.Tab1PK;

import java.math.BigDecimal;


/**
 * The persistent class for the tab1 database table.
 * 
 */
@Entity
@Table(name="tab1")
public class Tab1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tab1PK id;

	private String tab1arc;

	private String tab1desc;

	private String tab1mod;

	private BigDecimal tab1nord;

	public Tab1() {
	}

	public Tab1PK getId() {
		return this.id;
	}

	public void setId(Tab1PK id) {
		this.id = id;
	}

	public String getTab1arc() {
		return this.tab1arc;
	}

	public void setTab1arc(String tab1arc) {
		this.tab1arc = tab1arc;
	}

	public String getTab1desc() {
		return this.tab1desc;
	}

	public void setTab1desc(String tab1desc) {
		this.tab1desc = tab1desc;
	}

	public String getTab1mod() {
		return this.tab1mod;
	}

	public void setTab1mod(String tab1mod) {
		this.tab1mod = tab1mod;
	}

	public BigDecimal getTab1nord() {
		return this.tab1nord;
	}

	public void setTab1nord(BigDecimal tab1nord) {
		this.tab1nord = tab1nord;
	}

}