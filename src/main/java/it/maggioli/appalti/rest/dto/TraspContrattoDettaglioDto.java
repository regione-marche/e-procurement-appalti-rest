package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TraspContrattoDettaglioDto extends TraspContrattoDto {
  private Date datapubbgara;
  private Date datainvito;
  private Date dataaggiudicazione;
  private Date datapubbesito;
  private String codiceprop;
  private String codfiscprop;
  private Integer tipgarg;
  private Integer singolaaggiudicataria;
  private String codaggiudicataria;
  private String descaggiudicataria;
  private String codfiscaggiudicataria;
  private String partivaaggiudicataria;
  private Double impultcontr;
  List<TraspContrattoPartecipanteDto> partecipanti;
  List<TraspContrattoPartecipanteDto> aggiudicatariDto;
  
  @JsonProperty("dataPubblicazioneGara")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDatapubbgara() {
    return datapubbgara;
  }
  
  public void setDatapubbgara(Date datapubbgara) {
    this.datapubbgara = datapubbgara;
  }
  
  @JsonProperty("dataInvito")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDatainvito() {
    return datainvito;
  }
  
  public void setDatainvito(Date datainvito) {
    this.datainvito = datainvito;
  }
  
  @JsonProperty("dataAggiudicazione")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDataaggiudicazione() {
    return dataaggiudicazione;
  }
  
  public void setDataaggiudicazione(Date dataaggiudicazione) {
    this.dataaggiudicazione = dataaggiudicazione;
  }
  @JsonProperty("dataPubblicazioneEsito")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDatapubbesito() {
    return datapubbesito;
  }
  
  public void setDatapubbesito(Date datapubbesito) {
    this.datapubbesito = datapubbesito;
  }
  
  @JsonIgnore
  public String getCodiceprop() {
    return codiceprop;
  }
  
  public void setCodiceprop(String codiceprop) {
    this.codiceprop = codiceprop;
  }
  
  @JsonProperty("codiceFiscaleProponente")
  public String getCodfiscprop() {
    return codfiscprop;
  }
  
  public void setCodfiscprop(String codfiscprop) {
    this.codfiscprop = codfiscprop;
  }
  @JsonIgnore
  public Integer getTipgarg() {
    return tipgarg;
  }
  
  public void setTipgarg(Integer tipgarg) {
    this.tipgarg = tipgarg;
  }
  @JsonIgnore
  public Integer getSingolaaggiudicataria() {
    return singolaaggiudicataria;
  }
  
  public void setSingolaaggiudicataria(Integer singolaaggiudicataria) {
    this.singolaaggiudicataria = singolaaggiudicataria;
  }
  @JsonIgnore
  public String getCodaggiudicataria() {
    return codaggiudicataria;
  }
  
  public void setCodaggiudicataria(String codaggiudicataria) {
    this.codaggiudicataria = codaggiudicataria;
  }
  @JsonIgnore
  public String getDescaggiudicataria() {
    return descaggiudicataria;
  }
  
  public void setDescaggiudicataria(String descaggiudicataria) {
    this.descaggiudicataria = descaggiudicataria;
  }
  @JsonIgnore
  public String getCodfiscaggiudicataria() {
    return codfiscaggiudicataria;
  }
  
  public void setCodfiscaggiudicataria(String codfiscaggiudicataria) {
    this.codfiscaggiudicataria = codfiscaggiudicataria;
  }
  @JsonIgnore
  public String getPartivaaggiudicataria() {
    return partivaaggiudicataria;
  }
  
  public void setPartivaaggiudicataria(String partivaaggiudicataria) {
    this.partivaaggiudicataria = partivaaggiudicataria;
  }
  
  @JsonIgnore
  public Double getImpultcontr() {
    return impultcontr;
  }
  
  public void setImpultcontr(Double impultcontr) {
    this.impultcontr = impultcontr;
  }
  
  @JsonProperty(value = "elencoPartecipanti")
  public List<TraspContrattoPartecipanteDto> getPartecipanti() {
    return partecipanti;
  }
  
  public void setPartecipanti(List<TraspContrattoPartecipanteDto> partecipanti) {
    this.partecipanti = partecipanti;
  }

  @JsonProperty(value = "elencoAggiudicatari")
  public List<TraspContrattoPartecipanteDto> getAggiudicatariDto() {
    return aggiudicatariDto;
  }

  
  public void setAggiudicatariDto(List<TraspContrattoPartecipanteDto> aggiudicatariDto) {
    this.aggiudicatariDto = aggiudicatariDto;
  }

  @JsonIgnore
  @Override
  public List<String> getAggiudicatari() {
    return null;
  }

  @Override
  public String toString() {
    final int maxLen = 5;
    return "TraspContrattoDettaglioDto ["
        + (datapubbgara != null ? "datapubbgara=" + datapubbgara + ", " : "")
        + (datainvito != null ? "datainvito=" + datainvito + ", " : "")
        + (dataaggiudicazione != null ? "dataaggiudicazione=" + dataaggiudicazione + ", " : "")
        + (datapubbesito != null ? "datapubbesito=" + datapubbesito + ", " : "")
        + (codiceprop != null ? "codiceprop=" + codiceprop + ", " : "")
        + (codfiscprop != null ? "codfiscprop=" + codfiscprop + ", " : "")
        + (tipgarg != null ? "tipgarg=" + tipgarg + ", " : "")
        + (singolaaggiudicataria != null ? "singolaaggiudicataria=" + singolaaggiudicataria + ", " : "")
        + (codaggiudicataria != null ? "codaggiudicataria=" + codaggiudicataria + ", " : "")
        + (descaggiudicataria != null ? "descaggiudicataria=" + descaggiudicataria + ", " : "")
        + (codfiscaggiudicataria != null ? "codfiscaggiudicataria=" + codfiscaggiudicataria + ", " : "")
        + (partivaaggiudicataria != null ? "partivaaggiudicataria=" + partivaaggiudicataria + ", " : "")
        + (impultcontr != null ? "impultcontr=" + impultcontr + ", " : "")
        + (partecipanti != null ? "partecipanti=" + partecipanti.subList(0, Math.min(partecipanti.size(), maxLen)) + ", " : "")
        + (aggiudicatariDto != null ? "aggiudicatariDto=" + aggiudicatariDto.subList(0, Math.min(aggiudicatariDto.size(), maxLen)) : "")
        + "]";
  }
  
}
