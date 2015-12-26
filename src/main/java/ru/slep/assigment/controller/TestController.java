package ru.slep.assigment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.slep.assigment.domain.Address;
import ru.slep.assigment.domain.Person;
import ru.slep.assigment.service.PersonService;

import java.util.List;

/**
 * REST operations with persons and their addresses
 */
@RequestMapping(value = "/rest/person")
@RestController
public class TestController {

    /**
     * Person service
     */
    @Autowired
    private PersonService personService;

    /**
     * Returns list of all persons in a system
     *
     * @return list of all persons
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Person> listPersons() {
        return personService.findAll();
    }

    /**
     * Returns specific person
     *
     * @param id person id
     * @return person with the specified id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return personService.get(id);
    }

    /**
     * Adds new person
     *
     * @param person new person data
     * @return created person
     */
    @RequestMapping(method = RequestMethod.POST)
    public Person add(@RequestBody Person person) {
        return personService.save(person);
    }

    /**
     * Adds address to a person
     *
     * @param address new address data
     * @return created person
     */
    @RequestMapping(value = "/{id}/addresses", method = RequestMethod.POST)
    public Address addAddress(@PathVariable Long id, @RequestBody Address address) {
        return personService.addAddress(personService.get(id), address);
    }
}
