package it.maggioli.appalti.rest.exceptions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * Componente per gestire gli attributi di default del messaggio di errore
 * @author gabriele.nencini
 *
 */
@Component
public class ErrorAttributesHandler extends DefaultErrorAttributes {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
    Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, false);
    // javax.servlet.error.status_code
    // System.out.println("STATUS: "+webRequest.getAttribute("javax.servlet.error.status_code", 0));
    // Throwable error = (Throwable) webRequest.getAttribute("javax.servlet.error.exception", 0);
    // if(error != null) {
    // System.out.println("ERROR: "+error);
    // if(error.getCause()!=null && error.getCause().getClass().getSimpleName().equals("InvalidTokenException")) {
    // System.out.println("ERROR: "+error.getCause());
    // errorAttributes.put("status", HttpStatus.UNAUTHORIZED.value());
    // }
    // }
    errorAttributes.remove("error");
    errorAttributes.remove("path");
    logger.debug("{}",errorAttributes);
    return errorAttributes;
  }
}
