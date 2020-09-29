package dev.wakandaacademy.api.domain.wakander.service.lesson;

import java.util.List;

import dev.wakandaacademy.api.domain.journey.domain.Lesson;
import dev.wakandaacademy.api.domain.journey.domain.Skill;

public interface LessonService {
	List<Lesson> findBySkill(Skill skill);
}
