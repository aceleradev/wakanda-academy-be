package com.aceleradev.api.repository;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;

public interface WakanderTribeSkillLessonRepository {

	void endsCurrentLessonByWakanderCodeAndCurrentLessonCode(String wakanderCode, String currentLessonCode);

	WakanderTribeSkillLesson findNextWakanderLessonByWakanderCodeAndCurrentLessonCode(String wakanderCode,
			String currentLessonCode);

	WakanderTribeSkillLesson save(WakanderTribeSkillLesson nextLesson);


}
