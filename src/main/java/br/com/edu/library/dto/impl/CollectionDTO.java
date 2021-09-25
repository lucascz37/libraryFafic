package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Collection;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CollectionDTO extends GenericDTO<Collection>{

    private UUID libraryId;

    private UUID bookId;

    private Integer quantity;

    public CollectionDTO() {
        super(Collection.class);
    }
}
