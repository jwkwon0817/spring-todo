package me.jwkwon0817.todo.domain.services;

import lombok.RequiredArgsConstructor;
import me.jwkwon0817.todo.domain.dto.request.TodoRequestDto;
import me.jwkwon0817.todo.domain.dto.response.TodoResponseDto;
import me.jwkwon0817.todo.domain.entities.Todo;
import me.jwkwon0817.todo.domain.exceptions.TodoNotFoundException;
import me.jwkwon0817.todo.domain.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	private final TodoRepository todoRepository;
	
	@Override
	public TodoResponseDto getTodoById(Long id) {
		Todo byId = todoRepository.findById(id)
			.orElseThrow(() -> new TodoNotFoundException(id));
		
		return new TodoResponseDto(byId.getId(), byId.getContent(), byId.isCompleted());
	}
	
	@Override
	public List<TodoResponseDto> getAllTodos() {
		List<Todo> all = todoRepository.findAll();
		
		return all.stream()
			.map(todo -> new TodoResponseDto(todo.getId(), todo.getContent(), todo.isCompleted()))
			.toList();
	}
	
	@Override
	public TodoResponseDto createTodo(TodoRequestDto dto) {
		Todo todo = dto.toEntity();
		Todo savedTodo = todoRepository.save(todo);
		
		return new TodoResponseDto(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
	}
	
	@Override
	public TodoResponseDto updateTodo(Long id, TodoRequestDto dto) {
		Todo todo = todoRepository.findById(id)
			.orElseThrow(() -> new TodoNotFoundException(id));
		
		todo.update(dto.getContent());
		Todo savedTodo = todoRepository.save(todo);
		
		return new TodoResponseDto(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
	}
	
	@Override
	public TodoResponseDto deleteTodo(Long id) {
		Todo todo = todoRepository.findById(id)
			.orElseThrow(() -> new TodoNotFoundException(id));
		
		todoRepository.delete(todo);
		
		return new TodoResponseDto(todo.getId(), todo.getContent(), todo.isCompleted());
	}
	
	@Override
	public TodoResponseDto completeTodo(Long id) {
		Todo todo = todoRepository.findById(id)
			.orElseThrow(() -> new TodoNotFoundException(id));
		
		todo.complete();
		Todo savedTodo = todoRepository.save(todo);
		
		return new TodoResponseDto(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
	}
	
	@Override
	public TodoResponseDto uncompleteTodo(Long id) {
		Todo todo = todoRepository.findById(id)
			.orElseThrow(() -> new TodoNotFoundException(id));
		
		todo.uncomplete();
		Todo savedTodo = todoRepository.save(todo);
		
		return new TodoResponseDto(savedTodo.getId(), savedTodo.getContent(), savedTodo.isCompleted());
	}
}
