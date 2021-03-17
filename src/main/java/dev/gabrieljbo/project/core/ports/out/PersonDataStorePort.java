package dev.gabrieljbo.project.core.ports.out;

import java.util.List;

import dev.gabrieljbo.project.domain.model.Person;

public interface PersonDataStorePort {

	public Person findById(int id);

	public List<Person> findAll();
	
}
