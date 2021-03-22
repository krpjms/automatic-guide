package com.example.coetest.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coetest.exceptions.MailExistsException;
import com.example.coetest.domain.User;
import com.example.coetest.domain.UserResponse;
import com.example.coetest.domain.service.UserService;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody final User user) throws MailExistsException{
		logger.info("Usuario"+ user.getName());
		logger.info("fono:"+user.getPhones());
		UserResponse userNew;
		try {
			userNew = userService.createUser(user);
		} catch (MailExistsException e) {
			logger.error("El correo ya existe");
			Map<String, Object> body = new LinkedHashMap<>();
			body.put("mensaje", e.getMessage());
			return new ResponseEntity(body, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(userNew, HttpStatus.OK);
	}

}
