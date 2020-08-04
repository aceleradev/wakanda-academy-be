package com.aceleradev.api.controller.dto;

import com.aceleradev.api.domain.model.Wakander;
import io.jsonwebtoken.Claims;

public class WakanderProfileDTO {
	
	private String code;
	private String nome;
	private String email;

	public WakanderProfileDTO(Wakander wakander) {
		this.code = wakander.getCode();
		this.nome = wakander.getName();
		this.email = wakander.getEmail();
	}

	public WakanderProfileDTO(Claims claims) {
		this.code = String.valueOf(claims.get("wakanderCode"));
		this.nome = String.valueOf(claims.get("name"));
		this.email = String.valueOf(claims.get("email"));
	}

	public String getCode() {
		return code;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

}
