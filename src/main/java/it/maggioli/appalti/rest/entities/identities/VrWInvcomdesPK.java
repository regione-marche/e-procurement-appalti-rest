package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the w_invcomdes database table.
 * 
 */
@Embeddable
public class VrWInvcomdesPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String idprg;

	private long idcom;

	private long idcomdes;

	public VrWInvcomdesPK() {
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
	public long getIdcomdes() {
		return this.idcomdes;
	}
	public void setIdcomdes(long idcomdes) {
		this.idcomdes = idcomdes;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VrWInvcomdesPK)) {
			return false;
		}
		VrWInvcomdesPK castOther = (VrWInvcomdesPK)other;
		return 
			this.idprg.equals(castOther.idprg)
			&& (this.idcom == castOther.idcom)
			&& (this.idcomdes == castOther.idcomdes);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idprg.hashCode();
		hash = hash * prime + ((int) (this.idcom ^ (this.idcom >>> 32)));
		hash = hash * prime + ((int) (this.idcomdes ^ (this.idcomdes >>> 32)));
		
		return hash;
	}
}