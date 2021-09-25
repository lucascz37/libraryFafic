package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Collection;
import br.com.edu.library.repository.CollectionRepository;
import br.com.edu.library.service.GenericService;
import br.com.edu.library.utils.CollectionId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CollectionService extends GenericService<CollectionRepository, Collection, CollectionId> {

    private final CollectionRepository repository;

    public CollectionService(CollectionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Collection> getByBookId(UUID id) {
        return repository.findByBookId(id);
    }
}
