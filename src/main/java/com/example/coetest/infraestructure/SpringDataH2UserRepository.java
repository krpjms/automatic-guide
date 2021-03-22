package com.example.coetest.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataH2UserRepository extends JpaRepository<UserEntity, String>{
	
	@Override
	<S extends UserEntity> S save (S entity);
	
	@Query("SELECT usu FROM UserEntity usu WHERE usu.email = :mail") 
	UserEntity findEntityByEmail(@Param("mail") String mail);
}
