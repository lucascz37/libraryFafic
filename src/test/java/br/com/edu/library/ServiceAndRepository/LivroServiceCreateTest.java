package br.com.edu.library.ServiceAndRepository;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Book;
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
public class LivroServiceCreateTest {

    @Autowired
    private BookService service;

    private static UUID idLivro;

    @Autowired
    private LibraryService libraryService;

    @Order(1)
    @Test
    public void testCreate() throws Exception{
        Book livro1 = new Book();


        livro1.setIsbn("1H");
        livro1.setName("Testes");
        livro1.setField(BookField.EXACT);

        Book resultado = service.save(livro1);
        idLivro = resultado.getId();


        assertThat(resultado.getName()).isEqualTo(livro1.getName());


    }

    @Order(2)
    @Test
    public void testDelete() throws Exception{

        assertThat(service.deleteById(idLivro)).isTrue();

    }


}
