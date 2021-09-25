package br.com.edu.library.domain;

import br.com.edu.library.utils.TeacherCourse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Professor extends Person {

    @Valid
    @NotNull
    private TeacherCourse teacherCourse;

}
