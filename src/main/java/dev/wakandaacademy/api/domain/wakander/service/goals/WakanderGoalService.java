package dev.wakandaacademy.api.domain.wakander.service.goals;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.exception.BusinessException;

public interface WakanderGoalService {
	
	   void createOrUpdateGoal(WakanderGoalDTO dto) throws BusinessException; ;
	   
}
