package com.felipe.todolist.controler;

import com.felipe.todolist.model.TodoList;
import com.felipe.todolist.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api")
public class TodoListController {

    private TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping(value = "criaTODO", consumes = APPLICATION_JSON_VALUE)
    public TodoList crietTodo(@RequestBody @Valid TodoList todoList){
        return todoListService.postTodo(todoList);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping(value = "editaTODO/{id}", consumes = APPLICATION_JSON_VALUE)
    public Optional<TodoList> editItem(@PathVariable("id") Long id, @RequestBody @Valid TodoList todoList){
        return Optional.ofNullable(todoListService.editTodo(todoList, id));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping(value = "atualizaTODO/{id}", consumes = APPLICATION_JSON_VALUE)
    public Optional<TodoList> updateItem(@PathVariable("id") Long id, @RequestBody @Valid TodoList todoList){
        return Optional.ofNullable(todoListService.updateTodo(todoList, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("listaTODO")
    public List<TodoList> listTodo(){
        return todoListService.findByAdmin();
    }
}
