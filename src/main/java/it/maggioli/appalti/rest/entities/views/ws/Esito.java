package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_esiti</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_esiti")
public class Esito {
  private String ngara;
  private String codgar;
  @Id
  private String codice;
  private String oggetto;
  private Double importo;
  private Double impnoribasso;
  private Double impsicurezza;
  private Double imponeriprogett;
  private Integer tipologia;
  private String codsa;
  private String descsa;
  private String cfiscsa;
  private Integer codtipsa;
  private String proein;
  private String citein;
  private String viaein;
  private String nciein;
  private String respproc;
  private String descrup;
  private Integer codtipoapp;
  private String desctipoapp;
  private Integer codtipogar;
  private String desctipogar;
  private Integer coditergara;
  private Integer codcriagg;
  private String desccriagg;
  private Integer codmodagg;
  private Integer valtec;
  private Integer costofisso;
  private Date datpub;
  private Date dattermineoff;
  private String oratermineoff;
  private Date datterminepar;
  private String oraterminepar;
  private Date dattermine;
  private String oratermine;
  private Date dataoraterminepar;
  private Date dataoratermineoff;
  private String codcig;
  private String codcupprg;
  private String elencoe;
  private String isarchi;
  private Boolean iselenco;
  private Integer codstatogara;
  private String descstatogara;
  private String descstatoesito;
  private Date dataesito;
  private Double annoinizioperscadenza;
  private Date dultagg;
  private Double iaggiu;
  private String codavscp;
  private String urlavscp;
  private Boolean isaccordoquadro;
  private Integer naggiudicatari;
  private Boolean gartel;
  private Boolean offtel;
  private Integer ribcal;
  private Integer offaum;
  private Integer sicinc;
  private Integer onsogrib;
  private Boolean isoffpermuta;
  private Boolean isoffcanoneass;
  private String valoff;
  private Integer bustedistinte;
  private Boolean sommaur;
  private Integer altrisog;
  private Integer garpriv;
  private Integer prerib;
  
  public String getNgara() {
    return ngara;
  }
  
  public void setNgara(String ngara) {
    this.ngara = ngara;
  }
  
  public String getCodgar() {
    return codgar;
  }
  
  public void setCodgar(String codgar) {
    this.codgar = codgar;
  }
  
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  public Double getImporto() {
    return importo;
  }
  
  public void setImporto(Double importo) {
    this.importo = importo;
  }
  
  public Double getImpnoribasso() {
    return impnoribasso;
  }
  
  public void setImpnoribasso(Double impnoribasso) {
    this.impnoribasso = impnoribasso;
  }
  
  public Double getImpsicurezza() {
    return impsicurezza;
  }
  
  public void setImpsicurezza(Double impsicurezza) {
    this.impsicurezza = impsicurezza;
  }
  
  public Double getImponeriprogett() {
    return imponeriprogett;
  }
  
  public void setImponeriprogetti(Double imponeriprogett) {
    this.imponeriprogett = imponeriprogett;
  }
  
  public Integer getTipologia() {
    return tipologia;
  }
  
  public void setTipologia(Integer tipologia) {
    this.tipologia = tipologia;
  }
  
  public String getCodsa() {
    return codsa;
  }
  
  public void setCodsa(String codsa) {
    this.codsa = codsa;
  }
  
  public String getDescsa() {
    return descsa;
  }
  
  public void setDescsa(String descsa) {
    this.descsa = descsa;
  }
  
  public String getCfiscsa() {
    return cfiscsa;
  }
  
  public void setCfiscsa(String cfiscsa) {
    this.cfiscsa = cfiscsa;
  }
  
  public Integer getCodtipsa() {
    return codtipsa;
  }
  
  public void setCodtipsa(Integer codtipsa) {
    this.codtipsa = codtipsa;
  }
  
  public String getProein() {
    return proein;
  }
  
  public void setProein(String proein) {
    this.proein = proein;
  }
  
  public String getCitein() {
    return citein;
  }
  
  public void setCitein(String citein) {
    this.citein = citein;
  }
  
  public String getViaein() {
    return viaein;
  }
  
  public void setViaein(String viaein) {
    this.viaein = viaein;
  }
  
  public String getNciein() {
    return nciein;
  }
  
  public void setNciein(String nciein) {
    this.nciein = nciein;
  }
  
  public String getRespproc() {
    return respproc;
  }
  
  public void setRespproc(String respproc) {
    this.respproc = respproc;
  }
  
  public String getDescrup() {
    return descrup;
  }
  
  public void setDescrup(String descrup) {
    this.descrup = descrup;
  }
  
  public Integer getCodtipoapp() {
    return codtipoapp;
  }
  
  public void setCodtipoapp(Integer codtipoapp) {
    this.codtipoapp = codtipoapp;
  }
  
  public String getDesctipoapp() {
    return desctipoapp;
  }
  
  public void setDesctipoapp(String desctipoapp) {
    this.desctipoapp = desctipoapp;
  }
  
  public Integer getCodtipogar() {
    return codtipogar;
  }
  
  public void setCodtipogar(Integer codtipogar) {
    this.codtipogar = codtipogar;
  }
  
  public String getDesctipogar() {
    return desctipogar;
  }
  
  public void setDesctipogar(String desctipogar) {
    this.desctipogar = desctipogar;
  }
  
  public Integer getCoditergara() {
    return coditergara;
  }
  
  public void setCoditergara(Integer coditergara) {
    this.coditergara = coditergara;
  }
  
  public Integer getCodcriagg() {
    return codcriagg;
  }
  
  public void setCodcriagg(Integer codcriagg) {
    this.codcriagg = codcriagg;
  }
  
  public String getDesccriagg() {
    return desccriagg;
  }
  
  public void setDesccriagg(String desccriagg) {
    this.desccriagg = desccriagg;
  }
  
  public Integer getCodmodagg() {
    return codmodagg;
  }
  
  public void setCodmodagg(Integer codmodagg) {
    this.codmodagg = codmodagg;
  }
  
  public Integer getValtec() {
    return valtec;
  }
  
  public void setValtec(Integer valtec) {
    this.valtec = valtec;
  }
  
  public Integer getCostofisso() {
    return costofisso;
  }
  
  public void setCostofisso(Integer costofisso) {
    this.costofisso = costofisso;
  }
  
  public Date getDatpub() {
    return datpub;
  }
  
  public void setDatpub(Date datpub) {
    this.datpub = datpub;
  }
  
  public Date getDattermineoff() {
    return dattermineoff;
  }
  
  public void setDattermineoff(Date dattermineoff) {
    this.dattermineoff = dattermineoff;
  }
  
  public String getOratermineoff() {
    return oratermineoff;
  }
  
  public void setOratermineoff(String oratermineoff) {
    this.oratermineoff = oratermineoff;
  }
  
  public Date getDatterminepar() {
    return datterminepar;
  }
  
  public void setDatterminepar(Date datterminepar) {
    this.datterminepar = datterminepar;
  }
  
  public String getOraterminepar() {
    return oraterminepar;
  }
  
  public void setOraterminepar(String oraterminepar) {
    this.oraterminepar = oraterminepar;
  }
  
  public Date getDattermine() {
    return dattermine;
  }
  
  public void setDattermine(Date dattermine) {
    this.dattermine = dattermine;
  }
  
  public String getOratermine() {
    return oratermine;
  }
  
  public void setOratermine(String oratermine) {
    this.oratermine = oratermine;
  }
  
  public Date getDataoraterminepar() {
    return dataoraterminepar;
  }
  
  public void setDataoraterminepar(Date dataoraterminepar) {
    this.dataoraterminepar = dataoraterminepar;
  }
  
  public Date getDataoratermineoff() {
    return dataoratermineoff;
  }
  
  public void setDataoratermineoff(Date dataoratermineoff) {
    this.dataoratermineoff = dataoratermineoff;
  }
  
  public String getCodcig() {
    return codcig;
  }
  
  public void setCodcig(String codcig) {
    this.codcig = codcig;
  }
  
  public String getCodcupprg() {
    return codcupprg;
  }
  
  public void setCodcupprg(String codcupprg) {
    this.codcupprg = codcupprg;
  }
  
  public String getElencoe() {
    return elencoe;
  }
  
  public void setElencoe(String elencoe) {
    this.elencoe = elencoe;
  }
  
  public String getIsarchi() {
    return isarchi;
  }
  
  public void setIsarchi(String isarchi) {
    this.isarchi = isarchi;
  }
  
  public Boolean getIselenco() {
    return iselenco;
  }
  
  public void setIselenco(Boolean iselenco) {
    this.iselenco = iselenco;
  }
  
  public Integer getCodstatogara() {
    return codstatogara;
  }
  
  public void setCodstatogara(Integer codstatogara) {
    this.codstatogara = codstatogara;
  }
  
  public String getDescstatogara() {
    return descstatogara;
  }
  
  public void setDescstatogara(String descstatogara) {
    this.descstatogara = descstatogara;
  }
  
  public String getDescstatoesito() {
    return descstatoesito;
  }
  
  public void setDescstatoesito(String descstatoesito) {
    this.descstatoesito = descstatoesito;
  }
  
  public Date getDataesito() {
    return dataesito;
  }
  
  public void setDataesito(Date dataesito) {
    this.dataesito = dataesito;
  }
  
  public Double getAnnoinizioperscadenza() {
    return annoinizioperscadenza;
  }
  
  public void setAnnoinizioperscadenza(Double annoinizioperscadenza) {
    this.annoinizioperscadenza = annoinizioperscadenza;
  }
  
  public Date getDultagg() {
    return dultagg;
  }
  
  public void setDultagg(Date dultagg) {
    this.dultagg = dultagg;
  }
  
  public Double getIaggiu() {
    return iaggiu;
  }
  
  public void setIaggiu(Double iaggiu) {
    this.iaggiu = iaggiu;
  }
  
  public String getCodavscp() {
    return codavscp;
  }
  
  public void setCodavscp(String codavscp) {
    this.codavscp = codavscp;
  }
  
  public String getUrlavscp() {
    return urlavscp;
  }
  
  public void setUrlavscp(String urlavscp) {
    this.urlavscp = urlavscp;
  }
  
  public Boolean getIsaccordoquadro() {
    return isaccordoquadro;
  }
  
  public void setIsaccordoquadro(Boolean isaccordoquadro) {
    this.isaccordoquadro = isaccordoquadro;
  }
  
  public Integer getNaggiudicatari() {
    return naggiudicatari;
  }
  
  public void setNaggiudicatari(Integer naggiudicatari) {
    this.naggiudicatari = naggiudicatari;
  }
  
  public Boolean getGartel() {
    return gartel;
  }
  
  public void setGartel(Boolean gartel) {
    this.gartel = gartel;
  }
  
  public Boolean getOfftel() {
    return offtel;
  }
  
  public void setOfftel(Boolean offtel) {
    this.offtel = offtel;
  }
  
  public Integer getRibcal() {
    return ribcal;
  }
  
  public void setRibcal(Integer ribcal) {
    this.ribcal = ribcal;
  }
  
  public Integer getOffaum() {
    return offaum;
  }
  
  public void setOffaum(Integer offaum) {
    this.offaum = offaum;
  }
  
  public Integer getSicinc() {
    return sicinc;
  }
  
  public void setSicinc(Integer sicinc) {
    this.sicinc = sicinc;
  }
  
  public Integer getOnsogrib() {
    return onsogrib;
  }
  
  public void setOnsogrib(Integer onsogrib) {
    this.onsogrib = onsogrib;
  }
  
  public Boolean getIsoffpermuta() {
    return isoffpermuta;
  }
  
  public void setIsoffpermuta(Boolean isoffpermuta) {
    this.isoffpermuta = isoffpermuta;
  }
  
  public Boolean getIsoffcanoneass() {
    return isoffcanoneass;
  }
  
  public void setIsoffcanoneass(Boolean isoffcanoneass) {
    this.isoffcanoneass = isoffcanoneass;
  }
  
  public String getValoff() {
    return valoff;
  }
  
  public void setValoff(String valoff) {
    this.valoff = valoff;
  }
  
  public Integer getBustedistinte() {
    return bustedistinte;
  }
  
  public void setBustedistinte(Integer bustedistinte) {
    this.bustedistinte = bustedistinte;
  }
  
  public Boolean getSommaur() {
    return sommaur;
  }
  
  public void setSommaur(Boolean sommaur) {
    this.sommaur = sommaur;
  }
  
  public Integer getAltrisog() {
    return altrisog;
  }
  
  public void setAltrisog(Integer altrisog) {
    this.altrisog = altrisog;
  }
  
  
  /**
   * @return the garpriv
   */
  public Integer getGarpriv() {
    return garpriv;
  }

  
  /**
   * @param garpriv the garpriv to set
   */
  public void setGarpriv(Integer garpriv) {
    this.garpriv = garpriv;
  }

  
  /**
   * @return the prerib
   */
  public Integer getPrerib() {
    return prerib;
  }

  
  /**
   * @param prerib the prerib to set
   */
  public void setPrerib(Integer prerib) {
    this.prerib = prerib;
  }

  
  /**
   * @param imponeriprogett the imponeriprogett to set
   */
  public void setImponeriprogett(Double imponeriprogett) {
    this.imponeriprogett = imponeriprogett;
  }

  @Override
  public String toString() {
    return "Esito ["
        + (ngara != null ? "ngara=" + ngara + ", " : "")
        + (codgar != null ? "codgar=" + codgar + ", " : "")
        + (codice != null ? "codice=" + codice + ", " : "")
        + (oggetto != null ? "oggetto=" + oggetto + ", " : "")
        + (garpriv != null ? "garpriv=" + garpriv + ", " : "")
        + (importo != null ? "importo=" + importo : "")
        + "]";
  }
  
}
