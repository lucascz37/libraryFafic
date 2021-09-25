package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Book;
import br.com.edu.library.enumerators.BookField;
import br.com.edu.library.repository.BookRepository;
import br.com.edu.library.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService extends GenericService<BookRepository, Book, UUID> {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Book getByIsbn(String isbn) {
        return repository.findByIsbn(isbn);
    }

    public List<Book> getByName(String name) {
        return repository.findByName(name);
    }

    public List<Book> getByField(BookField field) {
        return repository.findByField(field);
    }

}
