package com.code.craft.mentor.domain.validation;

import com.code.craft.mentor.application.dto.ClienteDTO;
import com.code.craft.mentor.domain.model.Documento;

public class DocumentoValidator implements ClienteValidator {
    @Override
    public void validar(ClienteDTO dto) {
        Documento.isValido(dto.documento);
    }
}
