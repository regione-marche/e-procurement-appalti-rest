package it.maggioli.appalti.rest.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
  
  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    logger.error("Error {}",ex.getMessage(),ex);
    return new ResponseEntity<Object>(new ErrorResponse("No Handler Found For Exception.", null),HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status,
      WebRequest request) {
    logger.error("ExceptionInternal {}",ex.getMessage(),ex);
    ErrorResponse error = new ErrorResponse("Error on request", null);
    return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
  }

}
