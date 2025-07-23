package com.codecraftmentor.infrastructure.repository;

import com.codecraftmentor.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produto, Long> {
}
