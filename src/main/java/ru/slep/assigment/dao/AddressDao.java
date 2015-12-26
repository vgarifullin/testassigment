package ru.slep.assigment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slep.assigment.domain.Address;

/**
 * Address repository
 */
public interface AddressDao extends JpaRepository<Address, Long> {
}
