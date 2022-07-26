package com.cg.jwt.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jwt.security.jwt.JwtUtils;


@Service
public class ValidateService {
	
	
	@Autowired
    private JwtUtils jwtutils;
	
	 public AuthenticationResponse validate(String token) {
	        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
	        String jwt = token.substring(7);
	        authenticationResponse.setJwtToken(jwt);
	        authenticationResponse.setValid(jwtutils.validateJwtToken(jwt));
	        return authenticationResponse;
	    }
}
