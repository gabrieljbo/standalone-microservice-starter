package dev.gabrieljbo.project.core.ports.in;

import javax.validation.Valid;

import dev.gabrieljbo.project.domain.model.Customer;

public interface RegisterCustomerPort {
	
	public String registerCustomer(@Valid Customer customer);

}
