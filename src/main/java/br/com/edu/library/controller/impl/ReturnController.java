package br.com.edu.library.controller.impl;

import br.com.edu.library.controller.GenericUUIDController;
import br.com.edu.library.domain.Return;
import br.com.edu.library.dto.impl.ReturnDTO;
import br.com.edu.library.service.impl.ReturnService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/return")
public class ReturnController extends GenericUUIDController<ReturnDTO, Return> {

    private final ReturnService service;

    public ReturnController(ReturnService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<List<Return>> getByPersonId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getByPersonId(id));
    }

}
