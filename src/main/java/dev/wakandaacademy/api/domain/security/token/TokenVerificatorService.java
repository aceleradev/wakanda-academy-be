package dev.wakandaacademy.api.domain.security.token;

import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticatedUser;
import dev.wakandaacademy.api.exception.ExpiredTokenException;
import dev.wakandaacademy.api.exception.InvalidTokenException;

public interface TokenVerificatorService {
	
	AuthenticatedUser getTokenContent(String token) throws InvalidTokenException, ExpiredTokenException;
	
}
