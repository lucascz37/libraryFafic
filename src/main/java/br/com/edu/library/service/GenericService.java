package br.com.edu.library.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class GenericService <T extends JpaRepository<K, Y>, K, Y> {

    private final T repository;

    public GenericService(T repository) {
        this.repository = repository;
    }

    public K save(K k) {
        return repository.save(k);
    }

    public List<K> findAll(){
        return repository.findAll();
    }

    public Optional<K> findById(Y id) {
        return repository.findById(id);
    }

    public boolean deleteById(Y id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }

    }

}
