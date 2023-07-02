package me.jwkwon0817.todo.web.controllers;

import lombok.extern.slf4j.Slf4j;
import me.jwkwon0817.todo.domain.exceptions.TodoNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@Slf4j
public class ExceptionController {
	
	@ExceptionHandler(TodoNotFoundException.class)
	protected String handleTodoNotFoundException(TodoNotFoundException ex) {
		return "error/404";
	}
	
	@ExceptionHandler(Exception.class)
	protected String handleException(Exception ex) {
		log.info("Exception : {}", ex.getMessage());
		return "error/500";
	}
}
