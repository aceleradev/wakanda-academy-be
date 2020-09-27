package dev.wakandaacademy.api.domain.wakander.service.goals.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.repository.CurrentWakanderGoalRepository;
import dev.wakandaacademy.api.domain.wakander.service.goals.WakanderGoalService;
import dev.wakandaacademy.api.exception.BusinessException;

//@Service
public class CurrentWakanderGoalJpaService implements WakanderGoalService {
	
	
	private static final Logger log = LoggerFactory.getLogger(WakanderGoalsJpaService.class);
	private CurrentWakanderGoalRepository currentWakanderGoalRepository;
	
	public CurrentWakanderGoalJpaService(CurrentWakanderGoalRepository currentWakanderGoalRepository) {

		this.currentWakanderGoalRepository = currentWakanderGoalRepository;
	}

	@Override
	public WakanderGoal getCurrentGoal(String wakanderCode) throws BusinessException {
		//TODO
		return null;
	}
	
	
	
	
	




}
