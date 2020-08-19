package dev.wakandaacademy.api.domain.wakander.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribeGoalDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.service.goal.WakanderGoalService;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class WakanderGoalController implements WakanderGoalApi {
	
	private WakanderGoalService wkGoalService;

	public WakanderGoalController(WakanderGoalService wakanderGoalService) {
		this.wkGoalService = wakanderGoalService;
	}
	
	private static final Logger log = LoggerFactory.getLogger(WakanderGoalController.class);
			
	@Override
	public WakanderGoalDTO getOpenGoal(String WakanderCode) throws ApiException {
		log.info("Start getOpenGoal in WakanderGoalController");
		log.info("finding wakanderGoal by wakanderCode: {}",WakanderCode);
		WakanderGoalDTO wkGoal=null;
		try {
			Optional<WakanderGoalDTO> result = this.wkGoalService.getOpenGoal(WakanderCode);
			wkGoal = result.orElse(null);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("returning wakanderGoal: {}",wkGoal);
		return wkGoal;
	}

	@Override
	public WakanderGoalDTO updateOpenGoal(String wakanderCode, WakanderGoalDTO wakanderGoalDTO) throws ApiException {
		// TODO not implmented - Mocked
		return wakanderGoalDTO;
	}
}
