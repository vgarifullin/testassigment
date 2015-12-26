package ru.slep.assigment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import ru.slep.assigment.domain.Address;
import ru.slep.assigment.domain.Person;
import ru.slep.assigment.service.PersonService;

import javax.annotation.PostConstruct;

/**
 * Application entry point
 */
@ComponentScan
@EnableAutoConfiguration
public class TestAssigmentApplication {

    /**
     * Person service
     */
    @Autowired
    private PersonService personService;

    /**
     * Starts application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(TestAssigmentApplication.class, args);
    }

    /**
     * Adds test data to DB
     */
    @PostConstruct
    public void init() {
        Person person = new Person("Ivan", 25);
        personService.save(person);
        personService.addAddress(person, new Address("10a", "Lenina", "Moscow"));
        personService.addAddress(person, new Address("38", "Vershinina", "Tomsk"));
        person = new Person("Svetlana", 39);
        personService.save(person);
        personService.addAddress(person, new Address("54", "Usacheva", "Barnaul"));
    }
}
