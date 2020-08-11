package dev.wakandaacademy.api.domain.security.authentication;

import dev.wakandaacademy.api.domain.user.model.User;
import dev.wakandaacademy.api.exception.ExpiredTokenException;
import dev.wakandaacademy.api.exception.InvalidTokenException;
import dev.wakandaacademy.api.exception.NotFoundException;

public interface AuthenticatedProvider {
	User getByToken(String accessToken) throws InvalidTokenException, ExpiredTokenException, NotFoundException;
}
