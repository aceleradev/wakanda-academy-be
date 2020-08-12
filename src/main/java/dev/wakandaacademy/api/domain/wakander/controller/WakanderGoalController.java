package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribeGoalDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.exception.ApiException;

@RestController
public class WakanderGoalController implements WakanderGoalApi {
	@Override
	public WakanderGoalDTO getOpenGoal(String WakanderCode) throws ApiException {
		// TODO not implmented - Mocked
		return new WakanderGoalDTO(20, new TribeGoalDTO("TRIBE-MOCK", "Tribo mockada"));
	}

	@Override
	public WakanderGoalDTO updateOpenGoal(String wakanderCode, WakanderGoalDTO wakanderGoalDTO) throws ApiException {
		// TODO not implmented - Mocked
		return wakanderGoalDTO;
	}
}
