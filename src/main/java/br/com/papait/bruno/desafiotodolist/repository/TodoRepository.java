package br.com.papait.bruno.desafiotodolist.repository;

import br.com.papait.bruno.desafiotodolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
