package dev.gabrieljbo.project.adapters.out.database;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.gabrieljbo.project.domain.model.Customer;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoundedMapper {

    Customer customerEntityToCustomer(CustomerEntity customerEntity);

    List<Customer> customerEntityToCustomer(List<CustomerEntity> customerEntityList);

    CustomerEntity customerToCustomerEntity(Customer customer);

}