package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModelProperty;

public class OepvGfofDto {

	private Long id;
	private String cfein;

	public OepvGfofDto() {
	}

	public OepvGfofDto(Long id, String cfein) {
		super();
		this.id = id;
		this.cfein = cfein;
	}

	@ApiModelProperty(name = "id", value = "ID Gfof")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ApiModelProperty(name = "cfein", value = "CF Utente")
	public String getCfein() {
		return cfein;
	}

	public void setCfein(String cfein) {
		this.cfein = cfein;
	}

}
