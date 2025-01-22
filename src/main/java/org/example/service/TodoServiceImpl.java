package org.example.service;

import org.example.model.TodoItem;
import org.example.repository.todoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private todoRepo todoRepoService;

    @Override
    public TodoItem saveTodoItem(TodoItem todoItem) {
        return todoRepoService.save(todoItem);
    }

    @Override
    public TodoItem getTodoItem(Long id) {
        return todoRepoService.findById(id).orElse(null);
    }

    @Override
    public void deleteTodoItem(Long id) {
        todoRepoService.deleteById(id);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoRepoService.findAll();
    }

}
