package com.zoox.sample.git.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Department")
public class Department {

    @Id
    @SequenceGenerator(name = "department_generator", sequenceName = "department_sequence", allocationSize = 1)
    @GeneratedValue(generator = "department_generator")
    private Long id;
    private String name;
    private String description;
    @Version
    private long version;
}
