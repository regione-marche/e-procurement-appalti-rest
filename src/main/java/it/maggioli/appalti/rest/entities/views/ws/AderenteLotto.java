package it.maggioli.appalti.rest.entities.views.ws;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_aderente_lotto</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_aderente_lotto")
public class AderenteLotto implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private String codgar;
  private String ngara;
  private String codice;
  private String codcig;
  private String cenint;
  private String cfein;
  private String nomein;
  
  public String getCodgar() {
    return codgar;
  }
  
  public void setCodgar(String codgar) {
    this.codgar = codgar;
  }
  
  public String getNgara() {
    return ngara;
  }
  
  public void setNgara(String ngara) {
    this.ngara = ngara;
  }
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public String getCodcig() {
    return codcig;
  }
  
  public void setCodcig(String codcig) {
    this.codcig = codcig;
  }
  
  public String getCenint() {
    return cenint;
  }
  
  public void setCenint(String cenint) {
    this.cenint = cenint;
  }
  
  public String getCfein() {
    return cfein;
  }
  
  public void setCfein(String cfein) {
    this.cfein = cfein;
  }
  
  public String getNomein() {
    return nomein;
  }
  
  public void setNomein(String nomein) {
    this.nomein = nomein;
  }
  
  
}
