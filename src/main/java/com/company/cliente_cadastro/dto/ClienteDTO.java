package com.company.cliente_cadastro.dto;

import java.util.List;

public record ClienteDTO(String nome, String endereco, String bairro, List<TelefoneDTO> telefones) {
}
