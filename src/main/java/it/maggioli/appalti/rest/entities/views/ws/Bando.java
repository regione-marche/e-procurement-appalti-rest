package it.maggioli.appalti.rest.entities.views.ws;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe che mappa la vista <code>v_ws_bandi</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_bandi")
public class Bando  implements Serializable {
  private static final long serialVersionUID = 1L;
  @Column(name = "descsa")
  protected String stazioneAppaltante;
  @Id
  @Column(name = "codice")
  protected String codice;
  @Column(name = "oggetto")
  protected String oggetto;
  @Column(name = "codcig")
  protected String cig;
  @Column(name = "codcupprg")
  protected String cup;
  @Column(name = "tipologia")
  protected int tipologia;
  @Column(name = "bustedistinte")
  protected Boolean busteDistinte;
  @Column(name = "desctipoapp")
  protected String tipoAppalto;
  @Column(name = "desctipogar")
  protected String tipoProcedura;
  @Column(name = "codtipoapp")
  protected String idTipoAppalto;
  @Column(name = "desccriagg")
  protected String tipoAggiudicazione;
  @Column(name = "codmodagg")
  protected Integer modalitaAggiudicazione;
  @Column(name = "importo")
  protected double importo;
  @Column(name = "impnoribasso")
  protected Double importoNonSoggettoRibasso;
  @Column(name = "impsicurezza")
  protected Double importoSicurezza;
  @Column(name = "ricmano")
  protected String richiestaManodopera;
  @Column(name = "modmano")
  protected Integer modalitaManodopera;
  @Column(name = "imponeriprogett")
  protected Double importoOneriProgettazione;
  @Column(name = "gartel")
  protected boolean proceduraTelematica;
  @Column(name = "offtel")
  protected boolean offertaTelematica;
  @Column(name = "ribcal")
  protected Integer tipoRibasso;
  @Column(name = "offaum")
  protected boolean ammessaOffertaInAumento;
  @Column(name = "sicinc")
  protected boolean offertaComprensivaSicurezza;
  @Column(name = "onsogrib")
  protected boolean oneriSoggettiRibasso;
  @Column(name = "isoffpermuta")
  protected boolean offertaPerPermuta;
  @Column(name = "isoffcanoneass")
  protected boolean offertaPerCanoneAssistenza;
  @Column(name = "valoff")
  protected String numGiorniValiditaOfferta;
  @Column(name = "descstatogara")
  protected String stato;
  @Column(name = "datpub")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  protected Date dataPubblicazione;
  @Column(name = "dattermine")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  protected Date dataTermine;
  @Column(name = "oratermine")
  protected String oraTermine;
  @Column(name = "datterminepar")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  protected Date dataTerminePresentazioneDomanda;
  @Column(name = "oraterminepar")
  protected String oraTerminePresentazioneDomanda;
  @Column(name = "dattermineoff")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  protected Date dataTerminePresentazioneOfferta;
  @Column(name = "oratermineoff")
  protected String oraTerminePresentazioneOfferta;
  @Column(name = "dataesito")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  protected Date dataEsito;
  @Column(name = "descstatoesito")
  protected String esito;
  @Column(name = "coditergara")
  protected Integer iterGara;
  @Column(name = "ricastae")
  protected boolean astaElettronica;    
  @Column(name = "aedinvit")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  protected Date dataInvitoAsta;
  @Column(name = "dultagg")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  protected Date dataUltimaModifica;
  @Column(name = "fasgar")
  protected Integer faseGara;
  @Column(name = "costofisso")
  protected Integer costoFisso;
  @Column(name = "rilancio")
  protected boolean garaRilancio;
  @Column(name = "inversa")
  protected boolean proceduraInversa;
  @Column(name = "sommaur")
  protected boolean sommaUrgenza;
  @Column(name = "altrisog")
  protected Integer altriSoggetti;
  @Column(name = "isaccordoquadro")
  protected boolean accordoQuadro;
  @Column(name = "codstatogara")
  protected int codstatogara;
  @Column(name = "codsa")
  protected String codsa;
  @Column(name = "annoinizioperscadenza")
  protected Double annoinizioperscadenza;
  
  public String getStazioneAppaltante() {
    return stazioneAppaltante;
  }
  
  public void setStazioneAppaltante(String stazioneAppaltante) {
    this.stazioneAppaltante = stazioneAppaltante;
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
  
  public String getCig() {
    return cig;
  }
  
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  public String getCup() {
    return cup;
  }
  
  public void setCup(String cup) {
    this.cup = cup;
  }
  
  public int getTipologia() {
    return tipologia;
  }
  
  public void setTipologia(int tipologia) {
    this.tipologia = tipologia;
  }
  
  public Boolean getBusteDistinte() {
    return busteDistinte;
  }
  
  public void setBusteDistinte(Boolean busteDistinte) {
    this.busteDistinte = busteDistinte;
  }
  
  public String getTipoAppalto() {
    return tipoAppalto;
  }
  
  public void setTipoAppalto(String tipoAppalto) {
    this.tipoAppalto = tipoAppalto;
  }
  
  public String getTipoProcedura() {
    return tipoProcedura;
  }
  
  public void setTipoProcedura(String tipoProcedura) {
    this.tipoProcedura = tipoProcedura;
  }
  
  public String getTipoAggiudicazione() {
    return tipoAggiudicazione;
  }
  
  public void setTipoAggiudicazione(String tipoAggiudicazione) {
    this.tipoAggiudicazione = tipoAggiudicazione;
  }
  
  public Integer getModalitaAggiudicazione() {
    return modalitaAggiudicazione;
  }
  
  public void setModalitaAggiudicazione(Integer modalitaAggiudicazione) {
    this.modalitaAggiudicazione = modalitaAggiudicazione;
  }
  
  public double getImporto() {
    return importo;
  }
  
  public void setImporto(double importo) {
    this.importo = importo;
  }
  
  public Double getImportoNonSoggettoRibasso() {
    return importoNonSoggettoRibasso;
  }
  
  public void setImportoNonSoggettoRibasso(Double importoNonSoggettoRibasso) {
    this.importoNonSoggettoRibasso = importoNonSoggettoRibasso;
  }
  
  public Double getImportoSicurezza() {
    return importoSicurezza;
  }
  
  public void setImportoSicurezza(Double importoSicurezza) {
    this.importoSicurezza = importoSicurezza;
  }
  
  public String getRichiestaManodopera() {
    return richiestaManodopera;
  }
  
  public void setRichiestaManodopera(String richiestaManodopera) {
    this.richiestaManodopera = richiestaManodopera;
  }
  
  public Integer getModalitaManodopera() {
    return modalitaManodopera;
  }
  
  public void setModalitaManodopera(Integer modalitaManodopera) {
    this.modalitaManodopera = modalitaManodopera;
  }
  
  public Double getImportoOneriProgettazione() {
    return importoOneriProgettazione;
  }
  
  public void setImportoOneriProgettazione(Double importoOneriProgettazione) {
    this.importoOneriProgettazione = importoOneriProgettazione;
  }
  
  public boolean isProceduraTelematica() {
    return proceduraTelematica;
  }
  
  public void setProceduraTelematica(boolean proceduraTelematica) {
    this.proceduraTelematica = proceduraTelematica;
  }
  
  public boolean isOffertaTelematica() {
    return offertaTelematica;
  }
  
  public void setOffertaTelematica(boolean offertaTelematica) {
    this.offertaTelematica = offertaTelematica;
  }
  
  public Integer getTipoRibasso() {
    return tipoRibasso;
  }
  
  public void setTipoRibasso(Integer tipoRibasso) {
    this.tipoRibasso = tipoRibasso;
  }
  
  public boolean isAmmessaOffertaInAumento() {
    return ammessaOffertaInAumento;
  }
  
  public void setAmmessaOffertaInAumento(boolean ammessaOffertaInAumento) {
    this.ammessaOffertaInAumento = ammessaOffertaInAumento;
  }
  
  public boolean isOffertaComprensivaSicurezza() {
    return offertaComprensivaSicurezza;
  }
  
  public void setOffertaComprensivaSicurezza(boolean offertaComprensivaSicurezza) {
    this.offertaComprensivaSicurezza = offertaComprensivaSicurezza;
  }
  
  public boolean isOneriSoggettiRibasso() {
    return oneriSoggettiRibasso;
  }
  
  public void setOneriSoggettiRibasso(boolean oneriSoggettiRibasso) {
    this.oneriSoggettiRibasso = oneriSoggettiRibasso;
  }
  
  public boolean isOffertaPerPermuta() {
    return offertaPerPermuta;
  }
  
  public void setOffertaPerPermuta(boolean offertaPerPermuta) {
    this.offertaPerPermuta = offertaPerPermuta;
  }
  
  public boolean isOffertaPerCanoneAssistenza() {
    return offertaPerCanoneAssistenza;
  }
  
  public void setOffertaPerCanoneAssistenza(boolean offertaPerCanoneAssistenza) {
    this.offertaPerCanoneAssistenza = offertaPerCanoneAssistenza;
  }
  
  public String getNumGiorniValiditaOfferta() {
    return numGiorniValiditaOfferta;
  }
  
  public void setNumGiorniValiditaOfferta(String numGiorniValiditaOfferta) {
    this.numGiorniValiditaOfferta = numGiorniValiditaOfferta;
  }
  
  public String getStato() {
    return stato;
  }
  
  public void setStato(String stato) {
    this.stato = stato;
  }
  
  public Date getDataPubblicazione() {
    return dataPubblicazione;
  }
  
  public void setDataPubblicazione(Date dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }
  
  public Date getDataTermine() {
    return dataTermine;
  }
  
  public void setDataTermine(Date dataTermine) {
    this.dataTermine = dataTermine;
  }
  
  public String getOraTermine() {
    return oraTermine;
  }
  
  public void setOraTermine(String oraTermine) {
    this.oraTermine = oraTermine;
  }
  
  public Date getDataTerminePresentazioneDomanda() {
    return dataTerminePresentazioneDomanda;
  }
  
  public void setDataTerminePresentazioneDomanda(Date dataTerminePresentazioneDomanda) {
    this.dataTerminePresentazioneDomanda = dataTerminePresentazioneDomanda;
  }
  
  public String getOraTerminePresentazioneDomanda() {
    return oraTerminePresentazioneDomanda;
  }
  
  public void setOraTerminePresentazioneDomanda(String oraTerminePresentazioneDomanda) {
    this.oraTerminePresentazioneDomanda = oraTerminePresentazioneDomanda;
  }
  
  public Date getDataTerminePresentazioneOfferta() {
    return dataTerminePresentazioneOfferta;
  }
  
  public void setDataTerminePresentazioneOfferta(Date dataTerminePresentazioneOfferta) {
    this.dataTerminePresentazioneOfferta = dataTerminePresentazioneOfferta;
  }
  
  public String getOraTerminePresentazioneOfferta() {
    return oraTerminePresentazioneOfferta;
  }
  
  public void setOraTerminePresentazioneOfferta(String oraTerminePresentazioneOfferta) {
    this.oraTerminePresentazioneOfferta = oraTerminePresentazioneOfferta;
  }
  
  public Date getDataEsito() {
    return dataEsito;
  }
  
  public void setDataEsito(Date dataEsito) {
    this.dataEsito = dataEsito;
  }
  
  public String getEsito() {
    return esito;
  }
  
  public void setEsito(String esito) {
    this.esito = esito;
  }
  
  public String getIterGara() {
    return iterGara==null?"":iterGara.toString();
  }
  
  public void setIterGara(Integer iterGara) {
    this.iterGara = iterGara;
  }
  
  public boolean isAstaElettronica() {
    return astaElettronica;
  }
  
  public void setAstaElettronica(boolean astaElettronica) {
    this.astaElettronica = astaElettronica;
  }
  
  public Date getDataInvitoAsta() {
    return dataInvitoAsta;
  }
  
  public void setDataInvitoAsta(Date dataInvitoAsta) {
    this.dataInvitoAsta = dataInvitoAsta;
  }
  
  public Integer getFaseGara() {
    return faseGara;
  }
  
  public void setFaseGara(Integer faseGara) {
    this.faseGara = faseGara;
  }
  
  public Integer getCostoFisso() {
    return costoFisso;
  }
  
  public void setCostoFisso(Integer costoFisso) {
    this.costoFisso = costoFisso;
  }
  
  public boolean isGaraRilancio() {
    return garaRilancio;
  }
  
  public void setGaraRilancio(boolean garaRilancio) {
    this.garaRilancio = garaRilancio;
  }
  
  public boolean isProceduraInversa() {
    return proceduraInversa;
  }
  
  public void setProceduraInversa(boolean proceduraInversa) {
    this.proceduraInversa = proceduraInversa;
  }
  
  public boolean isAccordoQuadro() {
    return accordoQuadro;
  }
  
  public void setAccordoQuadro(boolean accordoQuadro) {
    this.accordoQuadro = accordoQuadro;
  }
  
  public int getCodstatogara() {
    return codstatogara;
  }
  
  public void setCodstatogara(int codstatogara) {
    this.codstatogara = codstatogara;
  }
  
  public String getCodsa() {
    return codsa;
  }

  public void setCodsa(String codsa) {
    this.codsa = codsa;
  }

  public Double getAnnoinizioperscadenza() {
    return annoinizioperscadenza;
  }
  
  public void setAnnoinizioperscadenza(Double annoinizioperscadenza) {
    this.annoinizioperscadenza = annoinizioperscadenza;
  }
  
  public Date getDataUltimaModifica() {
    return dataUltimaModifica;
  }
  
  public void setDataUltimaModifica(Date dataUltimaModifica) {
    this.dataUltimaModifica = dataUltimaModifica;
  }
  
  public boolean isSommaUrgenza() {
    return sommaUrgenza;
  }
  
  public void setSommaUrgenza(boolean sommaUrgenza) {
    this.sommaUrgenza = sommaUrgenza;
  }
  
  public Integer getAltriSoggetti() {
    return altriSoggetti;
  }
  
  public void setAltriSoggetti(Integer altriSoggetti) {
    this.altriSoggetti = altriSoggetti;
  }

  public String getIdTipoAppalto() {
    return idTipoAppalto;
  }

  public void setIdTipoAppalto(String idTipoAppalto) {
    this.idTipoAppalto = idTipoAppalto;
  }
}
