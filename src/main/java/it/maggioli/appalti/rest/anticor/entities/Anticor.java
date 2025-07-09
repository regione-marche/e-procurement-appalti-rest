package it.maggioli.appalti.rest.anticor.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity per la gestione della tabella anticor
 * 
 * @author gabriele.nencini
 *
 */
@Entity
@Table(name = "ANTICOR")
public class Anticor {
  @Id
  private Long id;
  private String titolo;
  private String estratto;
  private Date datapubbl;
  private String entepubbl;
  private Date dataagg;
  private Integer annorif;
  private String nomefile;
  private String licenza;
  private String completato;
  private String esportato;
  private String pubblicato;
  private String codein;
  private String urlsito;
  private Date datappr;
  
  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }
  
  /**
   * @return the titolo
   */
  public String getTitolo() {
    return titolo;
  }
  
  /**
   * @param titolo the titolo to set
   */
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }
  
  /**
   * @return the estratto
   */
  public String getEstratto() {
    return estratto;
  }
  
  /**
   * @param estratto the estratto to set
   */
  public void setEstratto(String estratto) {
    this.estratto = estratto;
  }
  
  /**
   * @return the datapubbl
   */
  public Date getDatapubbl() {
    return datapubbl;
  }
  
  /**
   * @param datapubbl the datapubbl to set
   */
  public void setDatapubbl(Date datapubbl) {
    this.datapubbl = datapubbl;
  }
  
  /**
   * @return the entepubbl
   */
  public String getEntepubbl() {
    return entepubbl;
  }
  
  /**
   * @param entepubbl the entepubbl to set
   */
  public void setEntepubbl(String entepubbl) {
    this.entepubbl = entepubbl;
  }
  
  /**
   * @return the dataagg
   */
  public Date getDataagg() {
    return dataagg;
  }
  
  /**
   * @param dataagg the dataagg to set
   */
  public void setDataagg(Date dataagg) {
    this.dataagg = dataagg;
  }
  
  /**
   * @return the annorif
   */
  public Integer getAnnorif() {
    return annorif;
  }
  
  /**
   * @param annorif the annorif to set
   */
  public void setAnnorif(Integer annorif) {
    this.annorif = annorif;
  }
  
  /**
   * @return the nomefile
   */
  public String getNomefile() {
    return nomefile;
  }
  
  /**
   * @param nomefile the nomefile to set
   */
  public void setNomefile(String nomefile) {
    this.nomefile = nomefile;
  }
  
  /**
   * @return the licenza
   */
  public String getLicenza() {
    return licenza;
  }
  
  /**
   * @param licenza the licenza to set
   */
  public void setLicenza(String licenza) {
    this.licenza = licenza;
  }
  
  /**
   * @return the completato
   */
  public String getCompletato() {
    return completato;
  }
  
  /**
   * @param completato the completato to set
   */
  public void setCompletato(String completato) {
    this.completato = completato;
  }
  
  /**
   * @return the esportato
   */
  public String getEsportato() {
    return esportato;
  }
  
  /**
   * @param esportato the esportato to set
   */
  public void setEsportato(String esportato) {
    this.esportato = esportato;
  }
  
  /**
   * @return the pubblicato
   */
  public String getPubblicato() {
    return pubblicato;
  }
  
  /**
   * @param pubblicato the pubblicato to set
   */
  public void setPubblicato(String pubblicato) {
    this.pubblicato = pubblicato;
  }
  
  /**
   * @return the codein
   */
  public String getCodein() {
    return codein;
  }
  
  /**
   * @param codein the codein to set
   */
  public void setCodein(String codein) {
    this.codein = codein;
  }
  
  /**
   * @return the urlsito
   */
  public String getUrlsito() {
    return urlsito;
  }
  
  /**
   * @param urlsito the urlsito to set
   */
  public void setUrlsito(String urlsito) {
    this.urlsito = urlsito;
  }
  
  /**
   * @return the datappr
   */
  public Date getDatappr() {
    return datappr;
  }
  
  /**
   * @param datappr the datappr to set
   */
  public void setDatappr(Date datappr) {
    this.datappr = datappr;
  }

  @Override
  public String toString() {
    return "Anticor [id=" + id + ", titolo=" + titolo + ", annorif=" + annorif + ", codein=" + codein + "]";
  }
  
  

}
