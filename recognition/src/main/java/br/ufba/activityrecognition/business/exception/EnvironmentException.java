package br.ufba.activityrecognition.business.exception;

public class EnvironmentException extends RuntimeException {

	private static final long serialVersionUID = -1329932014618913317L;
	
	public EnvironmentException() { super(); }
	public EnvironmentException(String message) { super(message); }
	public EnvironmentException(String message, Throwable cause) { super(message, cause); }
	public EnvironmentException(Throwable cause) { super(cause); }
}
