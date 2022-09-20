package com.felipe.todolist.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class User {

    @Id
    @Email
    @Column(unique = true)
    private String email;
    @NotEmpty
    @Length(min = 6, message = "* Necessário ter no mínimo 6 caracteres")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private Boolean administrador = false;

    @OneToOne
    @JoinColumn(name = "roles_id")
    private Role roles;
}
