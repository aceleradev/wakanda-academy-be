package com.aceleradev.api.security.authentication.impl;

import java.time.LocalDateTime;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.AuthenticationRequest;
import com.aceleradev.api.controller.dto.AuthenticationResponse;
import com.aceleradev.api.controller.dto.WakanderProfileDTO;
import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.repository.WakanderRepository;
import com.aceleradev.api.security.authentication.AuthenticationService;
import com.aceleradev.api.security.token.TokenGeneratorService;

@Service
public class JwtAuthenticationService implements AuthenticationService {
	
	private AuthenticationManager authenticationManager;
	private TokenGeneratorService tokenGeneratorService;
	private WakanderRepository wakanderRepository;
	
	public JwtAuthenticationService(AuthenticationManager authenticationManager, TokenGeneratorService tokenGeneratorService, WakanderRepository wakanderRepository) {
		this.authenticationManager = authenticationManager;
		this.tokenGeneratorService = tokenGeneratorService;
		this.wakanderRepository = wakanderRepository;
	}

	@Override
	public AuthenticationResponse authenticateUser(AuthenticationRequest request) throws AuthenticationException {
		this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		Wakander wakander = this.wakanderRepository.findByEmail(request.getUsername()).get();
		LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(30L);
		String generatedToken = this.tokenGeneratorService.generateToken(new WakanderProfileDTO(wakander), expiresAt);
		return new AuthenticationResponse(generatedToken, expiresAt, "Bearer");
	}

}
