package ServiceAndRepository;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Book;
import br.com.edu.library.repository.BookRepository;
import br.com.edu.library.service.impl.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class LivroMockTeste {

    @Autowired
    private BookService service;

    @MockBean
    private BookRepository repository;


    @Test
    public void testCreateProfessorMock() {
        Book livro1 = new Book();

        when(repository.save(livro1)).thenReturn(livro1);
        assertThat(service.save(livro1)).isEqualTo(livro1);

    }
}
