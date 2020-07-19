package com.aceleradev.api.service.wakander.lesson.impl;

import org.springframework.stereotype.Service;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.repository.WakanderTribeSkillLessonRepository;
import com.aceleradev.api.service.driver.DriverService;
import com.aceleradev.api.service.wakander.lesson.LessonUnlockService;

@Service
public class LessonUnlockServiceImpl implements LessonUnlockService {
	
	private WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository;
	private DriverService driverService;

	public LessonUnlockServiceImpl(WakanderTribeSkillLessonRepository wakanderTribeSkillLessonRepository,
			DriverService driverService) {
		this.wakanderTribeSkillLessonRepository = wakanderTribeSkillLessonRepository;
		this.driverService = driverService;
	}

	@Override
	public void unlockContent(WakanderTribeSkillLesson wk) {
		
		wk.setUnlockedContent(true);
		this.wakanderTribeSkillLessonRepository.save(wk);
		driverService.unlockContent();

	}

}
