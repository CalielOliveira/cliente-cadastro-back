package com.company.cliente_cadastro.validator;

import com.company.cliente_cadastro.dto.ClienteDTO;
import com.company.cliente_cadastro.dto.TelefoneDTO;
import com.company.cliente_cadastro.error.ClientException;
import com.company.cliente_cadastro.error.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ValidadorTelefoneTamanho implements Validador {

    @Override
    public void validate(ClienteDTO clienteDTO) {
        Set<TelefoneDTO> clienteTelefones = clienteDTO.telefones();
        boolean isValid = clienteTelefones.stream().parallel().anyMatch(telefoneDTO ->
                (telefoneDTO.getNumero() == null || !telefoneDTO.getNumero().matches("\\d{10,11}")));
        if (isValid) throw new ClientException(ErrorCode.CLIENT_NUMBER_ERROR);
    }
}
