package it.maggioli.appalti.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data Transfer Object per {@link it.maggioli.appalti.rest.entities.TabUno TabUno}
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "tipologia")
public class TabulatoDto {
  private int id;
  private String descrizione;
  
  public TabulatoDto(int id, String descrizione) {
    this.id = id;
    this.descrizione = descrizione;
  }

  @ApiModelProperty(name = "id",value = "Identificativo della tipologia")
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  @ApiModelProperty(name = "descrizione",value = "Descrizione della tipologia")
  public String getDescrizione() {
    return descrizione;
  }
  
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TabulatoDto other = (TabulatoDto) obj;
    if (descrizione == null) {
      if (other.descrizione != null) return false;
    } else if (!descrizione.equals(other.descrizione)) return false;
    if (id != other.id) return false;
    return true;
  }
  
  
}
