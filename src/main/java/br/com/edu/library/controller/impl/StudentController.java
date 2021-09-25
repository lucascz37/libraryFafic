package br.com.edu.library.controller.impl;

import br.com.edu.library.controller.GenericUUIDController;
import br.com.edu.library.domain.Student;
import br.com.edu.library.dto.impl.StudentDTO;
import br.com.edu.library.service.impl.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController extends GenericUUIDController<StudentDTO, Student> {

    private final StudentService service;

    public StudentController(StudentService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping("/registration/{registration}")
    public ResponseEntity<Student> getByRegistration(@PathVariable String registration) {
        return ResponseEntity.ok(service.getByRegistration(registration));
    }
}
