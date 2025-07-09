package it.maggioli.appalti.rest.entities.identities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dpun_cg database table.
 * 
 */
@Embeddable
public class DpunCgPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String ngara;

	private long necvan;

	private String dittao;

	public DpunCgPK() {
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
	public String getDittao() {
		return this.dittao;
	}
	public void setDittao(String dittao) {
		this.dittao = dittao;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DpunCgPK)) {
			return false;
		}
		DpunCgPK castOther = (DpunCgPK)other;
		return 
			this.ngara.equals(castOther.ngara)
			&& (this.necvan == castOther.necvan)
			&& this.dittao.equals(castOther.dittao);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ngara.hashCode();
		hash = hash * prime + ((int) (this.necvan ^ (this.necvan >>> 32)));
		hash = hash * prime + this.dittao.hashCode();
		
		return hash;
	}
}