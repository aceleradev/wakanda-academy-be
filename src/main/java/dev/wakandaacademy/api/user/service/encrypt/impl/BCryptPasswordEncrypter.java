package dev.wakandaacademy.api.user.service.encrypt.impl;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.api.user.service.encrypt.PasswordEncrypter;

@Service
public class BCryptPasswordEncrypter implements PasswordEncrypter {

	private PasswordEncoder passwordEncoder;
	
	public BCryptPasswordEncrypter(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String encrypt(String value) throws NoSuchAlgorithmException {
		String encrypt = this.passwordEncoder.encode(value);
		return encrypt;
	}

}
