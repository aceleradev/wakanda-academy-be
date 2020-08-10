package com.aceleradev.api.security.authentication;

import com.aceleradev.api.exception.ExpiredTokenException;
import com.aceleradev.api.exception.InvalidTokenException;
import com.aceleradev.api.exception.NotFoundException;
import com.aceleradev.api.user.model.User;

public interface AuthenticatedProvider {
	User getByToken(String accessToken) throws InvalidTokenException, ExpiredTokenException, NotFoundException;
}
