package br.com.papait.bruno.desafiotodolist.service;

import br.com.papait.bruno.desafiotodolist.entity.Todo;
import br.com.papait.bruno.desafiotodolist.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        this.todoRepository.save(todo);

        return this.findAll();
    }

    public List<Todo> findAll() {
        var sort = Sort.by("priority").descending()
                .and(Sort.by("name").ascending());

        return this.todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        this.todoRepository.save(todo);

        return this.findAll();
    }

    public List<Todo> delete(Long id) {
        this.todoRepository.deleteById(id);

        return this.findAll();
    }
}
