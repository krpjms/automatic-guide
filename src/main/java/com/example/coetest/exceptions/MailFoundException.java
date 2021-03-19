package com.example.coetest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND, reason = "Mail Found")
public class MailFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MailFoundException(String errorMessage) {
        super(errorMessage);
    }
	
}


