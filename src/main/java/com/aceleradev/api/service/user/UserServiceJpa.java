package com.aceleradev.api.service.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.UserCreationFormDto;
import com.aceleradev.api.domain.model.User;
import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.exception.EntityExistsException;
import com.aceleradev.api.repository.JourneyRepository;
import com.aceleradev.api.repository.UserRepository;
import com.aceleradev.api.service.user.encrypt.PasswordEncrypter;
import com.aceleradev.api.service.wakander.tribes.WakanderTribeService;

@Service
public class UserServiceJpa implements UserService {
	private static final Logger logger = LogManager.getLogger(UserServiceJpa.class);
	private UserRepository userRepository;
	private PasswordEncrypter passwordEncrypter;
	private JourneyRepository journeyRepository;
	private WakanderTribeService wakanderTribeService;

	public UserServiceJpa(UserRepository userRepository, PasswordEncrypter passwordEncrypter,
			JourneyRepository journeyRepository, WakanderTribeService wakanderTribeService) {
		this.userRepository = userRepository;
		this.passwordEncrypter = passwordEncrypter;
		this.journeyRepository = journeyRepository;
		this.wakanderTribeService = wakanderTribeService;
	}

	@Override
	public User create(UserCreationFormDto userDTO) throws Exception {
		logger.info("Starting UserService Create to User: {}",userDTO);
		logger.info("Converting DTO to User");
		Wakander wakanderUser = userDTO.converter(passwordEncrypter);
		saveUser(wakanderUser);
		logger.info("Seting Tribes of Standard Journey!");
		wakanderUser.setTribes(journeyRepository, wakanderTribeService);
		return wakanderUser;
	}

	private void saveUser(User user) throws EntityExistsException {
		try {
			logger.info("saving User {} on database", user.toString());
			this.userRepository.save(user);
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			String messageErro = String.format("Usuario[email=%s] já cadastrado", user.getEmail());
			logger.error(messageErro);
			throw new EntityExistsException(messageErro);
		}
	}
}
