package com.aceleradev.api.controller.dto;

import java.time.LocalDateTime;

public class AuthenticatedUser {
	
	private String email;
	private LocalDateTime expiresAt;

	public AuthenticatedUser(String email, LocalDateTime expiresAt) {
		this.email = email;
		this.expiresAt = expiresAt;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	@Override
	public String toString() {
		return "AuthenticatedUser [email=" + email + ", expiresAt=" + expiresAt + "]";
	}
	
}
