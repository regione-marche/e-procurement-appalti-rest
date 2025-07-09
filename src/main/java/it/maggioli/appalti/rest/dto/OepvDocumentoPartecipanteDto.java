package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class OepvDocumentoPartecipanteDto {

	private BigDecimal iddocdg;
	private String idprg;
	private String descrizione;
	private String dignomdoc;
	private String tipoFile = null;

	public OepvDocumentoPartecipanteDto() {
	}

	public OepvDocumentoPartecipanteDto(BigDecimal iddocdg, String idprg, String descrizione, String dignomdoc) {
		super();
		this.iddocdg = iddocdg;
		this.idprg = idprg;
		this.descrizione = descrizione;
		this.dignomdoc = dignomdoc;
	}

	@ApiModelProperty(name = "iddocdg", value = "ID documento")
	public BigDecimal getIddocdg() {
		return iddocdg;
	}

	public void setIddocdg(BigDecimal iddocdg) {
		this.iddocdg = iddocdg;
	}

	@ApiModelProperty(name = "idprg", value = "ID Programma")
	public String getIdprg() {
		return idprg;
	}

	public void setIdprg(String idprg) {
		this.idprg = idprg;
	}

	@ApiModelProperty(name = "dignomdoc", value = "Descrizione documento")
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@ApiModelProperty(name = "dignomdoc", value = "Nome file")
	public String getDignomdoc() {
		return dignomdoc;
	}

	public void setDignomdoc(String dignomdoc) {
		this.dignomdoc = dignomdoc;
	}

	/**
	 * @return the tipoFile
	 */
	@ApiModelProperty(name = "tipoFile", value = "Tipo file")
	public String getTipoFile() {
		return tipoFile;
	}

	/**
	 * @param tipoFile the tipoFile to set
	 */
	public void setTipoFile(String tipoFile) {
		this.tipoFile = tipoFile;
	}

}
