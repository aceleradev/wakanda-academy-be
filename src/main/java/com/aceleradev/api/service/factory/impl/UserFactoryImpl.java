package com.aceleradev.api.service.factory.impl;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.UserCreationFormDto;
import com.aceleradev.api.domain.model.Credential;
import com.aceleradev.api.domain.model.User;
import com.aceleradev.api.service.encrypt.PasswordEncrypter;
import com.aceleradev.api.service.factory.UserFactory;

@Service
public class UserFactoryImpl implements UserFactory {
	
	private PasswordEncrypter passwordEncrypter;

	public UserFactoryImpl(PasswordEncrypter passwordEncrypter) {
		this.passwordEncrypter = passwordEncrypter;
	}

	@Override
	public User createUser(UserCreationFormDto dto) throws NoSuchAlgorithmException {
		logger.info("converting UserCreationFormDto to User");
		String passwordEncrypted = this.passwordEncrypter.encrypt(dto.getPassword());
		Credential credential = new Credential(passwordEncrypted, dto.getEmail());
		User user = new User(dto.getName(), credential);
		return user;
	}
	
	private static final Logger logger = LogManager.getLogger(UserFactoryImpl.class);
}
