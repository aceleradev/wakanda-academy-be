package dev.wakandaacademy.api.domain.wakander.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;
import io.swagger.annotations.Api;

@Api(value = "wakander-goal")
@RequestMapping(value = "/wakander/{wakanderCode}/goal")
public interface WakanderGoalApi {
	
	static final Logger log = LoggerFactory.getLogger(WakanderGoalApi.class);
	

	
	@GetMapping
	WakanderGoalDTO getOpenGoal(@PathVariable("wakanderCode") String wakanderCode) 
			throws ApiException, BusinessException;
	
	


	@PutMapping
	WakanderGoalDTO updateOpenGoal(@PathVariable("wakanderCode") String wakanderCode, @RequestBody WakanderGoalDTO wakanderGoalDTO)
			throws ApiException, BusinessException;
}