package com.aceleradev.api.security.token;

import com.aceleradev.api.controller.dto.AuthenticationResponse;
import com.aceleradev.api.exception.InvalidTokenException;

public interface TokenRefresherService {

    AuthenticationResponse refreshToken(String expiredToken) throws InvalidTokenException;

}
