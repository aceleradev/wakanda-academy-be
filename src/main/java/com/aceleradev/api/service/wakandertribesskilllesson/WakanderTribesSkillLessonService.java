package com.aceleradev.api.service.wakandertribesskilllesson;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.exception.ApiException;

import java.util.Optional;

public interface WakanderTribesSkillLessonService {
	Optional<WakanderTribeSkillLesson> getNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException;
	
	
}
