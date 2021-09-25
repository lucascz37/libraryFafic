package br.com.edu.library.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Library {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 100)
    @NotNull
    private String name;

    @Column(length = 100)
    @NotNull
    private String institution;
}
