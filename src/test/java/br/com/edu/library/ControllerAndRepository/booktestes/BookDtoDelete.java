package br.com.edu.library.ControllerAndRepository.booktestes;

import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Book;
import br.com.edu.library.dto.impl.BookDTO;
import br.com.edu.library.enumerators.BookField;
import br.com.edu.library.service.impl.BookService;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class BookDtoDelete {

    @Autowired
    private BookService service;

    private static UUID bookId;

    @Autowired
    private LibraryService libraryService;

    @Order(1)
    @Test
    public void testCreateBookDto() throws Exception{
        BookDTO dto = new BookDTO();


        dto.setIsbn("4G");
        dto.setName("Testes");
        dto.setField(BookField.EXACT);

        Book result = service.save(dto.to());
        bookId = result.getId();


        assertThat(result.getName()).isEqualTo(dto.getName());



    }

    @Order(2)
    @Test
    public void testDeleteDto() throws Exception{

        assertThat(service.deleteById(bookId)).isTrue();

    }


}
