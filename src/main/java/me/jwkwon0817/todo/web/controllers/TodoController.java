package me.jwkwon0817.todo.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.jwkwon0817.todo.domain.dto.request.TodoRequestDto;
import me.jwkwon0817.todo.domain.dto.response.TodoResponseDto;
import me.jwkwon0817.todo.domain.services.TodoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@Slf4j
public class TodoController {
	
	private final TodoService todoService;
	
	// 해봐요 예시 알려드릴게요
	@PostMapping("/create")
	public HttpEntity<?> create(@RequestBody TodoRequestDto dto) {
		TodoResponseDto todo = todoService.createTodo(dto);
		
		return ResponseEntity.ok(todo);
	}
	
	// 이렇게 해봐요 쭉
	//할일삭제
	@DeleteMapping("/{id}")
	public HttpEntity<?> delete(@PathVariable Long id) {
		log.info("/api/todos/{} DELETE request", id);
		
		if (id == null) return ResponseEntity.badRequest().build();
		
		TodoResponseDto dto = todoService.deleteTodo(id);
		
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{id}")
	public HttpEntity<?> get(@PathVariable Long id) {
		
		TodoResponseDto todo = todoService.getTodoById(id);
		
		if (id == null) return ResponseEntity.badRequest().build();
		
		return ResponseEntity.ok(todo);
	}
	
	@GetMapping("/all")
	public HttpEntity<?> getAll() {
		return ResponseEntity.ok(todoService.getAllTodos());
	}
	
	//할일수정
	@PutMapping("/{id}")
	public HttpEntity<?> update(@PathVariable Long id, @RequestBody TodoRequestDto dto) {
		
		TodoResponseDto todo = todoService.updateTodo(id, dto);
		
		if (id == null) return ResponseEntity.badRequest().build();
		
		return ResponseEntity.ok(todo);
	}
	
	@PutMapping("/{id}/complete")
	public HttpEntity<?> complete(@PathVariable Long id) {
		
		TodoResponseDto todo = todoService.completeTodo(id);
		
		if (id == null) return ResponseEntity.badRequest().build();
		
		return ResponseEntity.ok(todo);
	}
	
	@PutMapping("/{id}/uncomplete")
	public HttpEntity<?> uncomplete(@PathVariable Long id) {
		
		TodoResponseDto todo = todoService.uncompleteTodo(id);
		
		if (id == null) return ResponseEntity.badRequest().build();
		
		return ResponseEntity.ok(todo);
	}
}
