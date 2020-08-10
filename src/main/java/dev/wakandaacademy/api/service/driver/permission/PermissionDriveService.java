package dev.wakandaacademy.api.service.driver.permission;

import dev.wakandaacademy.api.enums.DriveRole;
import dev.wakandaacademy.api.exception.DriveException;

public interface PermissionDriveService {
	
	void permit(String email, String fileId, DriveRole driveRole) throws DriveException;
	
}
