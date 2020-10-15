package dev.wakandaacademy.api.domain.security.controller.dto;

import java.time.LocalDateTime;

public class AuthenticationResponse {
	
	private String token;
	private LocalDateTime expiresAt;
	private String type;
	
	public AuthenticationResponse() {}
	
	public AuthenticationResponse(String token, LocalDateTime expiresAt, String type) {
		this.token = token;
		this.expiresAt = expiresAt;
		this.type = type;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}
	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [token=" + token + ", expiresAt=" + expiresAt + ", type=" + type + "]";
	}
	
}
