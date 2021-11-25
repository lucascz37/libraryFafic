package br.com.edu.library.ServiceAndRepository;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Library;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class LibraryServiceCreate {

 //sem mock

    @Autowired
    private LibraryService libraryService;

    @Test
    public void testCreate() throws Exception{
        Library livraria = new Library();

        livraria.setName("Biblioteca Fafic");
        livraria.setInstitution("Fafics");

        Library resultado = libraryService.save(livraria);

        assertThat(resultado.getName()).isEqualTo(livraria.getName());
    }
}
