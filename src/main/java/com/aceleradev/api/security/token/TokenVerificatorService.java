package com.aceleradev.api.security.token;

import com.aceleradev.api.controller.dto.AuthenticatedUser;
import com.aceleradev.api.exception.ExpiredTokenException;
import com.aceleradev.api.exception.InvalidTokenException;

public interface TokenVerificatorService {
	
	AuthenticatedUser getTokenContent(String token) throws InvalidTokenException, ExpiredTokenException;
	
}
