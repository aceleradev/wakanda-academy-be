package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.Status;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneNotLastSkillUseCase;

@Service
public class LessonDoneNotLastSkillStartSkillUseCase implements LessonDoneNotLastSkillUseCase {

	private WakanderTribeSkillRepository wakanderTribeSkillRepository;
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	
	public LessonDoneNotLastSkillStartSkillUseCase(WakanderTribeSkillRepository wakanderTribeSkillRepository, WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
		this.wakanderTribeSkillRepository = wakanderTribeSkillRepository;
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}

	@Override
	public void startNextSkillLesson(WakanderTribeSkill currentSkill) {
		WakanderTribeSkill nextSkill = currentSkill.getNextTribeSkill();
		if(isNotLastSkill(nextSkill)) {
			startNextSkill(nextSkill);
			startFirstLessonOfNextSkill(nextSkill);
		}
	}

	private boolean isNotLastSkill(WakanderTribeSkill nextSkill) {
		return nextSkill != null;
	}
	
	private void startNextSkill(WakanderTribeSkill nextSkill) {
		logger.info("Startando proxima skill");
		nextSkill.start();
		this.wakanderTribeSkillRepository.save(nextSkill);
	}
	
	private void startFirstLessonOfNextSkill(WakanderTribeSkill nextSkill) {
		logger.info("Startando primeira lesson da proxima skill");
		WakanderTribeSkillLesson firstLessonNextSkill = nextSkill.getFirstLesson();
		firstLessonNextSkill.setStatus(Status.DOING);
		this.wakanderTribeSkillLessonRepository.save(firstLessonNextSkill);
	}
	
	private static final Logger logger = LogManager.getLogger(LessonDoneNotLastSkillStartSkillUseCase.class);
}
