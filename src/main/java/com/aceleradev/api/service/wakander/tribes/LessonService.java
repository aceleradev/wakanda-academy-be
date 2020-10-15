package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import com.aceleradev.api.domain.model.Lesson;
import com.aceleradev.api.domain.model.Skill;

public interface LessonService {
	List<Lesson> findBySkill(Skill skill);
}
