package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class TodoController {

    protected static final Logger parentLogger = LogManager.getLogger();

    private Logger logger = parentLogger;

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo) {
        logger.warn(todo);
        return todoRepository.save(todo);
    }

    @GetMapping("/")
    public Iterable<Todo> getTodos(HttpServletRequest request) {
        return todoRepository.findAll();
    }
}
