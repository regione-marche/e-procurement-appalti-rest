package it.maggioli.appalti.rest.entities.views.ws;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * Classe che mappa la vista <code>v_ws_gare_anticor</code>
 * <br>questa classe è marcata come <code>@Immutable</code> per evitare che erroneamente si provi a modificare i dati
 * @author gabriele.nencini
 *
 */
@Entity
@Immutable
@Table(name = "v_ws_gare_anticor")
public class GareAnticorruzione {
  private Integer annorif;
  @Id
  private Long idanticorlotti;
  private String cig;
  private String codfiscprop;
  private String denomprop;
  private String oggetto;
  private Integer codsceltacontr;
  private String descsceltacontr;
  private Double impaggiudic;
  private Date datainizio;
  private Date dataultimazione;
  private Double impsommeliq;
  
  public Integer getAnnorif() {
    return annorif;
  }
  
  public void setAnnorif(Integer annorif) {
    this.annorif = annorif;
  }
  
  public Long getIdanticorlotti() {
    return idanticorlotti;
  }
  
  public void setIdanticorlotti(Long idanticorlotti) {
    this.idanticorlotti = idanticorlotti;
  }
  
  public String getCig() {
    return cig;
  }
  
  public void setCig(String cig) {
    this.cig = cig;
  }
  
  public String getCodfiscprop() {
    return codfiscprop;
  }
  
  public void setCodfiscprop(String codfiscprop) {
    this.codfiscprop = codfiscprop;
  }
  
  public String getDenomprop() {
    return denomprop;
  }
  
  public void setDenomprop(String denomprop) {
    this.denomprop = denomprop;
  }
  
  public String getOggetto() {
    return oggetto;
  }
  
  public void setOggetto(String oggetto) {
    this.oggetto = oggetto;
  }
  
  public Integer getCodsceltacontr() {
    return codsceltacontr;
  }
  
  public void setCodsceltacontr(Integer codsceltacontr) {
    this.codsceltacontr = codsceltacontr;
  }
  
  public String getDescsceltacontr() {
    return descsceltacontr;
  }
  
  public void setDescsceltacontr(String descsceltacontr) {
    this.descsceltacontr = descsceltacontr;
  }
  
  public Double getImpaggiudic() {
    return impaggiudic;
  }
  
  public void setImpaggiudic(Double impaggiudic) {
    this.impaggiudic = impaggiudic;
  }
  
  public Date getDatainizio() {
    return datainizio;
  }
  
  public void setDatainizio(Date datainizio) {
    this.datainizio = datainizio;
  }
  
  public Date getDataultimazione() {
    return dataultimazione;
  }
  
  public void setDataultimazione(Date dataultimazione) {
    this.dataultimazione = dataultimazione;
  }
  
  public Double getImpsommeliq() {
    return impsommeliq;
  }
  
  public void setImpsommeliq(Double impsommeliq) {
    this.impsommeliq = impsommeliq;
  }

  @Override
  public String toString() {
    return "GareAnticorruzione ["
        + (idanticorlotti != null ? "idanticorlotti=" + idanticorlotti + ", " : "")
        + (cig != null ? "cig=" + cig + ", " : "")
        + (codfiscprop != null ? "codfiscprop=" + codfiscprop : "")
        + "]";
  }
  
}
