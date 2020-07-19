package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.Lesson;
import com.aceleradev.api.domain.model.Skill;
import com.aceleradev.api.repository.LessonRepository;

@Service
public class LessonJPAService implements LessonService {
	LessonRepository lessonRepository;

	public LessonJPAService(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}

	@Override
	public List<Lesson> findBySkill(Skill skill) {
		return lessonRepository.findBySkill(skill);
	}
}
