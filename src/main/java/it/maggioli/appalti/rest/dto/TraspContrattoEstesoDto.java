package it.maggioli.appalti.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.TraspContratto TraspContratto}
 * @author gabriele.nencini
 *
 */
public class TraspContrattoEstesoDto extends TraspContrattoDto {
  private Date dtepar;
  private String otepar;
  private Date dteoff;
  private String oteoff;
  private String dataoraterminepar;
  private String dataoratermineoff;
  
  @JsonProperty(value = "dataterminepartecipazione")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDtepar() {
    return dtepar;
  }
  
  public void setDtepar(Date dtepar) {
    this.dtepar = dtepar;
  }
  
  @JsonProperty(value = "oraterminepartecipazione")
  public String getOtepar() {
    return otepar;
  }
  
  public void setOtepar(String otepar) {
    this.otepar = otepar;
  }
  
  @JsonProperty(value = "datatermineofferta")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDteoff() {
    return dteoff;
  }
  
  public void setDteoff(Date dteoff) {
    this.dteoff = dteoff;
  }
  
  @JsonProperty(value = "oratermineofferta")
  public String getOteoff() {
    return oteoff;
  }
  
  public void setOteoff(String oteoff) {
    this.oteoff = oteoff;
  }
  
  @JsonProperty(value = "dataoraterminepartecipazione")
  public String getDataoraterminepar() {
    return dataoraterminepar;
  }
  
  public void setDataoraterminepar(String dataoraterminepar) {
    this.dataoraterminepar = dataoraterminepar;
  }
  
  @JsonProperty(value = "dataoratermineofferta")
  public String getDataoratermineoff() {
    return dataoratermineoff;
  }
  
  public void setDataoratermineoff(String dataoratermineoff) {
    this.dataoratermineoff = dataoratermineoff;
  }
  
  
}
