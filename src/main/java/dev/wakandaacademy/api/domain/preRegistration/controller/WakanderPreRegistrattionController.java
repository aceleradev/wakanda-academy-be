package dev.wakandaacademy.api.domain.preRegistration.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.preRegistration.dto.WakanderPreRegistrationDetailDTO;
import dev.wakandaacademy.api.domain.preRegistration.dto.form.WakanderPreReistrationForm;
import dev.wakandaacademy.api.domain.preRegistration.service.WakanderPreRegistrationService;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class WakanderPreRegistrattionController implements WakanderPreRegistrattionApi {
	private static final Logger log = LoggerFactory.getLogger(WakanderPreRegistrattionController.class);
	
	WakanderPreRegistrationService wakanderPreRegistrationService;
	
	public WakanderPreRegistrattionController (WakanderPreRegistrationService wakanderPreRegistrationService) {
		this.wakanderPreRegistrationService = wakanderPreRegistrationService;
	}

	@Override
	public WakanderPreRegistrationDetailDTO create(@Valid WakanderPreReistrationForm form) throws ApiException, BusinessException {
		log.info("Start Method create in WakanderPreRegistrattionController");
		log.info("Paramaters: {}", form);
		WakanderPreRegistrationDetailDTO dto = form.convertToDTO();
		log.info("Creating WakanderPreRegistrattion");
		wakanderPreRegistrationService.create(dto);
		return dto;
	}
}
