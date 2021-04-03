package com.sgyeme.app;

public class ResourceNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	 public ResourceNotFoundException() {
	        super();
	    }

 public ResourceNotFoundException(String mesage) {
		super(mesage);
	}
 public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
 public ResourceNotFoundException(String message, Throwable cause) {
     super(message, cause);
 }

}
