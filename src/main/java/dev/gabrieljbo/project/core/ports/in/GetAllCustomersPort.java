package dev.gabrieljbo.project.core.ports.in;

import java.util.List;

import dev.gabrieljbo.project.domain.model.Customer;

public interface GetAllCustomersPort {
	
    public List<Customer> getAllCustomers();

}