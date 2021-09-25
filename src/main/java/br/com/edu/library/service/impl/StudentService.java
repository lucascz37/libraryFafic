package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Student;
import br.com.edu.library.repository.StudentRepository;
import br.com.edu.library.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class StudentService extends GenericService<StudentRepository, Student, UUID> {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Student getByRegistration(String registration) {
        return repository.findByRegistration(registration);
    }

    public List<Student> getByName(String name) {
        return repository.findByName(name);
    }
}
