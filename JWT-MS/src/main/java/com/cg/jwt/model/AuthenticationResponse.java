package com.cg.jwt.model;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationResponse {

	
	private String jwtToken;
    private Boolean valid;
    
    
    public AuthenticationResponse() {
        
    }
    
    public AuthenticationResponse(String jwtToken, Boolean valid) {
      
        this.jwtToken = jwtToken;
        this.valid = valid;
    }

   
 
    public String getJwtToken() {
        return jwtToken;
    }
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public Boolean getValid() {
        return valid;
    }
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
