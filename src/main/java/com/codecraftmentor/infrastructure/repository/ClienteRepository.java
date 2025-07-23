package com.codecraftmentor.infrastructure.repository;

import com.codecraftmentor.domain.model.Cliente;
import com.codecraftmentor.interfaceadapter.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<ClienteDTO> findByEmail(String email);
}
