package dev.wakandaacademy.api.domain.wakander.service.goals.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.journey.domain.Tribe;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.repository.TribeRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderGoalRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderRepository;
import dev.wakandaacademy.api.domain.wakander.service.goals.WakanderGoalService;
import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.NotFoundException;

@Service
public class WakanderGoalsJpaService implements WakanderGoalService {
	private static final Logger log = LoggerFactory.getLogger(WakanderGoalsJpaService.class);
	private WakanderGoalRepository wakanderGoalRepository;
	private TribeRepository tribeRepository;
	private WakanderRepository wakanderRepository;




	public  WakanderGoalsJpaService (WakanderGoalRepository wakanderGoalRepository,TribeRepository tribeRepository,WakanderRepository wakanderRepository ) {
		this.wakanderGoalRepository = wakanderGoalRepository;
		this.tribeRepository = tribeRepository;
		this.wakanderRepository =wakanderRepository;
	}

	@Override
	public void createOrUpdateGoal(String wakanderCode,WakanderGoalDTO goalDto) throws BusinessException {
		log.info("goalDto: {}",goalDto);
		String tribeCode = goalDto.getNextTribeGoal().getTribeCode();
		Integer weeklyGoalStudyHours = goalDto.getWeeklyGoalStudyHours();
		WakanderGoal goals = null;
		Tribe tribe = tribeRepository.findByCode(tribeCode)
				.orElseThrow(() -> new BusinessException("A tribo do wakander não existe"));
		log.info("Esse Cara : {}",tribe);

		try {

			goals = this.wakanderGoalRepository
					.findByWakanderCodeTopByIdDesc(wakanderCode)
					.orElseThrow(() -> new NotFoundException());

			goals.setTribe(tribe);
			goals.setWeeklyGoalStudyHours(weeklyGoalStudyHours);
			log.info(": {}",goals);
		} catch (NotFoundException e) {

			Wakander wakander = wakanderRepository.findByCode(wakanderCode)
					.orElseThrow(() -> new BusinessException(" wakander não existe"));;
					goals = new WakanderGoal(wakander, tribe, weeklyGoalStudyHours, LocalDateTime.now());
					log.info(": {}",goals);
		}
		this.wakanderGoalRepository.save(goals);
	}

	@Override
	public WakanderGoal getGoal(String wakanderCode) throws BusinessException {

		log.info("Chegou: {}",wakanderCode);
		WakanderGoal goals = null;
		Wakander wakander = wakanderRepository.findByCode(wakanderCode)
				.orElseThrow(() -> new BusinessException(" wakander não existe"));;
				log.info("wakander: {}",wakander);		
				goals = this.wakanderGoalRepository
						.findByWakanderCodeTopByIdDesc(wakanderCode)
						.orElseThrow(() -> new BusinessException(" wakander não possui horas semanais cadastradas."));;
						return goals;
	}

}
