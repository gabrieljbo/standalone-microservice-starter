package dev.gabrieljbo.project.adapters.out.database;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.gabrieljbo.project.core.ports.out.CustomerDataStorePort;
import dev.gabrieljbo.project.domain.model.Customer;

@Component
class CustomerDataStoreImpl implements CustomerDataStorePort {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		BoundedMapper boundedMapper = Mappers.getMapper(BoundedMapper.class);

		CustomerEntity newCustomerEntity = boundedMapper.customerToCustomerEntity(customer);
		CustomerEntity savedCustomerEntity = customerRepository.save(newCustomerEntity);
		Customer savedCustomer = boundedMapper.customerEntityToCustomer(savedCustomerEntity);

		return savedCustomer;
	}

	@Override
	public List<Customer> findAll() {
		BoundedMapper boundedMapper = Mappers.getMapper(BoundedMapper.class);

		List<CustomerEntity> customerEntityList = customerRepository.findAll();
		List<Customer> customerList = boundedMapper.customerEntityToCustomer(customerEntityList);

		return customerList;
	}

}