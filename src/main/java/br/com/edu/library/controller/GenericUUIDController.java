package br.com.edu.library.controller;

import br.com.edu.library.dto.DTO;
import br.com.edu.library.service.GenericService;

import java.util.UUID;

public abstract class GenericUUIDController<T extends DTO<K>, K> extends GenericController<T, K, UUID> {

    public GenericUUIDController(GenericService<?, K, UUID> service) {
        super(service);
    }
}
