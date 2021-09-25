package br.com.edu.library.controller.impl;

import br.com.edu.library.controller.GenericUUIDController;
import br.com.edu.library.domain.Librarian;
import br.com.edu.library.dto.impl.LibrarianDTO;
import br.com.edu.library.service.impl.LibrarianService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/librarian")
public class LibrarianController extends GenericUUIDController<LibrarianDTO, Librarian> {

    public LibrarianController(LibrarianService service) {
        super(service);
    }
}
