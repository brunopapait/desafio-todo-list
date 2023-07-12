package br.com.papait.bruno.desafiotodolist.controller;


import br.com.papait.bruno.desafiotodolist.entity.Todo;
import br.com.papait.bruno.desafiotodolist.service.TodoService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<List<Todo>> create(@RequestBody Todo todo) {
        return ResponseEntity.ok(this.todoService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(this.todoService.findAll());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<List<Todo>> update(@RequestBody Todo todo) {
        return ResponseEntity.ok(this.todoService.update(todo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<List<Todo>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.todoService.delete(id));
    }
}
