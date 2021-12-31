package it.maggioli.appalti.rest.filters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import it.maggioli.appalti.rest.exceptions.InvalidTokenException;
import it.maggioli.appalti.rest.manager.AuthenticationManager;

/**
 * Filtro per la autenticazione
 * @author gabriele.nencini
 *
 */
public class FilterAuthentication implements Filter{
  private Logger logger = LoggerFactory.getLogger(FilterAuthentication.class);
  
  private AuthenticationManager authenticationManager;
  
  public FilterAuthentication(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    logger.debug("Before filter");
    try {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      String auth = httpRequest.getHeader("Authorization");
      if(!StringUtils.isEmpty(auth)) {
        Map<String,Object> res = null;
        if(StringUtils.startsWithIgnoreCase(auth, "Bearer")) {
          res = authenticationManager.isTokenValid(auth.replace("Bearer ", ""));        
        } else {
          res = authenticationManager.isTokenValid(auth);
        }
        @SuppressWarnings("unchecked")
        List<String> codein = (List<String>) res.getOrDefault("codein", Collections.emptyList());
        logger.info("codein: {}",codein);
        request.setAttribute("codein", codein);
        request.setAttribute("syscon", res.getOrDefault("syscon", 0l));
        chain.doFilter(request, response);
      } else {
        logger.warn("No auth setted");
        throw new InvalidTokenException();
      }
    } catch (InvalidTokenException e) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
      String body = "{\"timestamp\":\""+sdf.format(new Date())+"\",\"status\":"+HttpStatus.UNAUTHORIZED.value()+",\"message\":\""+e.getMessage()+"\"}";
      httpResponse.setContentLength(body.length());
      httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
      httpResponse.getOutputStream().print(body);
      httpResponse.getOutputStream().flush();
    }
    logger.debug("After filter");
  }

}
