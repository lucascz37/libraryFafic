package ServiceAndRepository;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Book;
import br.com.edu.library.enumerators.BookField;
import br.com.edu.library.service.impl.BookService;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class LivroServiceCreate {

    @Autowired
    private BookService service;

    @Autowired
    private LibraryService libraryService;

    @Test
    public void testCreate() throws Exception{
        Book livro1 = new Book();


        livro1.setIsbn("1B");
        livro1.setName("O menino");
        livro1.setField(BookField.HUMAN);



        Book resultado = service.save(livro1);

        assertThat(resultado.getName()).isEqualTo(livro1.getName());
    }
}
