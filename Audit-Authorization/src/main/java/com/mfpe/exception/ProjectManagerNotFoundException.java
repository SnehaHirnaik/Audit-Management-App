package com.mfpe.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProjectManagerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProjectManagerNotFoundException(String message) {
		super(message);
	}
	
}
