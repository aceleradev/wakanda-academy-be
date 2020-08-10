package dev.wakandaacademy.api.exception;

public class DriveException extends Exception {
	
	public DriveException() {}
	public DriveException(String message) {super(message);}
	public DriveException(String message, Throwable cause) {super(message, cause);}
	
	private static final long serialVersionUID = 1L;
}
