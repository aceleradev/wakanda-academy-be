package dev.wakandaacademy.api.domain.security.authentication;

import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationRequest;
import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.exception.InvalidTokenException;

public interface AuthenticationService {
	
	AuthenticationResponse authenticateUser(AuthenticationRequest request);
	AuthenticationResponse refresfhToken(String expiredToken) throws InvalidTokenException;
	
}
