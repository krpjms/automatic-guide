package com.example.coetest.domain.repository;

import com.example.coetest.domain.User;
import com.example.coetest.domain.UserResponse;
import com.example.coetest.infraestructure.UserEntity;

public interface UserRepository {
	UserResponse createUser(User user);
	UserEntity findByEmail(String mail);
}
