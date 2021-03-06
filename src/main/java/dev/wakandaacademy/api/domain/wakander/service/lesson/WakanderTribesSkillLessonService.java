package dev.wakandaacademy.api.domain.wakander.service.lesson;

import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;

public interface WakanderTribesSkillLessonService {
	Optional<WakanderTribeSkillLesson> getNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException, BusinessException;
	
	
}
