package br.com.edu.library.domain;

import br.com.edu.library.enumerators.BookField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 13, unique = true)
    private String isbn;

    @Column(length = 100)
    @NotBlank
    private String name;

    @NotNull
    private BookField field;
}
