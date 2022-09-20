package com.felipe.todolist.model;

import com.felipe.todolist.enums.Roles;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
public class Role implements GrantedAuthority {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Roles roles;

    @Override
    public String getAuthority() {
        return this.roles.toString();
    }
}
