package it.maggioli.appalti.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Classe per gli ademptimenti anticorruzione L190
 * <br>ricalca {@code it.maggioli.eldasoft.appalti.bandiesitiavvisi.ws.AdempimentoAnticorruzioneType}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "AdempimentoAnticorruzione",description = "dati degli ademptimenti anticorruzione")
public class AdempimentoAnticorruzioneDto {
  public static final String EUROPE_TIMEZONE = "Europe/Rome";
  private String codice;

  private String stazioneAppaltante;

  private String codiceFiscaleSA;

  private int annoRiferimento;

  private String url;

  private int pubblicato;

  private Date dataPubblicazione;

  private Date dataAggiornamento;

  private Date dataApprovazione;

  
  /**
   * @return the codice
   */
  @ApiModelProperty(name = "codice",value="codice della Stazione Appaltante")
  public String getCodice() {
    return codice;
  }

  
  /**
   * @param codice the codice to set
   */
  public void setCodice(String codice) {
    this.codice = codice;
  }

  
  /**
   * @return the stazioneAppaltante
   */
  @ApiModelProperty(name = "stazioneAppaltante",value="denominazione della Stazione Appaltante")
  public String getStazioneAppaltante() {
    return stazioneAppaltante;
  }

  
  /**
   * @param stazioneAppaltante the stazioneAppaltante to set
   */
  public void setStazioneAppaltante(String stazioneAppaltante) {
    this.stazioneAppaltante = stazioneAppaltante;
  }

  
  /**
   * @return the codiceFiscaleSA
   */
  @ApiModelProperty(name = "codiceFiscaleSA",value="Codice fiscale Stazione Appaltante")
  public String getCodiceFiscaleSA() {
    return codiceFiscaleSA;
  }

  
  /**
   * @param codiceFiscaleSA the codiceFiscaleSA to set
   */
  public void setCodiceFiscaleSA(String codiceFiscaleSA) {
    this.codiceFiscaleSA = codiceFiscaleSA;
  }

  
  /**
   * @return the annoRiferimento
   */
  @ApiModelProperty(name = "annoRiferimento",value="anno di riferimento dei GIC oggetto di pubblicazione per l'adempimento sull'anticorruzione")
  public int getAnnoRiferimento() {
    return annoRiferimento;
  }

  
  /**
   * @param annoRiferimento the annoRiferimento to set
   */
  public void setAnnoRiferimento(int annoRiferimento) {
    this.annoRiferimento = annoRiferimento;
  }

  
  /**
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  
  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

  
  /**
   * @return the pubblicato
   */
  @ApiModelProperty(name = "pubblicato",value="indica che i dati sono pubblicati o in lavorazione")
  public int getPubblicato() {
    return pubblicato;
  }

  
  /**
   * @param pubblicato the pubblicato to set
   */
  public void setPubblicato(int pubblicato) {
    this.pubblicato = pubblicato;
  }

  
  /**
   * @return the dataPubblicazione
   */
  @ApiModelProperty(name = "dataPubblicazione",value="data di pubblicazione", example = "2020-05-11 00:00:00")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDataPubblicazione() {
    return dataPubblicazione;
  }

  
  /**
   * @param dataPubblicazione the dataPubblicazione to set
   */
  public void setDataPubblicazione(Date dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }

  
  /**
   * @return the dataAggiornamento
   */
  @ApiModelProperty(name = "dataAggiornamento",value="data di aggiornamento, ultima pubblicazione", example = "2020-05-11 00:00:00")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDataAggiornamento() {
    return dataAggiornamento;
  }

  
  /**
   * @param dataAggiornamento the dataAggiornamento to set
   */
  public void setDataAggiornamento(Date dataAggiornamento) {
    this.dataAggiornamento = dataAggiornamento;
  }

  
  /**
   * @return the dataApprovazione
   */
  @ApiModelProperty(name = "dataApprovazione",value="data di approvazione dei dati oggetto di pubblicazione", example = "2020-05-11 00:00:00")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDataApprovazione() {
    return dataApprovazione;
  }

  
  /**
   * @param dataApprovazione the dataApprovazione to set
   */
  public void setDataApprovazione(Date dataApprovazione) {
    this.dataApprovazione = dataApprovazione;
  }
  
  
}
