package br.com.edu.library.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class Contact {

    @Column(length = 254)
    @NotNull
    private String email;

    @Column(length = 15)
    @NotNull
    private String phone;
}
