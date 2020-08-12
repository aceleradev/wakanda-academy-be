package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribesCompletedVSJourneyTribes;
import dev.wakandaacademy.api.exception.ApiException;
import io.swagger.annotations.Api;

@Api(value = "wakander-performace")
@RequestMapping(value = "/wakander/performace")
public interface WakanderPerformanceApi {
	@RequestMapping(value = "/tribes-completed-vs-journey-tribes", method = RequestMethod.GET)
	TribesCompletedVSJourneyTribes getTotalTribesCompletedVSTotalTribesJourney(String WakanderCode)
			throws ApiException;
}
