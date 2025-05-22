package com.codecraftmentor.fundamentos;

public class MainProdutoConstrutor {
    public static void main(String[] args) {
        ProdutoConstrutor produto = new ProdutoConstrutor("Lápis", 1.5);
        System.out.println(produto.getNome());
        System.out.println(produto.getPreco());
    }
}
