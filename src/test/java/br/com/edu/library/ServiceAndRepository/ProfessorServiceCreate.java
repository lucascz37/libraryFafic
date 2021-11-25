package br.com.edu.library.ServiceAndRepository;


import br.com.edu.library.LibraryManagerApplication;
import br.com.edu.library.domain.Library;
import br.com.edu.library.domain.Professor;
import br.com.edu.library.enumerators.Gender;
import br.com.edu.library.service.impl.LibraryService;
import br.com.edu.library.service.impl.ProfessorService;
import br.com.edu.library.utils.Address;
import br.com.edu.library.utils.Contact;
import br.com.edu.library.utils.TeacherCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = LibraryManagerApplication.class)
public class ProfessorServiceCreate {

    @Autowired
    private ProfessorService service;

    @Autowired
    private LibraryService libraryService;

    @Test
    public void testCreate() throws Exception{
        Professor professor1 = new Professor();
        Library library = new Library();
        library.setName("FaficBiblio");
        library.setInstitution("Fafic");

        library = libraryService.save(library);

        Address address = new Address();
        TeacherCourse teacherCourse = new TeacherCourse();

        Contact contact = new Contact();

        contact.setEmail("ana@gmail.com");
        contact.setPhone("8399999");

        teacherCourse.setName("Teste1");
        teacherCourse.setField("Exatas");
        address.setUf("PB");
        address.setNumber("13");
        address.setDistrict("Cajazeiras");
        address.setStreet("Rua1");
        professor1.setName("Ana");
        professor1.setCpf("1234");
        professor1.setGender(Gender.FEMALE);
        professor1.setAddress(address);
        professor1.setPassword("ana12");
        professor1.setTeacherCourse(teacherCourse);
        professor1.setRegistration("123");
        professor1.setLibrary(library);
        professor1.setContact(contact);

        Professor resultado = service.save(professor1);

        assertThat(resultado.getName()).isEqualTo(professor1.getName());
    }
}
