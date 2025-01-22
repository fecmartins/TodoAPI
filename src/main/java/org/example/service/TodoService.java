package org.example.service;

import org.example.model.TodoItem;

import java.util.List;

public interface TodoService {

    TodoItem saveTodoItem(TodoItem todoItem);
    TodoItem getTodoItem(Long id);
    void deleteTodoItem(Long id);
    List<TodoItem> getAllTodoItems();
}
