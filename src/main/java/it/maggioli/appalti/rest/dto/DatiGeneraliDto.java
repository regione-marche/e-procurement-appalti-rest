package it.maggioli.appalti.rest.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;

/**
 * Dati generali della entità richiesta
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "datiGenerali",description = "Dati generali della entità")
public class DatiGeneraliDto {
  private String titolo;
  private String tipologiaAppalto;
  private String proceduraGara;
  private String criterioAggiudicazione;
  private Double importoBaseGara;
  private String dataPubblicazione;
  private String dataScadenza;
  private String proceduraRiferimento;
  private String stato;
  private List<? extends GareLottiDto> datiProceduralotti;
  private List<BandoDocumentoDto> attiDocumenti;
  private Date dataUltimaModifica;
  
  @ApiModelProperty(name = "titolo",accessMode = AccessMode.READ_ONLY,notes = "titolo")
  public String getTitolo() {
    return titolo;
  }
  
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }
  
  @ApiModelProperty(name = "tipologiaAppalto",accessMode = AccessMode.READ_ONLY,notes="tipologia di appalto",reference = "tipologia")
  public String getTipologiaAppalto() {
    return tipologiaAppalto;
  }
  
  public void setTipologiaAppalto(String tipologiaAppalto) {
    this.tipologiaAppalto = tipologiaAppalto;
  }
  
  @ApiModelProperty(name = "proceduraGara",accessMode = AccessMode.READ_ONLY,notes="tipo di procedura (aperta, ristretta, negoziata...)")
  public String getProceduraGara() {
    return proceduraGara;
  }
  
  public void setProceduraGara(String proceduraGara) {
    this.proceduraGara = proceduraGara;
  }
  
  @ApiModelProperty(name = "criterioAggiudicazione",accessMode = AccessMode.READ_ONLY,notes="Criterio di aggiudicazione della gara")
  public String getCriterioAggiudicazione() {
    return criterioAggiudicazione;
  }
  
  public void setCriterioAggiudicazione(String criterioAggiudicazione) {
    this.criterioAggiudicazione = criterioAggiudicazione;
  }
  
  @ApiModelProperty(name = "importoBaseGara",accessMode = AccessMode.READ_ONLY,notes="importo a base di gara")
  public Double getImportoBaseGara() {
    return importoBaseGara;
  }
  
  public void setImportoBaseGara(Double importoBaseGara) {
    this.importoBaseGara = importoBaseGara;
  }
  
  @ApiModelProperty(name = "dataPubblicazione",accessMode = AccessMode.READ_ONLY,notes="data di pubblicazione")
  public String getDataPubblicazione() {
    return dataPubblicazione;
  }
  
  public void setDataPubblicazione(String dataPubblicazione) {
    this.dataPubblicazione = dataPubblicazione;
  }
  
  @ApiModelProperty(name = "dataScadenza",accessMode = AccessMode.READ_ONLY,notes="data di scadenza")
  public String getDataScadenza() {
    return dataScadenza;
  }
  
  public void setDataScadenza(String dataScadenza) {
    this.dataScadenza = dataScadenza;
  }
  
  @ApiModelProperty(name = "proceduraRiferimento",accessMode = AccessMode.READ_ONLY,notes="codice della procedura di riferimento")
  public String getProceduraRiferimento() {
    return proceduraRiferimento;
  }
  
  public void setProceduraRiferimento(String proceduraRiferimento) {
    this.proceduraRiferimento = proceduraRiferimento;
  }
  
  @ApiModelProperty(name = "stato",accessMode = AccessMode.READ_ONLY,notes="stato della entità")
  public String getStato() {
    return stato;
  }
  
  public void setStato(String stato) {
    this.stato = stato;
  }
  
  @ApiModelProperty(name = "datiProceduralotti",accessMode = AccessMode.READ_ONLY,notes="dati dei lotti della procedura",reference = "lotto")
  public List<? extends GareLottiDto> getDatiProceduralotti() {
    return datiProceduralotti;
  }

  public void setDatiProceduralotti(List<? extends GareLottiDto> datiProceduralotti) {
    this.datiProceduralotti = datiProceduralotti;
  }

  @ApiModelProperty(name = "attiDocumenti",accessMode = AccessMode.READ_ONLY,notes="atti e documenti della entità",reference = "documento")
  public List<BandoDocumentoDto> getAttiDocumenti() {
    return attiDocumenti;
  }
  
  public void setAttiDocumenti(List<BandoDocumentoDto> attiDocumenti) {
    this.attiDocumenti = attiDocumenti;
  }

  @ApiModelProperty(name = "dataUltimaModifica",accessMode = AccessMode.READ_ONLY,notes="Data ultima modifica")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getDataUltimaModifica() {
    return dataUltimaModifica;
  }

  public void setDataUltimaModifica(Date dataUltimaModifica) {
    this.dataUltimaModifica = dataUltimaModifica;
  }

  @Override
  public String toString() {
    return "DatiGeneraliDto ["
        + (titolo != null ? "titolo=" + titolo + ", " : "")
        + (tipologiaAppalto != null ? "tipologiaAppalto=" + tipologiaAppalto + ", " : "")
        + (proceduraGara != null ? "proceduraGara=" + proceduraGara + ", " : "")
        + (criterioAggiudicazione != null ? "criterioAggiudicazione=" + criterioAggiudicazione + ", " : "")
        + (importoBaseGara != null ? "importoBaseGara=" + importoBaseGara + ", " : "")
        + (dataPubblicazione != null ? "dataPubblicazione=" + dataPubblicazione + ", " : "")
        + (dataScadenza != null ? "dataScadenza=" + dataScadenza + ", " : "")
        + (proceduraRiferimento != null ? "proceduraRiferimento=" + proceduraRiferimento + ", " : "")
        + (stato != null ? "stato=" + stato + ", " : "")
        + (datiProceduralotti != null ? "datiProceduralotti=" + datiProceduralotti + ", " : "")
        + (attiDocumenti != null ? "attiDocumenti=" + attiDocumenti : "")
        + "]";
  }
  
  
}
