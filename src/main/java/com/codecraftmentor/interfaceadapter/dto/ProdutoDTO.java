package com.codecraftmentor.interfaceadapter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoDTO {
    private String titulo;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private Long id;

}
