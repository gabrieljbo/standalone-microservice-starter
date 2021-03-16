package dev.gabrieljbo.project.core.ports.in;

import dev.gabrieljbo.project.domain.model.Person;

public interface GetPersonByIdPort {

    public Person getPersonById(int id);
	
}
