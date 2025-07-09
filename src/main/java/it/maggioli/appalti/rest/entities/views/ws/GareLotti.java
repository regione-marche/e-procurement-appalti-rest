package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_gare_lotti</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_gare_lotti")
public class GareLotti {
  @Id
  private String ngara;
  private String codgar;
  private String codice;
  @Column(name="codiceinterno")
  private String codiceInterno;
  private String oggetto;
  private String oggtor;
  private Double importo;
  @Column(name="imptor")
  private Double impTor;
  @Column(name="impnoribasso")
  private Double impNoRibasso;
  @Column(name="impsicurezza")
  private Double impSicurezza;
  @Column(name="imponeriprogett")
  private Double impOneriProgett;
  private String ricmano;
  private Integer modmano;
  private Integer tipologia;
  private String codsa;
  private String descsa;
  private String cfiscsa;
  private Integer codtipsa;
  private String proein;
  private String citein;
  private String viaein;
  private String nciein;
  private Integer uffdet;
  private String respproc;
  private String descrup;
  private Integer codtipoapp;
  private String desctipoapp;
  private Integer codtipogar;
  private String desctipgar;
  private Integer coditergara;
  private Integer codcriagg;
  private String desccriagg;
  private Integer codmodagg;
  private Integer valtec;
  private Integer costofisso;
  private Date datterminepar;
  private String oraterminepar;
  private Date datletterainv;
  private Date dattermineoff;
  private String oratermineoff;
  private Date dataoraterminepar;
  private Date dataoratermineoff;
  private Date dindoc;
  private Date dataoraterminedoc;
  private Date dultagg;
  private String codciglotto;
  private String codcig;
  private String codcupprglotto;
  private String codcupprg;
  private String isarchi;
  private String elencoe;
  private Boolean iselencolotto;
  private Boolean isaggiu;
  private Boolean isesito;
  private Date dataesito;
  private String aggiudicataria;
  private Double iaggiu;//importo aggiudicato???
  private Date dattoa;
  private String codscp;
  private String urlscp;
  private String codavscp;
  private String urlavscp;
  private Integer tattog;
  private Date dattog;
  private String nattog;
  private Integer norma1;
  private String norma;
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
  private Integer ricastae;
  private Date aedinvit;
  private Integer fasgar;
  private Integer rilancio;
  private Integer inversa;
  private Integer sommaur;
  private Integer altrisog;

//  @OneToOne(fetch = FetchType.LAZY)
//  @NotFound(action = NotFoundAction.IGNORE)
//  @JoinColumn(name = "ngara",referencedColumnName = "codice",insertable = false, updatable = false, 
//              foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT),nullable = true)
//  private GareStatoEsito garaStatoEsito;
//  @OneToOne(fetch = FetchType.LAZY)
//  @NotFound(action = NotFoundAction.IGNORE)
//  @JoinColumn(name = "ngara",referencedColumnName = "codice",insertable = false, updatable = false, 
//              foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT),nullable = true)
//  private GareStatoEsitoLotti garaStatoEsitoLotti;
//  
//  
//  public GareStatoEsito getGaraStatoEsito() {
//    return garaStatoEsito;
//  }
//
//  
//  public void setGaraStatoEsito(GareStatoEsito garaStatoEsito) {
//    this.garaStatoEsito = garaStatoEsito;
//  }
//
//  
//  public GareStatoEsitoLotti getGaraStatoEsitoLotti() {
//    return garaStatoEsitoLotti;
//  }
//
//  
//  public void setGaraStatoEsitoLotti(GareStatoEsitoLotti garaStatoEsitoLotti) {
//    this.garaStatoEsitoLotti = garaStatoEsitoLotti;
//  }

  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "ngara", insertable = false, updatable = false,referencedColumnName = "ngara")
  private List<GareCategorie> categoriePrestazioni;
  
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
  
  public String getCodiceInterno() {
    return codiceInterno;
  }
  
  public void setCodiceInterno(String codiceInterno) {
    this.codiceInterno = codiceInterno;
  }
  
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  public String getOggtor() {
    return oggtor;
  }
  
  public void setOggtor(String oggtor) {
    this.oggtor = oggtor;
  }
  
  public Double getImporto() {
    return importo;
  }
  
  public void setImporto(Double importo) {
    this.importo = importo;
  }
  
  public Double getImpTor() {
    return impTor;
  }
  
  public void setImpTor(Double impTor) {
    this.impTor = impTor;
  }
  
  public Double getImpNoRibasso() {
    return impNoRibasso;
  }
  
  public void setImpNoRibasso(Double impNoRibasso) {
    this.impNoRibasso = impNoRibasso;
  }
  
  public Double getImpSicurezza() {
    return impSicurezza;
  }
  
  public void setImpSicurezza(Double impSicurezza) {
    this.impSicurezza = impSicurezza;
  }
  
  public Double getImpOneriProgett() {
    return impOneriProgett;
  }
  
  public void setImpOneriProgett(Double impOneriProgett) {
    this.impOneriProgett = impOneriProgett;
  }
  
  public String getRicmano() {
    return ricmano;
  }
  
  public Integer getModmano() {
    return modmano;
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
  
  public Integer getUffdet() {
    return uffdet;
  }
  
  public void setUffdet(Integer uffdet) {
    this.uffdet = uffdet;
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
  
  public String getDesctipgar() {
    return desctipgar;
  }
  
  public void setDesctipgar(String desctipgar) {
    this.desctipgar = desctipgar;
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
  
  public Date getDatletterainv() {
    return datletterainv;
  }
  
  public void setDatletterainv(Date datletterainv) {
    this.datletterainv = datletterainv;
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
  
  public Date getDindoc() {
    return dindoc;
  }
  
  public void setDindoc(Date dindoc) {
    this.dindoc = dindoc;
  }
  
  public Date getDataoraterminedoc() {
    return dataoraterminedoc;
  }
  
  public void setDataoraterminedoc(Date dataoraterminedoc) {
    this.dataoraterminedoc = dataoraterminedoc;
  }
  
  public Date getDultagg() {
    return dultagg;
  }
  
  public void setDultagg(Date dultagg) {
    this.dultagg = dultagg;
  }
  
  public String getCodciglotto() {
    return codciglotto;
  }
  
  public void setCodciglotto(String codciglotto) {
    this.codciglotto = codciglotto;
  }
  
  public String getCodcig() {
    return codcig;
  }
  
  public void setCodcig(String codcig) {
    this.codcig = codcig;
  }
  
  public String getCodcupprglotto() {
    return codcupprglotto;
  }
  
  public void setCodcupprglotto(String codcupprglotto) {
    this.codcupprglotto = codcupprglotto;
  }
  
  public String getCodcupprg() {
    return codcupprg;
  }
  
  public void setCodcupprg(String codcupprg) {
    this.codcupprg = codcupprg;
  }
  
  public String getIsarchi() {
    return isarchi;
  }
  
  public void setIsarchi(String isarchi) {
    this.isarchi = isarchi;
  }
  
  public String getElencoe() {
    return elencoe;
  }
  
  public void setElencoe(String elencoe) {
    this.elencoe = elencoe;
  }
  
  public Boolean getIselencolotto() {
    return iselencolotto;
  }
  
  public void setIselencolotto(Boolean iselencolotto) {
    this.iselencolotto = iselencolotto;
  }
  
  public Boolean getIsaggiu() {
    return isaggiu;
  }
  
  public void setIsaggiu(Boolean isaggiu) {
    this.isaggiu = isaggiu;
  }
  
  public Boolean getIsesito() {
    return isesito;
  }
  
  public void setIsesito(Boolean isesito) {
    this.isesito = isesito;
  }
  
  public Date getDataesito() {
    return dataesito;
  }
  
  public void setDataesito(Date dataesito) {
    this.dataesito = dataesito;
  }
  
  public String getAggiudicataria() {
    return aggiudicataria;
  }
  
  public void setAggiudicataria(String aggiudicataria) {
    this.aggiudicataria = aggiudicataria;
  }
  
  public Double getIaggiu() {
    return iaggiu;
  }
  
  public void setIaggiu(Double iaggiu) {
    this.iaggiu = iaggiu;
  }
  
  public Date getDattoa() {
    return dattoa;
  }
  
  public void setDattoa(Date dattoa) {
    this.dattoa = dattoa;
  }
  
  public String getCodscp() {
    return codscp;
  }
  
  public void setCodscp(String codscp) {
    this.codscp = codscp;
  }
  
  public String getUrlscp() {
    return urlscp;
  }
  
  public void setUrlscp(String urlscp) {
    this.urlscp = urlscp;
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
  
  public Integer getTattog() {
    return tattog;
  }
  
  public void setTattog(Integer tattog) {
    this.tattog = tattog;
  }
  
  public Date getDattog() {
    return dattog;
  }
  
  public void setDattog(Date dattog) {
    this.dattog = dattog;
  }
  
  public String getNattog() {
    return nattog;
  }
  
  public void setNattog(String nattog) {
    this.nattog = nattog;
  }
  
  public Integer getNorma1() {
    return norma1;
  }
  
  public void setNorma1(Integer norma1) {
    this.norma1 = norma1;
  }
  
  public String getNorma() {
    return norma;
  }
  
  public void setNorma(String norma) {
    this.norma = norma;
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
  
  public Integer getOffanum() {
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
  
  public Integer getRicastae() {
    return ricastae;
  }
  
  public void setRicastae(Integer ricastae) {
    this.ricastae = ricastae;
  }
  
  public Date getAedinvit() {
    return aedinvit;
  }
  
  public void setAedinvit(Date aedinvit) {
    this.aedinvit = aedinvit;
  }
  
  public Integer getFasgar() {
    return fasgar;
  }
  
  public void setFasgar(Integer fasgar) {
    this.fasgar = fasgar;
  }
  
  public Integer getRilancio() {
    return rilancio;
  }
  
  public void setRilancio(Integer rilancio) {
    this.rilancio = rilancio;
  }
  
  public Integer getInversa() {
    return inversa;
  }
  
  public void setInversa(Integer inversa) {
    this.inversa = inversa;
  }
  
  public Integer getSommaur() {
    return sommaur;
  }
  
  public void setSommaur(Integer sommaur) {
    this.sommaur = sommaur;
  }
  
  public Integer getAltrisog() {
    return altrisog;
  }
  
  public void setAltrisog(Integer altrisog) {
    this.altrisog = altrisog;
  }
  
//  public GareStatoEsito getGaraStatoEsito() {
//    return garaStatoEsito;
//  }
//  
//  public void setGaraStatoEsito(GareStatoEsito garaStatoEsito) {
//    this.garaStatoEsito = garaStatoEsito;
//  }
//  
//  public GareStatoEsitoLotti getGaraStatoEsitoLotti() {
//    return garaStatoEsitoLotti;
//  }
//  
//  public void setGaraStatoEsitoLotti(GareStatoEsitoLotti garaStatoEsitoLotti) {
//    this.garaStatoEsitoLotti = garaStatoEsitoLotti;
//  }

  
  public List<GareCategorie> getCategoriePrestazioni() {
    return categoriePrestazioni;
  }

  
  public void setCategoriePrestazioni(List<GareCategorie> categoriePrestazioni) {
    this.categoriePrestazioni = categoriePrestazioni;
  }

  
  public Integer getOffaum() {
    return offaum;
  }

  
  public void setRicmano(String ricmano) {
    this.ricmano = ricmano;
  }

  
  public void setModmano(Integer modmano) {
    this.modmano = modmano;
  }

  @Override
  public String toString() {
    return "GareLotti ["
        + (ngara != null ? "ngara=" + ngara + ", " : "")
        + (codgar != null ? "codgar=" + codgar + ", " : "")
        + (codice != null ? "codice=" + codice + ", " : "")
        + (oggetto != null ? "oggetto=" + oggetto + ", " : "")
        + (importo != null ? "importo=" + importo + ", " : "")
//        + (garaStatoEsito != null ? "garaStatoEsito=" + garaStatoEsito + ", " : "")
//        + (garaStatoEsitoLotti != null ? "garaStatoEsitoLotti=" + garaStatoEsitoLotti : "")
        + "]";
  }
  
  
  
  
  
}
