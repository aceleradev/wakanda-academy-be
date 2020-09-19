package dev.wakandaacademy.api.domain.wakander.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.wakandaacademy.api.domain.wakander.controller.dto.CurrentWakanderGoalDTO;

import io.swagger.annotations.Api;

@Api(value = "current-wakander-goal")
@RequestMapping(value = "/wakander/{wakanderCode}/currentGoal")
public interface CurrentWakanderGoalApi {

	
	@GetMapping
	CurrentWakanderGoalDTO getCurrentGoal(@PathVariable("wakanderCode") String wakanderCode) ;
	
}
