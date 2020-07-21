package com.aceleradev.api.security.authentication;

import com.aceleradev.api.controller.dto.AuthenticationRequest;
import com.aceleradev.api.controller.dto.AuthenticationResponse;

public interface AuthenticationService {
	
	AuthenticationResponse authenticateUser(AuthenticationRequest request);
	
}
