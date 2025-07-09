package it.maggioli.appalti.rest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import it.maggioli.appalti.rest.entities.identities.TabTreIdentity;

/**
 * Classe che mappa la tabella <code>tab1</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="tab3")
@JsonIgnoreProperties({"codice","ordinamento"})
public class TabTre implements Serializable {
  
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private TabTreIdentity id;
  @Column(name="tab3desc")
  private String descrizione;
  @Column(name="tab3mod")
  private String modifica;
  @ApiModelProperty(hidden = true)
  @Column(name="tab3nord")
  private Double ordinamento;
  @Column(name="tab3arc")
  private String archiviato;
  
  /**
   * @return the identity
   */
  public TabTreIdentity getId() {
    return id;
  }
  
  /**
   * @param identity the identity to set
   */
  public void setId(TabTreIdentity id) {
    this.id = id;
  }
  
  /**
   * @return the descrizione
   */
  public String getDescrizione() {
    return descrizione;
  }
  
  /**
   * @param descrizione the descrizione to set
   */
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  /**
   * @return the modifica
   */
  public String getModifica() {
    return modifica;
  }
  
  /**
   * @param modifica the modifica to set
   */
  public void setModifica(String modifica) {
    this.modifica = modifica;
  }
  
  /**
   * @return the ordinamento
   */
  public Double getOrdinamento() {
    return ordinamento;
  }
  
  /**
   * @param ordinamento the ordinamento to set
   */
  public void setOrdinamento(Double ordinamento) {
    this.ordinamento = ordinamento;
  }
  
  /**
   * @return the archiviato
   */
  public String getArchiviato() {
    return archiviato;
  }
  
  /**
   * @param archiviato the archiviato to set
   */
  public void setArchiviato(String archiviato) {
    this.archiviato = archiviato;
  }
  
  
}
