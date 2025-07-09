package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;

public class OepvPartecipanteDettaglioDto {

	private String codiceImpresa;
	private String ragioneSociale;
	private BigDecimal numeroPlico;
	private String codiceGara;
	private String codiceLotto;
	private String lotto;
	private String cig;

	public OepvPartecipanteDettaglioDto(String codiceImpresa, String ragioneSociale, BigDecimal numeroPlico, String codiceGara, String codiceLotto, String lotto, String cig) {
		super();
		this.codiceImpresa = codiceImpresa;
		this.ragioneSociale = ragioneSociale;
		this.numeroPlico = numeroPlico;
		this.codiceGara = codiceGara;
		this.codiceLotto = codiceLotto;
		this.lotto = lotto;
		this.cig = cig;
	}

	public OepvPartecipanteDettaglioDto() {
	}

	public String getCodiceImpresa() {
		return codiceImpresa;
	}

	public void setCodiceImpresa(String codiceImpresa) {
		this.codiceImpresa = codiceImpresa;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public BigDecimal getNumeroPlico() {
		return numeroPlico;
	}

	public void setNumeroPlico(BigDecimal numeroPlico) {
		this.numeroPlico = numeroPlico;
	}

	public String getCodiceGara() {
		return codiceGara;
	}

	public void setCodiceGara(String codiceGara) {
		this.codiceGara = codiceGara;
	}

	public String getCodiceLotto() {
		return codiceLotto;
	}

	public void setCodiceLotto(String codiceLotto) {
		this.codiceLotto = codiceLotto;
	}

	public String getLotto() {
		return lotto;
	}

	public void setLotto(String lotto) {
		this.lotto = lotto;
	}

	public String getCig() {
		return cig;
	}

	public void setCig(String cig) {
		this.cig = cig;
	}

}
