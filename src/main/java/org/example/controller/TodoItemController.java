package org.example.controller;

import org.example.model.TodoItem;
import org.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem) {
        return ResponseEntity.ok(todoService.saveTodoItem(todoItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoItem(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoItem(id));
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        return ResponseEntity.ok(todoService.getAllTodoItems());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return ResponseEntity.ok().build();
    }

}
