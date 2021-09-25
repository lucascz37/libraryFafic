package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Student;
import br.com.edu.library.utils.StudentCourse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO extends PersonDTO<Student> {

    private StudentCourse studentCourse;

    public StudentDTO() {
        super(Student.class);
    }
}
