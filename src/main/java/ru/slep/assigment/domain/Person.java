package ru.slep.assigment.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Domain object for a person
 */
@Entity
public class Person {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name
     */
    private String name;

    /**
     * Age
     */
    private int age;

    /**
     * Different addresses of a person
     */
    @OneToMany(mappedBy = "person", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Address> addresses = new HashSet<>();

    /**
     * Default constructor
     */
    public Person() {

    }

    /**
     * Constructor
     *
     * @param name name
     * @param age  age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

}
