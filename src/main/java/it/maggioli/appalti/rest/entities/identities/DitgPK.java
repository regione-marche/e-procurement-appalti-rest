package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ditg database table.
 * 
 */
@Embeddable
public class DitgPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String codgar5;

	private String dittao;

	private String ngara5;

	public DitgPK() {
	}
	public String getCodgar5() {
		return this.codgar5;
	}
	public void setCodgar5(String codgar5) {
		this.codgar5 = codgar5;
	}
	public String getDittao() {
		return this.dittao;
	}
	public void setDittao(String dittao) {
		this.dittao = dittao;
	}
	public String getNgara5() {
		return this.ngara5;
	}
	public void setNgara5(String ngara5) {
		this.ngara5 = ngara5;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DitgPK)) {
			return false;
		}
		DitgPK castOther = (DitgPK)other;
		return 
			this.codgar5.equals(castOther.codgar5)
			&& this.dittao.equals(castOther.dittao)
			&& this.ngara5.equals(castOther.ngara5);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codgar5.hashCode();
		hash = hash * prime + this.dittao.hashCode();
		hash = hash * prime + this.ngara5.hashCode();
		
		return hash;
	}
}