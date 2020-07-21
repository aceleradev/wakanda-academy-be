package com.aceleradev.api.security.token;

import java.time.LocalDateTime;

public interface TokenGeneratorService {
	
	String generateToken(String username, LocalDateTime expiresAt);
	
}
