package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class OepvCriterioDettaglioDto {

	private String codiceLotto;
	private long id;
	private BigDecimal idPadre;
	private BigDecimal ordinamentoPadre;
	private BigDecimal ordinamento;
	private String descrizionePadre;
	private String descrizione;
	private BigDecimal punteggioMassimo;
	private BigDecimal modpunti;
	private BigDecimal modmanu;
	private boolean padre;

	public OepvCriterioDettaglioDto() {
	}

	public OepvCriterioDettaglioDto(String codiceLotto, long id, BigDecimal idPadre, BigDecimal ordinamentoPadre, BigDecimal ordinamento, String descrizione,
			BigDecimal punteggioMassimo, BigDecimal modpunti, BigDecimal modmanu, String descrizionePadre) {
		super();
		this.codiceLotto = codiceLotto;
		this.id = id;
		this.idPadre = idPadre;
		this.ordinamentoPadre = ordinamentoPadre;
		this.ordinamento = ordinamento;
		this.descrizione = descrizione;
		this.punteggioMassimo = punteggioMassimo;
		this.modpunti = modpunti;
		this.modmanu = modmanu;
		this.descrizionePadre = descrizionePadre;
	}

	@ApiModelProperty(name = "codiceLotto", value = "Codice della gara o del lotto")
	public String getCodiceLotto() {
		return codiceLotto;
	}

	public void setCodiceLotto(String codiceLotto) {
		this.codiceLotto = codiceLotto;
	}

	@ApiModelProperty(name = "id", value = "ID criterio padre")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ApiModelProperty(name = "idPadre", value = "Riferimento al criterio padre se NORPAR1 diverso da 0")
	public BigDecimal getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(BigDecimal idPadre) {
		this.idPadre = idPadre;
	}

	@ApiModelProperty(name = "ordinamentoPadre", value = "Ordinamento padre")
	public BigDecimal getOrdinamentoPadre() {
		return ordinamentoPadre;
	}

	public void setOrdinamentoPadre(BigDecimal ordinamentoPadre) {
		this.ordinamentoPadre = ordinamentoPadre;
	}

	@ApiModelProperty(name = "ordinamento", value = "Ordinamento")
	public BigDecimal getOrdinamento() {
		return ordinamento;
	}

	public void setOrdinamento(BigDecimal ordinamento) {
		this.ordinamento = ordinamento;
	}

	@ApiModelProperty(name = "descrizione", value = "Descrizione")
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@ApiModelProperty(name = "punteggioMassimo", value = "Punteggio massimo attribuito")
	public BigDecimal getPunteggioMassimo() {
		return punteggioMassimo;
	}

	public void setPunteggioMassimo(BigDecimal punteggioMassimo) {
		this.punteggioMassimo = punteggioMassimo;
	}

	@ApiModelProperty(name = "modpunti", value = "Modalita' punteggi")
	public BigDecimal getModpunti() {
		return modpunti;
	}

	public void setModpunti(BigDecimal modpunti) {
		this.modpunti = modpunti;
	}

	@ApiModelProperty(name = "modmanu", value = "Modalita' manuale")
	public BigDecimal getModmanu() {
		return modmanu;
	}

	public void setModmanu(BigDecimal modmanu) {
		this.modmanu = modmanu;
	}

	@ApiModelProperty(name = "descrizionePadre", value = "Descrizione padre")
	public String getDescrizionePadre() {
		return descrizionePadre;
	}

	public void setDescrizionePadre(String descrizionePadre) {
		this.descrizionePadre = descrizionePadre;
	}

	@ApiModelProperty(name = "padre", value = "Criterio padre")
	public boolean isPadre() {
		return padre;
	}

	public void setPadre(boolean padre) {
		this.padre = padre;
	}

}
