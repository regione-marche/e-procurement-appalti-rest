package it.maggioli.appalti.rest.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per i dati dei lotti {@link it.maggioli.appalti.rest.entities.views.ws.GareLotti GareLotti}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "lotto",subTypes = {EsitoLottoDto.class})
public class GareLottiDto {
  private String titolo;
  private Double importoBaseGara;
  private List<CategoriePrestazioniDto> categoriePrestazioni;
  private String riferimentoProcedura;
  private String codiceGara;//codice
  
  @ApiModelProperty(name = "titolo",notes = "titolo del lotto")
  public String getTitolo() {
    return titolo;
  }
  
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }
  
  @ApiModelProperty(name = "importoBaseGara",notes = "importo a base di gara del lotto")
  public Double getImportoBaseGara() {
    return importoBaseGara;
  }
  
  public void setImportoBaseGara(Double importoBaseGara) {
    this.importoBaseGara = importoBaseGara;
  }
  
  @ApiModelProperty(name = "categoriePrestazioni",notes = "categorie prestazioni del lotto", reference = "categoriePrestazioni")
  public List<CategoriePrestazioniDto> getCategoriePrestazioni() {
    return categoriePrestazioni;
  }
  
  public void setCategoriePrestazioni(List<CategoriePrestazioniDto> categoriePrestazioni) {
    this.categoriePrestazioni = categoriePrestazioni;
  }

  @ApiModelProperty(name = "riferimentoProcedura",notes = "Procedura di riferimento")
  public String getRiferimentoProcedura() {
    return riferimentoProcedura;
  }

  public void setRiferimentoProcedura(String riferimentoProcedura) {
    this.riferimentoProcedura = riferimentoProcedura;
  }
  
  @ApiModelProperty(value = "il codice della entità di riferimento")
  public String getCodiceGara() {
    return codiceGara;
  }
  
  public void setCodiceGara(String codiceGara) {
    this.codiceGara = codiceGara;
  }

  @Override
  public String toString() {
    return "GareLottiDto ["
        + (titolo != null ? "titolo=" + titolo + ", " : "")
        + (importoBaseGara != null ? "importoBaseGara=" + importoBaseGara + ", " : "")
        + (categoriePrestazioni != null ? "categoriePrestazioni=" + categoriePrestazioni : "")
        + "]";
  }
  
  
}
