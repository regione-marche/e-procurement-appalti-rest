package it.maggioli.appalti.rest.exceptions;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ErrorResponse", description = "This represent the default error message.")
public class ErrorResponse {
    public ErrorResponse(String message, final List<String> details) {
        this.message = message;
        this.details = details;
    }
 
    @ApiModelProperty(name = "message",value = "General error message about nature of error",dataType = "String")
    //General error message about nature of error
    private String message;
 
    @ApiModelProperty(name = "message",value = "Specific errors in API request processing",dataType = "List")
    //Specific errors in API request processing
    private List<String> details;
    
    public String getMessage() {
      return message;
    }
    
    public void setMessage(String message) {
      this.message = message;
    }
    
    public List<String> getDetails() {
      return details;
    }
    
    public void setDetails(List<String> details) {
      this.details = details;
    }  
    
}
