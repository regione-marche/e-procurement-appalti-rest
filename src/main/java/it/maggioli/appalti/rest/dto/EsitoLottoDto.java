package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.dto.IEsitoLottoDto IEsitoLottoDto}
 * @see GareLottiDto
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "lottoEsito",parent = GareLottiDto.class)
public class EsitoLottoDto extends GareLottiDto {
  
  private String codiceLotto;//ngara
  private String codiceinterno;//codiceinterno
  private String cig;
  private String cup;
  private Double importoAggiudicazione;//iaggiu
  private Date dataAggiudicazione;
  private String stato;//stato
  private String esito;//esito
  private List<String> aggiudicatari;
  
  @ApiModelProperty(value = "il codice del lotto della entità di riferimento")
  public String getCodiceLotto() {
    return codiceLotto;
  }
  
  public void setCodiceLotto(String codiceLotto) {
    this.codiceLotto = codiceLotto;
  }
  
  @ApiModelProperty(value = "il codice interno del lotto della entità di riferimento")
  public String getCodiceinterno() {
    return codiceinterno;
  }
  
  public void setCodiceinterno(String codiceinterno) {
    this.codiceinterno = codiceinterno;
  }
  
  @ApiModelProperty(value = "cig del lotto della entità di riferimento")
  public String getCig() {
    return cig;
  }
  
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  @ApiModelProperty(value = "cup del lotto della entità di riferimento")
  public String getCup() {
    return cup;
  }
  
  public void setCup(String cup) {
    this.cup = cup;
  }
  
  @ApiModelProperty(value = "importo di aggiudicazione del lotto")
  public Double getImportoAggiudicazione() {
    return importoAggiudicazione;
  }
  
  public void setImportoAggiudicazione(Double importoAggiudicazione) {
    this.importoAggiudicazione = importoAggiudicazione;
  }
  
  @ApiModelProperty(value = "data di aggiudicazione del lotto", example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDataAggiudicazione() {
    return dataAggiudicazione;
  }
  
  public void setDataAggiudicazione(Date dataAggiudicazione) {
    this.dataAggiudicazione = dataAggiudicazione;
  }
  
  @ApiModelProperty(value = "stato del lotto")
  public String getStato() {
    return stato;
  }
  
  public void setStato(String stato) {
    this.stato = stato;
  }
  
  @ApiModelProperty(value = "esito del lotto")
  public String getEsito() {
    return esito;
  }
  
  public void setEsito(String esito) {
    this.esito = esito;
  }

  @ApiModelProperty(value = "lista degli aggiudicatari del lotto")
  public List<String> getAggiudicatari() {
    return aggiudicatari;
  }

  public void setAggiudicatari(List<String> aggiudicatari) {
    this.aggiudicatari = aggiudicatari;
  }

  @Override
  public String toString() {
    final int maxLen = 5;
    return "EsitoLottoDto ["
        + (getCodiceGara() != null ? "codiceGara=" + getCodiceGara() + ", " : "")
        + (codiceLotto != null ? "codiceLotto=" + codiceLotto + ", " : "")
        + (codiceinterno != null ? "codiceinterno=" + codiceinterno + ", " : "")
        + (cig != null ? "cig=" + cig + ", " : "")
        + (cup != null ? "cup=" + cup + ", " : "")
        + (importoAggiudicazione != null ? "importoAggiudicazione=" + importoAggiudicazione + ", " : "")
        + (dataAggiudicazione != null ? "dataAggiudicazione=" + dataAggiudicazione + ", " : "")
        + (stato != null ? "stato=" + stato + ", " : "")
        + (esito != null ? "esito=" + esito + ", " : "")
        + (aggiudicatari != null ? "aggiudicatari=" + aggiudicatari.subList(0, Math.min(aggiudicatari.size(), maxLen)) : "")
        + "]";
  }
  
}
