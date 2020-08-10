package dev.wakandaacademy.api.security.authentication.impl;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.controller.dto.AuthenticatedUser;
import dev.wakandaacademy.api.exception.ExpiredTokenException;
import dev.wakandaacademy.api.exception.InvalidTokenException;
import dev.wakandaacademy.api.exception.NotFoundException;
import dev.wakandaacademy.api.security.authentication.AuthenticatedProvider;
import dev.wakandaacademy.api.security.token.TokenVerificatorService;
import dev.wakandaacademy.api.user.model.User;
import dev.wakandaacademy.api.user.repository.UserRepository;

@Service
public class JwtAuthenticatedProvider implements AuthenticatedProvider {
	
	private TokenVerificatorService tokenVerificatorService;
	private UserRepository userRepository;
	
	public JwtAuthenticatedProvider(TokenVerificatorService tokenVerificatorService, UserRepository userRepository) {
		this.tokenVerificatorService = tokenVerificatorService;
		this.userRepository = userRepository;
	}

	@Override
	public User getByToken(String accessToken) throws InvalidTokenException, ExpiredTokenException, NotFoundException {
		AuthenticatedUser authenticatedUser = this.tokenVerificatorService.getTokenContent(accessToken);
		User user = this.userRepository
						.findByEmail(authenticatedUser.getEmail())
						.orElseThrow(() -> new NotFoundException(String.format("Usuario[email=%s] nao encontrado", authenticatedUser.getEmail())));;
		return user;
	}

}
