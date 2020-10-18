package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeRepository;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneLastLessonLastSkillUseCase;
import dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases.LessonDoneNotLastTribeUseCase;

@Service
public class LessonDoneLastLessonLastSkillFinalizeCurrentStartNextUseCase implements LessonDoneLastLessonLastSkillUseCase {
	
	private WakanderTribeRepository wakanderTribeRepository;
	private LessonDoneNotLastTribeUseCase lessonDoneNotLastTribeUseCase;
	
	public LessonDoneLastLessonLastSkillFinalizeCurrentStartNextUseCase(WakanderTribeRepository wakanderTribeRepository, LessonDoneNotLastTribeUseCase lessonDoneNotLastTribeUseCase) {
		this.wakanderTribeRepository = wakanderTribeRepository;
		this.lessonDoneNotLastTribeUseCase = lessonDoneNotLastTribeUseCase;
	}

	@Override
	public void finalizeCurrentStartNextTribe(WakanderTribeSkillLesson currentLesson) {
		WakanderTribeSkill currentSkill = currentLesson.getWakanderTribeSkill();
		if(isLastLesson(currentLesson) && isLastSkill(currentSkill)) {
			WakanderTribe currentTribe = currentSkill.getWakanderTribe();
			finalizeCurrentTribe(currentTribe);
			this.lessonDoneNotLastTribeUseCase.startNextTribe(currentTribe);
		}
	}
	
	private boolean isLastSkill(WakanderTribeSkill currentSkill) {
		return currentSkill.getNextTribeSkill() == null;
	}

	private boolean isLastLesson(WakanderTribeSkillLesson currentLesson) {
		return currentLesson.getNextSkillLesson() == null;
	}

	private void finalizeCurrentTribe(WakanderTribe currentTribe) {
		logger.info("Finalizando tribo atual");
		currentTribe.finalize();
		this.wakanderTribeRepository.save(currentTribe);
	}
	
	private static final Logger logger = LogManager.getLogger(LessonDoneLastLessonLastSkillFinalizeCurrentStartNextUseCase.class);
}
