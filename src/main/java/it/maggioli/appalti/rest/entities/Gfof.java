package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the gfof database table.
 * 
 */
@Entity
@Table(name="gfof")
public class Gfof implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String codfof;

	private Timestamp dataaccettazione;

	private Timestamp datarichiesta;

	private Timestamp dliqspe;

	private String espgiu;

	private BigDecimal impfof;

	private BigDecimal impliq;

	private BigDecimal impspe;

	private BigDecimal incfof;

	private String indisponibilita;

	private String intfof;

	private String motivindisp;

	private String ngara2;

	private String nomfof;

	private BigDecimal numcomm;

	private BigDecimal numord;

	private BigDecimal sezalbo;

	public Gfof() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodfof() {
		return this.codfof;
	}

	public void setCodfof(String codfof) {
		this.codfof = codfof;
	}

	public Timestamp getDataaccettazione() {
		return this.dataaccettazione;
	}

	public void setDataaccettazione(Timestamp dataaccettazione) {
		this.dataaccettazione = dataaccettazione;
	}

	public Timestamp getDatarichiesta() {
		return this.datarichiesta;
	}

	public void setDatarichiesta(Timestamp datarichiesta) {
		this.datarichiesta = datarichiesta;
	}

	public Timestamp getDliqspe() {
		return this.dliqspe;
	}

	public void setDliqspe(Timestamp dliqspe) {
		this.dliqspe = dliqspe;
	}

	public String getEspgiu() {
		return this.espgiu;
	}

	public void setEspgiu(String espgiu) {
		this.espgiu = espgiu;
	}

	public BigDecimal getImpfof() {
		return this.impfof;
	}

	public void setImpfof(BigDecimal impfof) {
		this.impfof = impfof;
	}

	public BigDecimal getImpliq() {
		return this.impliq;
	}

	public void setImpliq(BigDecimal impliq) {
		this.impliq = impliq;
	}

	public BigDecimal getImpspe() {
		return this.impspe;
	}

	public void setImpspe(BigDecimal impspe) {
		this.impspe = impspe;
	}

	public BigDecimal getIncfof() {
		return this.incfof;
	}

	public void setIncfof(BigDecimal incfof) {
		this.incfof = incfof;
	}

	public String getIndisponibilita() {
		return this.indisponibilita;
	}

	public void setIndisponibilita(String indisponibilita) {
		this.indisponibilita = indisponibilita;
	}

	public String getIntfof() {
		return this.intfof;
	}

	public void setIntfof(String intfof) {
		this.intfof = intfof;
	}

	public String getMotivindisp() {
		return this.motivindisp;
	}

	public void setMotivindisp(String motivindisp) {
		this.motivindisp = motivindisp;
	}

	public String getNgara2() {
		return this.ngara2;
	}

	public void setNgara2(String ngara2) {
		this.ngara2 = ngara2;
	}

	public String getNomfof() {
		return this.nomfof;
	}

	public void setNomfof(String nomfof) {
		this.nomfof = nomfof;
	}

	public BigDecimal getNumcomm() {
		return this.numcomm;
	}

	public void setNumcomm(BigDecimal numcomm) {
		this.numcomm = numcomm;
	}

	public BigDecimal getNumord() {
		return this.numord;
	}

	public void setNumord(BigDecimal numord) {
		this.numord = numord;
	}

	public BigDecimal getSezalbo() {
		return this.sezalbo;
	}

	public void setSezalbo(BigDecimal sezalbo) {
		this.sezalbo = sezalbo;
	}

}