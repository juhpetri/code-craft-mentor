package com.codecraftmentor.interfaceadapter.controller;

import com.codecraftmentor.domain.usecase.ProdutoUseCase;
import com.codecraftmentor.interfaceadapter.dto.ProdutoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @PostMapping
    public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO dto) {
        return produtoUseCase.cadastrarProduto(dto);
    }

    @GetMapping
    public List<ProdutoDTO> listarProdutos() {
        return produtoUseCase.listarProdutos();
    }
}
