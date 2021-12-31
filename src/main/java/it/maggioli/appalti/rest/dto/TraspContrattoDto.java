package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
  
  @JsonProperty(value = "datapubblicazioneesito")
  @JsonFormat(pattern="dd-MM-yyyy",timezone = EUROPE_TIMEZONE)
  public Date getDatapubbesito() {
    return datapubbesito;
  }
  
  public void setDatapubbesito(Date datapubbesito) {
    this.datapubbesito = datapubbesito;
  }

  public Date getDatainizio() {
    return datainizio;
  }
  
  @JsonProperty(value = "datainizio")
  @JsonFormat(pattern="dd-MM-yyyy",timezone = EUROPE_TIMEZONE)
  public void setDatainizio(Date datainizio) {
    this.datainizio = datainizio;
  }
  
  @JsonProperty(value = "datafine")
  @JsonFormat(pattern="dd-MM-yyyy",timezone = EUROPE_TIMEZONE)
  public Date getDatafine() {
    return datafine;
  }
  
  public void setDatafine(Date datafine) {
    this.datafine = datafine;
  }
}
