package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneLastLessonUseCase;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneNotLastSkillUseCase;

@Service
public class LessonDoneLastLessonSkillUseCase implements LessonDoneLastLessonUseCase {
	
	private WakanderTribeSkillRepository wakanderTribeSkillRepository;
	private LessonDoneNotLastSkillUseCase lessonDoneNotLastSkillUseCase;
	
	public LessonDoneLastLessonSkillUseCase(WakanderTribeSkillRepository wakanderTribeSkillRepository, LessonDoneNotLastSkillUseCase lessonDoneNotLastSkillUseCase) {
		this.wakanderTribeSkillRepository = wakanderTribeSkillRepository;
		this.lessonDoneNotLastSkillUseCase = lessonDoneNotLastSkillUseCase;
	}

	@Override
	public void finalizeCurrentStartNextSkill(WakanderTribeSkillLesson currentLesson) {
		WakanderTribeSkill currentSkill = currentLesson.getWakanderTribeSkill();
		if(isLastLesson(currentLesson)) {
			finalizeCurrentSkill(currentSkill);
			this.lessonDoneNotLastSkillUseCase.startNextSkillLesson(currentSkill);
		}
	}

	private boolean isLastLesson(WakanderTribeSkillLesson currentLesson) {
		return currentLesson.getNextSkillLesson() == null;
	}

	private void finalizeCurrentSkill(WakanderTribeSkill currentSkill) {
		logger.info("Finalizando skill apos finalizar ultima aula");
		currentSkill.finalize();
		this.wakanderTribeSkillRepository.save(currentSkill);
	}
	
	private static final Logger logger = LogManager.getLogger(LessonDoneLastLessonSkillUseCase.class);
}
