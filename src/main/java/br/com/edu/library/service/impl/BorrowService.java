package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Book;
import br.com.edu.library.domain.Borrow;
import br.com.edu.library.domain.Collection;
import br.com.edu.library.repository.BorrowRepository;
import br.com.edu.library.repository.CollectionRepository;
import br.com.edu.library.repository.LibrarianRepository;
import br.com.edu.library.repository.PersonRepository;
import br.com.edu.library.service.GenericService;
import br.com.edu.library.utils.CollectionId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.UUID;

@Service
public class BorrowService extends GenericService<BorrowRepository, Borrow, UUID> {

    private final BorrowRepository repository;
    private final LibrarianRepository librarianRepository;
    private final PersonRepository personRepository;
    private final CollectionRepository collectionRepository;

    public BorrowService(BorrowRepository repository, LibrarianRepository librarianRepository, PersonRepository personRepository, CollectionRepository collectionRepository) {
        super(repository);
        this.repository = repository;
        this.librarianRepository = librarianRepository;
        this.personRepository = personRepository;
        this.collectionRepository = collectionRepository;
    }

    public List<Borrow> getByPersonId(UUID id) {
        return repository.findByPersonId(id);
    }

    public boolean canBorrow(UUID id) {
        return !librarianRepository.existsById(id) && personRepository.existsById(id);
    }

    @Transactional(rollbackFor = {PersistenceException.class})
    public Borrow save(Borrow borrow) {
        UUID libraryId = personRepository.getById(borrow.getPerson().getId()).getLibrary().getId();

        for (Book book : borrow.getBorrowedBooks()) {
            Collection collection = collectionRepository.getById(new CollectionId(libraryId, book.getId()));
            int newQuantity = collection.getQuantity() - 1;

            if(newQuantity < 0) {
                throw new PersistenceException("Collection book quantity cannot be below 0");
            }

            collection.setQuantity(newQuantity);
            collectionRepository.save(collection);
        }

        return repository.save(borrow);
    }
}
