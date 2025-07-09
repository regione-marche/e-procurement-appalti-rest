package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the garealbo database table.
 * 
 */
@Embeddable
public class GarealboPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String codgar;

	private String ngara;

	public GarealboPK() {
	}
	public String getCodgar() {
		return this.codgar;
	}
	public void setCodgar(String codgar) {
		this.codgar = codgar;
	}
	public String getNgara() {
		return this.ngara;
	}
	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GarealboPK)) {
			return false;
		}
		GarealboPK castOther = (GarealboPK)other;
		return 
			this.codgar.equals(castOther.codgar)
			&& this.ngara.equals(castOther.ngara);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codgar.hashCode();
		hash = hash * prime + this.ngara.hashCode();
		
		return hash;
	}
}