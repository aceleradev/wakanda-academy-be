package com.aceleradev.api.service.wakandertribesskilllesson;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;

public interface WakanderTribesSkillLessonService {
	WakanderTribeSkillLesson getNextWakanderLesson(String wakanderCode, String currentLessonCode);
	
	
}
