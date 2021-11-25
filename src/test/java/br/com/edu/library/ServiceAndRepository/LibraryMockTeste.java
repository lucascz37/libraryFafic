package br.com.edu.library.ServiceAndRepository;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Library;
import br.com.edu.library.dto.impl.LibraryDTO;
import br.com.edu.library.repository.LibraryRepository;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class LibraryMockTeste {

    @MockBean
    private LibraryService service;

    @Autowired
    private LibraryRepository repository;


    @Test
    public void testGetLibrary() throws Exception{
        LibraryDTO dto = new LibraryDTO();
        dto.setName("Fafic");
        dto.setInstitution("FAFIC");

        Library result = dto.to();

        when(service.save(result)).thenReturn(repository.save(result));

        assertThat(service.save(result).getName()).isEqualTo(result.getName());

        verify(service).save(result);



    }
}
