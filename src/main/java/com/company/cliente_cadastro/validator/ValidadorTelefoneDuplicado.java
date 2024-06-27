package com.company.cliente_cadastro.validator;

import com.company.cliente_cadastro.dto.ClienteDTO;
import com.company.cliente_cadastro.dto.TelefoneDTO;
import com.company.cliente_cadastro.entity.Telefone;
import com.company.cliente_cadastro.error.ClientException;
import com.company.cliente_cadastro.error.ErrorCode;
import com.company.cliente_cadastro.repository.TelefoneRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ValidadorTelefoneDuplicado implements Validador {

    private final TelefoneRepository telefoneRepository;

    @Override
    public void validate(ClienteDTO clienteDTO) {
        Set<Telefone> telefonesPersistidos = getTelefones();
        Set<TelefoneDTO> clienteTelefones = clienteDTO.telefones();
        telefonesPersistidos.retainAll(clienteTelefones);
        boolean isDuplicated = CollectionUtils.isNotEmpty(telefonesPersistidos);
        if (isDuplicated) throw new ClientException(ErrorCode.CLIENT_NUMBER_DUPLICATED_ERROR);
    }

    private Set<Telefone> getTelefones() {
        return new HashSet<>(telefoneRepository.findAll());
    }
}
