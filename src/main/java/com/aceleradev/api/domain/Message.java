package com.aceleradev.api.domain;

public class Message {
	
	private String message;

	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public static final Message SUCESSO = new Message("Conteudo liberado com sucesso");
	
}
