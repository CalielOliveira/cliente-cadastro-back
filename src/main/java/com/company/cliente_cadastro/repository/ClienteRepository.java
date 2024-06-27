package com.company.cliente_cadastro.repository;

import com.company.cliente_cadastro.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
