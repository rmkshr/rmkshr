package org.srv.springboot.framework5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srv.springboot.framework5.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
