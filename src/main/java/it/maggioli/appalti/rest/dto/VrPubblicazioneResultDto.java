package it.maggioli.appalti.rest.dto;

public class VrPubblicazioneResultDto {

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
