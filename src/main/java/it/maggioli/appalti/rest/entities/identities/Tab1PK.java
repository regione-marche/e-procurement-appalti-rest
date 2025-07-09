package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tab1 database table.
 * 
 */
@Embeddable
public class Tab1PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String tab1cod;

	private long tab1tip;

	public Tab1PK() {
	}
	public String getTab1cod() {
		return this.tab1cod;
	}
	public void setTab1cod(String tab1cod) {
		this.tab1cod = tab1cod;
	}
	public long getTab1tip() {
		return this.tab1tip;
	}
	public void setTab1tip(long tab1tip) {
		this.tab1tip = tab1tip;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tab1PK)) {
			return false;
		}
		Tab1PK castOther = (Tab1PK)other;
		return 
			this.tab1cod.equals(castOther.tab1cod)
			&& (this.tab1tip == castOther.tab1tip);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tab1cod.hashCode();
		hash = hash * prime + ((int) (this.tab1tip ^ (this.tab1tip >>> 32)));
		
		return hash;
	}
}