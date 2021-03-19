package com.example.coetest.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.coetest.domain.repository.UserRepository;
import com.example.coetest.domain.service.DomainUserService;
import com.example.coetest.domain.service.UserService;

@Configuration
@ComponentScan("com.example.coetest")
public class BeanConfiguration {
	
	@Bean
	UserService userService(final UserRepository userRepository) {
		return new DomainUserService(userRepository);
	}
}
