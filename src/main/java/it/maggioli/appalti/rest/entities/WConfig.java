package it.maggioli.appalti.rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import it.maggioli.appalti.rest.entities.identities.WConfigIdentity;

/**
 * Classe che mappa la tabella <code>w_config</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="w_config")
public class WConfig {
  @Id
  private WConfigIdentity id;
  private String valore;
  private String sezione;
  private String descrizione;
  private String criptato;
  
  public WConfigIdentity getId() {
    return id;
  }
  
  public void setId(WConfigIdentity id) {
    this.id = id;
  }
  
  public String getValore() {
    return valore;
  }
  
  public void setValore(String valore) {
    this.valore = valore;
  }
  
  public String getSezione() {
    return sezione;
  }
  
  public void setSezione(String sezione) {
    this.sezione = sezione;
  }
  
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  public String getCriptato() {
    return criptato;
  }
  
  public void setCriptato(String criptato) {
    this.criptato = criptato;
  }

  @Override
  public String toString() {
    return "WConfig [" + (id != null ? "id=" + id + ", " : "") + (valore != null ? "valore=" + valore : "") + "]";
  }
  
}
