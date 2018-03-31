package com.zoox.sample.git.controller;

import com.zoox.sample.git.domain.Customer;
import com.zoox.sample.git.repository.CustomerRepository;
import com.zoox.sample.git.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RequestMapping(value = "/customers")
@RestController
public class CustomerController {

    @Resource
    private CustomerRepository customerRepository;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
}
