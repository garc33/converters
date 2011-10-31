package org.sweet.converters.exception;

public class ConverterException extends RuntimeException {

	private static final long serialVersionUID = 9202569854266113346L;

	public ConverterException(String message) {
		super(message);
	}

	public ConverterException(String message, Throwable cause) {
		super(message, cause);
	}
}
