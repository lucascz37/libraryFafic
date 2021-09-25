package br.com.edu.library.repository;

import br.com.edu.library.domain.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReturnRepository extends JpaRepository<Return, UUID> {

    public List<Return> findByBorrowPersonId(UUID id);
}
