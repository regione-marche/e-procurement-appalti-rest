package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the goev database table.
 * 
 */
@Embeddable
public class GoevPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String ngara;

	private long necvan;

	public GoevPK() {
	}
	public String getNgara() {
		return this.ngara;
	}
	public void setNgara(String ngara) {
		this.ngara = ngara;
	}
	public long getNecvan() {
		return this.necvan;
	}
	public void setNecvan(long necvan) {
		this.necvan = necvan;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GoevPK)) {
			return false;
		}
		GoevPK castOther = (GoevPK)other;
		return 
			this.ngara.equals(castOther.ngara)
			&& (this.necvan == castOther.necvan);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ngara.hashCode();
		hash = hash * prime + ((int) (this.necvan ^ (this.necvan >>> 32)));
		
		return hash;
	}
}