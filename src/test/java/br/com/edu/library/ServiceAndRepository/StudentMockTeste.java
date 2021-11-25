package br.com.edu.library.ServiceAndRepository;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Student;
import br.com.edu.library.repository.StudentRepository;
import br.com.edu.library.service.impl.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class StudentMockTeste {


    @Autowired
    private StudentService service;

    @MockBean
    private StudentRepository repository;

    @Test
    public void testCreateStudentMock() {
        Student aluno1 = new Student();

        when(repository.save(aluno1)).thenReturn(aluno1);
        assertThat(service.save(aluno1)).isEqualTo(aluno1);

    }
}
