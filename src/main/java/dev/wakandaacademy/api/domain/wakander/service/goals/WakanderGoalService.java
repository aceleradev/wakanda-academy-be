package dev.wakandaacademy.api.domain.wakander.service.goals;

import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.exception.BusinessException;

public interface WakanderGoalService {
	
	


	WakanderGoal getCurrentGoal(String wakanderCode)throws BusinessException;

}
