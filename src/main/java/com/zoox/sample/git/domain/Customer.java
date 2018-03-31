package com.zoox.sample.git.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Entity
@ToString
@NoArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(generator = "customer_generator")
    private Long id;

    private String firstName;
    private String lastName;
    private String description;

    @OneToOne
    private Department department;

    @Version
    private long version;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

