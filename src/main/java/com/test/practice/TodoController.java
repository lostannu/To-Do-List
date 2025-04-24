package com.test.practice;



import com.test.practice.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Get all todos
    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoService.getAllTodos();
    }

    // Get todo by ID
    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoById(@PathVariable Long id) {
        Optional<TodoItem> todoItem = todoService.getTodoById(id);
        return todoItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new todo
    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem todoItem) {
        return todoService.addTodo(todoItem);
    }

    // Delete todo by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
