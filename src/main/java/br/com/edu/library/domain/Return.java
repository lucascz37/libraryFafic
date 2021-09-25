package br.com.edu.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Return {

    @Id
    private UUID id;

    @CreationTimestamp
    private LocalDate createdOn;

    @OneToOne
    @MapsId
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Borrow borrow;
}
