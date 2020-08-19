package dev.wakandaacademy.api.domain.wakander.service.goal.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.controller.dto.TribeGoalDTO;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.service.goal.WakanderGoalService;
import dev.wakandaacademy.api.exception.BusinessException;

@Service
public class WakanderGoalServiceImpl implements WakanderGoalService {

	@Override
	public Optional<WakanderGoalDTO> getOpenGoal(String wakanderCode) throws BusinessException {
		return Optional.of(new WakanderGoalDTO(20, new TribeGoalDTO("TRIBE-MOCK", "Tribo mockada")));
	}

	@Override
	public void update(String wakanderCode, WakanderGoalDTO wakanderGoalDTO) throws BusinessException {
		// TODO Auto-generated method stub

	}

}
