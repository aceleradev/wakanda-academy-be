package dev.wakandaacademy.api.domain.wakander.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderDTO;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;
import io.swagger.annotations.Api;

@Api(value = "current-goal")
@RequestMapping(value = "/wakander/{wakanderCode}/current")
public interface CurrentWakanderGoalApi {
	
	static final Logger log = LoggerFactory.getLogger(CurrentWakanderGoalApi.class);
	

	
	@GetMapping
    CurrentWakanderDTO getCurrent (@PathVariable("wakanderCode") String wakanderCode) 
	throws ApiException, BusinessException;

}


