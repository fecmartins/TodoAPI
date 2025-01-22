package org.example.repository;

import org.example.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todoRepo extends JpaRepository<TodoItem, Long> {

    //query methods

}
