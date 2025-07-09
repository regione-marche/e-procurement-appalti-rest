package it.maggioli.appalti.rest.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the imprvr database table.
 * 
 */
@Entity
@NamedQuery(name = "Imprvr.findAll", query = "SELECT i FROM Imprvr i")
public class Imprvr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String codimp;

	@Column(name = "data_inserimento")
	private Timestamp dataInserimento;

	private String elencoe;

	private BigDecimal idcalcolo;

	private BigDecimal idcalcolorow;

	private BigDecimal ivr;

	@Column(name = "ivr_data_fine")
	private Timestamp ivrDataFine;

	@Column(name = "ivr_data_inizio")
	private Timestamp ivrDataInizio;

	@Column(name = "sospensione_data_fine")
	private Timestamp sospensioneDataFine;

	@Column(name = "sospensione_data_inizio")
	private Timestamp sospensioneDataInizio;

	@Column(name = "sospensione_mesi")
	private BigDecimal sospensioneMesi;

	@Column(name = "sospensione_revocata")
	private String sospensioneRevocata;

	public Imprvr() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodimp() {
		return this.codimp;
	}

	public void setCodimp(String codimp) {
		this.codimp = codimp;
	}

	public Timestamp getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Timestamp dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getElencoe() {
		return this.elencoe;
	}

	public void setElencoe(String elencoe) {
		this.elencoe = elencoe;
	}

	public BigDecimal getIdcalcolo() {
		return this.idcalcolo;
	}

	public void setIdcalcolo(BigDecimal idcalcolo) {
		this.idcalcolo = idcalcolo;
	}

	public BigDecimal getIdcalcolorow() {
		return this.idcalcolorow;
	}

	public void setIdcalcolorow(BigDecimal idcalcolorow) {
		this.idcalcolorow = idcalcolorow;
	}

	public BigDecimal getIvr() {
		return this.ivr;
	}

	public void setIvr(BigDecimal ivr) {
		this.ivr = ivr;
	}

	public Timestamp getIvrDataFine() {
		return this.ivrDataFine;
	}

	public void setIvrDataFine(Timestamp ivrDataFine) {
		this.ivrDataFine = ivrDataFine;
	}

	public Timestamp getIvrDataInizio() {
		return this.ivrDataInizio;
	}

	public void setIvrDataInizio(Timestamp ivrDataInizio) {
		this.ivrDataInizio = ivrDataInizio;
	}

	public Timestamp getSospensioneDataFine() {
		return this.sospensioneDataFine;
	}

	public void setSospensioneDataFine(Timestamp sospensioneDataFine) {
		this.sospensioneDataFine = sospensioneDataFine;
	}

	public Timestamp getSospensioneDataInizio() {
		return this.sospensioneDataInizio;
	}

	public void setSospensioneDataInizio(Timestamp sospensioneDataInizio) {
		this.sospensioneDataInizio = sospensioneDataInizio;
	}

	public BigDecimal getSospensioneMesi() {
		return this.sospensioneMesi;
	}

	public void setSospensioneMesi(BigDecimal sospensioneMesi) {
		this.sospensioneMesi = sospensioneMesi;
	}

	public String getSospensioneRevocata() {
		return this.sospensioneRevocata;
	}

	public void setSospensioneRevocata(String sospensioneRevocata) {
		this.sospensioneRevocata = sospensioneRevocata;
	}

}