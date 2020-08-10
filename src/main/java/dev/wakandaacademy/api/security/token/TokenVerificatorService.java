package dev.wakandaacademy.api.security.token;

import dev.wakandaacademy.api.controller.dto.AuthenticatedUser;
import dev.wakandaacademy.api.exception.ExpiredTokenException;
import dev.wakandaacademy.api.exception.InvalidTokenException;

public interface TokenVerificatorService {
	
	AuthenticatedUser getTokenContent(String token) throws InvalidTokenException, ExpiredTokenException;
	
}
