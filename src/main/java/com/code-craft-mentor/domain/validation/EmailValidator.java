package com.code.craft.mentor.domain.validation;

import com.code.craft.mentor.application.dto.ClienteDTO;
import com.code.craft.mentor.domain.model.Email;

public class EmailValidator implements ClienteValidator {

    @Override
    public void validar(ClienteDTO dto) {
        Email.isValido(dto.email);
    }
}
