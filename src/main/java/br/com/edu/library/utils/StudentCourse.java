package br.com.edu.library.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class StudentCourse {

    @Column(length = 50)
    @NotNull
    private String name;

    @NotNull
    @Min(1)
    @Max(8)
    private int semester;
}
