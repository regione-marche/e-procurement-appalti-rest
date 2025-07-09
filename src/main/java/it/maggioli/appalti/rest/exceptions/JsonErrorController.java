package it.maggioli.appalti.rest.exceptions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class JsonErrorController extends AbstractErrorController {

  private static final Logger logger = LoggerFactory.getLogger(JsonErrorController.class);
  
  public JsonErrorController(ErrorAttributes errorAttributes) {
    super(errorAttributes);
  }

  @GetMapping
  public ResponseEntity<Map<String, Object>> error(final HttpServletRequest request) {
      final Map<String, Object> body = this.getErrorAttributes(request, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE));
      final HttpStatus status = this.getStatus(request);
      logger.trace("{}",status);
      return new ResponseEntity<>(body, status);
  }
  
}
