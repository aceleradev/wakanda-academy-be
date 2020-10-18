package dev.wakandaacademy.api.domain.wakander.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;


import dev.wakandaacademy.api.domain.wakander.controller.dto.TribeGoalDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;

import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.service.goals.CurrentWakanderGoalService;

import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class WakanderGoalController implements WakanderGoalApi {

	private static final Logger log = LoggerFactory.getLogger(WakanderGoalController.class);

	private CurrentWakanderGoalService wakanderGoalService;

	public WakanderGoalController(CurrentWakanderGoalService wakanderGoalService) {
		this.wakanderGoalService = wakanderGoalService;
	}

	@Override
	public WakanderGoalDTO getOpenGoal(String wakanderCode) throws BusinessException {
		WakanderGoal wakanderGoal = wakanderGoalService.getGoal(wakanderCode);
		return new WakanderGoalDTO(wakanderGoal.getWeeklyGoalStudyHours(), 
				new TribeGoalDTO(wakanderGoal.getTribe().getCode(), wakanderGoal.getTribe().getName()));

	}
	

	@Override
	public WakanderGoalDTO updateOpenGoal(String wakanderCode, WakanderGoalDTO dto) throws BusinessException {
		log.info("request: wakanderCode {} WakanderGoalDTO {}",wakanderCode,dto);
		wakanderGoalService.createOrUpdateGoal(wakanderCode,dto);
		return dto;
	}
}
