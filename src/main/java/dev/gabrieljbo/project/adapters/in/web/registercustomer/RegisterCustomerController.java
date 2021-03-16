package dev.gabrieljbo.project.adapters.in.web.registercustomer;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.gabrieljbo.project.adapters.in.web.commons.model.Request;
import dev.gabrieljbo.project.adapters.in.web.commons.model.Response;
import dev.gabrieljbo.project.core.ports.in.RegisterCustomerPort;
import dev.gabrieljbo.project.domain.model.Customer;

@RestController
class RegisterCustomerController {

    @Autowired
    RegisterCustomerPort registerCustomerPort;
    
    @PostMapping(path = "/api/customers")
	public ResponseEntity<Response<ResponsePayload>> registerCustomer(@RequestBody Request<RequestPayload> request) {
		BoundedMapper boundedMapper = Mappers.getMapper(BoundedMapper.class);

		Customer customer = boundedMapper.requestPayloadToCustomer(request.getData());
		registerCustomerPort.registerCustomer(customer);
		ResponsePayload responsePayload = boundedMapper.customerToResponsePayload(customer);

		Response<ResponsePayload> response = new Response<>();
		response.setData(responsePayload);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}