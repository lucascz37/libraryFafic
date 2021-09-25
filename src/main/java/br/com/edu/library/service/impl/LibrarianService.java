package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Librarian;
import br.com.edu.library.repository.LibrarianRepository;
import br.com.edu.library.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LibrarianService extends GenericService<LibrarianRepository, Librarian, UUID> {
    public LibrarianService(LibrarianRepository repository) {
        super(repository);
    }
}

