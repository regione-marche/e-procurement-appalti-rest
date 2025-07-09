package it.maggioli.appalti.rest.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class OepvDocumentoLottoDto {

	private Long id;
	private String url;
	private String descrizione;
	private String nomefile;
	private Date dataPubblicazione;

	public OepvDocumentoLottoDto() {
	}

	public OepvDocumentoLottoDto(Long id, String url, String descrizione, String nomefile, Date dataPubblicazione) {
		super();
		this.id = id;
		this.url = url;
		this.descrizione = descrizione;
		this.nomefile = nomefile;
		this.dataPubblicazione = dataPubblicazione;
	}

	@ApiModelProperty(name = "id", value = "ID documento")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ApiModelProperty(name = "url", value = "url documento")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ApiModelProperty(name = "descrizione", value = "Descrizione documento")
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@ApiModelProperty(name = "nomefile", value = "Nome file documento")
	public String getNomefile() {
		return nomefile;
	}

	public void setNomefile(String nomefile) {
		this.nomefile = nomefile;
	}

	@ApiModelProperty(name = "dataPubblicazione", value = "Data di pubblicazione")
	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

}
