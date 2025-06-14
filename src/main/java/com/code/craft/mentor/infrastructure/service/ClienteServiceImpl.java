package com.code.craft.mentor.infrastructure.service;

import com.code.craft.mentor.application.dto.ClienteResponseDTO;
import com.code.craft.mentor.application.dto.ClienteDTO;
import com.code.craft.mentor.application.usecase.ClienteUseCase;
import com.code.craft.mentor.domain.model.Cliente;
import com.code.craft.mentor.domain.model.Email;
import com.code.craft.mentor.domain.service.ClienteValidationService;
import com.code.craft.mentor.infrastructure.repository.ClienteRepository;
import com.code.craft.mentor.interfaceadapter.mapper.ClienteMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteUseCase {

    private final ClienteRepository repository;
    private final ClienteMapper clienteMapper;
    private final ClienteValidationService clienteValidationService;

    public ClienteServiceImpl(ClienteRepository repository,
                              ClienteMapper clienteMapper) {
        this.repository = repository;
        this.clienteMapper = clienteMapper;
        this.clienteValidationService = new ClienteValidationService();
    }

    @Override
    public ClienteResponseDTO criar(ClienteDTO dto) {
        clienteValidationService.validar(dto);
        Cliente cliente = clienteMapper.fromCreateDTO(dto);
        Cliente salvo = repository.save(cliente);
        return clienteMapper.toDTO(salvo);
    }

    @Override
    public ClienteResponseDTO atualizar(UUID id, ClienteDTO dto) {
        Cliente clienteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteValidationService.validar(dto);
        clienteExistente.atualizar(dto.nome, new Email(dto.email));
        Cliente atualizado = repository.save(clienteExistente);

        return clienteMapper.toDTO(atualizado);
    }

    @Override
    public List<ClienteResponseDTO> listar() {
        return repository.findAll().stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
