package dev.wakandaacademy.api.service.wakandertribesskilllesson;

import java.util.Optional;

import dev.wakandaacademy.api.domain.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.exception.ApiException;

public interface WakanderTribesSkillLessonService {
	Optional<WakanderTribeSkillLesson> getNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException;
	
	
}
