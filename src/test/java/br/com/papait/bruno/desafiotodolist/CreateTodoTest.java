package br.com.papait.bruno.desafiotodolist;

import br.com.papait.bruno.desafiotodolist.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateTodoTest {
  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testCreateTodoSuccess() {
    var todo = new TodoEntity("todo 1", "desc todo 1", false, 2);

    this.webTestClient
        .post()
        .uri("/todos")
        .bodyValue(todo)
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$").isArray()
        .jsonPath("$.length()").isEqualTo(1L)
        .jsonPath("$[0].id").isNumber()
        .jsonPath("$[0].name").isEqualTo(todo.getName())
        .jsonPath("$[0].description").isEqualTo(todo.getDescription())
        .jsonPath("$[0].done").isEqualTo(todo.isDone())
        .jsonPath("$[0].priority").isEqualTo(todo.getPriority());

  }

  @Test
  void testCreateTodoFailure() {
    var todo = new TodoEntity("", "", false, 2);

    this.webTestClient
        .post()
        .uri("/todos")
        .bodyValue(todo)
        .exchange()
        .expectStatus().isBadRequest();
  }
}
