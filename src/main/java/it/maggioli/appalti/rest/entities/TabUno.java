package it.maggioli.appalti.rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * Classe che mappa la tabella <code>tab1</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="tab1")
@JsonIgnoreProperties({"codice","ordinamento"})
public class TabUno implements Serializable {
  
  private static final long serialVersionUID = 1L;
  @ApiModelProperty(hidden = true)
  @Id
  @Column(name="tab1cod")
  private String codice;
  @Column(name="tab1tip")
  private int id;
  @Column(name="tab1desc")
  private String descrizione;
  @ApiModelProperty(hidden = true)
  @Column(name="tab1nord")
  private Double ordinamento;
  @Column(name="tab1arc")
  private String archiviato;
  
  @Override
  public String toString() {
    return "TabulatoUno ["
        + (codice != null ? "codice=" + codice + ", " : "")
        + "id="
        + id
        + ", "
        + (descrizione != null ? "descrizione=" + descrizione + ", " : "")
        + "ordinamento="
        + ordinamento
        + "]";
  }

  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  public Double getOrdinamento() {
    return ordinamento==null?0.0d:ordinamento;
  }
  
  public void setOrdinamento(Double ordinamento) {
    this.ordinamento = ordinamento;
  }

  
  public String getArchiviato() {
    return archiviato;
  }

  
  public void setArchiviato(String archiviato) {
    this.archiviato = archiviato;
  }
  
}
