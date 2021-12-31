package it.maggioli.appalti.rest.entities.views.ws;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_gare_istruttori</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="v_ws_gare_istruttori")
public class PuntoIstruttore {
  private Long numper;
  private Integer propri;
  @Id
  private String codice;
  private Long syscon;
  private String sysute;
  
  public Long getNumper() {
    return numper;
  }
  
  public void setNumper(Long numper) {
    this.numper = numper;
  }
  
  public Integer getPropri() {
    return propri;
  }
  
  public void setPropri(Integer propri) {
    this.propri = propri;
  }
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public Long getSyscon() {
    return syscon;
  }
  
  public void setSyscon(Long syscon) {
    this.syscon = syscon;
  }
  
  public String getSysute() {
    return sysute;
  }
  
  public void setSysute(String sysute) {
    this.sysute = sysute;
  }
  
  
}
