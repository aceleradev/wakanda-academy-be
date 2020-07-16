package com.aceleradev.api.service.wakandertribesskilllesson;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;

@Service
public class WakanderTribesSkillLessonJpaService implements WakanderTribesSkillLessonService{	
	WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	
	public WakanderTribesSkillLessonJpaService (WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository){
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}

	@Override
	public WakanderTribeSkillLesson getNextWakanderLesson(String wakanderCode, String currentLessonCode) {
		WakanderTribeSkillLesson currentLesson = wakanderTribeSkillLessonRepository.endsCurrentLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
		currentLesson.endsLesson();
		return startNextLessonBy(wakanderCode, currentLessonCode);
	}

	private WakanderTribeSkillLesson startNextLessonBy(String wakanderCode, String currentLessonCode) {
		WakanderTribeSkillLesson nextLesson = wakanderTribeSkillLessonRepository.findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(wakanderCode, currentLessonCode);
		nextLesson.startsLesson();
		return wakanderTribeSkillLessonRepository.save(nextLesson);
	}
	
	
	
	
}
