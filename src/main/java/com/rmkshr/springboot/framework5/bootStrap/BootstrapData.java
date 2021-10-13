package com.rmkshr.springboot.framework5.bootStrap;

import com.rmkshr.springboot.framework5.domain.Address;
import com.rmkshr.springboot.framework5.domain.Author;
import com.rmkshr.springboot.framework5.domain.Book;
import com.rmkshr.springboot.framework5.domain.Publisher;
import com.rmkshr.springboot.framework5.repositories.AddressRepository;
import com.rmkshr.springboot.framework5.repositories.AuthorRepository;
import com.rmkshr.springboot.framework5.repositories.BookRepository;
import com.rmkshr.springboot.framework5.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository,AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author author = new Author("Thiru", "Valluvar");
        Book book = new Book("Thirukkural", "334875");
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book jb = new Book("J2EE", "55478");
        rod.getBooks().add(jb);
        jb.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(jb);

        System.out.println("Total Books : " + bookRepository.count());

        Address address = new Address("5th Ave", "LA", "California",  90005);
        Publisher publisher = new Publisher("Higgingbothams");
        publisher.setAddress(address);
        addressRepository.save(address);
        publisherRepository.save(publisher);

        System.out.println(publisherRepository.findAll().toString());
    }
}
