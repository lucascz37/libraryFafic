package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Borrow;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BorrowDTO extends GenericDTO<Borrow>{

    private UUID personId;

    private List<BorrowedBooksDTO> borrowedBooks;

    public BorrowDTO() {
        super(Borrow.class);
    }
}
