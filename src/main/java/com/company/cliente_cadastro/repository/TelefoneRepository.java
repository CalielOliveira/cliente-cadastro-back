package com.company.cliente_cadastro.repository;

import com.company.cliente_cadastro.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
