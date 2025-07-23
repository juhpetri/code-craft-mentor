package com.codecraftmentor.domain.usecase;

import com.codecraftmentor.domain.model.Produto;
import com.codecraftmentor.interfaceadapter.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoUseCase {
    ProdutoDTO cadastrarProduto(ProdutoDTO dto);
    List<ProdutoDTO> listarProdutos();
    Produto buscarProdutoPorId(Long id);
}
