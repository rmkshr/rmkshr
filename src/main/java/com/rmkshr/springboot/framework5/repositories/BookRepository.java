package com.rmkshr.springboot.framework5.repositories;

import com.rmkshr.springboot.framework5.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
