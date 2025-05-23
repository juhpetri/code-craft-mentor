package com.codecraftmentor.domain.validation;

import com.codecraftmentor.application.dto.ClienteDTO;
import com.codecraftmentor.domain.model.Documento;

public class DocumentoValidator implements ClienteValidator {
    @Override
    public void validar(ClienteDTO dto) {
        Documento.isValido(dto.documento);
    }
}
