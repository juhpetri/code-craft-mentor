package com.codecraftmentor.interfaceadapter.mapper;

import org.mapstruct.Mapper;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface ProdutoMapper {
    // Conversão DTO <-> Entidade
}
