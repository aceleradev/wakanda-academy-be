package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribesCompletedVSJourneyTribesDTO;
import dev.wakandaacademy.api.exception.ApiException;
import io.swagger.annotations.Api;

@Api(value = "wakander-performace")
@RequestMapping(value = "/wakander/{wakanderCode}/performace")
public interface WakanderPerformanceApi {
	@RequestMapping(value = "/tribes-completed-vs-journey-tribes", method = RequestMethod.GET)
	TribesCompletedVSJourneyTribesDTO getTotalTribesCompletedVSTotalTribesJourney(@PathVariable String WakanderCode)
			throws ApiException;
}
