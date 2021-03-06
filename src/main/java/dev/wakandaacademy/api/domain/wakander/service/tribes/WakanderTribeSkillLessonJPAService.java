package dev.wakandaacademy.api.domain.wakander.service.tribes;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.domain.wakander.repository.WakanderTribeSkillLessonRepository;

@Service
public class WakanderTribeSkillLessonJPAService implements WakanderTribeSkillLessonService {
	private static final Logger log = LoggerFactory.getLogger(WakanderTribeSkillLessonJPAService.class);
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private LessonService lessonService;

	public WakanderTribeSkillLessonJPAService(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository,
			LessonService lessonService) {
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.lessonService = lessonService;
	}

	@Override
	public void saveAllWakanderTribeSkillLesson(WakanderTribeSkill wts) {
		log.info("Saving All Lessons to WakanderTribeSkill: {}",wts);
		List<WakanderTribeSkillLesson> wakanderTribeSkillLessons = wts.getWakanderTribeSkillLessons(lessonService);
		wakanderTribeSkillLessonRepository.saveAll(wakanderTribeSkillLessons);
	}
}
