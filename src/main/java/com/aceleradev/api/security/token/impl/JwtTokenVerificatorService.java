package com.aceleradev.api.security.token.impl;

import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.AuthenticatedUser;
import com.aceleradev.api.domain.PrivateKey;
import com.aceleradev.api.exception.ExpiredTokenException;
import com.aceleradev.api.exception.InvalidTokenException;
import com.aceleradev.api.security.token.TokenVerificatorService;
import com.aceleradev.api.util.DateUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@Service
public class JwtTokenVerificatorService implements TokenVerificatorService {
	
	private PrivateKey privateKey;
	
	public JwtTokenVerificatorService(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	
	@Override
	public AuthenticatedUser getTokenContent(String token) throws InvalidTokenException, ExpiredTokenException {
		if(token == null || token.isBlank())
			throw new InvalidTokenException("Token de acesso vazio");
		try {
			Claims claims = Jwts.parser()
								.setSigningKey(this.privateKey.getContent())
								.parseClaimsJws(token)
								.getBody();
			return new AuthenticatedUser(claims.getIssuer(), DateUtils.toLocalDateTime(claims.getExpiration()));
		} catch (ExpiredJwtException e) {
			throw new ExpiredTokenException("Token de acesso expirado", e);
		} catch (Exception e) {
			throw new InvalidTokenException("Token de acesso inválido", e);
		}
	}
	
}
