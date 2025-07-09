package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModelProperty;

public class OepvCriterioTabellareDto {

	private String codice;
	private String id;
	private String valore;
	private String descrizione;

	public OepvCriterioTabellareDto() {
	}

	public OepvCriterioTabellareDto(String codice, String id, String valore, String descrizione) {
		super();
		this.codice = codice;
		this.id = id;
		this.valore = valore;
		this.descrizione = descrizione;
	}

	@ApiModelProperty(name = "codice", value = "Codice tabella")
	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@ApiModelProperty(name = "id", value = "ID elemento")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ApiModelProperty(name = "valore", value = "Valore")
	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	@ApiModelProperty(name = "descrizione", value = "Descrizione")
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
