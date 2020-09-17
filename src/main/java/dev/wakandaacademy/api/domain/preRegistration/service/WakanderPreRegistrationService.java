package dev.wakandaacademy.api.domain.preRegistration.service;

import dev.wakandaacademy.api.domain.preRegistration.dto.WakanderPreRegistrationDetailDTO;
import dev.wakandaacademy.api.exception.BusinessException;

public interface WakanderPreRegistrationService {

	void create(WakanderPreRegistrationDetailDTO dto) throws BusinessException;

}
