package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class VrPubblicazioneImpresaDto {

	private String codImp;
	private BigDecimal idCalcolo;
	private BigDecimal idCalcoloRow;
	private String elencoe;
	private BigDecimal ivr;
	private Timestamp ivrDataInizio;
	private Timestamp ivrDataFine;
	private BigDecimal sospensioneMesi;
	private Timestamp sospensioneDataInizio;
	private Timestamp sospensioneDataFine;
	private String sospensioneRevocata;

	private String emailOggetto;
	private String emailTesto;

	public String getCodImp() {
		return codImp;
	}

	public void setCodImp(String codImp) {
		this.codImp = codImp;
	}

	public BigDecimal getIdCalcolo() {
		return idCalcolo;
	}

	public void setIdCalcolo(BigDecimal idCalcolo) {
		this.idCalcolo = idCalcolo;
	}

	public BigDecimal getIvr() {
		return ivr;
	}

	public void setIvr(BigDecimal ivr) {
		this.ivr = ivr;
	}

	public BigDecimal getSospensioneMesi() {
		return sospensioneMesi;
	}

	public void setSospensioneMesi(BigDecimal sospensioneMesi) {
		this.sospensioneMesi = sospensioneMesi;
	}

	public Timestamp getSospensioneDataInizio() {
		return sospensioneDataInizio;
	}

	public void setSospensioneDataInizio(Timestamp sospensioneDataInizio) {
		this.sospensioneDataInizio = sospensioneDataInizio;
	}

	public Timestamp getSospensioneDataFine() {
		return sospensioneDataFine;
	}

	public void setSospensioneDataFine(Timestamp sospensioneDataFine) {
		this.sospensioneDataFine = sospensioneDataFine;
	}

	public String getSospensioneRevocata() {
		return sospensioneRevocata;
	}

	public void setSospensioneRevocata(String sospensioneRevocata) {
		this.sospensioneRevocata = sospensioneRevocata;
	}

	public String getEmailOggetto() {
		return emailOggetto;
	}

	public void setEmailOggetto(String emailOggetto) {
		this.emailOggetto = emailOggetto;
	}

	public String getEmailTesto() {
		return emailTesto;
	}

	public void setEmailTesto(String emailTesto) {
		this.emailTesto = emailTesto;
	}

	public BigDecimal getIdCalcoloRow() {
		return idCalcoloRow;
	}

	public void setIdCalcoloRow(BigDecimal idCalcoloRow) {
		this.idCalcoloRow = idCalcoloRow;
	}

	public String getElencoe() {
		return elencoe;
	}

	public void setElencoe(String elencoe) {
		this.elencoe = elencoe;
	}

	public Timestamp getIvrDataInizio() {
		return ivrDataInizio;
	}

	public void setIvrDataInizio(Timestamp ivrDataInizio) {
		this.ivrDataInizio = ivrDataInizio;
	}

	public Timestamp getIvrDataFine() {
		return ivrDataFine;
	}

	public void setIvrDataFine(Timestamp ivrDataFine) {
		this.ivrDataFine = ivrDataFine;
	}

}
