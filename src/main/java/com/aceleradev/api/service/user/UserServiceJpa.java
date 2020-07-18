package com.aceleradev.api.service.user;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.aceleradev.api.controller.dto.UserCreationFormDto;
import com.aceleradev.api.domain.model.User;
import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.domain.model.WakanderTribe;
import com.aceleradev.api.exception.EntityExistsException;
import com.aceleradev.api.repository.JourneyRepository;
import com.aceleradev.api.repository.WakanderTribeRepository;
import com.aceleradev.api.repository.UserRepository;
import com.aceleradev.api.service.user.encrypt.PasswordEncrypter;

@Service
public class UserServiceJpa implements UserService {
	private static final Logger logger = LogManager.getLogger(UserServiceJpa.class);
	private UserRepository userRepository;
	private PasswordEncrypter passwordEncrypter;
	private JourneyRepository journeyRepository;
	private WakanderTribeRepository wakanderTribeRepository;

	public UserServiceJpa(UserRepository userRepository, PasswordEncrypter passwordEncrypter,
			JourneyRepository journeyRepository, WakanderTribeRepository journeyTribeRepository) {
		this.userRepository = userRepository;
		this.passwordEncrypter = passwordEncrypter;
		this.journeyRepository = journeyRepository;
		this.wakanderTribeRepository = journeyTribeRepository;
	}

	@Override
	public User create(UserCreationFormDto dto) throws Exception {
		Wakander wakanderUser = dto.converter(passwordEncrypter);
		saveUser(wakanderUser);
		wakanderUser.setTribes(journeyRepository);
		
		List<WakanderTribe> tribes = wakanderUser.getTribes();
		for (WakanderTribe wakanderTribe : tribes) {
			wakanderTribeRepository.save(wakanderTribe);
		}
		return wakanderUser;
	}

	private void saveUser(User user) throws EntityExistsException {
		try {
			logger.info("saving User on database");
			this.userRepository.save(user);
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			throw new EntityExistsException(String.format("Usuario[email=%s] já cadastrado", user.getEmail()));
		}
	}
}
