package com.felipe.todolist.repository;

import com.felipe.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUsers extends JpaRepository<User, String> {

    public Optional<User> findByLogin(String email);

}
