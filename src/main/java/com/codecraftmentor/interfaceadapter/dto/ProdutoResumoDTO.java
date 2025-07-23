package com.codecraftmentor.interfaceadapter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoResumoDTO {
    private Long id;
    private String titulo;
    private double valorUnitario;
    private Integer quantidade;
}
