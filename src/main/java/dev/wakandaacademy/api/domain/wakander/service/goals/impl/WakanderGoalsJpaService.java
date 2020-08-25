package dev.wakandaacademy.api.domain.wakander.service.goals.impl;

import java.time.LocalDateTime;

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
	public void createOrUpdateGoal(WakanderGoalDTO dto) {
		WakanderGoal wakanderGoal = new WakanderGoal();
		
		String tribeCode = wakanderGoal.getWakander().getCode();
	
		String wakanderCode = wakanderGoal.getTribe().getCode();
		
		Integer weeklyGoalStudyHours = 1;
		WakanderGoal goals = null;
		
		WakanderTribeInfo wakanderTribe = null;
		
		Tribe tribe = null;
		
		
		try {
			wakanderTribe = this.tribeRepository
												.findWakanderByCodeAndTribeByCode(wakanderCode, tribeCode)
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

			Wakander wakanderT = wakanderTribe.getWakander();
			goals = new WakanderGoal(wakanderT, tribe, weeklyGoalStudyHours, LocalDateTime.now());
		} finally {
			this.wakanderGoalRepository.save(goals);
		}
	}


}
