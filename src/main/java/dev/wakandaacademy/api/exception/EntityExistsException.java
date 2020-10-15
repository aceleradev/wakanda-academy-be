package dev.wakandaacademy.api.exception;

public class EntityExistsException extends Exception {
	
	public EntityExistsException() {}
	public EntityExistsException(String message) {super(message);}
	public EntityExistsException(String message, Throwable cause) {super(message, cause);}
	
	public static final int ENTITY_EXISTS_STATUS_CODE = 453;
	private static final long serialVersionUID = 1L;
}
