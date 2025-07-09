package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;

import javax.persistence.Id;

public class OepvCommissarioDto {

	@Id
	private Long id;

	private String codfof;
	private String nomfof;
	private BigDecimal incfof;
	private String descRuolo;
	private String cfein;

	public OepvCommissarioDto(Long id, String codfof, String nomfof, BigDecimal incfof, String descRuolo, String cfein) {
		super();
		this.id = id;
		this.codfof = codfof;
		this.nomfof = nomfof;
		this.incfof = incfof;
		this.descRuolo = descRuolo;
		this.cfein = cfein;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodfof() {
		return codfof;
	}

	public void setCodfof(String codfof) {
		this.codfof = codfof;
	}

	public String getNomfof() {
		return nomfof;
	}

	public void setNomfof(String nomfof) {
		this.nomfof = nomfof;
	}

	public BigDecimal getIncfof() {
		return incfof;
	}

	public void setIncfof(BigDecimal incfof) {
		this.incfof = incfof;
	}

	public String getDescRuolo() {
		return descRuolo;
	}

	public void setDescRuolo(String descRuolo) {
		this.descRuolo = descRuolo;
	}

	public String getCfein() {
		return cfein;
	}

	public void setCfein(String cfein) {
		this.cfein = cfein;
	}

}
