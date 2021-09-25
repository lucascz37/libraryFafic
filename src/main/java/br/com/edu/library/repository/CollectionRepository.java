package br.com.edu.library.repository;

import br.com.edu.library.domain.Collection;
import br.com.edu.library.utils.CollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, CollectionId> {

    public List<Collection> findByBookId(UUID id);
}
