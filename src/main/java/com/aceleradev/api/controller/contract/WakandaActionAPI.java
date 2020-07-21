package com.aceleradev.api.controller.contract;

import com.aceleradev.api.controller.dto.NextWakanderLessonDTO;
import com.aceleradev.api.domain.Message;
import com.aceleradev.api.exception.ApiException;
import com.aceleradev.api.exception.BusinessException;
import com.aceleradev.api.exception.DriveException;

import org.springframework.http.ResponseEntity;

public interface WakandaActionAPI {

	ResponseEntity<?> unlockTribe(String wakanderCode, String tribeCode);
	ResponseEntity<Message> unlockLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) throws BusinessException, DriveException;
    ResponseEntity<NextWakanderLessonDTO> getNextWakanderLessonDto(String wakanderCode,String currentLessonCode) throws ApiException;

}
