package com.contatos.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "contatos", joinColumns = @JoinColumn(name = "idpessoa"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Contato> contatos;

}
