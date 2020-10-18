package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;

public interface LessonDoneLastLessonUseCase {

	void finalizeCurrentStartNextSkill(WakanderTribeSkillLesson currentLesson);

}