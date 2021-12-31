package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.GareCategorie GareCategorie}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "categoriePrestazioni")
public class CategoriePrestazioniDto {
  private String categoriaPrestazione;
  private String codice;
  private Boolean prevalentePrincipale;
  private Boolean perlavori;
  
  @ApiModelProperty(name = "categoriaPrestazione",notes = "descrizione della categoria o prestazione")
  public String getCategoriaPrestazione() {
    return categoriaPrestazione;
  }
  
  public void setCategoriaPrestazione(String categoriaPrestazione) {
    this.categoriaPrestazione = categoriaPrestazione;
  }
  
  @ApiModelProperty(name = "codice",notes = "codice della categoria o prestazione")
  public String getCodice() {
    return codice;
  }
  
  public void setCodice(String codice) {
    this.codice = codice;
  }
  
  @ApiModelProperty(name = "prevalentePrincipale",notes = "booleano per indicare se questa categoria è la prevalente")
  public Boolean getPrevalentePrincipale() {
    return prevalentePrincipale;
  }
  
  public void setPrevalentePrincipale(Boolean prevalentePrincipale) {
    this.prevalentePrincipale = prevalentePrincipale;
  }
  
  @ApiModelProperty(name = "perlavori",notes = "booleano per indicare se questa categoria è per lavori")
  public Boolean getPerlavori() {
    return perlavori;
  }
  
  public void setPerlavori(Boolean perlavori) {
    this.perlavori = perlavori;
  }

  @Override
  public String toString() {
    return "CategoriePrestazioniDto ["
        + (categoriaPrestazione != null ? "categoriaPrestazione=" + categoriaPrestazione + ", " : "")
        + (codice != null ? "codice=" + codice + ", " : "")
        + (prevalentePrincipale != null ? "prevalentePrincipale=" + prevalentePrincipale + ", " : "")
        + (perlavori != null ? "perlavori=" + perlavori : "")
        + "]";
  }
  
  
}
