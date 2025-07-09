package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the documgara database table.
 * 
 */
@Embeddable
public class DocumgaraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String codgar;

	private long norddocg;

	public DocumgaraPK() {
	}
	public String getCodgar() {
		return this.codgar;
	}
	public void setCodgar(String codgar) {
		this.codgar = codgar;
	}
	public long getNorddocg() {
		return this.norddocg;
	}
	public void setNorddocg(long norddocg) {
		this.norddocg = norddocg;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DocumgaraPK)) {
			return false;
		}
		DocumgaraPK castOther = (DocumgaraPK)other;
		return 
			this.codgar.equals(castOther.codgar)
			&& (this.norddocg == castOther.norddocg);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codgar.hashCode();
		hash = hash * prime + ((int) (this.norddocg ^ (this.norddocg >>> 32)));
		
		return hash;
	}
}