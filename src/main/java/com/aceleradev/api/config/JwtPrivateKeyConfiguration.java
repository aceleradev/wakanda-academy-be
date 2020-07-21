package com.aceleradev.api.config;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aceleradev.api.domain.PrivateKey;

@Configuration
public class JwtPrivateKeyConfiguration {

	private String fileLocation;
	
	public JwtPrivateKeyConfiguration(@Value("${app.jwt.key.location}") String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Bean
	public PrivateKey privateKey() throws IOException {
		InputStream stream = JwtPrivateKeyConfiguration.class.getResourceAsStream(this.fileLocation);
		byte[] content = new byte[stream.available()];
		stream.read(content);
		return new PrivateKey(content);
	}
	
}
