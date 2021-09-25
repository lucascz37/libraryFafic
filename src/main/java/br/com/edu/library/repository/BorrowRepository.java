package br.com.edu.library.repository;

import br.com.edu.library.domain.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, UUID> {

    public List<Borrow> findByPersonId(UUID id);
}
