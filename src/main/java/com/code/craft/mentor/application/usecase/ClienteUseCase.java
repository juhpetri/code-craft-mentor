package com.code.craft.mentor.application.usecase;

import com.code.craft.mentor.application.dto.ClienteResponseDTO;
import com.code.craft.mentor.application.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteUseCase {
    ClienteResponseDTO criar(ClienteDTO dto);
    ClienteResponseDTO atualizar(UUID id, ClienteDTO dto);
    List<ClienteResponseDTO> listar();
}
