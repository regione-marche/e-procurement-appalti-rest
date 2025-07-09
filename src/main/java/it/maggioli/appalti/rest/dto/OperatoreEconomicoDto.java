package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Classe DTO per IMPR per Aset
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "operatoreEconomico")
@JsonIgnoreProperties({"ultimaDataAggiornamento"})
public class OperatoreEconomicoDto {
  private String codice;
  private String codiceFiscale;
  private String partitaIva;
  private String denominazione;
  private String indirizzo;
  private String civico;
  private String provinciaSigla;
  private String provinciaEstesa;
  private String cap;
  private String comune;
  private String codiceIstat;
  private String nazione;
  private String telefono;
  private String fax;
  private String cellulare;
  private String email;
  private String pec;
  private String sito;
  private Date ultimaDataAggiornamento;
  private Boolean rti;
  private Boolean mandataria;
  private List<OperatoreEconomicoDto> raggruppamento;
  /**
   * @return the codice
   */
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
   * @return the codiceFiscale
   */
  public String getCodiceFiscale() {
    return codiceFiscale;
  }
  
  /**
   * @param codiceFiscale the codiceFiscale to set
   */
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
  }
  
  /**
   * @return the partitaIva
   */
  public String getPartitaIva() {
    return partitaIva;
  }
  
  /**
   * @param partitaIva the partitaIva to set
   */
  public void setPartitaIva(String partitaIva) {
    this.partitaIva = partitaIva;
  }
  
  /**
   * @return the denominazione
   */
  public String getDenominazione() {
    return denominazione;
  }
  
  /**
   * @param denominazione the denominazione to set
   */
  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
  }
  
  /**
   * @return the indirizzo
   */
  public String getIndirizzo() {
    return indirizzo;
  }
  
  /**
   * @param indirizzo the indirizzo to set
   */
  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }
  
  /**
   * @return the civico
   */
  public String getCivico() {
    return civico;
  }
  
  /**
   * @param civico the civico to set
   */
  public void setCivico(String civico) {
    this.civico = civico;
  }
  
  /**
   * @return the provinciaSigla
   */
  public String getProvinciaSigla() {
    return provinciaSigla;
  }
  
  /**
   * @param provinciaSigla the provinciaSigla to set
   */
  public void setProvinciaSigla(String provinciaSigla) {
    this.provinciaSigla = provinciaSigla;
  }
  
  /**
   * @return the provinciaEstesa
   */
  public String getProvinciaEstesa() {
    return provinciaEstesa;
  }
  
  /**
   * @param provinciaEstesa the provinciaEstesa to set
   */
  public void setProvinciaEstesa(String provinciaEstesa) {
    this.provinciaEstesa = provinciaEstesa;
  }
  
  /**
   * @return the cap
   */
  public String getCap() {
    return cap;
  }
  
  /**
   * @param cap the cap to set
   */
  public void setCap(String cap) {
    this.cap = cap;
  }
  
  /**
   * @return the comune
   */
  public String getComune() {
    return comune;
  }
  
  /**
   * @param comune the comune to set
   */
  public void setComune(String comune) {
    this.comune = comune;
  }
  
  /**
   * @return the codiceIstat
   */
  public String getCodiceIstat() {
    return codiceIstat;
  }
  
  /**
   * @param codiceIstat the codiceIstat to set
   */
  public void setCodiceIstat(String codiceIstat) {
    this.codiceIstat = codiceIstat;
  }
  
  /**
   * @return the nazione
   */
  public String getNazione() {
    return nazione;
  }
  
  /**
   * @param nazione the nazione to set
   */
  public void setNazione(String nazione) {
    this.nazione = nazione;
  }
  
  /**
   * @return the telefono
   */
  public String getTelefono() {
    return telefono;
  }
  
  /**
   * @param telefono the telefono to set
   */
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  /**
   * @return the fax
   */
  public String getFax() {
    return fax;
  }
  
  /**
   * @param fax the fax to set
   */
  public void setFax(String fax) {
    this.fax = fax;
  }
  
  /**
   * @return the cellulare
   */
  public String getCellulare() {
    return cellulare;
  }
  
  /**
   * @param cellulare the cellulare to set
   */
  public void setCellulare(String cellulare) {
    this.cellulare = cellulare;
  }
  
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  
  /**
   * @return the pec
   */
  public String getPec() {
    return pec;
  }
  
  /**
   * @param pec the pec to set
   */
  public void setPec(String pec) {
    this.pec = pec;
  }
  
  /**
   * @return the sito
   */
  public String getSito() {
    return sito;
  }
  
  /**
   * @param sito the sito to set
   */
  public void setSito(String sito) {
    this.sito = sito;
  }

  /**
   * @return the ultimaDataAggiornamento
   */
  @JsonIgnore
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getUltimaDataAggiornamento() {
    return ultimaDataAggiornamento;
  }

  /**
   * @param ultimaDataAggiornamento the ultimaDataAggiornamento to set
   */
  public void setUltimaDataAggiornamento(Date ultimaDataAggiornamento) {
    this.ultimaDataAggiornamento = ultimaDataAggiornamento;
  }

  
  /**
   * @return the rti
   */
  public Boolean isRti() {
    return rti;
  }

  
  /**
   * @param rti the rti to set
   */
  public void setRti(Boolean rti) {
    this.rti = rti;
  }

  
  /**
   * @return the mandataria
   */
  public Boolean isMandataria() {
    return mandataria;
  }

  
  /**
   * @param mandataria the mandataria to set
   */
  public void setMandataria(Boolean mandataria) {
    this.mandataria = mandataria;
  }

  
  /**
   * @return the raggruppamento
   */
  @ApiModelProperty(dataType = "Array",allowEmptyValue = true, reference = "#/definitions/operatoreEconomico")
  public List<OperatoreEconomicoDto> getRaggruppamento() {
    return raggruppamento;
  }

  
  /**
   * @param raggruppamento the raggruppamento to set
   */
  public void setRaggruppamento(List<OperatoreEconomicoDto> raggruppamento) {
    this.raggruppamento = raggruppamento;
  }
  
}
