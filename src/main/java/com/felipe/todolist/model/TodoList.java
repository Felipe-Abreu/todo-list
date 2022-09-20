package com.felipe.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Data
@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPrevista;
    private Boolean status = false;
    private LocalDate dataEdicao = null;
    private LocalDate dataFinalizado = null;
    private LocalDate dataCriado = null;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_email")
    private User user;

}