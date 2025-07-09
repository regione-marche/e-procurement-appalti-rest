package it.maggioli.appalti.rest.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InternalExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(InternalExceptionHandler.class);
  
  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    LOG.error("Error {}",ex.getMessage(),ex);
    return new ResponseEntity<Object>(new ErrorResponse("Internal Server Error", null),HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    LOG.error("ExceptionInternal {}",ex.getMessage(),ex);
    ErrorResponse error = new ErrorResponse("Error on request", null);
    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(InvalidUserException.class)
  public ResponseEntity<ErrorResponse> handleInvalidUserException(InvalidUserException ex) {
    LOG.error("handleInvalidUserException {}",ex.getMessage(),ex);
    ErrorResponse error = new ErrorResponse(ex.getMessage(), null);
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.UNAUTHORIZED);
  }
  
  @ExceptionHandler(InvalidTokenException.class)
  public ResponseEntity<ErrorResponse> handleInvalidTokenException(InvalidTokenException ex) {
    LOG.error("InvalidTokenException {}",ex.getMessage(),ex);
    ErrorResponse error = new ErrorResponse(ex.getMessage(), null);
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.UNAUTHORIZED);
  }
  @ExceptionHandler(MissingMinimumDataException.class)
  public ResponseEntity<ErrorResponse> handleMissingMinimumDataException(MissingMinimumDataException ex) {
    LOG.error("MissingMinimumDataException {}",ex.getMessage(),ex);
    ErrorResponse error = new ErrorResponse("Richiesto almeno uno tra i seguenti parametri: "+ex.getMinimumData(), null);
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(Error404Exception.class)
  public ResponseEntity<ErrorResponse> handleError404Exception(Error404Exception ex) {
    LOG.error("Error404Exception {}",ex.getMessage(),ex);
    ErrorResponse error = new ErrorResponse(ex.getMessage(), null);
    return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
  }

}
