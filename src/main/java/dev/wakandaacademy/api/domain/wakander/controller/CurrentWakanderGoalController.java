package dev.wakandaacademy.api.domain.wakander.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.TribeGoalDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.service.goals.CurrentWakanderGoalService;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class CurrentWakanderGoalController implements CurrentWakanderGoalApi {
	
	private static final Logger log = LoggerFactory.getLogger(CurrentWakanderGoalController.class);

	private CurrentWakanderGoalService currentWakanderGoalService;

	public CurrentWakanderGoalController(CurrentWakanderGoalService wakanderGoalService) {
		this.currentWakanderGoalService = wakanderGoalService;
	}

	@Override
	public CurrentWakanderGoalDTO getCurrentGoal(String wakanderCode) throws ApiException, BusinessException {
		
		WakanderGoal wakanderGoal = currentWakanderGoalService.currentGoal(wakanderCode);
		return new CurrentWakanderGoalDTO();
		 
		return null;
	}

}
