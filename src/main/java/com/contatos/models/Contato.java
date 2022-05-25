package com.contatos.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Setter
@Getter
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O telefone é obrigatório!")
    private String telefone;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "O email é obrigatório!")
    private String email;

    private String empresa;

    private long idPessoa;

}
