package com.aceleradev.api.security.authentication.impl;

import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.AuthenticatedUser;
import com.aceleradev.api.exception.ExpiredTokenException;
import com.aceleradev.api.exception.InvalidTokenException;
import com.aceleradev.api.exception.NotFoundException;
import com.aceleradev.api.security.authentication.AuthenticatedProvider;
import com.aceleradev.api.security.token.TokenVerificatorService;
import com.aceleradev.api.user.model.User;
import com.aceleradev.api.user.repository.UserRepository;

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
