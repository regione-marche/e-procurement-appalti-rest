package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Questa classe definisce i soggetti aderenti
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "soggettoAderente")
public class SoggettoAderenteDto {
  private String codiceFiscale;
  private String denominazione;
  
  /**
   * @return the codiceFiscale
   */
  @ApiModelProperty(name = "codiceFiscale",value="Codice Fiscale del Soggetto Aderente")
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
   * @return the denominazione
   */
  @ApiModelProperty(name = "denominazione",value="Denominazione del Soggetto Aderente")
  public String getDenominazione() {
    return denominazione;
  }
  
  /**
   * @param denominazione the denominazione to set
   */
  public void setDenominazione(String denominazione) {
    this.denominazione = denominazione;
  }
  
  
}
