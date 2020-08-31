package dev.wakandaacademy.api.domain.wakander.service.goals.impl;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.List;
import java.util.Optional;
=======
>>>>>>> f438e5014d91048b7276ec129683123a8e55e5ec

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.journey.domain.Tribe;
import dev.wakandaacademy.api.domain.wakander.controller.dto.WakanderGoalDTO;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderGoal;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeInfo;
import dev.wakandaacademy.api.domain.wakander.repository.TribeRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderGoalRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeRepository;
import dev.wakandaacademy.api.domain.wakander.service.WakanderJPAService;
import dev.wakandaacademy.api.domain.wakander.service.goals.WakanderGoalService;
import dev.wakandaacademy.api.domain.wakander.service.tribes.WakanderTribesJpaService;
import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.NotFoundException;

@Service
public class WakanderGoalsJpaService implements WakanderGoalService {
	private static final Logger log = LoggerFactory.getLogger(WakanderGoalsJpaService.class);
	private WakanderGoalRepository wakanderGoalRepository;
	private WakanderTribeRepository WakanderTribeRepository;

	@Autowired
	private WakanderTribesJpaService wakanderTribesJpaService;

	@Autowired
	private TribeRepository tribeRepository;
	@Autowired
	private WakanderRepository wakanderRepository;




	public  WakanderGoalsJpaService (WakanderGoalRepository wakanderGoalRepository ) {
		this.wakanderGoalRepository = wakanderGoalRepository;


	}

	@Override
<<<<<<< HEAD
	public void createOrUpdateGoal(String wakanderCode,WakanderGoalDTO goalDto) throws BusinessException {
		log.info("Starting UserService Create to User: {}",goalDto);


		String tribeCode = goalDto.getNextTribeGoal().getTribeCode(); // Adicionar  BusinessException

		Integer weeklyGoalStudyHours = goalDto.getWeeklyGoalStudyHours();
		WakanderGoal goals = null;

		//Valida se exite a  tribo. ... . 
		Tribe tribe = tribeRepository.findByCode(tribeCode)
				.orElseThrow(() -> new BusinessException("A tribo do wakander não existe"));

		log.info("Esse Cara : {}",tribe);


=======
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
		
		
>>>>>>> f438e5014d91048b7276ec129683123a8e55e5ec
		try {
			// public Criar o metodo com o fluxo abaixo,o nome deve contemplar o fluxo abaixo. UPDATEGOAL 
			goals = this.wakanderGoalRepository
					.findByWakanderCodeTopByIdDesc(wakanderCode)
					.orElseThrow(() -> new NotFoundException());

			goals.setTribe(tribe);
			goals.setWeeklyGoalStudyHours(weeklyGoalStudyHours);
			log.info(": {}",goals);
		} catch (NotFoundException e) {
<<<<<<< HEAD
			//public  NEwGOALWakander 
			Wakander wakander = wakanderRepository.findByCode(wakanderCode)
					.orElseThrow(() -> new BusinessException(" wakander não existe"));;
					goals = new WakanderGoal(wakander, tribe, weeklyGoalStudyHours, LocalDateTime.now());
					log.info(": {}",goals);
=======

			Wakander wakanderT = wakanderTribe.getWakander();
			goals = new WakanderGoal(wakanderT, tribe, weeklyGoalStudyHours, LocalDateTime.now());
		} finally {
			this.wakanderGoalRepository.save(goals);
>>>>>>> f438e5014d91048b7276ec129683123a8e55e5ec
		}
		this.wakanderGoalRepository.save(goals);

		//Meu Codigo. 



	}

	@Override
	public WakanderGoal getGoal(String wakanderCode) throws BusinessException {

		log.info("Chegou: {}",wakanderCode);
		WakanderGoal goals = null;
		WakanderGoal great = null;

		Wakander wakander = wakanderRepository.findByCode(wakanderCode)
				.orElseThrow(() -> new BusinessException(" wakander não existe"));;
				log.info("wakander: {}",wakander);		

				try {
					goals = this.wakanderGoalRepository
							.findByWakanderCodeTopByIdDesc(wakanderCode)
							.orElseThrow(() -> new NotFoundException());
					log.info("goals: {}",goals.getTribe());
					log.info("goals: {}",goals.getWeeklyGoalStudyHours());


				} catch (NotFoundException e) {



				}




				return goals;
	}

}
