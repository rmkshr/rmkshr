package org.srv.springboot.framework5.repositories;

import org.srv.springboot.framework5.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
