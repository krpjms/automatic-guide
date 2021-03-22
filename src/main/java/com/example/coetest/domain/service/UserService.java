package com.example.coetest.domain.service;

import com.example.coetest.domain.User;
import com.example.coetest.domain.UserResponse;
import com.example.coetest.exceptions.MailExistsException;

public interface UserService {
	UserResponse createUser(User user) throws MailExistsException;
}
