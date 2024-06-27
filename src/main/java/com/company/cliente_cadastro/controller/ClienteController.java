package com.company.cliente_cadastro.controller;

import com.company.cliente_cadastro.dto.ClienteDTO;
import com.company.cliente_cadastro.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/create")
    public ResponseEntity<String> createCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.createCliente(clienteDTO);
        return ResponseEntity.ok().build();
    }
}
