package it.maggioli.appalti.rest.exceptions;


public class Error404Exception extends Exception {

  private static final long serialVersionUID = 1L;

  public Error404Exception(String message, Throwable cause) {
    super(message, cause);
  }

  public Error404Exception(String message) {
    super(message);
  }

  public Error404Exception(Throwable cause) {
    super(cause);
  }

}
