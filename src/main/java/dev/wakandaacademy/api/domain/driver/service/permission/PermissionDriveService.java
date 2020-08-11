package dev.wakandaacademy.api.domain.driver.service.permission;

import dev.wakandaacademy.api.domain.driver.enums.DriveRole;
import dev.wakandaacademy.api.exception.DriveException;

public interface PermissionDriveService {
	
	void permit(String email, String fileId, DriveRole driveRole) throws DriveException;
	
}
