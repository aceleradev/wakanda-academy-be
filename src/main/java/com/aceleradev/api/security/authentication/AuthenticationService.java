package com.aceleradev.api.security.authentication;

import com.aceleradev.api.controller.dto.AuthenticationRequest;
import com.aceleradev.api.controller.dto.AuthenticationResponse;
import com.aceleradev.api.exception.InvalidTokenException;

public interface AuthenticationService {
	
	AuthenticationResponse authenticateUser(AuthenticationRequest request);
	AuthenticationResponse refresfhToken(String expiredToken) throws InvalidTokenException;
	
}
