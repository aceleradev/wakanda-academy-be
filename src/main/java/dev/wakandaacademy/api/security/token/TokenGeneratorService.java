package dev.wakandaacademy.api.security.token;

import java.time.LocalDateTime;

import dev.wakandaacademy.api.controller.dto.WakanderProfileDTO;

public interface TokenGeneratorService {
	
	String generateToken(WakanderProfileDTO wakanderProfileDTO, LocalDateTime expiresAt);
	
}
