package com.felipe.todolist.services;

import com.felipe.todolist.model.User;
import com.felipe.todolist.repository.RepositoryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final RepositoryUsers repositoryUsers;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(RepositoryUsers repositoryUsers, PasswordEncoder encoder) {
        this.repositoryUsers = repositoryUsers;
        this.encoder = encoder;
    }

    public List<User> findAllUser() {
        List<User> users = repositoryUsers.findAll();
        return users;
    }

    public Optional<User> findUserId(String email) {
        Optional<User> findUserId = repositoryUsers.findByLogin(email);
        return findUserId;
    }

    public User createUser(User user) {
        user.setSenha(encoder.encode(user.getSenha()));
        return repositoryUsers.save(user);
    }

    public ResponseEntity<Boolean> validLogin(@RequestParam String email, @RequestParam String senha) {
        Optional<User> user = repositoryUsers.findById(email);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = encoder.matches(senha, user.get().getSenha());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
