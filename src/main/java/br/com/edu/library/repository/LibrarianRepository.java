package br.com.edu.library.repository;

import br.com.edu.library.domain.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, UUID> {
}
