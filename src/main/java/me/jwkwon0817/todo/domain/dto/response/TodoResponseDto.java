package me.jwkwon0817.todo.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponseDto {
	
	private Long id;
	private String content;
	private boolean completed;
}
