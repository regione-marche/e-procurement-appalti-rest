package it.maggioli.appalti.rest.entities.views.ws;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_gare_anticor</code>, ma solo per i due campi <code>denomprop,codfiscprop</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_gare_anticor")
public class StazioneAppaltanteL190 implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "DENOMPROP")
  private String codice;
  @Column(name = "CODFISCPROP")
  private String denominazione;
  
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codice == null) ? 0 : codice.hashCode());
    result = prime * result + ((denominazione == null) ? 0 : denominazione.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    StazioneAppaltanteL190 other = (StazioneAppaltanteL190) obj;
    if (codice == null) {
      if (other.codice != null) return false;
    } else if (!codice.equals(other.codice)) return false;
    if (denominazione == null) {
      if (other.denominazione != null) return false;
    } else if (!denominazione.equals(other.denominazione)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "StazioneAppaltanteL190 ["
        + (codice != null ? "codice=" + codice + ", " : "")
        + (denominazione != null ? "denominazione=" + denominazione : "")
        + "]";
  }
  
}
