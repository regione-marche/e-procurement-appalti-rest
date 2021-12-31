package it.maggioli.appalti.rest.exceptions;

/**
 * Eccezione lanciata in caso di token non valido
 * @author gabriele.nencini
 *
 */
public class InvalidTokenException extends Exception {
  private static final long serialVersionUID = 1L;

  @Override
  public String getMessage() {
    return "Token invalid or expired.";
  }

}
