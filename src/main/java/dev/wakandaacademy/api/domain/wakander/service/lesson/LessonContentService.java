package dev.wakandaacademy.api.domain.wakander.service.lesson;

import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.DriveException;

public interface LessonContentService {
	
	void unlockWakanderTribeSkillLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) throws BusinessException, DriveException;
}
