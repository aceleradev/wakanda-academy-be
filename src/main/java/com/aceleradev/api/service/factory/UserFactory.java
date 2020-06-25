package com.aceleradev.api.service.factory;

import java.security.NoSuchAlgorithmException;

import com.aceleradev.api.controller.dto.UserCreationFormDto;
import com.aceleradev.api.domain.model.User;

public interface UserFactory {
	
	User createUser(UserCreationFormDto dto) throws NoSuchAlgorithmException;
	
}
