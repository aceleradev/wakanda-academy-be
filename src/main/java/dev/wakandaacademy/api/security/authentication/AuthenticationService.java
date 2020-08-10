package dev.wakandaacademy.api.security.authentication;

import dev.wakandaacademy.api.controller.dto.AuthenticationRequest;
import dev.wakandaacademy.api.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.exception.InvalidTokenException;

public interface AuthenticationService {
	
	AuthenticationResponse authenticateUser(AuthenticationRequest request);
	AuthenticationResponse refresfhToken(String expiredToken) throws InvalidTokenException;
	
}
