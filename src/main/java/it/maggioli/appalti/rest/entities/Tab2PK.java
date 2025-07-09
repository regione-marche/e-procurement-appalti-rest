package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tab2 database table.
 * 
 */
@Embeddable
public class Tab2PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String tab2cod;

	private String tab2tip;

	public Tab2PK() {
	}
	public String getTab2cod() {
		return this.tab2cod;
	}
	public void setTab2cod(String tab2cod) {
		this.tab2cod = tab2cod;
	}
	public String getTab2tip() {
		return this.tab2tip;
	}
	public void setTab2tip(String tab2tip) {
		this.tab2tip = tab2tip;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tab2PK)) {
			return false;
		}
		Tab2PK castOther = (Tab2PK)other;
		return 
			this.tab2cod.equals(castOther.tab2cod)
			&& this.tab2tip.equals(castOther.tab2tip);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tab2cod.hashCode();
		hash = hash * prime + this.tab2tip.hashCode();
		
		return hash;
	}
}