package it.maggioli.appalti.rest.entities;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import it.maggioli.appalti.rest.entities.identities.RagimpIdentity;

/**
 * Classe che rappresenta il raggruppamento
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "ragimp")
public class Ragimp {
  
  @EmbeddedId
  private RagimpIdentity id;
  private String nomdic;
  private BigDecimal quodic;
  private String impman;
  
  /**
   * @return the id
   */
  public RagimpIdentity getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(RagimpIdentity id) {
    this.id = id;
  }
  
  /**
   * @return the nomdic
   */
  public String getNomdic() {
    return nomdic;
  }
  
  /**
   * @param nomdic the nomdic to set
   */
  public void setNomdic(String nomdic) {
    this.nomdic = nomdic;
  }
  
  /**
   * @return the quodic
   */
  public BigDecimal getQuodic() {
    return quodic;
  }
  
  /**
   * @param quodic the quodic to set
   */
  public void setQuodic(BigDecimal quodic) {
    this.quodic = quodic;
  }
  
  /**
   * @return the impman
   */
  public String getImpman() {
    return impman;
  }
  
  /**
   * @param impman the impman to set
   */
  public void setImpman(String impman) {
    this.impman = impman;
  }
  
  
}
