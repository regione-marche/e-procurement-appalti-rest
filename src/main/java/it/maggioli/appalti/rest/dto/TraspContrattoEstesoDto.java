package it.maggioli.appalti.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEsteso TraspContrattoEsteso}
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
  private String nrepat;
  
  @ApiModelProperty(example = "2020-05-11 00:00:00",value="Data termine partecipazione")
  @JsonProperty(value = "dataterminepartecipazione")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDtepar() {
    return dtepar;
  }
  
  public void setDtepar(Date dtepar) {
    this.dtepar = dtepar;
  }
  @ApiModelProperty(value="Ora termine partecipazione")
  @JsonProperty(value = "oraterminepartecipazione")
  public String getOtepar() {
    return otepar;
  }
  
  public void setOtepar(String otepar) {
    this.otepar = otepar;
  }
  
  @ApiModelProperty(example = "2020-05-11 00:00:00",value="Data termine offerta")
  @JsonProperty(value = "datatermineofferta")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDteoff() {
    return dteoff;
  }
  
  public void setDteoff(Date dteoff) {
    this.dteoff = dteoff;
  }
  
  @ApiModelProperty(value="Ora termine offerta")
  @JsonProperty(value = "oratermineofferta")
  public String getOteoff() {
    return oteoff;
  }
  
  public void setOteoff(String oteoff) {
    this.oteoff = oteoff;
  }
  
  @ApiModelProperty(value="Data e Ora termine partecipazione")
  @JsonProperty(value = "dataoraterminepartecipazione")
  public String getDataoraterminepar() {
    return dataoraterminepar;
  }
  
  public void setDataoraterminepar(String dataoraterminepar) {
    this.dataoraterminepar = dataoraterminepar;
  }
  
  @ApiModelProperty(value="Data e Ora termine offerta")
  @JsonProperty(value = "dataoratermineofferta")
  public String getDataoratermineoff() {
    return dataoratermineoff;
  }
  
  public void setDataoratermineoff(String dataoratermineoff) {
    this.dataoratermineoff = dataoratermineoff;
  }
  public String getNrepat() {
    return nrepat;
  }
  public void setNrepat(String nrepat) {
    this.nrepat = nrepat;
  }
}
