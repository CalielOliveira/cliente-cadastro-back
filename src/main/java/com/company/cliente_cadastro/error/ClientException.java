package com.company.cliente_cadastro.error;

public class ClientException extends CustomException {

    public ClientException(ErrorCode errorCode) {
        super(errorCode);
    }
}
