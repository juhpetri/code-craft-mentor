package com.codecraftmentor.domain.usecase;

import com.codecraftmentor.interfaceadapter.dto.ClienteDTO;

import java.util.List;

public interface ClienteUseCase {
    ClienteDTO cadastrarCliente(ClienteDTO dto);
    List<ClienteDTO> listarClientes();
    ClienteDTO buscarClientePorEmail(String email);
}
