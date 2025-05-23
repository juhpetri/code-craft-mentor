package com.codecraftmentor.application.usecase;

import com.codecraftmentor.application.dto.ClienteResponseDTO;
import com.codecraftmentor.application.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteUseCase {
    ClienteResponseDTO criar(ClienteDTO dto);
    ClienteResponseDTO atualizar(UUID id, ClienteDTO dto);
    List<ClienteResponseDTO> listar();
}
