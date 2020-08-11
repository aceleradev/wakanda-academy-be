package dev.wakandaacademy.api.domain.security.domain;

public class PrivateKey {
	
	private byte[] content;

	public PrivateKey(byte[] content) {
		this.content = content;
	}

	public byte[] getContent() {
		return content;
	}
	
}
