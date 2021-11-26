package br.com.edu.library.ControllerAndRepository.libraryTestes;

import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.controller.impl.LibraryController;
import br.com.edu.library.domain.Library;
import br.com.edu.library.dto.impl.LibraryDTO;
import br.com.edu.library.repository.LibraryRepository;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class TestLibrary {
    @Autowired
    private LibraryController controller;

    @MockBean
    private LibraryService service;

    @Autowired
    private LibraryRepository repository;

    @Test
    public void testGetLibrary() throws Exception{
        LibraryDTO dto = new LibraryDTO();
        dto.setName("Teste");
        dto.setInstitution("Faficc");
        Library resultado = dto.to();

        when(service.save(resultado)).thenReturn(repository.save(resultado));
        assertThat(service.save(resultado).getName()).isEqualTo(resultado.getName());
        verify(service).save(resultado);
    }
}
