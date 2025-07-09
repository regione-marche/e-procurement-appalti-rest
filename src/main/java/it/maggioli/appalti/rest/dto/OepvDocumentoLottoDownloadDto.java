package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModelProperty;

public class OepvDocumentoLottoDownloadDto {

	private String idprg;
	private Long iddocdig;
	private String dignomdoc;
	private byte[] digogg;

	public OepvDocumentoLottoDownloadDto() {
	}

	public OepvDocumentoLottoDownloadDto(String idprg, Long iddocdig, String dignomdoc, byte[] digogg) {
		super();
		this.idprg = idprg;
		this.iddocdig = iddocdig;
		this.dignomdoc = dignomdoc;
		this.digogg = digogg;
	}

	@ApiModelProperty(name = "idprg", value = "ID Programma")
	public String getIdprg() {
		return idprg;
	}

	public void setIdprg(String idprg) {
		this.idprg = idprg;
	}

	@ApiModelProperty(name = "iddocdig", value = "ID Documento")
	public Long getIddocdig() {
		return iddocdig;
	}

	public void setIddocdig(Long iddocdig) {
		this.iddocdig = iddocdig;
	}

	@ApiModelProperty(name = "dignomdoc", value = "Nome documento")
	public String getDignomdoc() {
		return dignomdoc;
	}

	public void setDignomdoc(String dignomdoc) {
		this.dignomdoc = dignomdoc;
	}

	@ApiModelProperty(name = "digogg", value = "Contenuto documento")
	public byte[] getDigogg() {
		return digogg;
	}

	public void setDigogg(byte[] digogg) {
		this.digogg = digogg;
	}

}
