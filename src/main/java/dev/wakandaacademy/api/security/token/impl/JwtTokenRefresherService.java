package dev.wakandaacademy.api.security.token.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.controller.dto.WakanderProfileDTO;
import dev.wakandaacademy.api.domain.PrivateKey;
import dev.wakandaacademy.api.exception.InvalidTokenException;
import dev.wakandaacademy.api.security.token.TokenRefresherService;

import java.time.LocalDateTime;

@Service
public class JwtTokenRefresherService implements TokenRefresherService {

    private PrivateKey privateKey;
    private JwtTokenGeneratorService tokenGeneratorService;

    public JwtTokenRefresherService(PrivateKey privateKey, JwtTokenGeneratorService tokenGeneratorService) {
        this.privateKey = privateKey;
        this.tokenGeneratorService = tokenGeneratorService;
    }

    @Override
    public AuthenticationResponse refreshToken(String expiredToken) throws InvalidTokenException {

        try {
            Claims claims = extractClaims(expiredToken);
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
