package com.aceleradev.api.service.driver.permission.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.aceleradev.api.enums.DriveRole;
import com.aceleradev.api.exception.DriveException;
import com.aceleradev.api.service.driver.permission.PermissionDriveService;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.Permission;

@Service
public class PermissionGoogleDriveService implements PermissionDriveService {

	private Drive driveService;
	private JsonBatchCallback<Permission> callback;
	
	public PermissionGoogleDriveService(Drive driveService, JsonBatchCallback<Permission> callback) {
		this.driveService = driveService;
		this.callback = callback;
	}

	@Override
	public void permit(String email, String fileId, DriveRole driveRole) throws DriveException {
		try {
			BatchRequest batch = driveService.batch();
	    	Permission userPermission = new Permission().setType("user")
											    	    .setRole(driveRole.getName())
											    	    .setEmailAddress(email);
	    	this.driveService
	    		.permissions()
				.create(fileId, userPermission)
	    	    .setFields("id")
	    	    .queue(batch, this.callback);
	    	batch.execute();
		} catch (Exception e) {
			String message = String.format("Erro ao setar permissão de arquivo[%s] para o usuário[%s] | Motivo: %s", fileId, email, e.getMessage());
			logger.error(message);
			throw new DriveException(message, e);
		}
	}

	private static final Logger logger = LogManager.getLogger(PermissionGoogleDriveService.class);
}
