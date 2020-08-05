package com.aceleradev.api.security.token;

import java.time.LocalDateTime;

import com.aceleradev.api.controller.dto.WakanderProfileDTO;

public interface TokenGeneratorService {
	
	String generateToken(WakanderProfileDTO wakanderProfileDTO, LocalDateTime expiresAt);
	
}
