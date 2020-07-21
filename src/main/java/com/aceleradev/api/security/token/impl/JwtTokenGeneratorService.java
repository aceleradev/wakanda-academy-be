package com.aceleradev.api.security.token.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.WakanderProfileDTO;
import com.aceleradev.api.domain.PrivateKey;
import com.aceleradev.api.security.token.TokenGeneratorService;
import com.aceleradev.api.util.DateUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenGeneratorService implements TokenGeneratorService {
	
	private PrivateKey privateKey;
	
	public JwtTokenGeneratorService(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	@Override
	public String generateToken(WakanderProfileDTO wakanderProfileDTO, LocalDateTime expiresAt) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("wakanderCode", wakanderProfileDTO.getCode());
		params.put("name", wakanderProfileDTO.getNome());
		params.put("email", wakanderProfileDTO.getEmail());
		return Jwts.builder()
				.setIssuedAt(new Date())
				.setSubject("Usuario wakanda")
				.setIssuer(wakanderProfileDTO.getEmail())
				.setExpiration(DateUtils.toDate(expiresAt))
				.signWith(SignatureAlgorithm.HS256, this.privateKey.getContent())
				.setClaims(params)
				.compact();
	}
	
}
