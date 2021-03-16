package dev.gabrieljbo.project.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.gabrieljbo.project.core.ports.in.GetAllCustomersPort;
import dev.gabrieljbo.project.core.ports.out.CustomerDataStorePort;
import dev.gabrieljbo.project.domain.model.Customer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
class GetAllCustomersImpl implements GetAllCustomersPort {

	@Autowired
	private CustomerDataStorePort customerDataStorePort;

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerDataStorePort.findAll();

		log.info("Customer list retrieved on UseCase!");

		return customerList;
	}

}