package dev.wakandaacademy.api.domain.wakander.service.lesson.usecase;

import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;

public interface FindNextLessonUseCase {
	
	Optional<WakanderTribeSkillLesson> findNextLesson(WakanderTribeSkillLesson currentLesson);
	
}
