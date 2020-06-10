package com.aceleradev.api.exception;

public class RepositoryException extends Exception {
	
	public RepositoryException() {}
	public RepositoryException(String message) {super(message);}
	public RepositoryException(String message, Throwable cause) {super(message, cause);}
	
	private static final long serialVersionUID = 1L;
}
