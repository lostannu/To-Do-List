package com.test.practice;



import com.test.practice.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Get all Todo items
    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    // Get Todo item by ID
    public Optional<TodoItem> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    // Add a new Todo item
    public TodoItem addTodo(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    // Delete a Todo item by ID
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
