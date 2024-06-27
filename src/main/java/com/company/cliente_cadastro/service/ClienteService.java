package com.company.cliente_cadastro.service;

import com.company.cliente_cadastro.dto.ClienteDTO;
import com.company.cliente_cadastro.dto.TelefoneDTO;
import com.company.cliente_cadastro.entity.Cliente;
import com.company.cliente_cadastro.entity.Telefone;
import com.company.cliente_cadastro.error.ClientException;
import com.company.cliente_cadastro.error.ErrorCode;
import com.company.cliente_cadastro.repository.ClienteRepository;
import com.company.cliente_cadastro.validator.Validador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    private final Set<Validador> validadores;

    public Cliente createCliente(ClienteDTO clienteDTO) {
        try {
            validar(clienteDTO);
            Set<TelefoneDTO> clienteTelefones = clienteDTO.telefones();
            Set<Telefone> telefones = clienteTelefones.stream()
                    .map(dto -> {
                        Telefone telefone = new Telefone();
                        telefone.setNumero(dto.getNumero());
                        return telefone;
                    })
                    .collect(Collectors.toSet());

            Cliente cliente = new Cliente();
            cliente.setNome(clienteDTO.nome());
            cliente.setEndereco(clienteDTO.endereco());
            cliente.setBairro(clienteDTO.bairro());
            cliente.setTelefones(telefones);

            telefones.forEach(telefone -> telefone.setCliente(cliente));

            return clienteRepository.save(cliente);
        } catch (ClientException clientException) {
            throw clientException;
        } catch (Exception e) {
            throw new ClientException(ErrorCode.GENERIC_ERROR);
        }
    }

    private void validar(ClienteDTO clienteDTO) {
        validadores.forEach(validador -> validador.validate(clienteDTO));
    }
}
