package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;

public interface LessonDoneLastLessonLastSkillUseCase {

	void finalizeCurrentStartNextTribe(WakanderTribeSkillLesson currentLesso);

}