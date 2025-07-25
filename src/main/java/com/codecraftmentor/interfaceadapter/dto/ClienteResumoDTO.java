package com.codecraftmentor.interfaceadapter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteResumoDTO {
    private Long id;
    private String nome;
    private String email;
}
