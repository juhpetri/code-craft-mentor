package com.codecraftmentor.domain.service;

import com.codecraftmentor.domain.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    // Simula uma base de dados em memória
    private final List<Produto> produtos = new ArrayList<>();
    private Long contadorId = 1L;

    public Produto salvar(Produto produto) {
        produto.setId(contadorId++);
        produtos.add(produto);
        return produto;
    }

    public List<Produto> listarTodos() {
        return produtos;
    }
}
