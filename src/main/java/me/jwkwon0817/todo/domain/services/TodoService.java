package me.jwkwon0817.todo.domain.services;

import me.jwkwon0817.todo.domain.dto.request.TodoRequestDto;
import me.jwkwon0817.todo.domain.dto.response.TodoResponseDto;

import java.util.List;

public interface TodoService {
	
	TodoResponseDto getTodoById(Long id);
	
	List<TodoResponseDto> getAllTodos();
	
	TodoResponseDto createTodo(TodoRequestDto dto);
	
	TodoResponseDto updateTodo(Long id, TodoRequestDto dto);
	
	TodoResponseDto deleteTodo(Long id);
	
	TodoResponseDto completeTodo(Long id);
	
	TodoResponseDto uncompleteTodo(Long id);
}
