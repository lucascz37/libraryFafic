package br.com.edu.library.controller.impl;

import br.com.edu.library.controller.GenericUUIDController;
import br.com.edu.library.domain.Book;
import br.com.edu.library.dto.impl.BookDTO;
import br.com.edu.library.enumerators.BookField;
import br.com.edu.library.service.impl.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/book")
public class BookController extends GenericUUIDController<BookDTO, Book> {

    private final BookService service;
    
    public BookController(BookService service) {
        super(service);
        this.service = service;
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Book>> getBooksByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping("/field/{fieldInt}")
    public ResponseEntity<List<Book>> getBooksByField(@PathVariable Integer fieldInt) {
        BookField field;
        try {
            field = BookField.getBookField(fieldInt);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.getByField(field));
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBooksByIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(service.getByIsbn(isbn));
    }

    
}
