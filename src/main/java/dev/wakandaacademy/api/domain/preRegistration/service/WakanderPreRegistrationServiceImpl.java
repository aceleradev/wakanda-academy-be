package dev.wakandaacademy.api.domain.preRegistration.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.preRegistration.dto.WakanderPreRegistrationDetailDTO;
import dev.wakandaacademy.api.domain.preRegistration.model.WakanderPreRegistration;
import dev.wakandaacademy.api.domain.preRegistration.repository.WakanderPreRegistrationRepository;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class WakanderPreRegistrationServiceImpl implements WakanderPreRegistrationService {
	private static final Logger logger = LogManager.getLogger(WakanderPreRegistrationServiceImpl.class);
	
	WakanderPreRegistrationRepository repository;

	public WakanderPreRegistrationServiceImpl(WakanderPreRegistrationRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(WakanderPreRegistrationDetailDTO dto) throws BusinessException {
		logger.info("initiated method created in WakanderPreRegistrationServiceImpl to crate user: {}", dto.toString());
		logger.info("converting DTO to Entity");
		WakanderPreRegistration entity = dto.convertToEntity();
		try {
			logger.info("saving Entity WakanderPreRegistration");
			this.repository.save(entity);
			logger.info("Entity {} saved", entity.toString());
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			String messageErro = String.format("Já existe um Pré cadastro com o email: [%s] em andamento", entity.getEmail());
			logger.error(messageErro);
			throw new BusinessException(messageErro);
		}
		
	}

}
