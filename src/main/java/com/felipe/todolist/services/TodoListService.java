package com.felipe.todolist.services;

import com.felipe.todolist.model.TodoList;
import com.felipe.todolist.repository.RepositoryTodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    private final RepositoryTodoList repositoryTodoList;

    @Autowired
    public TodoListService(RepositoryTodoList repositoryTodoList) {
        this.repositoryTodoList = repositoryTodoList;
    }

    public TodoList postTodo(TodoList todoList) {
        return repositoryTodoList.save(todoList);
    }

    public TodoList editTodo(TodoList todoList, Long id) {
        Optional<TodoList> editTodo = repositoryTodoList.findById(id);
        if (todoList.getStatus() == false) {
            todoList.setDataEdicao(todoList.getDataEdicao());
            return repositoryTodoList.save(todoList);
        } else {
            return null;
        }
    }

    public TodoList updateTodo(TodoList todoList, Long id) {
        Optional<TodoList> editTodo = repositoryTodoList.findById(id);
        todoList.setDataFinalizado(todoList.getDataFinalizado());
        todoList.setStatus(todoList.getStatus());
        todoList.setDataPrevista(todoList.getDataPrevista());
        return repositoryTodoList.save(todoList);
    }

    public List<TodoList> findByAdmin(){
        return repositoryTodoList.findAll();
    }
}
