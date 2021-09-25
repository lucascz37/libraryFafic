package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Library;
import br.com.edu.library.repository.LibraryRepository;
import br.com.edu.library.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LibraryService extends GenericService<LibraryRepository, Library, UUID> {

    public LibraryService(LibraryRepository repository) {
        super(repository);
    }
}
