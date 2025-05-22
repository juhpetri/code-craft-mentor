package com.codecraftmentor.interfaceadapter.controller;

import com.codecraftmentor.application.dto.ProdutoRequestDTO;
import com.codecraftmentor.domain.model.Produto;
import com.codecraftmentor.domain.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    // Injeção via construtor
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Endpoint POST /produtos
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody ProdutoRequestDTO dto) {
        // Converter DTO para entidade
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto produtoSalvo = produtoService.salvar(produto);

        // Retornar 201 Created com o produto criado
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }
}
