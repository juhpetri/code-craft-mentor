package com.codecraftmentor.application.service;

import com.codecraftmentor.domain.model.Produto;
import com.codecraftmentor.domain.usecase.ProdutoUseCase;
import com.codecraftmentor.infrastructure.repository.ProductRepository;
import com.codecraftmentor.interfaceadapter.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProductRepository productRepository;

    public ProdutoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProdutoDTO cadastrarProduto(ProdutoDTO dto) {
        Produto produto = Produto.builder()
                .titulo(dto.getTitulo())
                .quantidade(dto.getQuantidade())
                .valorUnitario(dto.getValorUnitario())
                .valorTotal(dto.getValorUnitario() * dto.getQuantidade())
                .build();

        Produto salvo = productRepository.save(produto);
        return mapToDTO(salvo);
    }

    @Override
    public List<ProdutoDTO> listarProdutos() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    private ProdutoDTO mapToDTO(Produto produto) {
        return ProdutoDTO.builder()
                .id(produto.getId())
                .titulo(produto.getTitulo())
                .quantidade(produto.getQuantidade())
                .valorUnitario(produto.getValorUnitario())
                .valorTotal(produto.getValorTotal())
                .build();
    }
}
