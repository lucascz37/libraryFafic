package br.com.edu.library.ControllerAndRepository.booktestes;

import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Book;
import br.com.edu.library.domain.Library;
import br.com.edu.library.dto.impl.BookDTO;
import br.com.edu.library.dto.impl.LibraryDTO;
import br.com.edu.library.enumerators.BookField;
import br.com.edu.library.repository.BookRepository;
import br.com.edu.library.repository.LibraryRepository;
import br.com.edu.library.service.impl.BookService;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class BookDtoTests {

    @MockBean
    private BookService service;

    @Autowired
    private BookRepository repository;


    @Test
    public void testGetBook() throws Exception{
        BookDTO dto = new BookDTO();
        dto.setName("book2");
        dto.setField(BookField.EXACT);
        dto.setIsbn("4A");


        Book result = dto.to();

        when(service.save(result)).thenReturn(repository.save(result));
        assertThat(service.save(result).getName()).isEqualTo(result.getName());
        verify(service).save(result);



    }
}
