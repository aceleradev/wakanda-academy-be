package com.aceleradev.api.service.wakander.lesson.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.exception.BusinessException;
import com.aceleradev.api.exception.DriveException;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;
import com.aceleradev.api.service.driver.DriveService;
import com.aceleradev.api.service.wakander.lesson.LessonContentService;

@Service
public class LessonContentServiceImpl implements LessonContentService {
	private static final Logger log = LoggerFactory.getLogger(LessonContentServiceImpl.class);
	
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private DriveService driveService;

	public LessonContentServiceImpl(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository, DriveService driveService) {
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.driveService = driveService;
	}



	@Override
	public void unlockWakanderTribeSkillLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) throws BusinessException, DriveException {
		log.info("Starting unlockWakanderTribeSkillLessonContent in LessonContentServiceImpl");
		WakanderTribeSkillLesson wakanderTribeSkillLesson = this.wakanderTribeSkillLessonRepository
																.findByCodes(wakanderCode, tribeCode, skillCode, lessonCode)
																.orElseThrow(() -> new BusinessException(String.format("Não encontrado dados do Wakander com esses parametros[wakander=%s, tribe=%s, skill=%s, lesson=%s]", wakanderCode, tribeCode, skillCode, lessonCode)));
		this.driveService.unlockAccess(wakanderTribeSkillLesson);
		wakanderTribeSkillLesson.setUnlockedContent(true);
		this.wakanderTribeSkillLessonRepository.save(wakanderTribeSkillLesson);
	}

}
