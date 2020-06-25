package com.aceleradev.api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.UserCreationFormDto;
import com.aceleradev.api.domain.model.User;
import com.aceleradev.api.exception.EntityExistsException;
import com.aceleradev.api.repository.UserRepository;
import com.aceleradev.api.service.contract.UserService;
import com.aceleradev.api.service.factory.UserFactory;

@Service
public class UserServiceJpa implements UserService {

    private UserRepository repository;
	private UserFactory factory;

    public UserServiceJpa(UserRepository repository, UserFactory factory) {
        this.repository = repository;
		this.factory = factory;
    }

    @Override
    public User create(UserCreationFormDto dto) throws Exception {
        User user = this.factory.createUser(dto);
        this.createUser(dto, user);
        return user;
    }

	private void createUser(UserCreationFormDto dto, User user) throws EntityExistsException {
		try {
			logger.info("saving User on database");
        	this.repository.save(user);
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			throw new EntityExistsException(String.format("Usuario[email=%s] já cadastrado", dto.getEmail()));
		}
	}
    
    private static final Logger logger = LogManager.getLogger(UserServiceJpa.class); 
}
