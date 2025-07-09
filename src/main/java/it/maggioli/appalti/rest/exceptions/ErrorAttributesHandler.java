package it.maggioli.appalti.rest.exceptions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
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

  private static final Logger logger = LoggerFactory.getLogger(ErrorAttributesHandler.class);

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
    Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE));
    errorAttributes.remove("error");
    errorAttributes.remove("path");
    logger.debug("{}", errorAttributes);
    return errorAttributes;
  }
}
