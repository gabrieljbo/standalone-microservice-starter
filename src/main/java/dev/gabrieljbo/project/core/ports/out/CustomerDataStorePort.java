package dev.gabrieljbo.project.core.ports.out;

import java.util.List;

import dev.gabrieljbo.project.domain.model.Customer;

public interface CustomerDataStorePort {
	
    Customer save(Customer customer);

    List<Customer> findAll();
    
}