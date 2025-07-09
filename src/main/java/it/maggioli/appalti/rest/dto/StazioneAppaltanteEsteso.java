package it.maggioli.appalti.rest.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import it.maggioli.appalti.rest.entities.views.ws.StazioneAppaltante;

/**
 * Classe dto per stazione appaltante
 * 
 * @author gabriele.nencini
 *
 */
@ApiModel("StazioneAppaltanteEsteso")
public class StazioneAppaltanteEsteso implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="Codice stazione appaltante")
	private String codice;
	@ApiModelProperty(value="Denomincazione stazione appaltante")
	private String denominazione;
	@ApiModelProperty(value="C.F. stazione appaltante")
	private String codfiscale;
	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}
	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	/**
	 * @return the denominazione
	 */
	public String getDenominazione() {
		return denominazione;
	}
	/**
	 * @param denominazione the denominazione to set
	 */
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	/**
	 * @return the codfiscale
	 */
	public String getCodfiscale() {
		return codfiscale;
	}
	/**
	 * @param codfiscale the codfiscale to set
	 */
	public void setCodfiscale(String codfiscale) {
		this.codfiscale = codfiscale;
	}

}
