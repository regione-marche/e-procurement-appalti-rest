package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class OepvGarPesiDto {

	private String numpesi;
	private String codicegara;
	private String descrizione;
	private BigDecimal ordine;
	private String valore;
	private String descexcel;

	public OepvGarPesiDto() {
	}

	public OepvGarPesiDto(String numpesi, String codicegara, String descrizione, BigDecimal ordine, String valore, String descexcel) {
		super();
		this.numpesi = numpesi;
		this.codicegara = codicegara;
		this.descrizione = descrizione;
		this.ordine = ordine;
		this.valore = valore;
		this.descexcel = descexcel;
	}

	@ApiModelProperty(name = "numpesi", value = "ID interno alla gara")
	public String getNumpesi() {
		return numpesi;
	}

	public void setNumpesi(String numpesi) {
		this.numpesi = numpesi;
	}

	@ApiModelProperty(name = "codicegara", value = "Codice della gara")
	public String getCodicegara() {
		return codicegara;
	}

	public void setCodicegara(String codicegara) {
		this.codicegara = codicegara;
	}

	@ApiModelProperty(name = "descrizione", value = "Descrizione valore")
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@ApiModelProperty(name = "ordine", value = "Ordinamento")
	public BigDecimal getOrdine() {
		return ordine;
	}

	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

	@ApiModelProperty(name = "valore", value = "Valore coefficiente peso")
	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	@ApiModelProperty(name = "descexcel", value = "Descrizione per Excel")
	public String getDescexcel() {
		return descexcel;
	}

	public void setDescexcel(String descexcel) {
		this.descexcel = descexcel;
	}

}
