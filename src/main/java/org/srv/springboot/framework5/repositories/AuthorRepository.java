package org.srv.springboot.framework5.repositories;

import org.srv.springboot.framework5.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
