package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderGoalDTO;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class CurrentWakanderGoalController implements CurrentWakanderGoalApi {

	@Override
	public CurrentWakanderGoalDTO getCurrentGoal(String wakanderCode) throws ApiException, BusinessException {
		
		return null;
	}

}
