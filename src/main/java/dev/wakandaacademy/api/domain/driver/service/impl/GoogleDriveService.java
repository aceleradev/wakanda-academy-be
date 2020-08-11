package dev.wakandaacademy.api.domain.driver.service.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.driver.enums.DriveRole;
import dev.wakandaacademy.api.domain.driver.service.DriveService;
import dev.wakandaacademy.api.domain.driver.service.permission.PermissionDriveService;
import dev.wakandaacademy.api.domain.journey.domain.Lesson;
import dev.wakandaacademy.api.domain.wakander.model.Wakander;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribe;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.exception.DriveException;

@Service
public class GoogleDriveService implements DriveService {
	
	private PermissionDriveService permissionDriveService;
	
	public GoogleDriveService(PermissionDriveService permissionDriveService) {
		this.permissionDriveService = permissionDriveService;
	}

	@Override
	public void unlockAccess(WakanderTribeSkillLesson wakanderTribeSkillLesson) throws DriveException {
		String wakanderEmail = this.getWakanderEmail(wakanderTribeSkillLesson);
		Lesson lesson = wakanderTribeSkillLesson.getLesson();
		logger.info("Liberando lesson[{}] para wakander[email={}]", lesson, wakanderEmail);
		if(wakanderTribeSkillLesson.isUnlockedContent())
		this.permissionDriveService.permit(wakanderEmail, lesson.getFileId(), DriveRole.READER);
	}

	private String getWakanderEmail(WakanderTribeSkillLesson wakanderTribeSkillLesson) {
		String wakanderEmail = Optional.ofNullable(wakanderTribeSkillLesson.getWakanderTribeSkill())
									.map(WakanderTribeSkill::getWakanderTribe)
									.map(WakanderTribe::getWakander)
									.map(Wakander::getEmail)
									.orElse(null);
		return wakanderEmail;
	}
	
	private static final Logger logger = LogManager.getLogger(GoogleDriveService.class);
}
