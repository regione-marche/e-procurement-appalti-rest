package it.maggioli.appalti.rest.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la tabella <code>gare</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="gare")
public class Gare {
  @Id
  private String ngara;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "codgar1", insertable = false, updatable = false,referencedColumnName = "codgar")
  @Fetch(FetchMode.JOIN)
  private Torn torn;
  
  public String getNgara() {
    return ngara;
  }
  
  public void setNgara(String ngara) {
    this.ngara = ngara;
  }
  
  public Torn getTorn() {
    return torn;
  }

  public void setTorn(Torn torn) {
    this.torn = torn;
  }
  
}
