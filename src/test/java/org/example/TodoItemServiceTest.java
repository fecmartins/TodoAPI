package org.example;

import org.example.model.TodoItem;
import org.example.repository.todoRepo;
import org.example.service.TodoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoItemServiceTest {

    @Mock
    private todoRepo todoItemRepository;

    @InjectMocks
    private TodoServiceImpl todoItemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTodoItem() {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle("Test Title");

        when(todoItemRepository.save(todoItem)).thenReturn(todoItem);

        TodoItem savedTodoItem = todoItemService.saveTodoItem(todoItem);

        assertNotNull(savedTodoItem);
        assertEquals("Test Title", savedTodoItem.getTitle());
        verify(todoItemRepository, times(1)).save(todoItem);
    }

    @Test
    void testGetTodoItemById() {
        TodoItem todoItem = new TodoItem();
        todoItem.setId(1L);

        when(todoItemRepository.findById(1L)).thenReturn(Optional.of(todoItem));

        TodoItem foundTodoItem = todoItemService.getTodoItem(1L);

        assertNotNull(foundTodoItem);
        assertEquals(1L, foundTodoItem.getId());
        verify(todoItemRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllTodoItems() {
        TodoItem todoItem1 = new TodoItem();
        TodoItem todoItem2 = new TodoItem();

        when(todoItemRepository.findAll()).thenReturn(Arrays.asList(todoItem1, todoItem2));

        List<TodoItem> todoItems = todoItemService.getAllTodoItems();

        assertEquals(2, todoItems.size());
        verify(todoItemRepository, times(1)).findAll();
    }

    @Test
    void testDeleteTodoItem() {
        doNothing().when(todoItemRepository).deleteById(1L);

        todoItemService.deleteTodoItem(1L);

        verify(todoItemRepository, times(1)).deleteById(1L);
    }
}