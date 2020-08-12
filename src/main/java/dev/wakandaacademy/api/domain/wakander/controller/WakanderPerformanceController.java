package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribesCompletedVSJourneyTribesDTO;
import dev.wakandaacademy.api.exception.ApiException;

@RestController
public class WakanderPerformanceController implements WakanderPerformanceApi {
	public TribesCompletedVSJourneyTribesDTO getTotalTribesCompletedVSTotalTribesJourney(String WakanderCode)
			throws ApiException {
		// TODO not implmented - Mocked
		return new TribesCompletedVSJourneyTribesDTO(1, 7);
	}
}
