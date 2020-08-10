package dev.wakandaacademy.api.controller.contract;

import org.springframework.http.ResponseEntity;

public interface WakanderActionController {
	
	ResponseEntity<?> unlockTribe(String wakanderCode, String tribeCode);
	
	ResponseEntity<?> unlockLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode);
	
	ResponseEntity<?> linWakanderTribeSkillLesson(String wakanderCode, String tribeCode, String skillCode, String lessonCode);
}
