package dev.wakandaacademy.api.exception;


public class InvalidTokenException extends Exception {
	
	public InvalidTokenException(String message) {
		super(message);
	}

	public InvalidTokenException(String message, Throwable cause) {
		super(message, cause);
	}
	
	private static final long serialVersionUID = 1L;
}
