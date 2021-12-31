package it.maggioli.appalti.rest.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Questa entità rappresenta il dettaglio dell'elemento richiesto
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "dettaglio",description = "Questa entità rappresenta il dettaglio dell'elemento richiesto")
public class DettaglioDto< R, U, I> {
  private StazioneAppaltanteDto stazioneAppaltante;
  private R datiGenerali;
  private List<U> documentazione;
  private List<SoggettoAderenteDto> soggettiAderenti;
  private List<I> comunicazioni;
  
  @ApiModelProperty(name = "stazioneAppaltante",reference = "stazioneAppaltante")
  public StazioneAppaltanteDto getStazioneAppaltante() {
    return stazioneAppaltante;
  }
  
  public void setStazioneAppaltante(StazioneAppaltanteDto stazioneAppaltante) {
    this.stazioneAppaltante = stazioneAppaltante;
  }
  
  @ApiModelProperty(name = "datiGenerali",value = "dati generali dell'elemento richiesto")
  public R getDatiGenerali() {
    return datiGenerali;
  }
  
  public void setDatiGenerali(R datiGenerali) {
    this.datiGenerali = datiGenerali;
  }
  
  @ApiModelProperty(name = "documentazione",value = "Contiene la lista dei documenti presenti")
  public List<U> getDocumentazione() {
    return documentazione;
  }
  
  public void setDocumentazione(List<U> documentazione) {
    this.documentazione = documentazione;
  }
  
  @ApiModelProperty(name = "comunicazioni",value = "Contiene la lista delle comunicazioni presenti")
  public List<I> getComunicazioni() {
    return comunicazioni;
  }
  
  public void setComunicazioni(List<I> comunicazioni) {
    this.comunicazioni = comunicazioni;
  }

  
  /**
   * @return the soggettiAderenti
   */
  public List<SoggettoAderenteDto> getSoggettiAderenti() {
    return soggettiAderenti;
  }

  
  /**
   * @param soggettiAderenti the soggettiAderenti to set
   */
  @ApiModelProperty(name = "soggettiAderenti",value = "Contiene la lista dei soggetti aderenti")
  public void setSoggettiAderenti(List<SoggettoAderenteDto> soggettiAderenti) {
    this.soggettiAderenti = soggettiAderenti;
  }

  @Override
  public String toString() {
    return "DettaglioDto ["
        + (stazioneAppaltante != null ? "stazioneAppaltante=" + stazioneAppaltante + ", " : "")
        + (datiGenerali != null ? "datiGenerali=" + datiGenerali + ", " : "")
        + (documentazione != null ? "documentazione=" + documentazione + ", " : "")
        + (comunicazioni != null ? "comunicazioni=" + comunicazioni : "")
        + "]";
  }
  
  
}
