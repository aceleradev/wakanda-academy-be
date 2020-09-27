package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.wakandaacademy.api.domain.wakander.controller.dto.JourneyScore;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderWeeklyPerformanceDTO;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;
import io.swagger.annotations.Api;

@Api(value = "wakander-performace")
@RequestMapping(value = "/wakander/{wakanderCode}/performace")
public interface WakanderPerformanceApi {
	
	@RequestMapping(value = "/tribes-completed-vs-journey-tribes", method = RequestMethod.GET)
	ResponseEntity<JourneyScore> getTotalTribesCompletedVSTotalTribesJourney(@PathVariable String wakanderCode)
			throws ApiException;
	
	@GetMapping
	ResponseEntity<WakanderWeeklyPerformanceDTO> getWakanderWeeklyPerformance(@PathVariable("wakanderCode") String wakanderCode) throws BusinessException;
	
}
