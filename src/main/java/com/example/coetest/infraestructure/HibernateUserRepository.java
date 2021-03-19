package com.example.coetest.infraestructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.coetest.domain.User;
import com.example.coetest.domain.UserResponse;
import com.example.coetest.domain.repository.UserRepository;

@Component
public class HibernateUserRepository implements UserRepository{
	@Autowired
	private SpringDataH2UserRepository springDataH2Repository;
	private final static Logger logger = LoggerFactory.getLogger(HibernateUserRepository.class);

	@Override
	public UserResponse createUser(User user) {
		logger.info("Se genera entidad");
		logger.info("user "+user.toString());
		 UserEntity ue = springDataH2Repository.save(new UserEntity(user));
		 return new UserResponse(ue.getId(), ue.getCreated(), ue.getModified(), ue.getLastLogin(), ue.getActive(), ue.getToken(), user.getName());
	}

	@Override
	public UserEntity findByEmail(String mail) {
		return springDataH2Repository.findTitleByEmail(mail);
	}




}
