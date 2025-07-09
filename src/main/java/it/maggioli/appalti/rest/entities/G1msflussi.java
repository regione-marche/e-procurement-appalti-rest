package it.maggioli.appalti.rest.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Questa classe mappa la tabella <code>cais</code>
 * <br>Marcata come Immutable per evitare modifiche
 * @author alessio.iezzi
 *
 */
@Entity
@Immutable
@Table(name = "G1MSFLUSSI")
public class G1msflussi {
	
	@Id
	private Long id;
	private String entita;
	private String chiave_int;
	private String chiave_ext;
	private String fonte;
	private Long tipo_flusso;
	private Date data_invio;
	private Date data_richiesta;
	private Date data_elab;
	private Long stato;
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEntita() {
		return entita;
	}
	public void setEntita(String entita) {
		this.entita = entita;
	}
	public String getChiave_int() {
		return chiave_int;
	}
	public void setChiave_int(String chiave_int) {
		this.chiave_int = chiave_int;
	}
	public String getChiave_ext() {
		return chiave_ext;
	}
	public void setChiave_ext(String chiave_ext) {
		this.chiave_ext = chiave_ext;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public Long getTipo_flusso() {
		return tipo_flusso;
	}
	public void setTipo_flusso(Long tipo_flusso) {
		this.tipo_flusso = tipo_flusso;
	}
	public Date getData_invio() {
		return data_invio;
	}
	public void setData_invio(Date data_invio) {
		this.data_invio = data_invio;
	}
	public Date getData_richiesta() {
		return data_richiesta;
	}
	public void setData_richiesta(Date data_richiesta) {
		this.data_richiesta = data_richiesta;
	}
	public Date getData_elab() {
		return data_elab;
	}
	public void setData_elab(Date data_elab) {
		this.data_elab = data_elab;
	}
	public Long getStato() {
		return stato;
	}
	public void setStato(Long stato) {
		this.stato = stato;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
  
}
