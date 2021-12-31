package it.maggioli.appalti.rest.entities.views.ws;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_gare_categorie</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_gare_categorie")
public class GareCategorie {
  private String ngara;
  private Long numord;
  @Id
  private String codice;
  private String descrizione;
  private Double impiscrizione;
  private Double importo;
  private Integer classifica;
  private String descclassifica;
  private Boolean prevalente;
  private Boolean perlavori;
  private Integer tipoappalto;
  private String titolo;
  
  public String getNgara() {
    return ngara;
  }
  
  public void setNgara(String ngara) {
    this.ngara = ngara;
  }
  
  public Long getNumord() {
    return numord;
  }
  
  public void setNumord(Long numord) {
    this.numord = numord;
  }
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  public Double getImpiscrizione() {
    return impiscrizione;
  }
  
  public void setImpiscrizione(Double impiscrizione) {
    this.impiscrizione = impiscrizione;
  }
  
  public Double getImporto() {
    return importo;
  }
  
  public void setImporto(Double importo) {
    this.importo = importo;
  }
  
  public Integer getClassifica() {
    return classifica;
  }
  
  public void setClassifica(Integer classifica) {
    this.classifica = classifica;
  }
  
  public String getDescclassifica() {
    return descclassifica;
  }
  
  public void setDescclassifica(String descclassifica) {
    this.descclassifica = descclassifica;
  }
  
  public Boolean getPrevalente() {
    return prevalente;
  }
  
  public void setPrevalente(Boolean prevalente) {
    this.prevalente = prevalente;
  }
  
  public Boolean getPerlavori() {
    return perlavori;
  }
  
  public void setPerlavori(Boolean perlavori) {
    this.perlavori = perlavori;
  }
  
  public Integer getTipoappalto() {
    return tipoappalto;
  }
  
  public void setTipoappalto(Integer tipoappalto) {
    this.tipoappalto = tipoappalto;
  }
  
  public String getTitolo() {
    return titolo;
  }
  
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  @Override
  public String toString() {
    return "GareCategorie ["
        + (ngara != null ? "ngara=" + ngara + ", " : "")
        + (codice != null ? "codice=" + codice + ", " : "")
        + (descrizione != null ? "descrizione=" + descrizione + ", " : "")
        + (prevalente != null ? "prevalente=" + prevalente : "")
        + "]";
  }
  
  
}
