package dev.wakandaacademy.api.domain.security.token.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticatedUser;
import dev.wakandaacademy.api.domain.security.domain.PrivateKey;
import dev.wakandaacademy.api.domain.security.token.TokenVerificatorService;
import dev.wakandaacademy.api.exception.ExpiredTokenException;
import dev.wakandaacademy.api.exception.InvalidTokenException;
import dev.wakandaacademy.api.util.DateUtils;
import dev.wakandaacademy.api.util.StringUtil;
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
		if(StringUtil.isBlank(token))
			throw new InvalidTokenException("Token de acesso vazio");
		try {
			Claims claims = Jwts.parser()
								.setSigningKey(this.privateKey.getContent())
								.parseClaimsJws(token)
								.getBody();
			String email = Optional.ofNullable(claims.get("email"))
								.map(Object::toString)
								.orElse(null);
			return new AuthenticatedUser(email, DateUtils.toLocalDateTime(claims.getExpiration()));
		} catch (ExpiredJwtException e) {
			throw new ExpiredTokenException("Token de acesso expirado", e);
		} catch (Exception e) {
			throw new InvalidTokenException("Token de acesso inválido", e);
		}
	}
	
}
