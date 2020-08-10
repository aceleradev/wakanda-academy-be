package dev.wakandaacademy.api.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.exception.EntityExistsException;
import dev.wakandaacademy.api.repository.JourneyRepository;
import dev.wakandaacademy.api.service.wakander.tribes.WakanderTribeService;
import dev.wakandaacademy.api.user.controller.dto.UserCreationFormDto;
import dev.wakandaacademy.api.user.model.User;
import dev.wakandaacademy.api.user.repository.UserRepository;
import dev.wakandaacademy.api.user.service.encrypt.PasswordEncrypter;
import dev.wakandaacademy.api.wakander.model.Wakander;

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
