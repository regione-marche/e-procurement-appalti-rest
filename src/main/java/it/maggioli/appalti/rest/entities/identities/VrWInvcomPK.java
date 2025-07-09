package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the w_invcom database table.
 * 
 */
@Embeddable
public class VrWInvcomPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String idprg;

	private long idcom;

	public VrWInvcomPK() {
	}
	public String getIdprg() {
		return this.idprg;
	}
	public void setIdprg(String idprg) {
		this.idprg = idprg;
	}
	public long getIdcom() {
		return this.idcom;
	}
	public void setIdcom(long idcom) {
		this.idcom = idcom;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VrWInvcomPK)) {
			return false;
		}
		VrWInvcomPK castOther = (VrWInvcomPK)other;
		return 
			this.idprg.equals(castOther.idprg)
			&& (this.idcom == castOther.idcom);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idprg.hashCode();
		hash = hash * prime + ((int) (this.idcom ^ (this.idcom >>> 32)));
		
		return hash;
	}
}