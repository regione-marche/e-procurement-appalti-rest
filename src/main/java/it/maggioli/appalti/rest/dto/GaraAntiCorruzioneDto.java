package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.GareAnticorruzione GareAnticorruzione}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "AppaltoAntiCorruzione",description = "Rappresenta un appalto anti corruzione")
public class GaraAntiCorruzioneDto {
  
  private Integer annorif;
  private String codicegara;
  private String codfiscprop;
  private String denomprop;
  private String cig;
  private String oggetto;
  private Integer codsceltacontr;
  private String descsceltacontr;
  private Double impaggiudic;
  
  private Date datainizio;
  private Date dataultimazione;
  
  private Double impsommeliq;
  private Date datapubbl;
  
  private Long idanticorlotti;
  
  private List<GaraAnticorruzioneDittaDto> partecipanti;
  private List<GaraAnticorruzioneDittaDto> assegnatari;
  
  @ApiModelProperty(name = "annoRiferimento",value = "Anno di riferimento")
  @JsonProperty("annoRiferimento")
  public Integer getAnnorif() {
    return annorif;
  }
  
  public void setAnnorif(Integer annorif) {
    this.annorif = annorif;
  }
  
  @ApiModelProperty(name = "codiceGara",value = "Codice Gara (identificativo interno)")
  @JsonProperty("codiceGara")
  public String getCodicegara() {
    return codicegara;
  }
  
  public void setCodicegara(String codicegara) {
    this.codicegara = codicegara;
  }
  
  @ApiModelProperty(name = "codiceFiscaleProponente",value = "Codice fiscale Stazione Appaltante")
  @JsonProperty("codiceFiscaleProponente")
  public String getCodfiscprop() {
    return codfiscprop;
  }
  
  public void setCodfiscprop(String codfiscprop) {
    this.codfiscprop = codfiscprop;
  }

  @ApiModelProperty(name = "denominazioneProponente",value = "Denominazione Stazione Appaltante")
  @JsonProperty("denominazioneProponente")
  public String getDenomprop() {
    return denomprop;
  }
  
  public void setDenomprop(String denomprop) {
    this.denomprop = denomprop;
  }
  
  public String getCig() {
    return cig;
  }
  
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  @JsonIgnore
  public Integer getCodsceltacontr() {
    return codsceltacontr;
  }
  
  public void setCodsceltacontr(Integer codsceltacontr) {
    this.codsceltacontr = codsceltacontr;
  }
  
  @ApiModelProperty(name = "sceltaContraente")
  @JsonProperty("sceltaContraente")
  public String getDescsceltacontr() {
    return descsceltacontr;
  }
  
  public void setDescsceltacontr(String descsceltacontr) {
    this.descsceltacontr = descsceltacontr;
  }
  
  @ApiModelProperty(name = "importoAggiudicazione")
  @JsonProperty("importoAggiudicazione")
  public Double getImpaggiudic() {
    return impaggiudic;
  }
  
  public void setImpaggiudic(Double impaggiudic) {
    this.impaggiudic = impaggiudic;
  }
  
  @ApiModelProperty(name = "dataInizio",example = "2020-05-11 00:00:00")
  @JsonProperty("dataInizio")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDatainizio() {
    return datainizio;
  }
  
  public void setDatainizio(Date datainizio) {
    this.datainizio = datainizio;
  }
  
  @ApiModelProperty(name = "dataUltimazione",example = "2020-05-11 00:00:00")
  @JsonProperty("dataUltimazione")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDataultimazione() {
    return dataultimazione;
  }
  
  public void setDataultimazione(Date dataultimazione) {
    this.dataultimazione = dataultimazione;
  }
  
  @ApiModelProperty(name = "importoSommeLiquidate")
  @JsonProperty("importoSommeLiquidate")
  public Double getImpsommeliq() {
    return impsommeliq;
  }

  public void setImpsommeliq(Double impsommeliq) {
    this.impsommeliq = impsommeliq;
  }
  
  @ApiModelProperty(name = "dataPubblicazione", example = "2020-05-11 00:00:00")
  @JsonProperty("dataPubblicazione")
  @JsonFormat(timezone = "CET",pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDatapubbl() {
    return datapubbl;
  }
  
  public void setDatapubbl(Date datapubbl) {
    this.datapubbl = datapubbl;
  }
  
  @JsonIgnore
  public Long getIdanticorlotti() {
    return idanticorlotti;
  }
  
  public void setIdanticorlotti(Long idanticorlotti) {
    this.idanticorlotti = idanticorlotti;
  }

  @ApiModelProperty(name = "partecipanti",value = "La lista dei partecipanti")
  @JsonProperty("partecipanti")
  public List<GaraAnticorruzioneDittaDto> getPartecipanti() {
    return partecipanti;
  }

  
  public void setPartecipanti(List<GaraAnticorruzioneDittaDto> partecipanti) {
    this.partecipanti = partecipanti;
  }

  
  @ApiModelProperty(name = "aggiudicatari",value = "La lista degli aggiudicatari")
  @JsonProperty("aggiudicatari")
  public List<GaraAnticorruzioneDittaDto> getAssegnatari() {
    return assegnatari;
  }

  
  public void setAssegnatari(List<GaraAnticorruzioneDittaDto> assegnatari) {
    this.assegnatari = assegnatari;
  }

  @Override
  public String toString() {
    return "GaraAntiCorruzioneDto ["
        + (annorif != null ? "annorif=" + annorif + ", " : "")
        + (codicegara != null ? "codicegara=" + codicegara + ", " : "")
        + (cig != null ? "cig=" + cig + ", " : "")
        + (oggetto != null ? "oggetto=" + oggetto + ", " : "")
        + (codsceltacontr != null ? "codsceltacontr=" + codsceltacontr + ", " : "")
        + (idanticorlotti != null ? "idanticorlotti=" + idanticorlotti : "")
        + "]";
  }
  
}
