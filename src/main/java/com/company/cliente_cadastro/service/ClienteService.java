package com.company.cliente_cadastro.service;

import com.company.cliente_cadastro.dto.ClienteDTO;
import com.company.cliente_cadastro.entity.Cliente;
import com.company.cliente_cadastro.entity.Telefone;
import com.company.cliente_cadastro.repository.ClienteRepository;
import com.company.cliente_cadastro.repository.TelefoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final TelefoneRepository telefoneRepository;

    public Cliente createCliente(ClienteDTO clienteDTO) {
        validateNome(clienteDTO.nome());
        List<Telefone> telefones = clienteDTO.telefones().stream()
                .map(dto -> {
                    validateTelefone(dto.numero());
                    Telefone telefone = new Telefone();
                    telefone.setNumero(dto.numero());
                    return telefone;
                })
                .collect(Collectors.toList());

        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.nome());
        cliente.setEndereco(clienteDTO.endereco());
        cliente.setBairro(clienteDTO.bairro());
        cliente.setTelefones(telefones);

        telefones.forEach(telefone -> telefone.setCliente(cliente));

        return clienteRepository.save(cliente);
    }

    private void validateNome(String nome) {
        if (nome == null || nome.length() <= 10) {
            throw new IllegalArgumentException("Nome deve ter mais de 10 caracteres.");
        }
    }

    private void validateTelefone(String numero) {
        if (numero == null || !numero.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Número de telefone inválido.");
        }
        if (telefoneRepository.findAll().stream().anyMatch(t -> t.getNumero().equals(numero))) {
            throw new IllegalArgumentException("Telefone já cadastrado.");
        }
    }
}
