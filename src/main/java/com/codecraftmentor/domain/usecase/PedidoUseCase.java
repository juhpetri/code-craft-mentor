package com.codecraftmentor.domain.usecase;

import com.codecraftmentor.interfaceadapter.dto.PedidoDTO;

import java.util.List;

public interface PedidoUseCase {
    PedidoDTO cadastrarPedido(PedidoDTO pedidoDTO);
    List<PedidoDTO> listarPedidos();
}
