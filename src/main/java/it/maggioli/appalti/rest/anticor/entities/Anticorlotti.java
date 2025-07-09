package it.maggioli.appalti.rest.anticor.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * Entity per la gestione della tabella anticorlotti
 * 
 * @author gabriele.nencini
 *
 */
@Entity
@Table(name = "ANTICORLOTTI")
@DynamicUpdate
public class Anticorlotti {

  @Id
  private Long id;
//  private Long idanticor;
  private String pubblica;
  private String daannoprec;
  private String cig;
  private String codfiscprop;
  private String denomprop;
  private String oggetto;
  private Long sceltacontr;
  private Double impaggiudic;
  private Date datainizio;
  private Date dataultimazione;
  private Double impsommeliq;
  private String inviabile;
  private Integer stato;
  private String lottoinbo;
  private String idlotto;
  private String testolog;
  private String codfisresp;
  private String nomeresp;
  //campo presente dalla 8.8.0
  private String idcontratto;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idanticor")
  private Anticor anticor;
  
  
  /**
   * @return the anticor
   */
  public Anticor getAnticor() {
    return anticor;
  }

  
  /**
   * @param anticor the anticor to set
   */
  public void setAnticor(Anticor anticor) {
    this.anticor = anticor;
  }

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
   * @return the pubblica
   */
  public String getPubblica() {
    return pubblica;
  }
  
  /**
   * @param pubblica the pubblica to set
   */
  public void setPubblica(String pubblica) {
    this.pubblica = pubblica;
  }
  
  /**
   * @return the daannoprec
   */
  public String getDaannoprec() {
    return daannoprec;
  }
  
  /**
   * @param daannoprec the daannoprec to set
   */
  public void setDaannoprec(String daannoprec) {
    this.daannoprec = daannoprec;
  }
  
  /**
   * @return the cig
   */
  public String getCig() {
    return cig;
  }
  
  /**
   * @param cig the cig to set
   */
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  /**
   * @return the codfiscprop
   */
  public String getCodfiscprop() {
    return codfiscprop;
  }
  
  /**
   * @param codfiscprop the codfiscprop to set
   */
  public void setCodfiscprop(String codfiscprop) {
    this.codfiscprop = codfiscprop;
  }
  
  /**
   * @return the denomprop
   */
  public String getDenomprop() {
    return denomprop;
  }
  
  /**
   * @param denomprop the denomprop to set
   */
  public void setDenomprop(String denomprop) {
    this.denomprop = denomprop;
  }
  
  /**
   * @return the oggetto
   */
  public String getOggetto() {
    return oggetto;
  }
  
  /**
   * @param oggetto the oggetto to set
   */
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  /**
   * @return the sceltacontr
   */
  public Long getSceltacontr() {
    return sceltacontr;
  }
  
  /**
   * @param sceltacontr the sceltacontr to set
   */
  public void setSceltacontr(Long sceltacontr) {
    this.sceltacontr = sceltacontr;
  }
  
  /**
   * @return the impaggiudic
   */
  public Double getImpaggiudic() {
    return impaggiudic;
  }
  
  /**
   * @param impaggiudic the impaggiudic to set
   */
  public void setImpaggiudic(Double impaggiudic) {
    this.impaggiudic = impaggiudic;
  }
  
  /**
   * @return the datainizio
   */
  public Date getDatainizio() {
    return datainizio;
  }
  
  /**
   * @param datainizio the datainizio to set
   */
  public void setDatainizio(Date datainizio) {
    this.datainizio = datainizio;
  }
  
  /**
   * @return the dataultimazione
   */
  public Date getDataultimazione() {
    return dataultimazione;
  }
  
  /**
   * @param dataultimazione the dataultimazione to set
   */
  public void setDataultimazione(Date dataultimazione) {
    this.dataultimazione = dataultimazione;
  }
  
  /**
   * @return the impsommeliq
   */
  public Double getImpsommeliq() {
    return impsommeliq;
  }
  
  /**
   * @param impsommeliq the impsommeliq to set
   */
  public void setImpsommeliq(Double impsommeliq) {
    this.impsommeliq = impsommeliq;
  }
  
  /**
   * @return the inviabile
   */
  public String getInviabile() {
    return inviabile;
  }
  
  /**
   * @param inviabile the inviabile to set
   */
  public void setInviabile(String inviabile) {
    this.inviabile = inviabile;
  }
  
  /**
   * @return the stato
   */
  public Integer getStato() {
    return stato;
  }
  
  /**
   * @param stato the stato to set
   */
  public void setStato(Integer stato) {
    this.stato = stato;
  }
  
  /**
   * @return the lottoinbo
   */
  public String getLottoinbo() {
    return lottoinbo;
  }
  
  /**
   * @param lottoinbo the lottoinbo to set
   */
  public void setLottoinbo(String lottoinbo) {
    this.lottoinbo = lottoinbo;
  }
  
  /**
   * @return the idlotto
   */
  public String getIdlotto() {
    return idlotto;
  }
  
  /**
   * @param idlotto the idlotto to set
   */
  public void setIdlotto(String idlotto) {
    this.idlotto = idlotto;
  }
  
  /**
   * @return the testolog
   */
  public String getTestolog() {
    return testolog;
  }
  
  /**
   * @param testolog the testolog to set
   */
  public void setTestolog(String testolog) {
    this.testolog = testolog;
  }
  
  /**
   * @return the codfisresp
   */
  public String getCodfisresp() {
    return codfisresp;
  }
  
  /**
   * @param codfisresp the codfisresp to set
   */
  public void setCodfisresp(String codfisresp) {
    this.codfisresp = codfisresp;
  }
  
  /**
   * @return the nomeresp
   */
  public String getNomeresp() {
    return nomeresp;
  }
  
  /**
   * @param nomeresp the nomeresp to set
   */
  public void setNomeresp(String nomeresp) {
    this.nomeresp = nomeresp;
  }
  
  /**
   * @return the idcontratto
   */
  public String getIdcontratto() {
    return idcontratto;
  }
  
  /**
   * @param idcontratto the idcontratto to set
   */
  public void setIdcontratto(String idcontratto) {
    this.idcontratto = idcontratto;
  }


  @Override
  public String toString() {
    return "Anticorlotti ["
        + (id != null ? "id=" + id + ", " : "")
        + (cig != null ? "cig=" + cig + ", " : "")
        + (stato != null ? "stato=" + stato + ", " : "")
        + (idlotto != null ? "idlotto=" + idlotto + ", " : "")
        + (anticor != null ? "anticor=" + anticor : "")
        + "]";
  }
  
  
}
