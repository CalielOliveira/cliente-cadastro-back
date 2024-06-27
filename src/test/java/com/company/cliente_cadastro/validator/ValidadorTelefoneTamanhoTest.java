package com.company.cliente_cadastro.validator;

import com.company.cliente_cadastro.dto.ClienteDTO;
import com.company.cliente_cadastro.dto.TelefoneDTO;
import com.company.cliente_cadastro.error.ClientException;
import com.company.cliente_cadastro.error.CustomException;
import com.company.cliente_cadastro.error.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorTelefoneTamanhoTest {

    private ValidadorTelefoneTamanho sut;

    @BeforeEach
    void setUp() {
        sut = new ValidadorTelefoneTamanho();
    }

    @Test
    void validate() {
        ClienteDTO clienteDTO = new ClienteDTO("", "", "", Set.of(new TelefoneDTO("123")));
        Exception exception = assertThrows(ClientException.class, () -> {
            sut.validate(clienteDTO);
        });

        CustomException customException = (CustomException) exception;
        ErrorCode errorCode = customException.getErrorCode();
        assertEquals(ErrorCode.CLIENT_NUMBER_ERROR, errorCode);
    }

}