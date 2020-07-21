package com.aceleradev.api.service.driver;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.http.HttpHeaders;
import com.google.api.services.drive.model.Permission;

@Component
public class DriveBatchCallback extends JsonBatchCallback<Permission> {

	@Override
	public void onSuccess(Permission permission, HttpHeaders responseHeaders) throws IOException {
		logger.info("Permission ID: {}", permission.getId());
		
	}

	@Override
	public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) throws IOException {
		logger.error("Callback JSON error: {}", e.getMessage());
		
	}
	
	private static final Logger logger = LogManager.getLogger(DriveBatchCallback.class);
}
