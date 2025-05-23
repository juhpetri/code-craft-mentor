package com.codecraftmentor.domain.model;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Documento {
    private final String valor;

    public Documento(String valor) {
        this.valor = valor;
    }

    public static boolean isValido(String valor) {
        // Exemplo simples de CPF
        if (!(isNullOrEmpty(valor) && valor.matches("\\d{11}"))) {
            throw new IllegalArgumentException("Documento inválido: " + valor);
        }
        return true;
    }

    @Override
    public String toString() {
        return valor;
    }
}
