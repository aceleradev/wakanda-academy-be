package dev.wakandaacademy.api.domain.wakander.service.goal;

import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.exception.BusinessException;

public interface WakanderGoalService {
	
	Optional<WakanderGoalDTO> getOpenGoal(String wakanderCode) throws BusinessException;
	
	void update(String wakanderCode, WakanderGoalDTO wakanderGoalDTO) throws BusinessException;

}
