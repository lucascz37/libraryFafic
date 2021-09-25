package br.com.edu.library.service.impl;

import br.com.edu.library.domain.Professor;
import br.com.edu.library.repository.ProfessorRepository;
import br.com.edu.library.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService extends GenericService<ProfessorRepository, Professor, UUID> {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Professor getByRegistration(String registration) {
        return repository.findByRegistration(registration);
    }

    public List<Professor> getByName(String name) {
        return repository.findByName(name);
    }
}
