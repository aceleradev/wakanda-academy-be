package dev.wakandaacademy.api.domain.wakander.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribeGoalDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.service.goals.WakanderGoalService;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class WakanderGoalController implements WakanderGoalApi {
	
	private static final Logger log = LoggerFactory.getLogger(WakanderGoalController.class);
	
	private WakanderGoalService wakanderGoalService;

	public WakanderGoalController(WakanderGoalService wakanderGoalService) {
		this.wakanderGoalService = wakanderGoalService;
	}
	
	@Override
	public WakanderGoalDTO getOpenGoal(String WakanderCode) throws ApiException {
		// TODO not implmented - Mocked
		return new WakanderGoalDTO(20, new TribeGoalDTO("TRIBE-MOCK", "Tribo mockada"));
	}

	@Override
	public WakanderGoalDTO updateOpenGoal(String wakanderCode, WakanderGoalDTO dto) throws BusinessException {
		log.info("start WakanderGoalController");
		log.info("request: wakanderCode {} WakanderGoalDTO {}",wakanderCode,dto);
		log.info(wakanderCode);
		wakanderGoalService.createOrUpdateGoal(dto);
		return dto;
	}
}
