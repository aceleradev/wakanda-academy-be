package dev.wakandaacademy.api.domain.preRegistration.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.preRegistration.dto.WakanderPreRegistrationDetailDTO;
import dev.wakandaacademy.api.domain.preRegistration.dto.form.WakanderPreReistrationForm;
import dev.wakandaacademy.api.exception.ApiException;

@RestController
@RequestMapping("/public/wakander/pre-registrattion")
public interface WakanderPreRegistrattionApi {
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	WakanderPreRegistrationDetailDTO create(@RequestBody @Valid WakanderPreReistrationForm form) throws ApiException;
}
