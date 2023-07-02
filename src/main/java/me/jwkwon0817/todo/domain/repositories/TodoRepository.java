package me.jwkwon0817.todo.domain.repositories;

import me.jwkwon0817.todo.domain.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
