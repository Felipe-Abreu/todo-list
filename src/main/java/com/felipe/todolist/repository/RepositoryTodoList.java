package com.felipe.todolist.repository;

import com.felipe.todolist.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTodoList extends JpaRepository<TodoList, Long> {
}
