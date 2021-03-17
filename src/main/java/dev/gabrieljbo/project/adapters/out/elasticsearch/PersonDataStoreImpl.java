package dev.gabrieljbo.project.adapters.out.elasticsearch;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.gabrieljbo.project.core.ports.out.PersonDataStorePort;
import dev.gabrieljbo.project.domain.model.Person;

@Component
public class PersonDataStoreImpl implements PersonDataStorePort {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public Person findById(int id) {
		PersonEntity personEntity = personRepository.findById(id);
		BoundedMapper boundedMapper = Mappers.getMapper(BoundedMapper.class);
		Person person = boundedMapper.personEntityToPerson(personEntity);
		
		return person;
	}

	@Override
	public List<Person> findAll() {
		List<PersonEntity> personEntityList = personRepository.findAll();
		BoundedMapper boundedMapper = Mappers.getMapper(BoundedMapper.class);
		List<Person> personList = boundedMapper.personEntityToPerson(personEntityList);
		
		return personList;
	}

}
