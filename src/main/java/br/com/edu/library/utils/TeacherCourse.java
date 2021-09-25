package br.com.edu.library.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class TeacherCourse {

    @Column(length = 50)
    @NotNull
    private String name;

    @Column(length = 100)
    @NotNull
    private String field;
}
