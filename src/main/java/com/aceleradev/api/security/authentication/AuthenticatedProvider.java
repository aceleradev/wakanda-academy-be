package com.aceleradev.api.security.authentication;

import com.aceleradev.api.domain.model.User;
import com.aceleradev.api.exception.ExpiredTokenException;
import com.aceleradev.api.exception.InvalidTokenException;
import com.aceleradev.api.exception.NotFoundException;

public interface AuthenticatedProvider {
	User getByToken(String accessToken) throws InvalidTokenException, ExpiredTokenException, NotFoundException;
}
