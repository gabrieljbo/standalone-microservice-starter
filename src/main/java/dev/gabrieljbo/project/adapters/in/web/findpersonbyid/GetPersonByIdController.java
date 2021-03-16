package dev.gabrieljbo.project.adapters.in.web.findpersonbyid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.gabrieljbo.project.domain.model.Person;

public interface GetPersonByIdController {

    @GetMapping(path = "/api/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") int id);
	
}
