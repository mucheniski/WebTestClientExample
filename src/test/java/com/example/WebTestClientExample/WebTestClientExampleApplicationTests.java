package com.example.WebTestClientExample;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WebTestClientExampleApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	@Order(1)
	public void testGetBranches() {
		webTestClient
				.get()
				.uri("https://api.sulamericaseguros.com.br/open-insurance/channels/v1/branches")
				.exchange()
				.expectStatus().isOk()
		;
	}

}
