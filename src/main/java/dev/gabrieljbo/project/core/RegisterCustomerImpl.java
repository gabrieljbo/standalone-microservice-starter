package dev.gabrieljbo.project.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import dev.gabrieljbo.project.core.ports.in.RegisterCustomerPort;
import dev.gabrieljbo.project.core.ports.out.CustomerDataStorePort;
import dev.gabrieljbo.project.domain.model.Customer;

@Component
@Validated
public class RegisterCustomerImpl implements RegisterCustomerPort {

	@Autowired
	private CustomerDataStorePort customerDataStorePort;

	@Override
	public String registerCustomer(Customer customer) {
		Customer savedCustomer = customerDataStorePort.save(customer);
		
		return String.valueOf(savedCustomer.getId());
	}

}
