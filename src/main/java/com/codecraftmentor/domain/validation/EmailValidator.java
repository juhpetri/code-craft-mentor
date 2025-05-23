package com.codecraftmentor.domain.validation;

import com.codecraftmentor.application.dto.ClienteDTO;
import com.codecraftmentor.domain.model.Email;

public class EmailValidator implements ClienteValidator {

    @Override
    public void validar(ClienteDTO dto) {
        Email.isValido(dto.email);
    }
}
