package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class OepvPartecipanteListaDto {

	private String codiceImpresa;
	private String ragioneSociale;
	private BigDecimal numeroPlico;
	private String tipoPartecipante;

	public OepvPartecipanteListaDto() {
	}

	public OepvPartecipanteListaDto(String codiceImpresa, String ragioneSociale, BigDecimal numeroPlico, String tipoPartecipante) {
		super();
		this.codiceImpresa = codiceImpresa;
		this.ragioneSociale = ragioneSociale;
		this.numeroPlico = numeroPlico;
		this.tipoPartecipante = tipoPartecipante;
	}

	@ApiModelProperty(name = "codiceImpresa", value = "Codice impresa partecipante")
	public String getCodiceImpresa() {
		return codiceImpresa;
	}

	public void setCodiceImpresa(String codiceImpresa) {
		this.codiceImpresa = codiceImpresa;
	}

	@ApiModelProperty(name = "ragioneSociale", value = "Ragione sociale impresa partecipante")
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	@ApiModelProperty(name = "numeroPlico", value = "Numero  plico")
	public BigDecimal getNumeroPlico() {
		return numeroPlico;
	}

	public void setNumeroPlico(BigDecimal numeroPlico) {
		this.numeroPlico = numeroPlico;
	}

	@ApiModelProperty(name = "tipoPartecipante", value = "Tipologia partecipante")
	public String getTipoPartecipante() {
		return tipoPartecipante;
	}

	public void setTipoPartecipante(String tipoPartecipante) {
		this.tipoPartecipante = tipoPartecipante;
	}

}
