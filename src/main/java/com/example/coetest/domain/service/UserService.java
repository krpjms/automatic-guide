package com.example.coetest.domain.service;

import com.example.coetest.exceptions.MailExistsException;
import com.example.coetest.domain.User;
import com.example.coetest.domain.UserResponse;

public interface UserService {
	UserResponse createUser(User user) throws MailExistsException;
}
