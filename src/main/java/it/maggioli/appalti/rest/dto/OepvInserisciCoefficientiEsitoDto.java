package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.BandoDocumento BandoDocumento}
 * 
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "OepvInserisciCoefficientiEsitoDto")
public class OepvInserisciCoefficientiEsitoDto {

	private boolean esito;
	private String errorData;

	public boolean isEsito() {
		return esito;
	}

	public void setEsito(boolean esito) {
		this.esito = esito;
	}

	public String getErrorData() {
		return errorData;
	}

	public void setErrorData(String errorData) {
		this.errorData = errorData;
	}

}
