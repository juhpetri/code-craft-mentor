package com.codecraftmentor.domain.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Cliente {
    private UUID id;
    private String nome;
    private Documento documento;
    private Email email;

    public Cliente(UUID id, String nome, Documento documento, Email email) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }

    public void atualizar(String nome, Email email) {
        this.nome = nome;
        this.email = email;
    }
}
