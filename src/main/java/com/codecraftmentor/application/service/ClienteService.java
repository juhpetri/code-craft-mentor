package com.codecraftmentor.application.service;

import com.codecraftmentor.domain.model.Cliente;
import com.codecraftmentor.domain.usecase.ClienteUseCase;
import com.codecraftmentor.infrastructure.repository.ClienteRepository;
import com.codecraftmentor.interfaceadapter.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ClienteUseCase {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO cadastrarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente(dto.getNome(), dto.getEmail());
        Cliente save = clienteRepository.save(cliente);
        return ClienteDTO.builder()
                .id(save.getId())
                .nome(save.getNome())
                .email(save.getEmail())
                .build();
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return List.of();
    }

    @Override
    public ClienteDTO buscarClientePorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .map(cliente -> ClienteDTO.builder()
                        .id(cliente.getId())
                        .nome(cliente.getNome())
                        .email(cliente.getEmail())
                        .build())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o email: " + email));
    }
}
