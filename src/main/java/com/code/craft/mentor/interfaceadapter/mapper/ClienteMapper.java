package com.code.craft.mentor.interfaceadapter.mapper;

import com.code.craft.mentor.application.dto.ClienteResponseDTO;
import com.code.craft.mentor.application.dto.ClienteDTO;
import com.code.craft.mentor.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface ClienteMapper {

    // Mapeia Cliente -> ClienteResponseDTO
    ClienteResponseDTO toDTO(Cliente cliente);

    // Mapeia ClienteCreateDTO -> Cliente
    @Mapping(target = "email", expression = "java(new Email(dto.email))")
    @Mapping(target = "documento", expression = "java(new Documento(dto.documento))")
    Cliente fromCreateDTO(ClienteDTO dto);

}
