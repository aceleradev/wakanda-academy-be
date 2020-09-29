package dev.wakandaacademy.api.domain.wakander.service.lesson;

import java.util.Optional;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.NotFoundException;

public interface WakanderTribesSkillLessonService {
	Optional<WakanderTribeSkillLesson> endsCurrentLessonAndStartsNextWakanderLesson(String wakanderCode, String currentLessonCode) throws ApiException, NotFoundException;
	
	
}
