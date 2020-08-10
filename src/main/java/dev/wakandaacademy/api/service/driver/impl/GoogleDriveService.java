package dev.wakandaacademy.api.service.driver.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.domain.model.Lesson;
import dev.wakandaacademy.api.domain.model.Wakander;
import dev.wakandaacademy.api.domain.model.WakanderTribe;
import dev.wakandaacademy.api.domain.model.WakanderTribeSkill;
import dev.wakandaacademy.api.domain.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.enums.DriveRole;
import dev.wakandaacademy.api.exception.DriveException;
import dev.wakandaacademy.api.service.driver.DriveService;
import dev.wakandaacademy.api.service.driver.permission.PermissionDriveService;

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
