package dev.wakandaacademy.api.domain.wakander.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.GoalPerformance;
import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyPerformance;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderWeeklyPerfomanceDTO;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderPerformaceService;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

@RestController
public class WakanderPerformanceController implements WakanderPerformanceApi {
	private static final Logger log = LoggerFactory.getLogger(WakanderPerformanceController.class);
	private WakanderPerformaceService wakanderPerformaceService;

	public WakanderPerformanceController(WakanderPerformaceService wakanderPerformanceJpaService) {

		this.wakanderPerformaceService = wakanderPerformanceJpaService;
	}

	public ResponseEntity<JourneyPerformance> getJourneyPerformance(String wakanderCode)
			throws ApiException {
		log.info("Start controller");
		log.info("Parameters WakanderCode = {}", wakanderCode);
		log.info("Start getJourneyPerformance");
		JourneyPerformance totalTribesCompletedVSTotalTribesJourney = wakanderPerformaceService
																			.getJourneyPerformance(wakanderCode);
		return ResponseEntity.ok(totalTribesCompletedVSTotalTribesJourney);

	}

	@Override
	public ResponseEntity<WakanderWeeklyPerfomanceDTO> getWakanderWeeklyPerformance(String wakanderCode) throws BusinessException {
		WakanderWeeklyPerfomanceDTO dto = this.wakanderPerformaceService.getWakanderWeeklyPerformance(wakanderCode);
		log.info("Start getWakanderWeeklyPerformance");
		
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<GoalPerformance> getWakanderGoalPerformance(String wakanderCode)
			throws BusinessException {
		log.info("Start controller");
		
		GoalPerformance goalPerformance = wakanderPerformaceService.getGoalPerformance(wakanderCode);
		log.info("Start getWakanderGoalPerformance");
		return ResponseEntity.ok(goalPerformance);
	}
	
}
