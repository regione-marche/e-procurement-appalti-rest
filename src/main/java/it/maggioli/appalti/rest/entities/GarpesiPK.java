package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the garpesi database table.
 * 
 */
@Embeddable
public class GarpesiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String numpesi;

	@Column(insertable=false, updatable=false)
	private String codicegara;

	public GarpesiPK() {
	}
	public String getNumpesi() {
		return this.numpesi;
	}
	public void setNumpesi(String numpesi) {
		this.numpesi = numpesi;
	}
	public String getCodicegara() {
		return this.codicegara;
	}
	public void setCodicegara(String codicegara) {
		this.codicegara = codicegara;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GarpesiPK)) {
			return false;
		}
		GarpesiPK castOther = (GarpesiPK)other;
		return 
			this.numpesi.equals(castOther.numpesi)
			&& this.codicegara.equals(castOther.codicegara);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numpesi.hashCode();
		hash = hash * prime + this.codicegara.hashCode();
		
		return hash;
	}
}