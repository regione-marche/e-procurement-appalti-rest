package it.maggioli.appalti.rest.entities.views.ws;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

/**
 * Classe che mappa la vista <code>v_ws_stazioni_app</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_stazioni_app")
@JsonIgnoreProperties({"codfiscale"})
public class StazioneAppaltante implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "codice")
  private String codice;
  @Column(name = "denominazione")
  private String denominazione;
  @ApiModelProperty(hidden = true)
  @Column(name = "codfiscale")
  private String codfiscale;
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public String getDenominazione() {
    return denominazione;
  }
  
  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
  }
  
  public String getCodfiscale() {
    return codfiscale;
  }
  
  public void setCodfiscale(String codfiscale) {
    this.codfiscale = codfiscale;
  }

  @Override
  public String toString() {
    return "StazioneAppaltante [codice=" + codice + ", denominazione=" + denominazione + ", codfiscale=" + codfiscale + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codice == null) ? 0 : codice.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    StazioneAppaltante other = (StazioneAppaltante) obj;
    if (codice == null) {
      if (other.codice != null) return false;
    } else if (!codice.equals(other.codice)) return false;
    return true;
  }

  
  
}
