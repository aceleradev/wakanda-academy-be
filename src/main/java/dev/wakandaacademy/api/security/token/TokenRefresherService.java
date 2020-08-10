package dev.wakandaacademy.api.security.token;

import dev.wakandaacademy.api.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.exception.InvalidTokenException;

public interface TokenRefresherService {

    AuthenticationResponse refreshToken(String expiredToken) throws InvalidTokenException;

}
