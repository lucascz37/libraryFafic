package br.com.edu.library.domain;

import br.com.edu.library.utils.CollectionId;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@IdClass(CollectionId.class)
public class Collection {

    @Id
    @ManyToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Library library;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @NotNull
    private Integer quantity;

}
