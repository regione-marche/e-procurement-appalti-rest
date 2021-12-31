package it.maggioli.appalti.rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la tabella <code>torn</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="torn")
public class Torn {
  @Id
  private String codgar;
  private String cenint;
  
  public String getCenint() {
    return cenint;
  }
  
  public void setCenint(String cenint) {
    this.cenint = cenint;
  }

  public String getCodgar() {
    return codgar;
  }
  
  public void setCodgar(String codgar) {
    this.codgar = codgar;
  }
  
}
