package br.com.edu.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Borrow {

    @Id
    @GeneratedValue
    private UUID id;

    @CreationTimestamp
    private LocalDate createdOn;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @NotNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Person person;

    @NotNull
    @ManyToMany
    @JoinTable(name = "borrowed_books",
    joinColumns = @JoinColumn(name = "borrow_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> borrowedBooks;
}
