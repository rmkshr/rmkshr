package org.srv.springboot.framework5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.srv.springboot.framework5.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
