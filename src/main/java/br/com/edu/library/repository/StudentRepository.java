package br.com.edu.library.repository;

import br.com.edu.library.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    public Student findByRegistration(String registration);

    public List<Student> findByName(String name);
}
