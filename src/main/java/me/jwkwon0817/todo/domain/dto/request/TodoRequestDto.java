package me.jwkwon0817.todo.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jwkwon0817.todo.domain.entities.Todo;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequestDto {
	
	private String content;
	
	public Todo toEntity() {
		return Todo.builder()
			.content(content)
			.completed(false)
			.build();
	}
}
