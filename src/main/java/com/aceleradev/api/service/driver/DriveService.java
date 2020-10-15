package com.aceleradev.api.service.driver;

import com.aceleradev.api.domain.model.WakanderTribeSkillLesson;
import com.aceleradev.api.exception.DriveException;

public interface DriveService {
	
	void unlockAccess(WakanderTribeSkillLesson lesson) throws DriveException;
	
}
