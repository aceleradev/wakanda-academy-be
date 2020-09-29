package dev.wakandaacademy.api.domain.wakander.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyScore;
import dev.wakandaacademy.api.domain.wakander.service.performace.WakanderPerformaceService;
import dev.wakandaacademy.api.exception.ApiException;

@RestController
public class WakanderPerformanceController implements WakanderPerformanceApi {
	private static final Logger log = LoggerFactory.getLogger(WakanderPerformanceController.class);
	private WakanderPerformaceService wakanderPerformaceService;

	public WakanderPerformanceController(WakanderPerformaceService wakanderPerformanceJpaService) {

		this.wakanderPerformaceService = wakanderPerformanceJpaService;
	}

	public ResponseEntity<JourneyScore> getTotalTribesCompletedVSTotalTribesJourney(String wakanderCode)
			throws ApiException {
		log.info("Start controller");
		log.info("Parameters WakanderCode = {}", wakanderCode);
		JourneyScore totalTribesCompletedVSTotalTribesJourney = wakanderPerformaceService
				                                                            .findTotalTribesCompletedVSTotalTribesJourney(wakanderCode);
		return ResponseEntity.ok(totalTribesCompletedVSTotalTribesJourney);
	}

}
