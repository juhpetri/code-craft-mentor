package com.codecraftmentor.fundamentos;

public class Produto {

    // atributos
    String nome;
    double preco;

    // método para exibir as informações do produto
    void exibirInformacoes() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$" + preco);
    }
}

