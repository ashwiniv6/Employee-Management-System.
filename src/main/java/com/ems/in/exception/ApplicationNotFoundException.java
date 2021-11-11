package com.ems.in.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ApplicationNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ApplicationNotFoundException(String message){
    	super(message);
    }
}