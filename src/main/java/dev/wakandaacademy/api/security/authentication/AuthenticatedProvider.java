package dev.wakandaacademy.api.security.authentication;

import dev.wakandaacademy.api.exception.ExpiredTokenException;
import dev.wakandaacademy.api.exception.InvalidTokenException;
import dev.wakandaacademy.api.exception.NotFoundException;
import dev.wakandaacademy.api.user.model.User;

public interface AuthenticatedProvider {
	User getByToken(String accessToken) throws InvalidTokenException, ExpiredTokenException, NotFoundException;
}
