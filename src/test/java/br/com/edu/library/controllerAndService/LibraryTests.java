package br.com.edu.library.controllerAndService;

import br.com.edu.library.controller.impl.LibraryController;
import br.com.edu.library.domain.Library;
import br.com.edu.library.dto.impl.LibraryDTO;
import br.com.edu.library.repository.LibraryRepository;
import br.com.edu.library.service.impl.LibraryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LibraryTests {

    @Autowired
    private LibraryController libraryController;

    @Autowired
    private LibraryService libraryService;

    @MockBean
    private LibraryRepository libraryRepository;


    @Test
    void testGet(){
        Library library = new Library();

        library.setId(UUID.fromString("21b89928-e0b1-4b5c-81a8-4fded9d31df1"));
        library.setName("Biblioteca Central");
        library.setInstitution("FAFIC");

        when(libraryRepository.findAll()).thenReturn(Collections.singletonList(library));

        assertThat(libraryController.get().getStatusCode()).isEqualTo(HttpStatus.OK);

        Mockito.verify(libraryRepository, times(1)).findAll();
    }

    @Test
    void testCreate() throws Exception{
        //Setando dados e mock
        LibraryDTO dto = new LibraryDTO();

        dto.setName("Biblioteca Central");
        dto.setInstitution("FAFIC");

        Library result = dto.to();
        result.setId(UUID.fromString("21b89928-e0b1-4b5c-81a8-4fded9d31df1"));

        when(libraryRepository.save(dto.to())).thenReturn(result);

        assertThat(libraryController.create(dto).getStatusCode()).isEqualTo(HttpStatus.OK);

        Mockito.verify(libraryRepository).save(dto.to());
    }

    @Test
    void testDelete(){
        String id = "21b89928-e0b1-4b5c-81a8-4fded9d31df1";

        assertThat(libraryController.delete(UUID.fromString(id)).getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }
}
