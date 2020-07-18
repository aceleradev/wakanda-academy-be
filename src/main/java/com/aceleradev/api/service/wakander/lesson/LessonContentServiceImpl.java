package com.aceleradev.api.service.wakander.lesson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;
import com.aceleradev.api.service.driver.DriverService;

@Service
public class LessonContentServiceImpl implements LessonContentService {
	private static final Logger log = LoggerFactory.getLogger(LessonContentServiceImpl.class);
	
	private DriverService driverService;
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;

	public LessonContentServiceImpl(DriverService driverService,
			WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository) {
		this.driverService = driverService;
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
	}

	@Override
	public void unlockWakanderTribeSkillLessonContent(String wakanderCode, String tribeCode, String skillCode, String lessonCode) {
		log.info("Starting unlockWakanderTribeSkillLessonContent in LessonContentServiceImpl");
		this.wakanderTribeSkillLessonRepository.unlockContent(wakanderCode, tribeCode, skillCode, lessonCode);
		log.info("loking for lesson");
		driverService.unlockContent();

	}

}
