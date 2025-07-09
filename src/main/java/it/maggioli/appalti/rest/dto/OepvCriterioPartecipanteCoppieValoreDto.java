package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModelProperty;

public class OepvCriterioPartecipanteCoppieValoreDto {

	private String codiceImpresa = null;
	private String garpesiNumpesi;

	public OepvCriterioPartecipanteCoppieValoreDto() {
	}

	@ApiModelProperty(name = "codiceImpresa", value = "Codice impresa comparata")
	public String getCodiceImpresa() {
		return codiceImpresa;
	}

	public void setCodiceImpresa(String codiceImpresa) {
		this.codiceImpresa = codiceImpresa;
	}

	@ApiModelProperty(name = "garpesiNumpesi", value = "Valore confronto a coppie")
	public String getGarpesiNumpesi() {
		return garpesiNumpesi;
	}

	public void setGarpesiNumpesi(String garpesiNumpesi) {
		this.garpesiNumpesi = garpesiNumpesi;
	}

}
