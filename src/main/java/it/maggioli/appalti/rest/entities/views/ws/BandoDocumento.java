package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_gare_documenti</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name="v_ws_gare_documenti")
public class BandoDocumento {
  @Column(name="descdoc")
  private String descrizione;
  @Column(name="filedoc")
  private String nomefile;
  @Id
  @Column(name="iddoc")
  private Long id;
  @Column(name="urldoc")
  private String url;
  @Column(name="codice")
  private String codice;
  @Column(name="ngara")
  private String ngara;
  @Column(name="gruppo")
  private Integer gruppo;
  @Column(name="datpub")
  private Date dataPubblicazione;
  @Column(name="numord")
  private Integer numord;
  @Column(name="obbligatorio")
  private boolean obbligatorio;
  @Column(name="ordine")
  private Integer ordine;
  
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  public String getNomefile() {
    return nomefile;
  }
  
  public void setNomefile(String nomefile) {
    this.nomefile = nomefile;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public Date getDataPubblicazione() {
    return dataPubblicazione;
  }
  
  public void setDataPubblicazione(Date dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }

  
  public String getCodice() {
    return codice;
  }

  
  public void setCodice(String codice) {
    this.codice = codice;
  }

  
  public String getNgara() {
    return ngara;
  }

  
  public void setNgara(String ngara) {
    this.ngara = ngara;
  }

  
  public Integer getGruppo() {
    return gruppo;
  }

  
  public void setGruppo(Integer gruppo) {
    this.gruppo = gruppo;
  }

  
  public Integer getNumord() {
    return numord;
  }

  
  public void setNumord(Integer numord) {
    this.numord = numord;
  }

  
  public boolean isObbligatorio() {
    return obbligatorio;
  }

  
  public void setObbligatorio(boolean obbligatorio) {
    this.obbligatorio = obbligatorio;
  }

  
  public Integer getOrdine() {
    return ordine;
  }

  
  public void setOrdine(Integer ordine) {
    this.ordine = ordine;
  }

  @Override
  public String toString() {
    return "BandoDocumento ["
        + (nomefile != null ? "nomefile=" + nomefile + ", " : "")
        + (id != null ? "id=" + id + ", " : "")
        + (codice != null ? "codice=" + codice + ", " : "")
        + (ngara != null ? "ngara=" + ngara + ", " : "")
        + (gruppo != null ? "gruppo=" + gruppo + ", " : "")
        + (ordine != null ? "ordine=" + ordine : "")
        + "]";
  }

  
  
}
