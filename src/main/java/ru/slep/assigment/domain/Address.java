package ru.slep.assigment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Domain object for an address
 */
@Entity
public class Address {

    /**
     * Unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Parent person
     */
    @ManyToOne
    private Person person;

    /**
     * House
     */
    private String houseNumber;

    /**
     * Street
     */
    private String streetName;

    /**
     * City
     */
    private String city;

    /**
     * Default constructor
     */
    public Address() {

    }

    /**
     * Constructor
     */
    public Address(String houseNumber, String streetName, String city) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    @JsonIgnore
    public Person getPerson() {
        return person;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
