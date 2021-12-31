package it.maggioli.appalti.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.ComunicazioneDocumento ComunicazioneDocumento}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "comunicazioneDocumento")
public class ComunicazioneDocumentoDto {
  private Long iddocumento;
  private String descrizione;
  private String nomefile;
  private Date dataPubblicazione;
  
  @ApiModelProperty(name = "iddocumento",value = "Identificativo del documento",allowableValues = "range(0,infinity]")
  public Long getIddocumento() {
    return iddocumento;
  }
  
  public void setIddocumento(Long iddocumento) {
    this.iddocumento = iddocumento;
  }
  
  @ApiModelProperty(name = "descrizione",value = "Descrizione del documento")
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }
  
  @ApiModelProperty(name = "nomefile",value = "Nome del file del documento")
  public String getNomefile() {
    return nomefile;
  }
  
  public void setNomefile(String nomefile) {
    this.nomefile = nomefile;
  }
  
  @ApiModelProperty(name = "dataPubblicazione",value = "Data di pubblicazione del documento",example = "2020-01-13 14:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDataPubblicazione() {
    return dataPubblicazione;
  }
  
  public void setDataPubblicazione(Date dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }

  @Override
  public String toString() {
    return "ComunicazioneDocumentoDto ["
        + (iddocumento != null ? "iddocumento=" + iddocumento + ", " : "")
        + (descrizione != null ? "descrizione=" + descrizione : "")
        + "]";
  }
  
}
