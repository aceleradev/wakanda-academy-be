package com.aceleradev.api.controller.contract;

import com.aceleradev.api.exception.InvalidTokenException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aceleradev.api.controller.dto.AuthenticationRequest;
import com.aceleradev.api.controller.dto.AuthenticationResponse;

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
