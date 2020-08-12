package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.exception.ApiException;
import io.swagger.annotations.Api;

@Api(value = "wakander-goal")
@RequestMapping(value = "/wakander/{wakanderCode}/goal")
public interface WakanderGoalApi {
	@GetMapping
	WakanderGoalDTO getOpenGoal(@PathVariable String wakanderCode) throws ApiException;

	@PutMapping
	WakanderGoalDTO updateOpenGoal(@PathVariable String wakanderCode, @RequestBody WakanderGoalDTO wakanderGoalDTO)
			throws ApiException;
}
