package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ditgammis database table.
 * 
 */
@Embeddable
public class DitgammiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String codgar;

	private String ngara;

	private String dittao;

	private long fasgar;

	public DitgammiPK() {
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
	public String getDittao() {
		return this.dittao;
	}
	public void setDittao(String dittao) {
		this.dittao = dittao;
	}
	public long getFasgar() {
		return this.fasgar;
	}
	public void setFasgar(long fasgar) {
		this.fasgar = fasgar;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DitgammiPK)) {
			return false;
		}
		DitgammiPK castOther = (DitgammiPK)other;
		return 
			this.codgar.equals(castOther.codgar)
			&& this.ngara.equals(castOther.ngara)
			&& this.dittao.equals(castOther.dittao)
			&& (this.fasgar == castOther.fasgar);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codgar.hashCode();
		hash = hash * prime + this.ngara.hashCode();
		hash = hash * prime + this.dittao.hashCode();
		hash = hash * prime + ((int) (this.fasgar ^ (this.fasgar >>> 32)));
		
		return hash;
	}
}