package com.example.coetest

import org.springframework.boot.test.context.SpringBootTest

import com.example.coetest.domain.Token

import spock.lang.Specification

@SpringBootTest
class TokenTest extends Specification {
	
	
	void 'UserRepository injection'() {
		given: 'a Repository injection'
//
		def token = new Token()
		when: ''
//		
		then: 'Service injection ok'
		token!=null
	}
  
	
}