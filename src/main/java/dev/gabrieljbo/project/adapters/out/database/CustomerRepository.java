package dev.gabrieljbo.project.adapters.out.database;

import java.util.List;

interface CustomerRepository {

    CustomerEntity save(CustomerEntity entity);

    List<CustomerEntity> findAll();

}