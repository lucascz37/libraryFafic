package br.com.edu.library.controller.impl;


import br.com.edu.library.controller.GenericUUIDController;
import br.com.edu.library.domain.Borrow;
import br.com.edu.library.dto.impl.BorrowDTO;
import br.com.edu.library.service.impl.BorrowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/borrow")
public class BorrowController extends GenericUUIDController<BorrowDTO, Borrow> {

    public final BorrowService service;

    public BorrowController(BorrowService service) {
        super(service);
        this.service = service;
    }

    @Override
    public ResponseEntity<Borrow> create(@RequestBody @Valid BorrowDTO body) {

        if(service.canBorrow(body.getPersonId())) {
            Borrow response = service.save(body.to());
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

    @GetMapping("/person/{id}")
    public ResponseEntity<List<Borrow>> getByPersonId(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getByPersonId(id));
    }
}
