package com.company.cliente_cadastro.validator;

import com.company.cliente_cadastro.dto.ClienteDTO;
import com.company.cliente_cadastro.dto.TelefoneDTO;
import com.company.cliente_cadastro.entity.Telefone;
import com.company.cliente_cadastro.error.ClientException;
import com.company.cliente_cadastro.error.CustomException;
import com.company.cliente_cadastro.error.ErrorCode;
import com.company.cliente_cadastro.repository.TelefoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ValidadorTelefoneDuplicadoTest {

    private static final String numero = "123";

    private TelefoneRepository telefoneRepository;

    private  ValidadorTelefoneDuplicado sut;

    @BeforeEach
    void setUp() {
        telefoneRepository = mock(TelefoneRepository.class);
        sut = new ValidadorTelefoneDuplicado(telefoneRepository);
        Telefone telefone = new Telefone();
        telefone.setNumero(numero);
        when(telefoneRepository.findAll()).thenReturn(List.of(telefone));
    }

    @Test
    void validate() {
        ClienteDTO clienteDTO = new ClienteDTO("", "", "",
                new HashSet<>(Collections.singleton(new TelefoneDTO(numero))));
        Exception exception = assertThrows(ClientException.class, () -> {
            sut.validate(clienteDTO);
        });
        CustomException customException = (CustomException) exception;
        ErrorCode errorCode = customException.getErrorCode();
        assertEquals(ErrorCode.CLIENT_NUMBER_DUPLICATED_ERROR, errorCode);
    }
}