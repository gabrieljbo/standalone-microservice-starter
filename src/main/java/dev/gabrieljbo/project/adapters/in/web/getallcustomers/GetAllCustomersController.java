package dev.gabrieljbo.project.adapters.in.web.getallcustomers;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gabrieljbo.project.adapters.in.web.commons.model.Response;
import dev.gabrieljbo.project.core.ports.in.GetAllCustomersPort;
import dev.gabrieljbo.project.domain.model.Customer;

@RestController
class GetAllCustomersController {

	@Autowired
	GetAllCustomersPort getAllCustomersPort;

	@GetMapping(path = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<ResponsePayload>>> getAllCustomers() {
		/*
		 * BoundedMapper boundedMapper = Mappers.getMapper(BoundedMapper.class);
		 * 
		 * List<Customer> customerList = getAllCustomersPort.getAllCustomers();
		 * List<ResponsePayload> resourceEntityList =
		 * boundedMapper.customerToResourceEntity(customerList);
		 * 
		 */		
		Response<List<ResponsePayload>> response = new Response<>();
		response.setData(null);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
