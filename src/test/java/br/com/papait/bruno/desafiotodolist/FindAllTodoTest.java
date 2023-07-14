package br.com.papait.bruno.desafiotodolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindAllTodoTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testFindAllTodoSuccess() {
    this.webTestClient
        .get()
        .uri("/todos")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$").isArray();
  }
}
