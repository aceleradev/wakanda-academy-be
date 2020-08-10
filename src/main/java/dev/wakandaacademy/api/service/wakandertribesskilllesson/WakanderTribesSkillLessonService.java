package dev.wakandaacademy.api.service.wakandertribesskilllesson;

import java.util.Optional;

import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.wakander.model.WakanderTribeSkillLesson;

public interface WakanderTribesSkillLessonService {
	Optional<WakanderTribeSkillLesson> getNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException;
	
	
}
