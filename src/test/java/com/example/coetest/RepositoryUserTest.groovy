package com.example.coetest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import com.example.coetest.domain.Phones
import com.example.coetest.domain.User
import com.example.coetest.domain.repository.UserRepository
import com.example.coetest.domain.service.DomainUserService

import spock.lang.Specification

@SpringBootTest
class RepositoryUserTest extends Specification {


	@Autowired
	private UserRepository userRepository;
	private DomainUserService tested;	

	void 'Create a user test'() {
		given: 'a Service injection'
//		creating phone
		Phones ph = new Phones("66008232", "9", "56");
		List<Phones> phones = new ArrayList<Phones>()
		phones.add(ph)
		tested = new DomainUserService(userRepository)
		when: ''
		def some = tested.createUser(new User("Pepito","xxx@pepito.com","Dunenn01",phones))
		
		then: 'Service injection ok'
		some.isActive == '1'
	}
}