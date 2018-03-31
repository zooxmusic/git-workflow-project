package com.zoox.sample.git.integration;

import com.zoox.sample.git.domain.Customer;
import com.zoox.sample.git.integration.annotation.Steps;
import com.zoox.sample.git.repository.CustomerRepository;

import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.Assert.assertNotNull;



@Steps
public class FindAllCustomersSteps extends AbstractSteps {

    private final CustomerRepository customerRepository;

    @Autowired
    public FindAllCustomersSteps(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @BeforeStories
    public void beforeStories() {
        //log.debug("beforeStories");
    }

    @AfterStories
    public void afterStories() {
        //log.debug("afterStories");
    }

    @Given("a customer with the first name of $firstName and a last name of $lastName")
    public void aCustomerWillBeAdded(@Named("firstName") String firstName, @Named("lastName") String lastName) {
        Customer customer = new Customer(firstName, lastName);
        Customer savedCustomer = customerRepository.save(customer);
        assertValid(savedCustomer);
    }

    @Then("a valid customer is created with the last name of $lastName")
    public void successfulCustomerCreated(@Named("lastName") String lastName) {

        Customer customer = customerRepository.findByLastName(lastName)
                .stream()
                .findFirst()
                .get();


        assertValid(customer);

    }

    private void assertValid(Customer customer) {
        assertNotNull(customer);
        Optional<Long> id = Optional.of(customer.getId());
        assertNotNull(id.get());
    }

}
