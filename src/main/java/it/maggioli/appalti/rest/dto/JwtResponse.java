package it.maggioli.appalti.rest.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Json di risposta con il jwt token
 * @author gabriele.nencini
 *
 */
@ApiModel(value = "jwtResponse")
public class JwtResponse implements Serializable {
  private static final long serialVersionUID = 1L;
  private final String jwttoken;

  public JwtResponse(String jwttoken) {
      this.jwttoken = jwttoken;
  }

  @ApiModelProperty(value = "Token da usare per accedere ai servizi necessari di autenticazione")
  public String getToken() {
      return this.jwttoken;
  }
}
