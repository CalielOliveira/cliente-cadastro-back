package com.company.cliente_cadastro.dto;

import java.util.Set;

public record ClienteDTO(String nome, String endereco, String bairro, Set<TelefoneDTO> telefones) {
}
