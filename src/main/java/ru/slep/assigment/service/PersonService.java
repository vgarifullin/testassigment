package ru.slep.assigment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.slep.assigment.dao.AddressDao;
import ru.slep.assigment.dao.PersonDao;
import ru.slep.assigment.domain.Address;
import ru.slep.assigment.domain.Person;

import java.util.List;

/**
 * Person service
 */
@Service
public class PersonService {

    /**
     * Person repository
     */
    @Autowired
    private PersonDao personDao;

    /**
     * Address repository
     */
    @Autowired
    private AddressDao addressDao;

    /**
     * Saves person to repository
     *
     * @param person person to save
     * @return saved person
     */
    @Transactional
    public Person save(final Person person) {
        return personDao.save(person);
    }

    /**
     * Returns list of all persons
     *
     * @return list of all persons
     */
    public List<Person> findAll() {
        return personDao.findAll();
    }

    /**
     * Returns person with the specified id
     *
     * @param id person id
     * @return person
     */
    public Person get(Long id) {
        return personDao.findOne(id);
    }

    /**
     * Adds address to a person
     *
     * @param person  person
     * @param address address to add
     */
    public Address addAddress(Person person, Address address) {
        address.setPerson(person);
        return addressDao.save(address);
    }
}
