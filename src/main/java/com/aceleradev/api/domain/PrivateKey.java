package com.aceleradev.api.domain;

public class PrivateKey {
	
	private byte[] content;

	public PrivateKey(byte[] content) {
		this.content = content;
	}

	public byte[] getContent() {
		return content;
	}
	
}
