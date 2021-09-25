package br.com.edu.library.controller.impl;

import br.com.edu.library.controller.GenericUUIDController;
import br.com.edu.library.domain.Professor;
import br.com.edu.library.dto.impl.ProfessorDTO;
import br.com.edu.library.service.impl.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController extends GenericUUIDController<ProfessorDTO, Professor> {


    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Professor>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping("/registration/{registration}")
    public ResponseEntity<Professor> getByRegistration(@PathVariable String registration) {
        return ResponseEntity.ok(service.getByRegistration(registration));
    }
}
