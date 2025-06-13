package com.code.craft.mentor.interfaceadapter.controller;

import com.code.craft.mentor.application.dto.ClienteResponseDTO;
import com.code.craft.mentor.application.dto.ClienteDTO;
import com.code.craft.mentor.application.usecase.ClienteUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @PostMapping
    public ClienteResponseDTO criar(@RequestBody ClienteDTO dto) {
        return clienteUseCase.criar(dto);
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(@PathVariable UUID id, @RequestBody ClienteDTO dto) {
        return clienteUseCase.atualizar(id, dto);
    }

    @GetMapping
    public List<ClienteResponseDTO> listar() {
        return clienteUseCase.listar();
    }
}
