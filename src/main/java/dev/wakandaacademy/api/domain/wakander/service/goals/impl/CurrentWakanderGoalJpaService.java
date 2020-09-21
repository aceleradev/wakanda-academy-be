package dev.wakandaacademy.api.domain.wakander.service.goals.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.repository.CurrentWakanderGoalRepository;
import dev.wakandaacademy.api.domain.wakander.service.goals.WakanderGoalService;
import dev.wakandaacademy.api.exception.BusinessException;

public class CurrentWakanderGoalJpaService implements WakanderGoalService {
	
	
	private static final Logger log = LoggerFactory.getLogger(WakanderGoalsJpaService.class);
	private CurrentWakanderGoalRepository currentWakanderGoalRepository;
	
	public CurrentWakanderGoalJpaService(CurrentWakanderGoalRepository currentWakanderGoalRepository) {

		this.currentWakanderGoalRepository = currentWakanderGoalRepository;
	}

	@Override
	public WakanderGoal getCurrentGoal(String wakanderCode) throws BusinessException {
		
		WakanderGoal wakanderGoal =  null;
		try {
			wakanderGoal = currentWakanderGoalRepository.findByWakanderXp(wakanderCode)
					.orElseThrow(() -> new BusinessException(" wakander não possui xp"));
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wakanderGoal;
	}
	
	
	
	
	




}
