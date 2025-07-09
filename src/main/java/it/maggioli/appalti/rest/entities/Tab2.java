package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tab2 database table.
 * 
 */
@Entity
@Table(name="tab2")
public class Tab2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tab2PK id;

	private String tab2arc;

	private String tab2d1;

	private String tab2d2;

	private String tab2mod;

	private BigDecimal tab2nord;

	public Tab2() {
	}

	public Tab2PK getId() {
		return this.id;
	}

	public void setId(Tab2PK id) {
		this.id = id;
	}

	public String getTab2arc() {
		return this.tab2arc;
	}

	public void setTab2arc(String tab2arc) {
		this.tab2arc = tab2arc;
	}

	public String getTab2d1() {
		return this.tab2d1;
	}

	public void setTab2d1(String tab2d1) {
		this.tab2d1 = tab2d1;
	}

	public String getTab2d2() {
		return this.tab2d2;
	}

	public void setTab2d2(String tab2d2) {
		this.tab2d2 = tab2d2;
	}

	public String getTab2mod() {
		return this.tab2mod;
	}

	public void setTab2mod(String tab2mod) {
		this.tab2mod = tab2mod;
	}

	public BigDecimal getTab2nord() {
		return this.tab2nord;
	}

	public void setTab2nord(BigDecimal tab2nord) {
		this.tab2nord = tab2nord;
	}

}