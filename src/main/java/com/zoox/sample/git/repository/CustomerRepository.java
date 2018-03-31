package com.zoox.sample.git.repository;

import java.util.List;

import com.zoox.sample.git.domain.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
