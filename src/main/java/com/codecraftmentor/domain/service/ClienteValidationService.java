package com.codecraftmentor.domain.service;

import com.codecraftmentor.application.dto.ClienteDTO;
import com.codecraftmentor.domain.validation.ClienteValidator;
import com.codecraftmentor.domain.validation.DocumentoValidator;
import com.codecraftmentor.domain.validation.EmailValidator;
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
