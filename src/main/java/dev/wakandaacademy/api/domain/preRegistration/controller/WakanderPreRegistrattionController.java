package dev.wakandaacademy.api.domain.preRegistration.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.preRegistration.dto.WakanderPreRegistrationDetailDTO;
import dev.wakandaacademy.api.domain.preRegistration.dto.form.WakanderPreReistrationForm;
import dev.wakandaacademy.api.exception.ApiException;

@RestController
public class WakanderPreRegistrattionController implements WakanderPreRegistrattionApi {
	private static final Logger log = LoggerFactory.getLogger(WakanderPreRegistrattionController.class);

	@Override
	public WakanderPreRegistrationDetailDTO create(@Valid WakanderPreReistrationForm form) throws ApiException {
		log.info("Start Method create in WakanderPreRegistrattionController");
		log.info("Paramaters: {}", form);
		return new WakanderPreRegistrationDetailDTO(form.getFullName(), form.getCellPhoneNumber(), form.getEmail());
	}
}
