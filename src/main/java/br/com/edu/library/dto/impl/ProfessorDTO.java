package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Professor;
import br.com.edu.library.utils.TeacherCourse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO extends PersonDTO<Professor>{

    private TeacherCourse teacherCourse;

    public ProfessorDTO() {
        super(Professor.class);
    }
}
