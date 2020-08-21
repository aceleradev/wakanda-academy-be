package dev.wakandaacademy.api.domain.wakander.service.goals.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.journey.domain.Tribe;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeInfo;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderGoalRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeRepository;
import dev.wakandaacademy.api.domain.wakander.service.goals.WakanderGoalService;
import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.NotFoundException;

@Service
public class WakanderGoalsJpaService implements WakanderGoalService {
	
	private WakanderGoalRepository wakanderGoalRepository;
	private WakanderTribeRepository tribeRepository;

	public void WakanderGoalServiceJpa(WakanderGoalRepository wakanderGoalRepository, WakanderTribeRepository tribeRepository) {
		this.wakanderGoalRepository = wakanderGoalRepository;
		this.tribeRepository = tribeRepository;
	}

	@Override
	public void createOrUpdateGoal(WakanderGoalDTO Dto) {
		String WakanderGoalDTO = "adasd";
		String tribeCode = "tribe";
		String wakanderCode = "wakander";
		
		Integer weeklyGoalStudyHours = 1;
		WakanderGoal goals = null;
		
		WakanderTribeInfo wakanderTribe = null;
		
		Tribe tribe = null;
		
		
		try {
			wakanderTribe = this.tribeRepository
												.findWakanderByCodeAndTribeByCode(WakanderGoalDTO, tribeCode)
												.orElseThrow(() -> new BusinessException("A tribo do wakander não existe"));
			 tribe = wakanderTribe.getTribe();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			 goals = this.wakanderGoalRepository
						.findByWakanderCode(wakanderCode)
						.orElseThrow(() -> new NotFoundException());
			goals.setTribe(tribe);
			goals.setWeeklyGoalStudyHours(weeklyGoalStudyHours);
			
			
		} catch (NotFoundException e) {

			Wakander wakander = wakanderTribe.getWakander();
			goals = new WakanderGoal(wakander, tribe, weeklyGoalStudyHours, LocalDateTime.now());
		} finally {
			this.wakanderGoalRepository.save(goals);
		}
	}


}
