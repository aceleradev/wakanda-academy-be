package dev.wakandaacademy.api.domain.security.token.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.domain.security.domain.PrivateKey;
import dev.wakandaacademy.api.domain.security.domain.SecurityToken;
import dev.wakandaacademy.api.domain.security.token.TokenRefresherService;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderProfileDTO;
import dev.wakandaacademy.api.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Service
public class JwtTokenRefresherService implements TokenRefresherService {

    private PrivateKey privateKey;
    private JwtTokenGeneratorService tokenGeneratorService;

    public JwtTokenRefresherService(PrivateKey privateKey, JwtTokenGeneratorService tokenGeneratorService) {
        this.privateKey = privateKey;
        this.tokenGeneratorService = tokenGeneratorService;
    }

    @Override
    public AuthenticationResponse refreshToken(SecurityToken expiredToken) throws InvalidTokenException {

        try {
            Claims claims = extractClaims(expiredToken.getToken());
            LocalDateTime expireAt=LocalDateTime.now().plusMinutes(30L);
            return new AuthenticationResponse(
                    tokenGeneratorService.generateToken(
                            new WakanderProfileDTO(claims),
                            expireAt
                    ),
                    expireAt,
                    "Bearer"
            );

        } catch (InvalidTokenException e) {
             throw new InvalidTokenException("Token de acesso inválido", e);
        }

    }


    private Claims extractClaims(String token) throws InvalidTokenException{
        return Jwts.parser()
                    .setSigningKey(this.privateKey.getContent())
                    .parseClaimsJws(token) //Linha que lança a exception
                    .getBody();
    }

}
