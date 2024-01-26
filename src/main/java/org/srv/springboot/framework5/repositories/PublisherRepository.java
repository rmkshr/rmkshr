package org.srv.springboot.framework5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srv.springboot.framework5.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
