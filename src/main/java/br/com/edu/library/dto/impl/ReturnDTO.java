package br.com.edu.library.dto.impl;

import br.com.edu.library.domain.Return;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ReturnDTO extends GenericDTO<Return>{

    private UUID borrowId;

    public ReturnDTO() {
        super(Return.class);
    }
}
