package com.codecraftmentor.application.dto;

public class ProdutoRequestDTO {
    private String nome;
    private Double preco;

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
}
