package com.codecraftmentor.interfaceadapter.controller;

import com.codecraftmentor.domain.usecase.ClienteUseCase;
import com.codecraftmentor.interfaceadapter.dto.ClienteDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @PostMapping
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteUseCase.cadastrarCliente(clienteDTO);
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return clienteUseCase.listarClientes();
    }
}
