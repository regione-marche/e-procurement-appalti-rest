package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import it.maggioli.appalti.rest.entities.views.ws.identities.AdempimentiAnticorIdentity;

/**
 * Classe che mappa la vista <code>v_ws_adempimenti_anticor</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_adempimenti_anticor")
public class AdempimentiAnticor {
  
  @EmbeddedId
  private AdempimentiAnticorIdentity identity = new AdempimentiAnticorIdentity();
  private String nomein;
  private String cfein;
  
  private String urlsito;
  private Integer pubblicato;
  private Date datapubblicazione;
  private Date dataaggiornamento;
  private Date dataapprovazione;
  
  /**
   * @return the identity
   */
  public AdempimentiAnticorIdentity getIdentity() {
    return identity;
  }
  
  /**
   * @param identity the identity to set
   */
  public void setIdentity(AdempimentiAnticorIdentity identity) {
    this.identity = identity;
  }
  
  /**
   * @return the nomein
   */
  public String getNomein() {
    return nomein;
  }
  
  /**
   * @param nomein the nomein to set
   */
  public void setNomein(String nomein) {
    this.nomein = nomein;
  }
  
  /**
   * @return the cfein
   */
  public String getCfein() {
    return cfein;
  }
  
  /**
   * @param cfein the cfein to set
   */
  public void setCfein(String cfein) {
    this.cfein = cfein;
  }
  
  /**
   * @return the urlsito
   */
  public String getUrlsito() {
    return urlsito;
  }
  
  /**
   * @param urlsito the urlsito to set
   */
  public void setUrlsito(String urlsito) {
    this.urlsito = urlsito;
  }
  
  /**
   * @return the pubblicato
   */
  public Integer getPubblicato() {
    return pubblicato;
  }
  
  /**
   * @param pubblicato the pubblicato to set
   */
  public void setPubblicato(Integer pubblicato) {
    this.pubblicato = pubblicato;
  }
  
  /**
   * @return the datapubblicazione
   */
  public Date getDatapubblicazione() {
    return datapubblicazione;
  }
  
  /**
   * @param datapubblicazione the datapubblicazione to set
   */
  public void setDatapubblicazione(Date datapubblicazione) {
    this.datapubblicazione = datapubblicazione;
  }
  
  /**
   * @return the dataaggiornamento
   */
  public Date getDataaggiornamento() {
    return dataaggiornamento;
  }
  
  /**
   * @param dataaggiornamento the dataaggiornamento to set
   */
  public void setDataaggiornamento(Date dataaggiornamento) {
    this.dataaggiornamento = dataaggiornamento;
  }
  
  /**
   * @return the dataapprovazione
   */
  public Date getDataapprovazione() {
    return dataapprovazione;
  }
  
  /**
   * @param dataapprovazione the dataapprovazione to set
   */
  public void setDataapprovazione(Date dataapprovazione) {
    this.dataapprovazione = dataapprovazione;
  }

  @Override
  public String toString() {
    return "AdempimentiAnticor ["
        + (identity != null ? "identity=" + identity + ", " : "")
        + (pubblicato != null ? "pubblicato=" + pubblicato : "")
        + "]";
  }
  
}
