package com.felipe.todolist.controler;

import com.felipe.todolist.model.User;
import com.felipe.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "listaUsuarios")
    public List<User> listUsers() {
        return userService.findAllUser();
    }

    @GetMapping(value = "listaUsuarios/{email}")
    public void listUserId(@PathVariable("email") String email) {
        userService.findUserId(email);
    }

    @PostMapping(value = "criaUsuario", consumes = APPLICATION_JSON_VALUE)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }
}
