package org.srv.springboot.framework5.repositories;

import org.srv.springboot.framework5.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
