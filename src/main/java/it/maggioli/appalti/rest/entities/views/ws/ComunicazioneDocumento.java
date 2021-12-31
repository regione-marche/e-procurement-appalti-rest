package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_comunicazioni_documenti</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_comunicazioni_documenti")
public class ComunicazioneDocumento {
  private String idprg;
  private Long idcom;
  @Id
  private Long iddoc;
  private String descdoc;
  private String filedoc;
  private Date datpub;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idcom", insertable = false, updatable = false,referencedColumnName = "idcom")
  private Comunicazione comunicazione;
  
  public Comunicazione getComunicazione() {
    return comunicazione;
  }
  
  public void setComunicazione(Comunicazione comunicazione) {
    this.comunicazione = comunicazione;
  }

  public String getIdprg() {
    return idprg;
  }
  
  public void setIdprg(String idprg) {
    this.idprg = idprg;
  }
  
  public Long getIdcom() {
    return idcom;
  }
  
  public void setIdcom(Long idcom) {
    this.idcom = idcom;
  }
  
  public Long getIddoc() {
    return iddoc;
  }
  
  public void setIddoc(Long iddoc) {
    this.iddoc = iddoc;
  }
  
  public String getDescdoc() {
    return descdoc;
  }
  
  public void setDescdoc(String descdoc) {
    this.descdoc = descdoc;
  }
  
  public String getFiledoc() {
    return filedoc;
  }
  
  public void setFiledoc(String filedoc) {
    this.filedoc = filedoc;
  }
  
  public Date getDatpub() {
    return datpub;
  }
  
  public void setDatpub(Date datpub) {
    this.datpub = datpub;
  }

  @Override
  public String toString() {
    return "ComunicazioneDocumento ["
        + (idprg != null ? "idprg=" + idprg + ", " : "")
        + (idcom != null ? "idcom=" + idcom + ", " : "")
        + (iddoc != null ? "iddoc=" + iddoc : "")
        + "]";
  }
  
  
}
