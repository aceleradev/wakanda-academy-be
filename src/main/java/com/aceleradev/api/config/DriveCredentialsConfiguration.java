package com.aceleradev.api.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

@Configuration
public class DriveCredentialsConfiguration {
	
	private String credentialLocation;
	private String applicationName;
	
	public DriveCredentialsConfiguration(@Value("${app.drive.credentials}") String credentialLocation, @Value("${app.drive.applicationName}") String applicationName) {
		this.credentialLocation = credentialLocation;
		this.applicationName = applicationName;
	}
	
	@Bean
	public File dataStoreFolder() {
		File file = new File("tokens");
		if(!file.exists())
			file.mkdir();
		return file;
	}
	
	@Bean
	public InputStream credentialsInputStream() {
		return DriveCredentialsConfiguration.class.getResourceAsStream(this.credentialLocation);
	}
	
	@Bean
	public HttpTransport httpTransport() throws GeneralSecurityException, IOException {
		NetHttpTransport netHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
		return netHttpTransport;
	}
	
	@Bean
	public JsonFactory jsonFactory() {
		JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();
		return jsonFactory;
	}
	
	@Bean
	public Credential googleCredential(HttpTransport httpTransport, JsonFactory jsonFactory, File dataStoreFolder, InputStream credentialsInputStream) throws IOException {
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(credentialsInputStream));
		
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory, clientSecrets, SCOPES)
																		.setDataStoreFactory(new FileDataStoreFactory(dataStoreFolder))
                														.build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}
	
	@Bean
	public Drive driveService(Credential credential, HttpTransport httpTransport, JsonFactory jsonFactory) {
		 Drive driveService = new Drive.Builder(httpTransport, jsonFactory, credential)
									.setApplicationName(this.applicationName)
									.build();
		 return driveService;
	}
	
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
}
