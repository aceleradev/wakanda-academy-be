package dev.wakandaacademy.api.service.driver;

import dev.wakandaacademy.api.domain.model.WakanderTribeSkillLesson;
import dev.wakandaacademy.api.exception.DriveException;

public interface DriveService {
	
	void unlockAccess(WakanderTribeSkillLesson lesson) throws DriveException;
	
}
