package dev.wakandaacademy.api.domain.wakander.service.goals.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.repository.CurrentWakanderGoalRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderRepository;
import dev.wakandaacademy.api.domain.wakander.service.goals.CurrentWakanderGoalService;
import dev.wakandaacademy.api.exception.BusinessException;

public class CurrentWakanderGoalJpaService implements CurrentWakanderGoalService {
	
	
	private static final Logger log = LoggerFactory.getLogger(WakanderGoalsJpaService.class);
	private CurrentWakanderGoalRepository currentWakanderGoalRepository;
	private WakanderRepository wakanderRepository;
	
	
	public CurrentWakanderGoalJpaService(CurrentWakanderGoalRepository currentWakanderGoalRepository,
			WakanderRepository wakanderRepository) {
		this.currentWakanderGoalRepository = currentWakanderGoalRepository;
		this.wakanderRepository = wakanderRepository;
	}

	@Override
	public WakanderGoal getGoalCurrent(String wakanderCode) throws BusinessException {

		log.info("Chegou: {}",wakanderCode);
		WakanderGoal goals = null;
		Wakander wakander = wakanderRepository.findByCode(wakanderCode)
				.orElseThrow(() -> new BusinessException(" wakander não existe"));;
				log.info("wakander: {}",wakander);	
				
				goals = this.currentWakanderGoalRepository
						.findByWakanderXp(wakanderCode)
						.orElseThrow(() -> new BusinessException(" wakander não possui xp"));
						return goals;
	}

	@Override
	public void createOrUpdateGoal(String wakanderCode, WakanderGoalDTO dto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WakanderGoal getGoal(String wakanderCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
