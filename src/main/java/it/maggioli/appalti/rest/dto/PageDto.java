package it.maggioli.appalti.rest.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Questa classe rappresenta una pagina di oggetti presenti in base dati
 * 
 * @author gabriele.nencini
 *
 * @param <T> - la classe degli oggetti che verranno restituiti nel content
 */
@ApiModel(value = "Pagina")
public class PageDto<T> implements Serializable {
  private static final long serialVersionUID = 1L;
  private List<T> content;
  private int totalPages;
  private long totalElements;
  private boolean last;
  private int size;
  private int number;
  private boolean first;
  private int numberOfElements;
  private boolean empty;
  
  /**
   * 
   * @return restituisce la lista degli oggetti da restituire
   */
  @ApiModelProperty(name = "contenuto",value = "Il contenuto della pagina")
  public List<T> getContent() {
    return content;
  }
  
  public void setContent(List<T> content) {
    this.content = content;
  }
  
  /**
   * 
   * @return Le pagine totali presenti a sistema
   */
  @ApiModelProperty(name = "pagineTotali",value = "Le pagine totali presenti a sistema",allowableValues = "range[0,infinity]")
  public int getTotalPages() {
    return totalPages;
  }
  
  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
  
  /**
   * 
   * @return Il totale degli elementi presenti a sistema
   */
  @ApiModelProperty(name = "elementiTotali",value = "Il totale degli elementi presenti a sistema",allowableValues = "range[0,infinity]")
  public long getTotalElements() {
    return totalElements;
  }
  
  public void setTotalElements(long totalElements) {
    this.totalElements = totalElements;
  }
  
  /**
   * 
   * @return Indicatore di ultima pagina
   */
  @ApiModelProperty(name = "ultimaPagina",value = "Indicatore di ultima pagina",allowableValues = "true,false")
  public boolean isLast() {
    return last;
  }
  
  public void setLast(boolean last) {
    this.last = last;
  }
  
  /**
   * 
   * @return Il massimo numero di elementi presenti nella pagina
   */
  @ApiModelProperty(name = "grandezzaPagina",value = "Il massimo numero di elementi presenti nella pagina",allowableValues = "range[0,infinity]")
  public int getSize() {
    return size;
  }
  
  public void setSize(int size) {
    this.size = size;
  }
  
  /**
   * 
   * @return Numero della pagina richiesta, parte da 0
   */
  @ApiModelProperty(name = "numeroPagina",value = "Numero della pagina richiesta, parte da 0",allowableValues = "range[0,infinity]")
  public int getNumber() {
    return number;
  }
  
  public void setNumber(int number) {
    this.number = number;
  }
  
  /**
   * 
   * @return Indicatore di prima pagina
   */
  @ApiModelProperty(name = "primaPagina",value = "Indicatore di prima pagina",allowableValues = "true,false")
  public boolean isFirst() {
    return first;
  }
  
  public void setFirst(boolean first) {
    this.first = first;
  }
  
  /**
   * 
   * @return Numero degli elementi presenti nella pagina richiesta
   */
  @ApiModelProperty(name = "numeroElementi",value = "Numero degli elementi presenti nella pagina richiesta",allowableValues = "range[0,infinity]")
  public int getNumberOfElements() {
    return numberOfElements;
  }
  
  public void setNumberOfElements(int numberOfElements) {
    this.numberOfElements = numberOfElements;
  }
  
  /**
   * 
   * @return Indicatore di pagina vuota
   */
  @ApiModelProperty(name = "paginaVuota",value = "Indicatore di pagina vuota",allowableValues = "true,false")
  public boolean isEmpty() {
    return empty;
  }
  
  public void setEmpty(boolean empty) {
    this.empty = empty;
  }
  
  
}
