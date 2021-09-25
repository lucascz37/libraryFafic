package br.com.edu.library.controller;

import br.com.edu.library.dto.DTO;
import br.com.edu.library.service.GenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class GenericController <T extends DTO<K>, K, Y> {
    private final GenericService<?, K, Y> service;

    public GenericController(GenericService<?, K, Y> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<K>> get(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<K> create(@RequestBody @Valid T body) {
        return ResponseEntity.ok(service.save(body.to()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO<K>> update(@RequestBody @Valid T body, @PathVariable @Valid Y id){
        K object = service.findById(id).orElse(null);
        if (object != null) {
            service.save(body.replace(object));
            return ResponseEntity.ok(body);
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @Valid Y id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
