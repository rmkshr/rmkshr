package com.rmkshr.springboot.framework5.repositories;

import com.rmkshr.springboot.framework5.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
