package br.com.edu.library.controllerAndService;

import br.com.edu.library.controller.impl.LibraryController;
import br.com.edu.library.domain.Library;
import br.com.edu.library.dto.impl.LibraryDTO;
import br.com.edu.library.service.impl.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LibraryController.class)
public class LibraryMockTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LibraryController libraryController;

    @MockBean
    private LibraryService libraryService;


    @Test
    void testGet() throws Exception{
        Library library = new Library();

        library.setId(UUID.fromString("21b89928-e0b1-4b5c-81a8-4fded9d31df1"));
        library.setName("Biblioteca Central");
        library.setInstitution("FAFIC");

        when(libraryService.findAll()).thenReturn(Collections.singletonList(library));

        mvc.perform(get("/library"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].id").value(library.getId().toString()))
                    .andExpect(jsonPath("$[0].name").value(library.getName()))
                    .andExpect(jsonPath("$[0].institution").value(library.getInstitution()));

        Mockito.verify(libraryService, times(1)).findAll();
    }

    @Test
    void testCreate() throws Exception{
        //Setando dados e mock
        LibraryDTO dto = new LibraryDTO();

        dto.setName("Biblioteca Central");
        dto.setInstitution("FAFIC");

        Library result = dto.to();
        result.setId(UUID.fromString("21b89928-e0b1-4b5c-81a8-4fded9d31df1"));

        when(libraryService.save(dto.to())).thenReturn(result);

        mvc.perform(post("/library")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("21b89928-e0b1-4b5c-81a8-4fded9d31df1"))
                .andExpect(jsonPath("$.name").value(dto.getName()))
                .andExpect(jsonPath("$.institution").value(dto.getInstitution()));

        Mockito.verify(libraryService).save(dto.to());
    }

    @Test
    void testDelete() throws Exception{
        String id = "21b89928-e0b1-4b5c-81a8-4fded9d31df1";

        when(libraryService.deleteById(UUID.fromString(id))).thenReturn(true);

        mvc.perform(delete("/library/{id}", id)
                .contentType("application/json"))
                .andExpect(status().isNoContent());

        Mockito.verify(libraryService).deleteById(UUID.fromString(id));
    }
}
