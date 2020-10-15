package com.aceleradev.api.service.driver.permission;

import com.aceleradev.api.enums.DriveRole;
import com.aceleradev.api.exception.DriveException;

public interface PermissionDriveService {
	
	void permit(String email, String fileId, DriveRole driveRole) throws DriveException;
	
}
