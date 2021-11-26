package br.com.edu.library.ControllerAndRepository.booktestes;
import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.controller.impl.BookController;
import br.com.edu.library.domain.Book;
import br.com.edu.library.dto.impl.BookDTO;
import br.com.edu.library.enumerators.BookField;
import br.com.edu.library.repository.BookRepository;
import br.com.edu.library.service.impl.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class BookDtoTest {

    @Autowired
    private BookController controller;

    @MockBean
    private BookService service;

    @Autowired
    private BookRepository repository;

    @Test
    public void testGetBook() throws Exception{
        BookDTO dto = new BookDTO();
        dto.setName("livro1");
        dto.setField(BookField.EXACT);
        dto.setIsbn("3C");

        Book resultado = dto.to();

        when(service.save(resultado)).thenReturn(repository.save(resultado));
        assertThat(controller.create(dto).getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}
