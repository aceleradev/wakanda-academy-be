package dev.wakandaacademy.api.domain.wakander.service.lesson.event.sourcing.usecases;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;

public interface LessonDoneNotLastSkillUseCase {

	void startNextSkillLesson(WakanderTribeSkill currentSkill);

}