package br.com.edu.library.repository;

import br.com.edu.library.domain.Book;
import br.com.edu.library.enumerators.BookField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    public Book findByIsbn(String Isbn);

    public List<Book> findByField(BookField field);

    public List<Book> findByName(String name);

}
