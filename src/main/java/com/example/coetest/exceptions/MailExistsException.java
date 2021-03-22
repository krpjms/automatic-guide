package com.example.coetest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND, reason = "Mail Exists")
public class MailExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MailExistsException(String errorMessage) {
        super(errorMessage);
    }
	
}


