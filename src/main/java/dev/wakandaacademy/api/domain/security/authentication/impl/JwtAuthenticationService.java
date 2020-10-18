package dev.wakandaacademy.api.domain.security.authentication.impl;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.security.authentication.AuthenticationService;
import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationRequest;
import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.domain.security.domain.BearerToken;
import dev.wakandaacademy.api.domain.security.token.TokenGeneratorService;
import dev.wakandaacademy.api.domain.security.token.TokenRefresherService;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderProfileDTO;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderRepository;
import dev.wakandaacademy.api.exception.InvalidTokenException;

@Service
public class JwtAuthenticationService implements AuthenticationService {
	
	private AuthenticationManager authenticationManager;
	private TokenGeneratorService tokenGeneratorService;
	private WakanderRepository wakanderRepository;
	private TokenRefresherService tokenRefresherService;

	public JwtAuthenticationService(AuthenticationManager authenticationManager, TokenGeneratorService tokenGeneratorService,
									WakanderRepository wakanderRepository, TokenRefresherService tokenRefresherService) {
		this.authenticationManager = authenticationManager;
		this.tokenGeneratorService = tokenGeneratorService;
		this.wakanderRepository = wakanderRepository;
		this.tokenRefresherService = tokenRefresherService;
	}

	@Override
	public AuthenticationResponse authenticateUser(AuthenticationRequest request) throws AuthenticationException {
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		Wakander wakander = this.wakanderRepository.findByEmail(request.getUsername()).get();
		LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(30L);
		String generatedToken = this.tokenGeneratorService.generateToken(new WakanderProfileDTO(wakander), expiresAt);
		return new AuthenticationResponse(generatedToken, expiresAt, "Bearer");
	}

	@Override
	public AuthenticationResponse refresfhToken(String expiredToken) throws InvalidTokenException {
		return this.tokenRefresherService.refreshToken(new BearerToken(expiredToken));
	}

}
