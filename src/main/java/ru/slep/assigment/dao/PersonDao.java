package ru.slep.assigment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slep.assigment.domain.Person;

/**
 * Person repository
 */
public interface PersonDao extends JpaRepository<Person, Long> {
}
