package dev.wakandaacademy.api.exception;

public class NotFoundException extends Exception {
	
	public NotFoundException() {}
	public NotFoundException(String message) {super(message);}
	public NotFoundException(String message, Throwable cause) {super(message, cause);}
	
	private static final long serialVersionUID = 1L;
}
