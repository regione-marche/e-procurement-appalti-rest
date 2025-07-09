package it.maggioli.appalti.rest.exceptions;

/**
 * Classe per generare una eccezione ad hoc per gestire il set di dati minimi da ottenere in input
 * @author gabriele.nencini
 *
 */
public class MissingMinimumDataException extends Exception {
  private static final long serialVersionUID = 1L;
  private final String minimumData;
  
  public MissingMinimumDataException(String data) {
    super("Missing some data: "+data);
    this.minimumData = data;
  }
  
  public String getMinimumData() {
    return this.minimumData;
  }
}
