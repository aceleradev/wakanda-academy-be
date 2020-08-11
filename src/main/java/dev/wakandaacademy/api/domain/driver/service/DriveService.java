package dev.wakandaacademy.api.domain.driver.service;

import dev.wakandaacademy.api.domain.wakander.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.exception.DriveException;

public interface DriveService {
	
	void unlockAccess(WakanderTribeSkillLesson lesson) throws DriveException;
	
}
