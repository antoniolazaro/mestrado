package br.ufba.activityrecognition.business.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = -5070313310143258487L;
	
	public ApplicationException() { super(); }
	public ApplicationException(String message) { super(message); }
	public ApplicationException(String message, Throwable cause) { super(message, cause); }
	public ApplicationException(Throwable cause) { super(cause); }
	
}
