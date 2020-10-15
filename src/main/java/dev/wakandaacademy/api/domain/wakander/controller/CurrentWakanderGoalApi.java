package dev.wakandaacademy.api.domain.wakander.controller;






import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderGoalDTO;
import dev.wakandaacademy.api.exception.BusinessException;
import io.swagger.annotations.Api;

@Api(value = "current-wakander-goal")
@RequestMapping(value = "/wakander/{wakanderCode}/currentGoal")
public interface CurrentWakanderGoalApi {

	
	@GetMapping
	CurrentWakanderGoalDTO getCurrentGoal(String wakanderCode) throws BusinessException;
	
}
