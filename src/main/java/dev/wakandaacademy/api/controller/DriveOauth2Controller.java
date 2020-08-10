package dev.wakandaacademy.api.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;

import dev.wakandaacademy.api.controller.contract.DriveOauth2Api;

@Controller
public class DriveOauth2Controller implements DriveOauth2Api {
	
	private GoogleAuthorizationCodeFlow flow;
	
	public DriveOauth2Controller(GoogleAuthorizationCodeFlow flow) {
		this.flow = flow;
	}

	@Override
	public ResponseEntity<Void> oauth2(String authorizationCode) throws IOException {
		GoogleTokenResponse tokenResponse = flow.newTokenRequest(authorizationCode).setRedirectUri("http://wakanda-academy-be.herokuapp.com/wakanda/app/v1/oauth2").execute();
		flow.createAndStoreCredential(tokenResponse, "user");
		return ResponseEntity.ok().build();
	}
	
}
