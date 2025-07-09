package it.maggioli.appalti.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.views.ws.TraspContrattoEsteso TraspContrattoEsteso}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "TraspContrattoEstesoDac")
public class TraspContrattoEstesoDacDto extends TraspContrattoEstesoDto {
  private Date dataacquisizionecig;
  
  /**
   * @return the dataacquisizionecig
   */
  @ApiModelProperty(example = "2020-05-11 00:00:00",value = "Data acquisizione cig")
  @JsonProperty(value = "dataacquisizionecig")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = EUROPE_TIMEZONE)
  public Date getDataacquisizionecig() {
    return dataacquisizionecig;
  }

  
  /**
   * @param dataacquisizionecig the dataacquisizionecig to set
   */
  public void setDataacquisizionecig(Date dataacquisizionecig) {
    this.dataacquisizionecig = dataacquisizionecig;
  }

}
