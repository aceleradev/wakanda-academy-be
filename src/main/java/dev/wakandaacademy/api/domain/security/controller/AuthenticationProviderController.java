package dev.wakandaacademy.api.domain.security.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import dev.wakandaacademy.api.domain.security.authentication.AuthenticationService;
import dev.wakandaacademy.api.domain.security.controller.contract.AuthenticationProviderApi;
import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationRequest;
import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.exception.InvalidTokenException;

@Controller
public class AuthenticationProviderController implements AuthenticationProviderApi {
	
	private AuthenticationService authenticationService;

	public AuthenticationProviderController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Override
	public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
		logger.info("Recebendo requisição de autenticação: {}", request);
		AuthenticationResponse authenticateUser = this.authenticationService.authenticateUser(request);
		return ResponseEntity.ok(authenticateUser);
	}

	@Override
	public ResponseEntity<AuthenticationResponse> authenticationRefresh(String expiredToken) throws InvalidTokenException {
		logger.info("Solicitando renovação do Token");
		AuthenticationResponse refreshedAuthentication=this.authenticationService.refresfhToken(expiredToken);
		return ResponseEntity.ok(refreshedAuthentication);
	}

	private static final Logger logger = LogManager.getLogger(AuthenticationProviderController.class);
}
