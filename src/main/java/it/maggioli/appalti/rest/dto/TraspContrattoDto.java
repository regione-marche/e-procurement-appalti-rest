package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.TraspContratto TraspContratto}
 * @author gabriele.nencini
 *
 */
public class TraspContrattoDto {
  public static final String EUROPE_TIMEZONE = "Europe/Rome";
  private String codice;
  private String cig;
  private String oggetto;
  private String denomprop;
  private String descsceltacontr;
  private List<String> aggiudicatari;
  private Double impaggiudic;
  private Double impsommeliq;
  private Date datapubbesito;
  private Date datainizio;
  private Date datafine;
  
  @JsonProperty(value = "riferimentoProcedura")
  public String getCodice() {
    return codice;
  }

  public void setCodice(String codice) {
    this.codice = codice;
  }

  @JsonProperty(value = "cig")
  public String getCig() {
    return cig;
  }
  
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  @JsonProperty(value = "oggetto")
  public String getOggetto() {
    return oggetto;
  }

  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }

  @JsonProperty(value = "denominazioneProponente")
  public String getDenomprop() {
    return denomprop;
  }
  
  public void setDenomprop(String denomprop) {
    this.denomprop = denomprop;
  }

  @JsonProperty(value = "scelatContraente")
  public String getDescsceltacontr() {
    return descsceltacontr;
  }
  
  public void setDescsceltacontr(String descsceltacontr) {
    this.descsceltacontr = descsceltacontr;
  }
  
  @JsonProperty(value = "aggiudicatari")
  public List<String> getAggiudicatari() {
    return aggiudicatari;
  }
  
  public void setAggiudicatari(List<String> aggiudicatari) {
    this.aggiudicatari = aggiudicatari;
  }
  
  @JsonProperty(value = "importoAggiudicazione")
  public Double getImpaggiudic() {
    return impaggiudic;
  }
  
  public void setImpaggiudic(Double impaggiudic) {
    this.impaggiudic = impaggiudic;
  }
  
  @JsonProperty(value = "importoSommeLiquidate")
  public Double getImpsommeliq() {
    return impsommeliq;
  }
  
  public void setImpsommeliq(Double impsommeliq) {
    this.impsommeliq = impsommeliq;
  }
  
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonProperty(value = "datapubblicazioneesito")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDatapubbesito() {
    return datapubbesito;
  }
  
  public void setDatapubbesito(Date datapubbesito) {
    this.datapubbesito = datapubbesito;
  }

  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDatainizio() {
    return datainizio;
  }
  
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonProperty(value = "datainizio")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public void setDatainizio(Date datainizio) {
    this.datainizio = datainizio;
  }
  
  @ApiModelProperty(example = "2020-05-11 00:00:00")
  @JsonProperty(value = "datafine")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDatafine() {
    return datafine;
  }
  
  public void setDatafine(Date datafine) {
    this.datafine = datafine;
  }
}
