package dev.gabrieljbo.project.adapters.in.web.findpersonbyid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.gabrieljbo.project.core.ports.in.GetPersonByIdPort;
import dev.gabrieljbo.project.domain.model.Person;

@RestController
public class GetPersonByIdControllerImpl  implements GetPersonByIdController {

    @Autowired
    GetPersonByIdPort getPersonByIdPort;
	
	@Override
	public ResponseEntity<Person> getPersonById(int id) {
		Person person = getPersonByIdPort.getPersonById(id);
		
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

}
