package com.zoox.sample.git.service;

import com.zoox.sample.git.domain.Customer;
import com.zoox.sample.git.repository.CustomerRepository;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Set<Customer> findAllCustomers() {
        return StreamSupport.stream(
                customerRepository.findAll().spliterator(), false)
                        .sorted(Comparator.comparing(Customer::getFirstName)
                        .thenComparing(Customer::getLastName))
                        .collect(Collectors.toSet());
    }
}
