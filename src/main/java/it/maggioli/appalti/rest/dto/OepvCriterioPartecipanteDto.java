package it.maggioli.appalti.rest.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class OepvCriterioPartecipanteDto {

	private String ngara;
	private String dittao;
	private Long necvan;
	private boolean confrontoCoppie;
	private List<OepvCriterioPartecipanteCoefficienteDto> coefficienti;

	public OepvCriterioPartecipanteDto() {
	}

	@ApiModelProperty(name = "ngara", value = "Codice lotto")
	public String getNgara() {
		return ngara;
	}

	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	@ApiModelProperty(name = "ditta", value = "Codice ditta partecipante")
	public String getDittao() {
		return dittao;
	}

	public void setDittao(String dittao) {
		this.dittao = dittao;
	}

	@ApiModelProperty(name = "necvan", value = "ID criterio")
	public Long getNecvan() {
		return necvan;
	}

	public void setNecvan(Long necvan) {
		this.necvan = necvan;
	}

	@ApiModelProperty(name = "coefficienti", value = "Elenco coefficienti")
	public List<OepvCriterioPartecipanteCoefficienteDto> getCoefficienti() {
		return coefficienti;
	}

	public void setCoefficienti(List<OepvCriterioPartecipanteCoefficienteDto> coefficienti) {
		this.coefficienti = coefficienti;
	}

	@ApiModelProperty(name = "confrontoCoppie", value = "Indica se confronto a coppie")
	public boolean isConfrontoCoppie() {
		return confrontoCoppie;
	}

	public void setConfrontoCoppie(boolean confrontoCoppie) {
		this.confrontoCoppie = confrontoCoppie;
	}

}
