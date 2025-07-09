package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the g1crivalcom database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="g1crivalcom")
public class G1crivalcom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal coeffi;

	private BigDecimal idcridef;

	private BigDecimal idcrival;

	private BigDecimal idgfof;

	private String note;

	public G1crivalcom() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCoeffi() {
		return this.coeffi;
	}

	public void setCoeffi(BigDecimal coeffi) {
		this.coeffi = coeffi;
	}

	public BigDecimal getIdcridef() {
		return this.idcridef;
	}

	public void setIdcridef(BigDecimal idcridef) {
		this.idcridef = idcridef;
	}

	public BigDecimal getIdcrival() {
		return this.idcrival;
	}

	public void setIdcrival(BigDecimal idcrival) {
		this.idcrival = idcrival;
	}

	public BigDecimal getIdgfof() {
		return this.idgfof;
	}

	public void setIdgfof(BigDecimal idgfof) {
		this.idgfof = idgfof;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}