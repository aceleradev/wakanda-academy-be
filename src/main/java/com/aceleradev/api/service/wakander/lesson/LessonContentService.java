package com.aceleradev.api.service.wakander.lesson;

import com.aceleradev.api.exception.BusinessException;

public interface LessonContentService {
	
	void unlockWakanderTribeSkillLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) throws BusinessException;
}
