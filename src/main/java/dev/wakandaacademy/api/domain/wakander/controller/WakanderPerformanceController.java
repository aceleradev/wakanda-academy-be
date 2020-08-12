package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribesCompletedVSJourneyTribes;
import dev.wakandaacademy.api.exception.ApiException;

@RestController
public class WakanderPerformanceController implements WakanderPerformanceApi {
	public TribesCompletedVSJourneyTribes getTotalTribesCompletedVSTotalTribesJourney(String WakanderCode)
			throws ApiException {
		// TODO not implmented - Mocked
		return new TribesCompletedVSJourneyTribes(1, 7);
	}
}
