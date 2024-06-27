package com.company.cliente_cadastro.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    CLIENT_NUMBER_DUPLICATED_ERROR(1, "Numero ja cadastrado", HttpStatus.BAD_REQUEST),
    CLIENT_NUMBER_ERROR(2, "Numero de telefone invalido", HttpStatus.BAD_REQUEST),
    GENERIC_ERROR(999, "Erro Interno, entre em contato com o suporte", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;
}

