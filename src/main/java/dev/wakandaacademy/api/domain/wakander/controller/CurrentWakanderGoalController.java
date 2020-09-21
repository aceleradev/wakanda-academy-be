package dev.wakandaacademy.api.domain.wakander.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.service.goals.WakanderGoalService;
import dev.wakandaacademy.api.exception.BusinessException;


@RestController
public class CurrentWakanderGoalController implements CurrentWakanderGoalApi {
	
	private static final Logger log = LoggerFactory.getLogger(CurrentWakanderGoalController.class);

	private WakanderGoalService wakanderGoalService;

	public CurrentWakanderGoalController(WakanderGoalService wakanderGoalService) throws BusinessException{
		this.wakanderGoalService = wakanderGoalService;
	}

	@Override
	public CurrentWakanderGoalDTO getCurrentGoal(String wakanderCode) throws BusinessException   {
		log.info(wakanderCode);
	  WakanderGoal wakanderGoal = wakanderGoalService.getCurrentGoal(wakanderCode);
	  return new CurrentWakanderGoalDTO(wakanderGoal.getVelocidadeXp());
		
		
	
	}

}
