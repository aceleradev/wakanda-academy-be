package dev.wakandaacademy.api.domain.wakander.service.lesson;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.journey.domain.Lesson;
import dev.wakandaacademy.api.domain.journey.domain.Skill;
import dev.wakandaacademy.api.domain.journey.repository.LessonRepository;

@Service
public class LessonJPAService implements LessonService {
	private static final Logger log = LoggerFactory.getLogger(LessonJPAService.class);
	LessonRepository lessonRepository;

	public LessonJPAService(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}

	@Override
	public List<Lesson> findBySkill(Skill skill) {
		log.info("Finding lessons by skill: {}",skill.toString());
		return lessonRepository.findBySkill(skill);
	}
}
