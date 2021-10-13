package com.rmkshr.springboot.framework5.repositories;

import com.rmkshr.springboot.framework5.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
