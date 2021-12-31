package it.maggioli.appalti.rest.entities.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_gare_statoesitolotti</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_gare_statoesitolotti")
public class GareStatoEsitoLotti {
  @Column(name="codgar1")
  private String codgar;
  @Id
  private String codice;
  private Integer genere;
  private String oggetto;
  private Integer codstato;
  private String stato;
  private String esito;
  
  public String getCodgar() {
    return codgar;
  }
  
  public void setCodgar(String codgar) {
    this.codgar = codgar;
  }
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public Integer getGenere() {
    return genere;
  }
  
  public void setGenere(Integer genere) {
    this.genere = genere;
  }
  
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  public Integer getCodstato() {
    return codstato;
  }
  
  public void setCodstato(Integer codstato) {
    this.codstato = codstato;
  }
  
  public String getStato() {
    return stato;
  }
  
  public void setStato(String stato) {
    this.stato = stato;
  }
  
  public String getEsito() {
    return esito;
  }
  
  public void setEsito(String esito) {
    this.esito = esito;
  }

  @Override
  public String toString() {
    return "GareStatoEsitoLotti ["
        + (codgar != null ? "codgar=" + codgar + ", " : "")
        + (codice != null ? "codice=" + codice + ", " : "")
        + (genere != null ? "genere=" + genere + ", " : "")
        + (oggetto != null ? "oggetto=" + oggetto + ", " : "")
        + (codstato != null ? "codstato=" + codstato + ", " : "")
        + (stato != null ? "stato=" + stato + ", " : "")
        + (esito != null ? "esito=" + esito : "")
        + "]";
  }
  
}
