package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneNotLastTribeUseCase;

@Service
public class LessonDoneNotLastTribeStartTribeUseCase implements LessonDoneNotLastTribeUseCase {
	
	private WakanderTribeSkillRepository wakanderTribeSkillRepository;
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	
	public LessonDoneNotLastTribeStartTribeUseCase(WakanderTribeSkillRepository wakanderTribeSkillRepository, WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
		this.wakanderTribeSkillRepository = wakanderTribeSkillRepository;
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}
	
	@Override
	public void startNextTribe(WakanderTribe currentTribe) {
		WakanderTribe nextTribe = currentTribe.getNextTribe();
		WakanderTribeSkill firstSkillNextTribe = nextTribe.getFirstSkill();
		startFirstSkillNextTribe(firstSkillNextTribe);
		startFirstLessonNextTribe(firstSkillNextTribe);
	}
	
	private void startFirstLessonNextTribe(WakanderTribeSkill firstSkillNextTribe) {
		logger.info("Iniciando primeira aula da proxima tribo");
		WakanderTribeSkillLesson firstLessonNextTribe = firstSkillNextTribe.getFirstLesson();
		firstLessonNextTribe.setStatus(Status.DOING);
		this.wakanderTribeSkillLessonRepository.save(firstLessonNextTribe);
	}

	private void startFirstSkillNextTribe(WakanderTribeSkill firstSkillNextTribe) {
		logger.info("Iniciando primeira skill da proxima tribo");
		firstSkillNextTribe.start();
		this.wakanderTribeSkillRepository.save(firstSkillNextTribe);
	}
	
	private static final Logger logger = LogManager.getLogger(LessonDoneNotLastTribeStartTribeUseCase.class);
}