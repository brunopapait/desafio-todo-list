package br.com.papait.bruno.desafiotodolist.controller;


import br.com.papait.bruno.desafiotodolist.entity.TodoEntity;
import br.com.papait.bruno.desafiotodolist.service.TodoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<List<TodoEntity>> create(@RequestBody @Valid TodoEntity todo) {
        return ResponseEntity.ok(this.todoService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<TodoEntity>> findAll() {
        return ResponseEntity.ok(this.todoService.findAll());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<List<TodoEntity>> update(@RequestBody @Valid TodoEntity todo) {
        return ResponseEntity.ok(this.todoService.update(todo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<List<TodoEntity>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.todoService.delete(id));
    }
}
