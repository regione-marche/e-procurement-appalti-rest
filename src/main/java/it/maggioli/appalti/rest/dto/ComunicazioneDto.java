package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.Comunicazione Comunicazione}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "comunicazione")
public class ComunicazioneDto {
  private Long idcomunicazione;
  private String oggetto;
  private String testo;
  private Date dataPubblicazione;
  private List<ComunicazioneDocumentoDto> documentiComunicazione;
  
  @ApiModelProperty(name = "oggetto",value = "oggetto della comunicazione")
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  @ApiModelProperty(name = "testo",value = "testo della comunicazione")
  public String getTesto() {
    return testo;
  }
  
  public void setTesto(String testo) {
    this.testo = testo;
  }
  
  @ApiModelProperty(name = "dataPubblicazione",value = "data di pubblicazione della comunicazione", example = "2020-05-11 00:00:00")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDataPubblicazione() {
    return dataPubblicazione;
  }
  
  public void setDataPubblicazione(Date dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }
  
  public List<ComunicazioneDocumentoDto> getDocumentiComunicazione() {
    return documentiComunicazione;
  }
  
  public void setDocumentiComunicazione(List<ComunicazioneDocumentoDto> documentiComunicazione) {
    this.documentiComunicazione = documentiComunicazione;
  }

  public Long getIdcomunicazione() {
    return idcomunicazione;
  }

  public void setIdcomunicazione(Long idcomunicazione) {
    this.idcomunicazione = idcomunicazione;
  }

  @Override
  public String toString() {
    final int maxLen = 5;
    return "ComunicazioneDto ["
        + (idcomunicazione != null ? "idcomunicazione=" + idcomunicazione + ", " : "")
        + (oggetto != null ? "oggetto=" + oggetto + ", " : "")
        + (dataPubblicazione != null ? "dataPubblicazione=" + dataPubblicazione + ", " : "")
        + (documentiComunicazione != null ? "documentoComunicazione=" + documentiComunicazione.subList(0, Math.min(documentiComunicazione.size(), maxLen)) : "")
        + "]";
  }

}
