package dev.wakandaacademy.api.domain.security.token;

import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.exception.InvalidTokenException;

public interface TokenRefresherService {

    AuthenticationResponse refreshToken(String expiredToken) throws InvalidTokenException;

}
