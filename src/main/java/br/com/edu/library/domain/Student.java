package br.com.edu.library.domain;

import br.com.edu.library.utils.StudentCourse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Student extends Person {

    @Valid
    @NotNull
    private StudentCourse studentCourse;
}
