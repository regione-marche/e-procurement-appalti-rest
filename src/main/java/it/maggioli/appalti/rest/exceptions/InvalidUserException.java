package it.maggioli.appalti.rest.exceptions;

/**
 * Eccezione lanciata in caso di utente non valido
 * @author gabriele.nencini
 *
 */
public class InvalidUserException extends Exception {
  private static final long serialVersionUID = 1L;

  @Override
  public String getMessage() {
    return "Username o password invalidi.";
  }

}
