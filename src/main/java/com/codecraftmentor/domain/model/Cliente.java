package com.codecraftmentor.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {
    @Setter
    @Id
    private UUID id;
    private String nome;
    @Embedded
    private Documento documento;
    @Embedded
    private Email email;

    public Cliente(String nome, Documento documento, Email email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }

    public void atualizar(String nome, Email email) {
        this.nome = nome;
        this.email = email;
    }
}
