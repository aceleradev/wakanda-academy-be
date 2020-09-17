package dev.wakandaacademy.api.domain.preRegistration.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.preRegistration.dto.WakanderPreRegistrationDetailDTO;
import dev.wakandaacademy.api.domain.preRegistration.model.WakanderPreRegistration;
import dev.wakandaacademy.api.domain.preRegistration.repository.WakanderPreRegistrationRepository;

@Service
public class WakanderPreRegistrationServiceImpl implements WakanderPreRegistrationService {
	private static final Logger logger = LogManager.getLogger(WakanderPreRegistrationServiceImpl.class);
	
	WakanderPreRegistrationRepository repository;

	public WakanderPreRegistrationServiceImpl(WakanderPreRegistrationRepository repository) {
		this.repository = repository;
	}

	@Override
	public void create(WakanderPreRegistrationDetailDTO dto) {
		logger.info("initiated method created in WakanderPreRegistrationServiceImpl to crate user: {}", dto.toString());
		logger.info("converting DTO to Entity");
		WakanderPreRegistration entity = dto.convert();
		try {
			logger.info("saving Entity WakanderPreRegistration");
			this.repository.save(entity);
		} catch (Exception e) {
			logger.warn("Entity WakanderPreRegistration not saved due to: {}", e.toString());
			throw e;
		}
		
	}

}
