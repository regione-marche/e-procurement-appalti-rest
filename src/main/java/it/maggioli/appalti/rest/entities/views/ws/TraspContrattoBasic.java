package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Questa classe rappresenta la base dei dati per i contratti della trasparenza
 * @author gabriele.nencini
 *
 */
@MappedSuperclass
public class TraspContrattoBasic {
  //Id needed for Hibernate
  @Id
  private String codice;
  private Date datapubbgara;
  private Date datainvito;
  private Date dataaggiudicazione;
  private Date datapubbesito;
  private String cig;
  private String codiceprop;
  private String codfiscprop;
  private String denomprop;
  private String oggetto;
  private Integer tipgarg;
  private String descsceltacontr;
  private Integer singolaaggiudicataria;
  @Column(insertable = false,updatable = false)
  private String codaggiudicataria;
  private String descaggiudicataria;
  private String codfiscaggiudicataria;
  private String partivaaggiudicataria;
  private Double impaggiudic;
  private Date datainizio;
  private Date datafine;
  private Double impsommeliq;
  
  /*
   * Sono gli operatori invitati
   */
  @OneToMany(fetch = FetchType.LAZY,mappedBy = "codice")
  @Fetch(FetchMode.SUBSELECT)
  @OrderBy("ragsoc ASC")
  private List<TraspContrattoPartecipante> partecipanti;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "codaggiudicataria", referencedColumnName = "ditta")
  private TraspContrattoPartecipante aggiudicataria;
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public Date getDatapubbgara() {
    return datapubbgara;
  }
  
  public void setDatapubbgara(Date datapubbgara) {
    this.datapubbgara = datapubbgara;
  }
  
  public Date getDatainvito() {
    return datainvito;
  }
  
  public void setDatainvito(Date datainvito) {
    this.datainvito = datainvito;
  }
  
  public Date getDataaggiudicazione() {
    return dataaggiudicazione;
  }
  
  public void setDataaggiudicazione(Date dataaggiudicazione) {
    this.dataaggiudicazione = dataaggiudicazione;
  }
  
  public Date getDatapubbesito() {
    return datapubbesito;
  }
  
  public void setDatapubbesito(Date datapubbesito) {
    this.datapubbesito = datapubbesito;
  }
  
  public String getCig() {
    return cig;
  }
  
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  public String getCodiceprop() {
    return codiceprop;
  }
  
  public void setCodiceprop(String codiceprop) {
    this.codiceprop = codiceprop;
  }
  
  public String getCodfiscprop() {
    return codfiscprop;
  }
  
  public void setCodfiscprop(String codfiscprop) {
    this.codfiscprop = codfiscprop;
  }
  
  public String getDenomprop() {
    return denomprop;
  }
  
  public void setDenomprop(String denomprop) {
    this.denomprop = denomprop;
  }
  
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  public Integer getTipgarg() {
    return tipgarg;
  }
  
  public void setTipgarg(Integer tipgarg) {
    this.tipgarg = tipgarg;
  }
  
  public String getDescsceltacontr() {
    return descsceltacontr;
  }
  
  public void setDescsceltacontr(String descsceltacontr) {
    this.descsceltacontr = descsceltacontr;
  }
  
  public Integer getSingolaaggiudicataria() {
    return singolaaggiudicataria;
  }
  
  public void setSingolaaggiudicataria(Integer singolaaggiudicataria) {
    this.singolaaggiudicataria = singolaaggiudicataria;
  }
  
  public String getCodaggiudicataria() {
    return codaggiudicataria;
  }
  
  public void setCodaggiudicataria(String codaggiudicataria) {
    this.codaggiudicataria = codaggiudicataria;
  }
  
  public String getDescaggiudicataria() {
    return descaggiudicataria;
  }
  
  public void setDescaggiudicataria(String descaggiudicataria) {
    this.descaggiudicataria = descaggiudicataria;
  }
  
  public String getCodfiscaggiudicataria() {
    return codfiscaggiudicataria;
  }
  
  public void setCodfiscaggiudicataria(String codfiscaggiudicataria) {
    this.codfiscaggiudicataria = codfiscaggiudicataria;
  }
  
  public String getPartivaaggiudicataria() {
    return partivaaggiudicataria;
  }
  
  public void setPartivaaggiudicataria(String partivaaggiudicataria) {
    this.partivaaggiudicataria = partivaaggiudicataria;
  }
  
  public Double getImpaggiudic() {
    return impaggiudic;
  }
  
  public void setImpaggiudic(Double impaggiudic) {
    this.impaggiudic = impaggiudic;
  }
  
  public Date getDatainizio() {
    return datainizio;
  }
  
  public void setDatainizio(Date datainizio) {
    this.datainizio = datainizio;
  }
  
  public Date getDatafine() {
    return datafine;
  }
  
  public void setDatafine(Date datafine) {
    this.datafine = datafine;
  }
  
  public Double getImpsommeliq() {
    return impsommeliq;
  }
  
  public void setImpsommeliq(Double impsommeliq) {
    this.impsommeliq = impsommeliq;
  }
  
  /**
   * Restituisce la lista degli operatori invitati
   */
  public List<TraspContrattoPartecipante> getPartecipanti() {
    return partecipanti;
  }
  
  public void setPartecipanti(List<TraspContrattoPartecipante> partecipanti) {
    this.partecipanti = partecipanti;
  }

  
  public TraspContrattoPartecipante getAggiudicataria() {
    return aggiudicataria;
  }

  
  public void setAggiudicataria(TraspContrattoPartecipante aggiudicataria) {
    this.aggiudicataria = aggiudicataria;
  }
  
  
}
