package dev.wakandaacademy.api.domain.security.token;

import java.time.LocalDateTime;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderProfileDTO;

public interface TokenGeneratorService {
	
	String generateToken(WakanderProfileDTO wakanderProfileDTO, LocalDateTime expiresAt);
	
}
