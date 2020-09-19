package dev.wakandaacademy.api.domain.wakander.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.service.goals.CurrentWakanderGoalService;


@RestController
public class CurrentWakanderGoalController implements CurrentWakanderGoalApi {
	
	private static final Logger log = LoggerFactory.getLogger(CurrentWakanderGoalController.class);

	private CurrentWakanderGoalService currentWakanderGoalService;

	public CurrentWakanderGoalController(CurrentWakanderGoalService wakanderGoalService) {
		this.currentWakanderGoalService = wakanderGoalService;
	}

	@Override
	public CurrentWakanderGoalDTO getCurrentGoal(@PathVariable String wakanderCode)  {
		

		WakanderGoal wakanderGoal = currentWakanderGoalService.getGoalCurrent(wakanderCode);
		return new CurrentWakanderGoalDTO(wakanderGoal.getExpirationDateXp());
		
		
	
	}

}
