package it.maggioli.appalti.rest.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class OepvConfermaDatiDto {

	private String codiceGara;
	private String ngara;
	private List<OepvCriterioPartecipanteDto> criteriPartecipanti;

	public OepvConfermaDatiDto() {
	}

	@ApiModelProperty(name = "codiceGara", value = "Codice gara")
	public String getCodiceGara() {
		return codiceGara;
	}

	public void setCodiceGara(String codiceGara) {
		this.codiceGara = codiceGara;
	}

	@ApiModelProperty(name = "ngara", value = "Numero gara")
	public String getNgara() {
		return ngara;
	}

	public void setNgara(String ngara) {
		this.ngara = ngara;
	}

	@ApiModelProperty(name = "criteriPartecipanti", value = "Dati gare, criteri, partecipanti")
	public List<OepvCriterioPartecipanteDto> getCriteriPartecipanti() {
		return criteriPartecipanti;
	}

	public void setCriteriPartecipanti(List<OepvCriterioPartecipanteDto> criteriPartecipanti) {
		this.criteriPartecipanti = criteriPartecipanti;
	}

}
