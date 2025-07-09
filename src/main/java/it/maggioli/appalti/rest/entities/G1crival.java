package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the g1crival database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="g1crival")
public class G1crival implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal coeffi;

	private String dittao;

	private BigDecimal idcridef;

	private BigDecimal necvan;

	private String ngara;

	private String note;

	private BigDecimal punteg;

	private Timestamp valdat;

	private BigDecimal valnum;

	private String valstg;

	public G1crival() {
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

	public String getDittao() {
		return this.dittao;
	}

	public void setDittao(String dittao) {
		this.dittao = dittao;
	}

	public BigDecimal getIdcridef() {
		return this.idcridef;
	}

	public void setIdcridef(BigDecimal idcridef) {
		this.idcridef = idcridef;
	}

	public BigDecimal getNecvan() {
		return this.necvan;
	}

	public void setNecvan(BigDecimal necvan) {
		this.necvan = necvan;
	}

	public String getNgara() {
		return this.ngara;
	}

	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getPunteg() {
		return this.punteg;
	}

	public void setPunteg(BigDecimal punteg) {
		this.punteg = punteg;
	}

	public Timestamp getValdat() {
		return this.valdat;
	}

	public void setValdat(Timestamp valdat) {
		this.valdat = valdat;
	}

	public BigDecimal getValnum() {
		return this.valnum;
	}

	public void setValnum(BigDecimal valnum) {
		this.valnum = valnum;
	}

	public String getValstg() {
		return this.valstg;
	}

	public void setValstg(String valstg) {
		this.valstg = valstg;
	}

}