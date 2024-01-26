package org.srv.springboot.framework5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srv.springboot.framework5.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
