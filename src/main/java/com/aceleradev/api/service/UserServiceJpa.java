package com.aceleradev.api.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.UserCreationFormDto;
import com.aceleradev.api.domain.model.User;
import com.aceleradev.api.repository.UserRepository;
import com.aceleradev.api.service.contract.UserService;
import com.aceleradev.api.service.factory.UserFactory;

import at.favre.lib.crypto.bkdf.PasswordHasher;

@Service
public class UserServiceJpa implements UserService {

    private UserRepository repository;
    private PasswordHasher hasher;
	private UserFactory factory;

    public UserServiceJpa(UserRepository repository, UserFactory factory) {
        this.repository = repository;
		this.factory = factory;
        this.hasher = null;
    }
    //FIXME: retirar log
    @Override
    public User create(UserCreationFormDto dto, Logger logger) {
        logger.info("encrypting password");
        //encodePassword(dto);
        logger.info("converting UserCreationFormDto to User");
        User user=dto.generateUser();//FIXME: passar hasher para dto
        logger.info("saving User on database");
        repository.save(user);
        return user;
    }

    private void encodePassword(UserCreationFormDto dto){
        dto.setPassword(hasher.hash(dto.getPassword().toCharArray(),10));
    }

}
