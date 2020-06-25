package com.aceleradev.api.service.encrypt.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import com.aceleradev.api.service.encrypt.PasswordEncrypter;

@Service
public class MD5PasswordEncrypter implements PasswordEncrypter {

	@Override
	public String encrypt(String value) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] bytes = value.getBytes();
        digest.update(bytes, 0, value.length());
        
        String encrypt = new BigInteger(1,digest.digest()).toString(16);
        
		return encrypt;
	}

}
