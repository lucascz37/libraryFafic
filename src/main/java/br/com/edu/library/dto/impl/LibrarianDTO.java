package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Librarian;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibrarianDTO extends GenericDTO<Librarian>{

    public LibrarianDTO() {
        super(Librarian.class);
    }
}
