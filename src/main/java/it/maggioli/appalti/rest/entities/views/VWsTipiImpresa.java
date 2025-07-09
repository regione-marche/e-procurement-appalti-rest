package it.maggioli.appalti.rest.entities.views;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the v_ws_tipi_impresa database table.
 * 
 */
@Entity
@Table(name = "v_ws_tipi_impresa")
public class VWsTipiImpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private BigDecimal codice;

	private Integer consorzio;

	private String descrizione;

	@Column(name = "ditta_individuale")
	private Integer dittaIndividuale;

	@Column(name = "impresa_sociale")
	private Integer impresaSociale;

	@Column(name = "libero_professionista")
	private Integer liberoProfessionista;

	private BigDecimal ordine;

	public VWsTipiImpresa() {
	}

	public BigDecimal getCodice() {
		return this.codice;
	}

	public void setCodice(BigDecimal codice) {
		this.codice = codice;
	}

	public Integer getConsorzio() {
		return this.consorzio;
	}

	public void setConsorzio(Integer consorzio) {
		this.consorzio = consorzio;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getDittaIndividuale() {
		return this.dittaIndividuale;
	}

	public void setDittaIndividuale(Integer dittaIndividuale) {
		this.dittaIndividuale = dittaIndividuale;
	}

	public Integer getImpresaSociale() {
		return this.impresaSociale;
	}

	public void setImpresaSociale(Integer impresaSociale) {
		this.impresaSociale = impresaSociale;
	}

	public Integer getLiberoProfessionista() {
		return this.liberoProfessionista;
	}

	public void setLiberoProfessionista(Integer liberoProfessionista) {
		this.liberoProfessionista = liberoProfessionista;
	}

	public BigDecimal getOrdine() {
		return this.ordine;
	}

	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

}