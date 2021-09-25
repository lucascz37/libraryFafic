package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Book;
import br.com.edu.library.enumerators.BookField;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO extends GenericDTO<Book>{

    private String isbn;

    private String name;

    private BookField field;

    public BookDTO() {
        super(Book.class);
    }
}
