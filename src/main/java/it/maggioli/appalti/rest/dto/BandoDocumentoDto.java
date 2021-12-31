package it.maggioli.appalti.rest.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.BandoDocumento BandoDocumento}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "documento")
public class BandoDocumentoDto {
  private String descrizione;
  private String nomefile;
  private Long id;
  private String url;
  private Date dataPubblicazione;
  
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  public String getNomefile() {
    return nomefile;
  }
  
  public void setNomefile(String nomefile) {
    this.nomefile = nomefile;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getUrl() {
    return url;
  }
  
  public void setUrl(String url) {
    this.url = url;
  }
  
  public Date getDataPubblicazione() {
    return dataPubblicazione;
  }
  
  public void setDataPubblicazione(Date dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }

  @Override
  public String toString() {
    return "BandoDocumentoDto [" + (nomefile != null ? "nomefile=" + nomefile + ", " : "") + (id != null ? "id=" + id : "") + "]";
  }
  
  
}
