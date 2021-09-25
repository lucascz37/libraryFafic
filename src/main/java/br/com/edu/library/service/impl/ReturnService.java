package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Book;
import br.com.edu.library.domain.Borrow;
import br.com.edu.library.domain.Collection;
import br.com.edu.library.domain.Return;
import br.com.edu.library.repository.BorrowRepository;
import br.com.edu.library.repository.CollectionRepository;
import br.com.edu.library.repository.ReturnRepository;
import br.com.edu.library.service.GenericService;
import br.com.edu.library.utils.CollectionId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;

@Service
public class ReturnService extends GenericService<ReturnRepository, Return, UUID> {

    private final ReturnRepository repository;
    private final BorrowRepository borrowRepository;
    private final CollectionRepository collectionRepository;

    public ReturnService(ReturnRepository repository, BorrowRepository borrowRepository, CollectionRepository collectionRepository) {
        super(repository);
        this.repository = repository;
        this.borrowRepository = borrowRepository;
        this.collectionRepository = collectionRepository;
    }

    public List<Return> getByPersonId(UUID id){
        return repository.findByBorrowPersonId(id);
    }

    @Transactional(rollbackFor = {PersistenceException.class})
    public Return save(Return r) {
        Borrow borrow = borrowRepository.getById(r.getBorrow().getId());
        UUID libraryId = borrow.getPerson().getLibrary().getId();

        for(Book book : borrow.getBorrowedBooks()) {
            Collection collection = collectionRepository.getById(new CollectionId(libraryId, book.getId()));
            collection.setQuantity(collection.getQuantity() + 1);

            collectionRepository.save(collection);
        }

        return repository.save(r);
    }

}
