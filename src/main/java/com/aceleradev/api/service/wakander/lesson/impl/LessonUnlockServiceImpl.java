package com.aceleradev.api.service.wakander.lesson.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;
import com.aceleradev.api.service.driver.DriverService;
import com.aceleradev.api.service.wakander.lesson.LessonUnlockService;

@Service
public class LessonUnlockServiceImpl implements LessonUnlockService {
	private static final Logger log = LoggerFactory.getLogger(LessonUnlockServiceImpl.class);
	
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private DriverService driverService;

	public LessonUnlockServiceImpl(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository,
			DriverService driverService) {
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.driverService = driverService;
	}

	@Override
	public void unlockContent(WakanderTribeSkillLesson wk) {
		log.info("Starting unlockContent in LessonUnlockServiceImpl");
		wk.setUnlockedContent(true);
		this.wakanderTribeSkillLessonRepository.save(wk);
		driverService.unlockContent();

	}

}
