package com.example.coetest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.example.coetest.domain.Phones
import com.example.coetest.domain.repository.UserRepository
import com.example.coetest.domain.service.DomainUserService

import spock.lang.Specification

@SpringBootTest
class ServiceInjectionTest extends Specification {

	@Autowired
	private UserRepository userRepository;
	private DomainUserService tested;

	void 'DomainUserService injection'() {
		given: 'a Service injection'
//		creating phone
		Phones ph = new Phones("66008232", "9", "56");
		List<Phones> phones = new ArrayList<Phones>()
		phones.add(ph)
		
		when: ''
		tested = new DomainUserService(userRepository)
		then: 'Service injection ok'
		tested != null
	}
	
}