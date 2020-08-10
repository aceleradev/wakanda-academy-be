package dev.wakandaacademy.api.service.driver;

import dev.wakandaacademy.api.exception.DriveException;
import dev.wakandaacademy.api.wakander.model.WakanderTribeSkillLesson;

public interface DriveService {
	
	void unlockAccess(WakanderTribeSkillLesson lesson) throws DriveException;
	
}
