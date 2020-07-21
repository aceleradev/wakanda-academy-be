package com.aceleradev.api.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.aceleradev.api.domain.PrivateKey;
import com.google.common.io.Files;

@Configuration
public class JwtPrivateKeyConfiguration {

	private Resource resource;
	
	public JwtPrivateKeyConfiguration(@Value("${app.jwt.key.location}") Resource resource) {
		this.resource = resource;
	}

	@Bean
	public PrivateKey privateKey() throws IOException {
		byte[] content = Files.toByteArray(this.resource.getFile());
		return new PrivateKey(content);
	}
	
}
