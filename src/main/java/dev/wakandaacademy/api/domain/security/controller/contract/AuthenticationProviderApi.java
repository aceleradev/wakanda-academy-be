package dev.wakandaacademy.api.domain.security.controller.contract;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationRequest;
import dev.wakandaacademy.api.domain.security.controller.dto.AuthenticationResponse;
import dev.wakandaacademy.api.exception.InvalidTokenException;

@RequestMapping("/authenticate")
public interface AuthenticationProviderApi {
	
	@CrossOrigin
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

	@CrossOrigin
	@RequestMapping("/refresh")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AuthenticationResponse> authenticationRefresh(@RequestHeader(name="Authorization") String token) throws InvalidTokenException;
	
}
