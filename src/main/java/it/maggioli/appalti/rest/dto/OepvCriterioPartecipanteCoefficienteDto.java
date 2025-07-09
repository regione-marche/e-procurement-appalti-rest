package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class OepvCriterioPartecipanteCoefficienteDto {

	private String cfein;
	private List<OepvCriterioPartecipanteCoppieValoreDto> coppie;
	private BigDecimal coeffi;
	private String note;
	private double pesoAhp;

	public OepvCriterioPartecipanteCoefficienteDto() {
	}

	@ApiModelProperty(name = "cfein", value = "Codice fiscale utente")
	public String getCfein() {
		return cfein;
	}

	public void setCfein(String cfein) {
		this.cfein = cfein;
	}

	@ApiModelProperty(name = "coeffi", value = "Valore coefficiente")
	public BigDecimal getCoeffi() {
		return coeffi;
	}

	public void setCoeffi(BigDecimal coeffi) {
		this.coeffi = coeffi;
	}

	@ApiModelProperty(name = "note", value = "Note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@ApiModelProperty(name = "coppie", value = "Valori confronto a coppie")
	public List<OepvCriterioPartecipanteCoppieValoreDto> getCoppie() {
		return coppie;
	}

	public void setCoppie(List<OepvCriterioPartecipanteCoppieValoreDto> coppie) {
		this.coppie = coppie;
	}

	public double getPesoAhp() {
		return pesoAhp;
	}

	public void setPesoAhp(double pesoAhp) {
		this.pesoAhp = pesoAhp;
	}

}
