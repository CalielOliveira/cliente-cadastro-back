package com.company.cliente_cadastro;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.io.IOException;

@SpringBootTest
class ClienteCadastroApplicationTests {

	private static EmbeddedPostgres embeddedPostgres;

	@BeforeAll
	public static void setUp() throws IOException {
		embeddedPostgres = EmbeddedPostgres.builder().start();
	}

	@AfterAll
	public static void tearDown() throws IOException {
		if (embeddedPostgres != null) {
			embeddedPostgres.close();
		}
	}

	@DynamicPropertySource
	public static void overrideProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", () -> embeddedPostgres.getJdbcUrl("postgres", "postgres"));
		registry.add("spring.datasource.username", () -> "postgres");
		registry.add("spring.datasource.password", () -> "postgres");
	}

	@Test
	void contextLoads() {
	}

}
