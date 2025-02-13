package com.company.cliente_cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClienteCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteCadastroApplication.class, args);
	}

}
