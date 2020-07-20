package com.aceleradev.api.controller.contract;

import com.aceleradev.api.controller.dto.NextWakanderLessonDTO;
import com.aceleradev.api.exception.ApiException;
import org.springframework.http.ResponseEntity;

public interface WakandaActionAPI {

    ResponseEntity<NextWakanderLessonDTO> getNextWakanderLessonDto(String wakanderCode,String currentLessonCode) throws ApiException;

}
