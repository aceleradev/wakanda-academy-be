package com.aceleradev.api.service.wakander.tribes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribeSkill;
import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;

@Service
public class WakanderTribeSkillLessonJPAService implements WakanderTribeSkillLessonService {
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private LessonService lessonService;

	public WakanderTribeSkillLessonJPAService(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository,
			LessonService lessonService) {
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.lessonService = lessonService;
	}

	@Override
	public void saveAllWakanderTribeSkillLesson(WakanderTribeSkill wts) {
		List<WakanderTribeSkillLesson> wakanderTribeSkillLessons = wts.getWakanderTribeSkillLessons(lessonService);
		wakanderTribeSkillLessonRepository.saveAll(wakanderTribeSkillLessons);
	}
}
