package dev.wakandaacademy.api.exception;


public class ExpiredTokenException extends Exception {
	
	public ExpiredTokenException(String message) {
		super(message);
	}

	public ExpiredTokenException(String message, Throwable cause) {
		super(message, cause);
	}
	
	private static final long serialVersionUID = 1L;
}
