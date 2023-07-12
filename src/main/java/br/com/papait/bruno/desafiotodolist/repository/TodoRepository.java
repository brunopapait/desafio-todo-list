package br.com.papait.bruno.desafiotodolist.repository;


import br.com.papait.bruno.desafiotodolist.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
