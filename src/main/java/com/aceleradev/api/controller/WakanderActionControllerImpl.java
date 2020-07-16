package com.aceleradev.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceleradev.api.controller.contract.WakanderActionController;
import com.aceleradev.api.service.wakander.lesson.LessonContentService;

@RestController
@RequestMapping("/unlock")
public class WakanderActionControllerImpl implements WakanderActionController {
	private static final Logger log = LoggerFactory.getLogger(WakanderActionControllerImpl.class);
	
	private LessonContentService lessonContentService;

	public WakanderActionControllerImpl(LessonContentService lessonContentService) {
		this.lessonContentService = lessonContentService;
	}

	@Override
	public ResponseEntity<?> unlockTribe(String wakanderCode, String tribeCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/{wakanderCode}/{tribeCode}/{skillCode}/{lessonCode}")
	public ResponseEntity<?> unlockLessonContent(
			@PathVariable String wakanderCode,
			@PathVariable String tribeCode, 
			@PathVariable String skillCode, 
			@PathVariable String lessonCode) {
		
		log.info("Starting unlockLessonContent in WakanderActionControllerImpl");
		
		try {
			log.info("trying unlockLessonContent in WakanderActionControllerImpl");
			lessonContentService.unlockWakanderTribeSkillLessonContent(wakanderCode, tribeCode, skillCode, lessonCode);
			log.info("unlockLessonContent returns ok");
			return (ResponseEntity<?>) ResponseEntity.ok();
		} catch (Exception e) {
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
	}

	@Override
	public ResponseEntity<?> linWakanderTribeSkillLesson(String wakanderCode, String tribeCode, String skillCode,
			String lessonCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
