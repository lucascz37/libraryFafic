package br.com.edu.library.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@Embeddable
public class Address {

    @Column(length = 150)
    @NotNull
    private String street;

    @Column(length = 150)
    @NotNull
    private String district;

    @Column(length = 10)
    private String number;

    @Column(length = 2)
    private String uf;
}
