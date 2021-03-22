package com.example.coetest

import org.springframework.boot.test.context.SpringBootTest

import spock.lang.Specification

@SpringBootTest
class ContextTest extends Specification {

  
	def "test context loads"() {
	  expect:
	  context != null
	  context.containsBean("usersApplication")
	  context.containsBean("userController")
	  context.containsBean("beanConfiguration")
	
	}
	
}