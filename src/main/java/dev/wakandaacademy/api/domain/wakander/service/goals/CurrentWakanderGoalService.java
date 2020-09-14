package dev.wakandaacademy.api.domain.wakander.service.goals;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.exception.BusinessException;

public interface CurrentWakanderGoalService {
	
	   void createOrUpdateGoal(String wakanderCode, WakanderGoalDTO dto) throws BusinessException;

	     WakanderGoal getGoal(String wakanderCode) throws BusinessException;

		WakanderGoal currentGoal(String wakanderCode)throws BusinessException;
	   
}
