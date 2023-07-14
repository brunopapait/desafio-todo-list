package br.com.papait.bruno.desafiotodolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeleteTodoTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testDeleteTodoSuccess() {
    var id = 1L;

    this.webTestClient
        .delete()
        .uri("/todos/" + id)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody();
  }

  @Test
  void testDeleteTodoWithoutIdInUriFailure() {
    this.webTestClient
        .delete()
        .uri("/todos/")
        .exchange()
        .expectStatus()
        .isNotFound();

  }
}
