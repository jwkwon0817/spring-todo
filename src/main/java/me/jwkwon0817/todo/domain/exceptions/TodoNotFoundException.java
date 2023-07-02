package me.jwkwon0817.todo.domain.exceptions;

public class TodoNotFoundException extends RuntimeException {
	
	public TodoNotFoundException(Long id) {
		super("Todo id not found : " + id);
	}
}
