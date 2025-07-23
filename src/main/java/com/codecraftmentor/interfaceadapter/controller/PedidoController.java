package com.codecraftmentor.interfaceadapter.controller;

import com.codecraftmentor.domain.usecase.PedidoUseCase;
import com.codecraftmentor.interfaceadapter.dto.PedidoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    public PedidoController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @PostMapping
    public PedidoDTO cadastrarPedido(@RequestBody PedidoDTO dto) {
        return pedidoUseCase.cadastrarPedido(dto);
    }

    @GetMapping
    public List<PedidoDTO> listarPedidos() {
        return pedidoUseCase.listarPedidos();
    }
}
