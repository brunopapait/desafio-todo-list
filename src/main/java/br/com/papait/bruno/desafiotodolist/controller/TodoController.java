package br.com.papait.bruno.desafiotodolist.controller;


import br.com.papait.bruno.desafiotodolist.entity.Todo;
import br.com.papait.bruno.desafiotodolist.service.TodoService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    public ResponseEntity<List<Todo>> create(Todo todo) {
        return ResponseEntity.ok(this.todoService.create(todo));
    }

    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(this.todoService.findAll());
    }

    public ResponseEntity<List<Todo>> update(Todo todo) {
        return ResponseEntity.ok(this.todoService.update(todo));
    }

    public ResponseEntity<List<Todo>> delete(Long id) {
        return ResponseEntity.ok(this.todoService.delete(id));
    }
}
