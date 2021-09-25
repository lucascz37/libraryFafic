package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Person;
import br.com.edu.library.enumerators.Gender;
import br.com.edu.library.utils.Address;
import br.com.edu.library.utils.Contact;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class PersonDTO<T extends Person> extends GenericDTO<T> {

    private String name;

    private String cpf;

    private Gender gender;

    private String registration;

    private Address address;

    private Contact contact;

    private String password;

    private UUID libraryId;

    public PersonDTO(Class<T> tClass) {
        super(tClass);
    }
}
