package com.codecraftmentor.application.usecase;

import com.codecraftmentor.application.dto.ProdutoRequestDTO;
import com.codecraftmentor.domain.model.Produto;

public interface SalvarProdutoUseCase {
    Produto executar(ProdutoRequestDTO dto);
}
