package dev.wakandaacademy.api.domain.wakander.controller;

import org.springframework.http.ResponseEntity;

import dev.wakandaacademy.api.domain.driver.domain.Message;
import dev.wakandaacademy.api.domain.wakander.controller.dto.NextWakanderLessonDTO;
import dev.wakandaacademy.api.exception.ApiException;
import dev.wakandaacademy.api.exception.BusinessException;
import dev.wakandaacademy.api.exception.DriveException;

public interface WakanderActionAPI {

	ResponseEntity<?> unlockTribe(String wakanderCode, String tribeCode);
	ResponseEntity<Message> unlockLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) throws BusinessException, DriveException;
    ResponseEntity<NextWakanderLessonDTO> getNextWakanderLessonDto(String wakanderCode,String currentLessonCode) throws ApiException, BusinessException;

}
