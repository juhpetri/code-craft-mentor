package com.code.craft.mentor.domain.model;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Documento {
    private final String documento;

    public Documento(String documento) {
        this.documento = documento;
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
        return documento;
    }
}
