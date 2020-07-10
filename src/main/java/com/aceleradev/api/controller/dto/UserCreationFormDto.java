package com.aceleradev.api.controller.dto;

import java.security.NoSuchAlgorithmException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aceleradev.api.domain.model.Credential;
import com.aceleradev.api.domain.model.Wakander;
import com.aceleradev.api.service.encrypt.PasswordEncrypter;

public class UserCreationFormDto {
	private static final Logger logger = LogManager.getLogger(UserCreationFormDto.class);

	@NotNull
	@NotBlank
	@Size(min = 3, max = 60)
	private String name;
	@Pattern(regexp = "^[a-z]\\w*") @Size(min = 3, max = 30)
	private String wakanderCode;
	@Email
	@NotBlank
	@NotNull
	private String email;
	@NotNull
	@NotBlank
	@Size(min = 3, max = 10)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWakanderCode() {
		return hasWakanderCode() ? this.wakanderCode : buildWakanderCodeByEmail();
	}

	public boolean hasWakanderCode() {
		return this.wakanderCode != null && !this.wakanderCode.isEmpty();
	}

	private String buildWakanderCodeByEmail() {
		String firstPartOfEmail = getFirstPartOfEmail();
		return firstPartOfEmail.replaceAll("\\W", "");
	}

	private String getFirstPartOfEmail() {
		return this.email.split("@")[0];
	}

	public void setWakanderCode(String wakanderCode) {
		this.wakanderCode = wakanderCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Wakander converter(PasswordEncrypter passwordEncrypter) throws NoSuchAlgorithmException {
		logger.info("converting UserCreationFormDto to WakanderUser");
		String passwordEncrypted = passwordEncrypter.encrypt(this.getPassword());
		Credential credential = new Credential(passwordEncrypted, this.getEmail());
		Wakander wakanderUser = new Wakander(this.getWakanderCode(), this.getName(), credential);
		return wakanderUser;
	}
}
