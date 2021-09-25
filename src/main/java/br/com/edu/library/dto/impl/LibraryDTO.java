package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Library;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class LibraryDTO extends GenericDTO<Library> {

    public LibraryDTO(){
        super(Library.class);
    }

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 100)
    private String institution;

}
