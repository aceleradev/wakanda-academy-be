package dev.wakandaacademy.api.exception;

public class ApiException extends Exception {

	private Long code;

	public ApiException(Long code, String message) {
		super(message);
		this.code = code;
	}

	public Long getCode() {
		return code;
	}

	private static final long serialVersionUID = 1L;
}