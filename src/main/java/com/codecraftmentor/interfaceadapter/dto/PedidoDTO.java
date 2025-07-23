package com.codecraftmentor.interfaceadapter.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PedidoDTO {
    private UUID id;
    private String numero;
    private Double valorTotal;
    private Boolean pago;
    private String emailCliente;
    private ClienteResumoDTO cliente;
    private List<ProdutoResumoDTO> produtos;
}
