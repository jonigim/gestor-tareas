package com.ttps.gestortareas.exception;

public class AuthenticationException extends Exception {
	
	private static final long serialVersionUID = 2061821851727002340L;

	public AuthenticationException() {
		super("Invalid username or password");
	}

}
