package com.code.craft.mentor.domain.service;

import com.code.craft.mentor.application.dto.ClienteDTO;
import com.code.craft.mentor.domain.validation.ClienteValidator;
import com.code.craft.mentor.domain.validation.DocumentoValidator;
import com.code.craft.mentor.domain.validation.EmailValidator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteValidationService {
    private final List<ClienteValidator> clienteValidators;

    public ClienteValidationService() {
        this.clienteValidators = List.of(new EmailValidator(), new DocumentoValidator());
    }

    public void validar(ClienteDTO clienteDTO) {
        for (ClienteValidator validator : clienteValidators) {
            validator.validar(clienteDTO);
        }
    }
}
