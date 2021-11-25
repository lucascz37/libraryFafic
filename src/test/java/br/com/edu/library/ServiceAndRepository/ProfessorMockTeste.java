package br.com.edu.library.ServiceAndRepository;
import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Professor;
import br.com.edu.library.repository.ProfessorRepository;
import br.com.edu.library.service.impl.ProfessorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = LibraryManagerApplication.class)
public class ProfessorMockTeste {

    @Autowired
    private ProfessorService service;

    @MockBean
    private ProfessorRepository repository;


    @Test
    public void testCreateProfessorMock() {
        Professor professor1 = new Professor();

        when(repository.save(professor1)).thenReturn(professor1);
        assertThat(service.save(professor1)).isEqualTo(professor1);

    }


}
