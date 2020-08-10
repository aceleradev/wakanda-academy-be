package dev.wakandaacademy.api.service.wakander.tribes;

import java.util.List;

import dev.wakandaacademy.api.domain.model.Lesson;
import dev.wakandaacademy.api.domain.model.Skill;

public interface LessonService {
	List<Lesson> findBySkill(Skill skill);
}
