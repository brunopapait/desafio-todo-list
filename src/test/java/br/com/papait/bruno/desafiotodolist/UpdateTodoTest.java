package br.com.papait.bruno.desafiotodolist;

import br.com.papait.bruno.desafiotodolist.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpdateTodoTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testUpdateTodoSuccess() {
    var id = 1L;
    var todo = new TodoEntity("todo 2", "desc todo 1", true, 1);
    todo.setId(id);

    this.webTestClient
        .put()
        .uri("/todos")
        .bodyValue(todo)
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$").isArray()
        .jsonPath("$.length()").isEqualTo(1L)
        .jsonPath("$[0].id").isEqualTo(id)
        .jsonPath("$[0].name").isEqualTo(todo.getName())
        .jsonPath("$[0].description").isEqualTo(todo.getDescription())
        .jsonPath("$[0].done").isEqualTo(todo.isDone())
        .jsonPath("$[0].priority").isEqualTo(todo.getPriority());
  }

  @Test
  void testUpdateTodoFailure() {
    var id = 1L;
    var todo = new TodoEntity("", "", true, 1);
    todo.setId(id);

    this.webTestClient
        .put()
        .uri("/todos")
        .bodyValue(todo)
        .exchange()
        .expectStatus()
        .isBadRequest();
  }
}
