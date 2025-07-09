package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.BandoDocumento BandoDocumento}
 * 
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "OepvDocumentoDto")
public class OepvDocumentoDto {

	private String nome;
	private String nomefile;
	private Long id;
	private String descrizione;
	private String urldoc;
	private String tipoFile = null;

	public OepvDocumentoDto() {
	}

	public OepvDocumentoDto(String nome, String nomefile, Long id, String descrizione, String urldoc) {
		super();
		this.nome = nome;
		this.nomefile = nomefile;
		this.id = id;
		this.descrizione = descrizione;
		this.urldoc = urldoc;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNomefile() {
		return nomefile;
	}

	public void setNomefile(String nomefile) {
		this.nomefile = nomefile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrldoc() {
		return urldoc;
	}

	public void setUrldoc(String urldoc) {
		this.urldoc = urldoc;
	}

	/**
	 * @return the tipoFile
	 */
	public String getTipoFile() {
		return tipoFile;
	}

	/**
	 * @param tipoFile the tipoFile to set
	 */
	public void setTipoFile(String tipoFile) {
		this.tipoFile = tipoFile;
	}

	@Override
	public String toString() {
		return "OepvDocumentoDto [nome=" + nome + ", nomefile=" + nomefile + ", id=" + id + ", descrizione=" + descrizione + ", urldoc=" + urldoc + "]";
	}

}
