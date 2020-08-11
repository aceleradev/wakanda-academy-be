package dev.wakandaacademy.api.domain.user.service.encrypt;

import java.security.NoSuchAlgorithmException;

public interface PasswordEncrypter {
	
	String encrypt(String value) throws NoSuchAlgorithmException;
	
}
