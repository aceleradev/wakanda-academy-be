package dev.wakandaacademy.api.security.authentication.impl;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.controller.dto.AuthenticationRequest;
import dev.wakandaacademy.api.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.controller.dto.WakanderProfileDTO;
import dev.wakandaacademy.api.domain.model.Wakander;
import dev.wakandaacademy.api.exception.InvalidTokenException;
import dev.wakandaacademy.api.repository.WakanderRepository;
import dev.wakandaacademy.api.security.authentication.AuthenticationService;
import dev.wakandaacademy.api.security.token.TokenGeneratorService;
import dev.wakandaacademy.api.security.token.TokenRefresherService;

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
		return this.tokenRefresherService.refreshToken(expiredToken);
	}

}
