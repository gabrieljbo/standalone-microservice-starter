package dev.gabrieljbo.project.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.gabrieljbo.project.core.ports.in.GetPersonByIdPort;
import dev.gabrieljbo.project.core.ports.out.PersonDataStorePort;
import dev.gabrieljbo.project.domain.model.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
class GetPersonByIdImpl implements GetPersonByIdPort {

	@Autowired
	private PersonDataStorePort personDataStorePort;
	
	@Override
	public Person getPersonById(int id) {
		Person person = personDataStorePort.findById(id);
		log.info("Person retrieved on UseCase!");
		
		return person;
	}

}
