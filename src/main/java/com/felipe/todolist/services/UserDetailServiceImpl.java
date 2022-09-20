package com.felipe.todolist.services;

import com.felipe.todolist.model.User;
import com.felipe.todolist.repository.RepositoryUsers;
import com.felipe.todolist.data.UserDetailData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private final RepositoryUsers repositoryUsers;

    public UserDetailServiceImpl(RepositoryUsers repositoryUsers) {
        this.repositoryUsers = repositoryUsers;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repositoryUsers.findByLogin(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }
        return new UserDetailData(user);
    }
}
