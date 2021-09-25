package br.com.edu.library.domain;

import br.com.edu.library.enumerators.Gender;
import br.com.edu.library.utils.Address;
import br.com.edu.library.utils.Contact;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 100)
    @NotNull
    private String name;

    @Column(length = 11, unique = true)
    @NotNull
    private String cpf;

    @NotNull
    private Gender gender;

    @Column(length = 6, unique = true)
    @NotNull
    private String registration;

    @Valid
    @NotNull
    private Address address;

    @Valid
    @NotNull
    private Contact contact;

    @Column(length = 25)
    @NotNull
    private String password;

    @NotNull
    @OneToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Library library;
}
