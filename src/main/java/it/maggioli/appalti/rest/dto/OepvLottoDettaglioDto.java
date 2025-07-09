package it.maggioli.appalti.rest.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class OepvLottoDettaglioDto {

	private String codicegara;
	private String codicelotto;
	private String lotto;
	private String codicecig;
	private String oggetto;
	private BigDecimal importobasegara;
	private String rup;
	private Timestamp datatermineoff;
	private String oratermineoff;

	public OepvLottoDettaglioDto() {
	}

	public OepvLottoDettaglioDto(String codicegara, String codicelotto, String lotto, String codicecig, String oggetto, BigDecimal importobasegara, String rup, Date datatermineoff,
			String oratermineoff) {
		super();
		this.codicegara = codicegara;
		this.codicelotto = codicelotto;
		this.lotto = lotto;
		this.codicecig = codicecig;
		this.oggetto = oggetto;
		this.importobasegara = importobasegara;
		this.rup = rup;
		this.datatermineoff = datatermineoff != null ? new Timestamp(datatermineoff.getTime()) : null;
		this.oratermineoff = oratermineoff;
	}

	@ApiModelProperty(name = "codicegara", value = "Codice gara")
	public String getCodicegara() {
		return codicegara;
	}

	public void setCodicegara(String codicegara) {
		this.codicegara = codicegara;
	}

	@ApiModelProperty(name = "codicelotto", value = "Codice lotto")
	public String getCodicelotto() {
		return codicelotto;
	}

	public void setCodicelotto(String codicelotto) {
		this.codicelotto = codicelotto;
	}

	@ApiModelProperty(name = "lotto", value = "Lotto")
	public String getLotto() {
		return lotto;
	}

	public void setLotto(String lotto) {
		this.lotto = lotto;
	}

	@ApiModelProperty(name = "codicecig", value = "Codice cig")
	public String getCodicecig() {
		return codicecig;
	}

	public void setCodicecig(String codicecig) {
		this.codicecig = codicecig;
	}

	@ApiModelProperty(name = "oggetto", value = "Oggetto")
	public String getOggetto() {
		return oggetto;
	}

	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}

	@ApiModelProperty(name = "importobasegara", value = "Importo a base gara")
	public BigDecimal getImportobasegara() {
		return importobasegara;
	}

	public void setImportobasegara(BigDecimal importobasegara) {
		this.importobasegara = importobasegara;
	}

	@ApiModelProperty(name = "rup", value = "RUP")
	public String getRup() {
		return rup;
	}

	public void setRup(String rup) {
		this.rup = rup;
	}

	@ApiModelProperty(name = "datatermineoff", value = "Data termine presentazione offerta")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	public Timestamp getDatatermineoff() {
		return datatermineoff;
	}

	public void setDatatermineoff(Timestamp datatermineoff) {
		this.datatermineoff = datatermineoff;
	}

	@ApiModelProperty(name = "oratermineoff", value = "Ora termine presentazione offerta")
	public String getOratermineoff() {
		return oratermineoff;
	}

	public void setOratermineoff(String oratermineoff) {
		this.oratermineoff = oratermineoff;
	}

}
