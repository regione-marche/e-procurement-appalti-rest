package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Immutable;

import it.maggioli.appalti.rest.entities.Gare;

/**
 * Classe che mappa la vista <code>v_ws_comunicazioni_da_sa</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_comunicazioni_da_sa")
public class Comunicazione {
  @Id
  private Long idcom;
  private Long idcomdes;
  private String nomeuser;
  private String codice;
  private String commsgogg; //oggetto
  private String commsgtes; //testo
//  private Date comdatains;
  private Date datainvio;
  private Date dataorainvio;
  private Date dataoralettura;
  private Date dataoraprotocollo;
  private String numprotocollo;
  private Integer bloccarispondi;
  private String comdatins;
  private transient String genere;
  private transient String titolo;
  private transient String tipologia;
  private String idcfg;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "codice", insertable = false, updatable = false,referencedColumnName = "ngara")
  @Fetch(FetchMode.JOIN)
  private Gare gara;
  
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "idcom", insertable = false, updatable = false,referencedColumnName = "idcom")
//  @Fetch(FetchMode.SUBSELECT)
  private List<ComunicazioneDocumento> comunicazioni;
  
  public Gare getGara() {
    return gara;
  }
  
  public void setGara(Gare gara) {
    this.gara = gara;
  }

  public Long getIdcom() {
    return idcom;
  }
  
  public void setIdcom(Long idcom) {
    this.idcom = idcom;
  }
  
  public Long getIdcomdes() {
    return idcomdes;
  }
  
  public void setIdcomdes(Long idcomdes) {
    this.idcomdes = idcomdes;
  }
  
  public String getNomeuser() {
    return nomeuser;
  }
  
  public void setNomeuser(String nomeuser) {
    this.nomeuser = nomeuser;
  }
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public String getCommsgogg() {
    return commsgogg;
  }
  
  public void setCommsgogg(String commsgogg) {
    this.commsgogg = commsgogg;
  }
  
  public String getCommsgtes() {
    return commsgtes;
  }
  
  public void setCommsgtes(String commsgtes) {
    this.commsgtes = commsgtes;
  }
  
//  public Date getComdatains() {
//    return comdatains;
//  }
//  
//  public void setComdatains(Date comdatains) {
//    this.comdatains = comdatains;
//  }
  
  public Date getDatainvio() {
    return datainvio;
  }
  
  public void setDatainvio(Date datainvio) {
    this.datainvio = datainvio;
  }
  
  public Date getDataorainvio() {
    return dataorainvio;
  }
  
  public void setDataorainvio(Date dataorainvio) {
    this.dataorainvio = dataorainvio;
  }
  
  public Date getDataoralettura() {
    return dataoralettura;
  }
  
  public void setDataoralettura(Date dataoralettura) {
    this.dataoralettura = dataoralettura;
  }
  
  public Date getDataoraprotocollo() {
    return dataoraprotocollo;
  }
  
  public void setDataoraprotocollo(Date dataoraprotocollo) {
    this.dataoraprotocollo = dataoraprotocollo;
  }
  
  public String getNumprotocollo() {
    return numprotocollo;
  }
  
  public void setNumprotocollo(String numprotocollo) {
    this.numprotocollo = numprotocollo;
  }
  
  public Integer getBloccarispondi() {
    return bloccarispondi;
  }
  
  public void setBloccarispondi(Integer bloccarispondi) {
    this.bloccarispondi = bloccarispondi;
  }
  
  public String getComdatins() {
    return comdatins;
  }
  
  public void setComdatins(String comdatins) {
    this.comdatins = comdatins;
  }
  
  public String getGenere() {
    return genere;
  }
  
  public void setGenere(String genere) {
    this.genere = genere;
  }
  
  public String getTitolo() {
    return titolo;
  }
  
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }
  
  public String getTipologia() {
    return tipologia;
  }
  
  public void setTipologia(String tipologia) {
    this.tipologia = tipologia;
  }
  
  public String getIdcfg() {
    return idcfg;
  }
  
  public void setIdcfg(String idcfg) {
    this.idcfg = idcfg;
  }
  
  public List<ComunicazioneDocumento> getComunicazioni() {
    return comunicazioni;
  }
  
  public void setComunicazioni(List<ComunicazioneDocumento> comunicazioni) {
    this.comunicazioni = comunicazioni;
  }
  
}
