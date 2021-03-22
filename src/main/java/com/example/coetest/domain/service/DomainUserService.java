package com.example.coetest.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.coetest.domain.User;
import com.example.coetest.domain.UserResponse;
import com.example.coetest.domain.repository.UserRepository;
import com.example.coetest.exceptions.MailExistsException;
import com.example.coetest.infraestructure.UserEntity;

public class DomainUserService implements UserService {
	
	private final UserRepository userRepository;
	private final static Logger logger = LoggerFactory.getLogger(DomainUserService.class);
	
	public DomainUserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserResponse createUser(User user) throws MailExistsException {
		logger.warn("Verifiying: "+ user.getEmail()+" doesnt exist");
		UserEntity correo = userRepository.findByEmail(user.getEmail());
		
		if(null == correo) {
			logger.info("Creating user");
			UserResponse ur =  userRepository.createUser(user);
			return ur;
		}else
			logger.error("Mail " + user.getEmail() + "already exists");
			throw new MailExistsException("Mail already exists");
	}
}
