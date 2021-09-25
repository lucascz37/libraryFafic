package br.com.edu.library.controller.impl;

import br.com.edu.library.controller.GenericController;
import br.com.edu.library.domain.Collection;
import br.com.edu.library.dto.impl.CollectionDTO;
import br.com.edu.library.service.impl.CollectionService;
import br.com.edu.library.utils.CollectionId;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/collection")
public class CollectionController extends GenericController<CollectionDTO, Collection, CollectionId> {

    private final CollectionService service;

    public CollectionController(CollectionService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Collection>> findBookQuantity(@PathVariable UUID bookId){
        return ResponseEntity.ok(service.getByBookId(bookId));
    }
}
