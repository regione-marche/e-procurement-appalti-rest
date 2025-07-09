package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.BandoDocumento BandoDocumento}
 * 
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "OepvExportEsitoDto")
public class OepvExportEsitoDto {

	private String data;

	private boolean esito;
	private String errorData;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

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
