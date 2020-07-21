package com.aceleradev.api.service.wakander.lesson;

import com.aceleradev.api.exception.BusinessException;
import com.aceleradev.api.exception.DriveException;

public interface LessonContentService {
	
	void unlockWakanderTribeSkillLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) throws BusinessException, DriveException;
}
